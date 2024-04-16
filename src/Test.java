import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//TODO: Side-effecting / `void` methods okay? Or should return 0/1 instead?
//TODO: Test-drive the above feature into existence?

class Test {

    /**
     *
     */
    static void
    run(Class cls, String[] args) {
        /* Get declared test methods */
        Method[] methods = cls.getDeclaredMethods();

        /* Call each test method in a loop */
        for (int i=0; i < methods.length; ++i) {
            if (methods[i].getName().startsWith("test")) {
                try {
                    methods[i].invoke(new Object(), new Object[0]);
                } catch (IllegalAccessException e) {
                    System.err.println(e);
                    System.exit(1);
                } catch (InvocationTargetException e) {
                    /* Invoked method itself threw an exception.
                     * (e.g. an AssertionError)
                     */
                    Exit.displayError(e.getTargetException());
                }
            }
        }
    }


    /**
     *
     */
    static void
    runNested(Class cls, String[] args) {
        /* Get array of nested test classes */
        Class[] classes = cls.getDeclaredClasses();

        /* Run nested class when passed in as only argument
           in its own process.
           Using `.endsWith()` allows both short and fully-qualified
           class names to be used.
         */
        if (args.length == 1) {
            String nestedClassName = args[0];

            for (int i=0; i < classes.length; ++i) {
                if (classes[i].getName().endsWith(nestedClassName)) {
                    runInNewProcess(classes[i]);
                    break;
                }
            }

        /* Or discover and run each nested class individually
           in its own process.
         */
        } else if (args.length == 0) {
            for (int i=0; i < classes.length; ++i) {
                runInNewProcess(classes[i]);
            }
        } else if (args.length > 1) {
            System.err.println("ERROR: WRONG NUMBER OF ARGUMENTS!");
            System.exit(1);
        }
    }


    /**
     *
     */
    static void
    runInNewProcess(Class cls) {
        Runtime runtime = Runtime.getRuntime();
        Process process = null;  // TODO: No nulls!
        String className = cls.getName();

        System.out.println("\nRunning "+ className +" in a new process...");

        try {
            process = runtime.exec(new String[] {
                    "java",
                    className
            });
        } catch (Exception e) {
            System.err.println(e);
            System.exit(1);
        }

        checkReturnCode(process, cls);
    }


    /**
     *
     */
    static void
    checkReturnCode(Process process, Class cls) {
        long actualReturnCode = Long.MIN_VALUE;

        try {
            actualReturnCode = process.waitFor();
        } catch (InterruptedException e) {
            System.err.println(e);
            System.exit(1);
        }

        long expectedReturnCode = Long.MAX_VALUE;
        try {
            expectedReturnCode =
                    cls.getDeclaredField("EXPECTED_RETURN_CODE").getInt(null);
        } catch (NoSuchFieldException e) {
            System.err.println(e);
            System.exit(1);
        } catch (IllegalAccessException e) {
            System.err.println(e);
            System.exit(1);
        }

        System.out.println("Expected return code: "+ expectedReturnCode);
        System.out.println("Actual return code: "+ actualReturnCode);

        if (actualReturnCode != expectedReturnCode) {
            System.err.println("ERROR: UNEXPECTED RETURN CODE!");
            System.exit(1);
        }
    }
}

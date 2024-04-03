import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

class TestRunner {
    static void
    requireAssertEnabled() {
        boolean isAssertEnabled = false;
        assert isAssertEnabled = true;
        if (! isAssertEnabled) throw new RuntimeException(
                "\n\nASSERTIONS MUST BE ENABLED WITH: -ea\n");
    }

    public static void
    main(String[] args) {
        requireAssertEnabled();
        runLowLevelTests();
        runHighLevelTests();
        System.out.println("All tests pass!");
    }

    static int
    runLowLevelTests() {
        UtilitiesTest.main(new String[0]);  // TODO
        System.out.println("Low level testing completed.");
        return 0;
    }

    static int
    runHighLevelTests() {
        BibleTest.main(new String[0]);
        System.out.println("High level testing completed.");
        return 0;
    }

    static int
    runAllTests(Class cls) {
        Method[] methods = cls.getMethods();
        int testResult = -1;  //TODO: enum { NO_OP=-1, SUCCESS=0, FAIL=1 }

        /* Invoke all public methods on class (besides `main`) */
        for (int i=0; i < methods.length; ++i) {
            if (methods[i].getDeclaringClass() == cls
                    && ! methods[i].getName().equals("main"))
            {
                try {
                    testResult = (int) methods[i].invoke(
                            new Object(), new Object[0]
                    );
                } catch (Exception e) {
                    System.err.println("runAllTests: Unexpected Exception!");
                    System.err.println(e +": "+ methods[i].getName());
                    System.exit(1);  // !!
                }

                if (testResult != 0) {
                    System.err.println(methods[i].getName() +" <- Failed Test!");
                }
            }
        }

        return 0;
    }

//    /** Invoke single public method in a new process. */
//    static int
//    runInNewProcess(Method method, int expectedStatusCode) {
//        /* Arrange */
//        int statusCode = -1;
//        //boolean isProcessFinished = false;
//
//        /* Act */
//        try {
//            Process process = Runtime.getRuntime().exec(new String[] {
//                    "java",
//                    method.getDeclaringClass().getName(),
//                    method.getName()
//            });
//            statusCode = process.waitFor();
//            System.out.println("statusCode: "+ statusCode);
//        } catch (Exception e) {
//            System.err.println("TestRunner.runInNewProcess: "+ e);
//            System.exit(1);
//        }
//
//        /* Assert */
//        if (statusCode != expectedStatusCode) {
//            System.err.println("PROCESS STATUS CODE SHOULD BE: 1");
//            return 1;
//        }
//        return 0;
//    }

    static
    Method
    getMethod(Class<?> cls, String methodName, Class[] params) {
        Method resultingMethod = null;
        try {
            resultingMethod = cls.getMethod(methodName, params);
        } catch (Exception e) {
            System.err.println("TestRunner.getMethod: "+ e);
            System.exit(1);
        }

        return resultingMethod;
    }
}

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

//TODO: TestRunner should just use a config file,
//      or automatically discover tests,
//      instead of hardcoding each test class name.

class TestRunner {
    public static void
    assertThat(boolean assertion, String detailMessage) {
        AssertionError assertionError = new AssertionError(detailMessage);
        StackTraceElement[] stackTrace = assertionError.getStackTrace();
        System.arraycopy(stackTrace, 1, stackTrace, 0, stackTrace.length-1);
        assertionError.setStackTrace(stackTrace);
        if (! assertion) throw assertionError;
    }


    public static void
    main(String[] args) {
        String packageName = args[0];

        runAllTestClasses(packageName);
        //runLowLevelTests();
        //runHighLevelTests();

        System.out.println("\nTesting complete.");
    }


    static int
    runLowLevelTests() {
        ExitTests.main(new String[0]);  // TODO
        System.out.println("Low level testing completed.");
        return 0;
    }


    static int
    runHighLevelTests() {
        BibleTests.main(new String[0]);
        System.out.println("High level testing completed.");
        return 0;
    }


    static int
    runAllTestClasses(String packageName) {
        if (packageName.equals(".")) {
            packageName = "./";
        } else {
            packageName = packageName.replace('.', '/');
        }

        File[] files = new File(packageName).listFiles();
        if (files == null) {
            System.err.println("ERROR: Bad package name");
            System.exit(1);
        }

        for (int i=0; i < files.length; ++i) {
            String fileName = files[i].getName();
            if (fileName.endsWith("Tests.class")) {
                //URL resource = Temp.class.getResource(fileName);
                String name = fileName.substring(0, fileName.length()-6);
                try {
                    //System.out.println(Class.forName(name).getName());
                    Class cls = Class.forName(name);
                    Method method = cls.getMethod(
                            "main",
                            new Class[] { String[].class }
                    );
                    method.invoke(new Object(), new Object[] { new String[0] });
                } catch (java.lang.ReflectiveOperationException e) {
                    System.err.println(e);
                    System.exit(1);
                }
            }
        }

        return 0;
    }

//    static int
//    runAllTests(Class cls) {
//        Method[] methods = cls.getMethods();
//        int testResult = -1;  //TODO: enum { NO_OP=-1, SUCCESS=0, FAIL=1 }
//
//        /* Invoke all public methods on class (besides `main`) */
//        for (int i=0; i < methods.length; ++i) {
//            if (methods[i].getDeclaringClass() == cls
//                    && ! methods[i].getName().equals("main"))
//            {
//                try {
//                    testResult = ((Integer) methods[i].invoke(
//                            new Object(), new Object[0]
//                    )).intValue();
//                } catch (Exception e) {
//                    System.err.println("runAllTests: Unexpected Exception!");
//                    System.err.println(e +": "+ methods[i].getName());
//                    System.exit(1);  // !!
//                }
//
//                if (testResult != 0) {
//                    System.err.println(methods[i].getName() +" <- Failed Test!");
//                }
//            }
//        }
//
//        return 0;
//    }
}

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
        runLowLevelTests();
        runHighLevelTests();
        System.out.println("All tests pass!");
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

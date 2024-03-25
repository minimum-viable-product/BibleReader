import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ExceptionTests {

    /* Called via reflection... */
    public static void
    test_Bible_DisplayErrorAndExit() {
        Utilities.DisplayErrorAndExit(new Exception("Exception Suceeded!"));
    }

    public static void
    main(String[] args) {
        if (args.length == 0) {
            runAllExceptionTests();
        } else if (args[args.length-1].equals("process-started")) {
            try {
                ExceptionTests.class
                        .getMethod(args[0], new Class[0])
                        .invoke(new Object(), new Object[0]);
            } catch (NoSuchMethodException e) { Utilities.DisplayErrorAndExit(e);
            } catch (IllegalAccessException e) { Utilities.DisplayErrorAndExit(e);
            } catch (InvocationTargetException e) { Utilities.DisplayErrorAndExit(e); }
        } else {
            Process process = null;
            try {
                process = Runtime.getRuntime().exec(new String[] {
                        "java",
                        "ExceptionTests",
                        args[0],  /* method name */
                        "process-started"
                });
            } catch (java.io.IOException e) {
                System.err.println("I/O Exception!");
            }

            int processReturnCode = -1;
            try {
                processReturnCode = process.waitFor();
            } catch (InterruptedException e) { System.err.println(e); }

            System.out.println("Return code: "+ processReturnCode);
        }
    }

    static int
    runAllExceptionTests() {
        Method[] methods = ExceptionTests.class.getMethods();

        /* Invoke all public methods in this class (besides `main`) */
        for (int i=0; i < methods.length; ++i) {
            if (methods[i].toString().indexOf("ExceptionTests") != -1
                    && methods[i].toString().indexOf("main") == -1) {
                ExceptionTests.main(new String[] { methods[i].getName() });
            }
        }

        return 0;
    }
}
////
//// Get method, alternative way (DeFenox): e.getStackTrace()[0].getMethodName()
////
//// if you want process many cases you can make your own exception
//// and process them in global exception handler...
//// Thread.setDefaultUncaughtExceptionHandler(globalExceptionHandler);
////

//...                if (processReturnCode != 1) throw new Exception(
//                        "\n\t"+
//                        "ExceptionTests: RETURN CODE SHOULD BE 1 in..."+
//                        "\n\t\t"+ methodName);
//            }
//        } catch (Exception e) { System.err.println(e); }//System.exit(1); }
//
//        System.out.println("Exception testing completed.");


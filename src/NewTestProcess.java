import java.io.*;

class NewTestProcess {
    static Process
    run(Class cls) {
        Runtime runtime = Runtime.getRuntime();
        Process process = null;  // TODO: No nulls!

        try {
            process = runtime.exec(new String[] {
                    "java",
                    cls.getName(),
                    "run",
                    "--dont-launch-new-process"
            });
        } catch (Exception e) {
            System.err.println(e);
            System.exit(1);
        }

        return process;
    }

    static void
    checkReturnCode(Process process, int expectedReturnCode) {
        long actualReturnCode = Long.MIN_VALUE;

        try {
            actualReturnCode = process.waitFor();
        } catch (InterruptedException e) {
            System.err.println(e);
            System.exit(1);
        }

        if (actualReturnCode != expectedReturnCode) {
            System.err.println("UNEXPECTED RETURN CODE: "+ actualReturnCode);
            System.exit(1);
        }

        return;
    }

//        //statusCode = process.waitFor();
//
//        /* Assert */
//        if (statusCode != expectedStatusCode) {
//            System.err.println("PROCESS STATUS CODE SHOULD BE: "
//                               + expectedStatusCode);
//            return 1;
//        }
//
//
//    if (args.length == 0) {
//            int statusCode = -1;
//            try {
//                statusCode = TestRunner.runInNewProcess(
//                        NewProcessTests.class.getMethod(
//                                "test_Bible_DisplayErrorAndExit",
//                                new Class[0]),
//                                1
//                );
//            } catch (NoSuchMethodException e) {
//                System.err.println(e);
//                System.exit(1);
//            }
//            System.out.println("NewProcessTests status code: "+ statusCode);
//        } else {
//            test_Bible_DisplayErrorAndExit();
//        }
//    }
}

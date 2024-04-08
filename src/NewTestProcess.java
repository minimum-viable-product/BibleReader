import java.io.*;

class NewTestProcess {
    static void
    run(Class cls) {
        Runtime runtime = Runtime.getRuntime();
        Process process = null;  // TODO: No nulls!

        try {
            process = runtime.exec(new String[] {
                    "java",
                    cls.getName()
            });
        } catch (Exception e) {
            System.err.println(e);
            System.exit(1);
        }

        //return process;
        NewTestProcess.checkReturnCode(process, cls);
        //        UtilitiesTest.DisplayErrorAndExitTest.class.expectedReturnValue);

    }

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
                    cls.getDeclaredField("expectedReturnCode").getInt(null);
        } catch (NoSuchFieldException e) {
            System.err.println(e);
            System.exit(1);
        } catch (IllegalAccessException e) {
            System.err.println(e);
            System.exit(1);
        }

        checkReturnCode(actualReturnCode, expectedReturnCode);
    }

    static void
    checkReturnCode(long actualReturnCode, long expectedReturnCode) {
        if (actualReturnCode != expectedReturnCode) {
            System.err.println("UNEXPECTED RETURN CODE: "+ actualReturnCode);
            System.exit(1);
        }
    }
}

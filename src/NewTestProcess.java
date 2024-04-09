import java.io.*;

class NewTestProcess {
    static void
    run(Class cls) {
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

        NewTestProcess.checkReturnCode(process, cls);
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

        System.out.println("Expected return code: "+ expectedReturnCode);
        System.out.println("Actual return code: "+ actualReturnCode);

        if (actualReturnCode != expectedReturnCode) {
            System.err.println("UNEXPECTED RETURN CODE!");
            System.exit(1);
        }
    }
}

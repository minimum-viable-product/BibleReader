import java.lang.reflect.InvocationTargetException;

class ExceptionTests {
    public static void
    main(String[] args) {
        if (args.length == 0) runExceptionTests();
        else { /* When runs as native process... */
            try {
                ExceptionTests.class.getMethod(args[0]).invoke(null);
            } catch (NoSuchMethodException |
                     IllegalAccessException |
                     InvocationTargetException e) {
                System.exit(2);
            }
        }
    }

    /* Called via reflection... */
    public static void
    test_Bible_DisplayErrorAndExit() {
        // Register in test list! (Decorate!)
        Utilities.DisplayErrorAndExit(new Exception("Exception Suceeded!"));
    }

    static int
    runExceptionTests() {
        String[] tests = new String[] {
                "test_Bible_DisplayErrorAndExit",
                "test_openBufferedReader_throwsFileNotFoundException"
        };

        try {
            for (String methodName : tests) {
                Process process = new ProcessBuilder(
                        "java",
                        "ExceptionTests", /* <== Called via reflection! */
                        methodName).start();
                int processReturnCode = process.waitFor();
                if (processReturnCode != 1) throw new Exception(
                        "\n\t"+
                        "ExceptionTests: RETURN CODE SHOULD BE 1 in..."+
                        "\n\t\t"+ methodName);
            }
        } catch (Exception e) { System.err.println(e); }//System.exit(1); }

        System.out.println("Exception testing completed.");
        return 0;
    }
}

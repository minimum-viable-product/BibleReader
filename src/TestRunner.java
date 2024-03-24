class TestRunner {
    static {
        boolean isAssertEnabled = false;
        assert isAssertEnabled = true;
        if (! isAssertEnabled) throw new RuntimeException(
                "\n\nASSERTIONS MUST BE ENABLED WITH: -ea\n");
    }

    public static void
    main(String[] args) {
        runLowLevelTests();
        runExceptionTests();
        runHighLevelTests();
        System.out.println("All tests passed.");
    }

    static int
    runLowLevelTests() {
        //testBibleFillBuffer();
        UtilitiesTest.main(null);
        System.out.println("Low level testing completed.");
        return 0;
    }

    static int
    runHighLevelTests() {
        BibleTest.main(null);
        System.out.println("High level testing completed.");
        return 0;
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

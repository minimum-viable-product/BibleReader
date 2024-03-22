class ExceptionTests {
    /* Runs as native process... */
    public static void
    main(String[] args) throws Exception {
        ExceptionTests.class.getMethod(args[0]).invoke(null);
    }

    /* Called via reflection... */
    public static void
    test_Bible_DisplayErrorAndExit() {
        Utilities.DisplayErrorAndExit(new Exception("Exception Suceeded!"));
    }
}

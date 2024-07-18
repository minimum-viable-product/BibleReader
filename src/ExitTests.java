class ExitTests {

    public static void
    main(String[] args) {
        Test.runNested(ExitTests.class, args);
    }


    public static
    class Test_displayError_returnsOne_givenException {
        public static final int
        EXPECTED_RETURN_CODE = 1;

        public static void
        main(String[] args) {
            Exit.displayError(
                    new Exception("This is an expected test exception..."));
        }
    }


    public static
    class Test_displayError_returnsOne_givenThrowable {
        public static final int
        EXPECTED_RETURN_CODE = 1;

        public static void
        main(String[] args) {
            Exit.displayError(
                    new Throwable("This is an expected test exception..."));
        }
    }


    public static
    class Test_displayError_returnsOne_givenEmptyString {
        public static final int
        EXPECTED_RETURN_CODE = 1;

        public static void
        main(String[] args) {
            Exit.displayError("");
        }
    }
}

class BibleReaderTests {
    public static void
    main(String[] args) {
        /* Run all tests in class */
        Test.run(BibleReaderTests.class, args);
    }

    public static int
    test_checkCommandLine_returnsTrue_givenArgsArray() {
        /* Arrange */
        String[] arguments = { "genesis", "1", "1" };

        /* Act */
        boolean result = BibleReader.checkCommandLine(arguments);

        /* Assert */
        TestRunner.assertThat(result == true, "\n\nSHOULD RETURN TRUE\n");

        return 0;
    }

//    public static int
//    test_checkCommandLine_returnsFalse_givenEmptyArgsArray() {
//        /* Arrange */
//        String[] arguments = { };
//
//        /* Act */
//        boolean result = Main.checkCommandLine(arguments);
//
//        /* Assert */
//        TestRunner.assertThat(result == false, "\n\nSHOULD RETURN FALSE\n");
//
//        return 0;
//    }
}

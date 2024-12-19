class MainTests {
    public static void
    main(String[] args) {
        /* Run all tests in class */
        Test.run(MainTests.class, args);
    }


    public static int
    test_columnize_returnsStringArrayOfColumns_givenNames() {
        /* Arrange */
        String[] names = new String[] { "Name1", "Name2", "Name3", "Name4",
                                        "Name5", "Name6", "Name7", "Name8",
                                        "Name9", "Name10", "Name11", "Name12",
                                        "Name13", "Name14", "Name15", "Name16" };
        String[] result;
        String expected = "Name1            Name15           ";
        /* Act */
        result = Main.columnize(names);
        /* Assert */
        TestRunner.assertThat(result[0].equals(expected),
                              "\n\nEXPECTED:\n"+ expected
                              +"\nGOT:\n"+ result[0] +"\n");
        return 0;
    }


    public static int
    test_columnize_returnsProperSecondLine_givenNames() {
        /* Arrange */
        String[] names = new String[] { "Name1", "Name2", "Name3", "Name4",
                                        "Name5", "Name6", "Name7", "Name8",
                                        "Name9", "Name10", "Name11", "Name12",
                                        "Name13", "Name14", "Name15", "Name16" };
        String[] result;
        String expected = "Name2            Name16           ";
        /* Act */
        result = Main.columnize(names);
        /* Assert */
        TestRunner.assertThat(result[1].equals(expected),
                              "\n\nEXPECTED:\n"+ expected
                              +"\nGOT:\n"+ result[1] +"\n");
        return 0;
    }


    public static int
    test_pad_returnsStringWithTrailingSpace_givenString() {
        /* Arrange */
        String string = "My String";

        /* Act */
        string = Main.pad(string);

        /* Assert */
        TestRunner.assertThat(string.equals("My String       "),
                              "\n\nSTRING SHOULD BE PADDED TO 16 CHARACTERS\n");

        return 0;
    }

    public static int
    test_isExactly_returnsTrue_givenSameValues() {
        /* Arrange */
        int expected_length = 3;
        int actual_length = 3;
        boolean expected = true;
        boolean result = false;

        /* Act */
        result = Main.isExactly(expected_length, actual_length);

        /* Assert */
        TestRunner.assertThat(
                result == expected,
                "\n\nSHOULD BE: "+ expected +", GOT: "+ result +"\n"
        );

        return 0;
    }

    public static int
    test_isExactly_returnsFalse_givenDifferentValues() {
        /* Arrange */
        int expected_length = 3;
        int actual_length = 2;
        boolean expected = false;
        boolean result = true;

        /* Act */
        result = Main.isExactly(expected_length, actual_length);

        /* Assert */
        TestRunner.assertThat(
                result == expected,
                "\n\nSHOULD BE: "+ expected +", GOT: "+ result +"\n"
        );

        return 0;
    }
}

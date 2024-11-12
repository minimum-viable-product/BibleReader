class MainTests {
    public static void
    main(String[] args) {
        /* Run all tests in class */
        Test.run(MainTests.class, args);
    }


    public static int
    test_checkCommandLine_returnsTrue_givenArgsArray() {
        /* Arrange */
        String[] arguments = { "genesis", "1", "1" };

        /* Act */
        boolean result = Main.checkCommandLine(arguments);

        /* Assert */
        TestRunner.assertThat(result == true, "\n\nSHOULD RETURN TRUE\n");

        return 0;
    }


    public static int
    test_getBookNames_beginsWithGenesis_givenEmptyCmdArgs() {
//        /* Arrange */
//
//
        /* Act */
        String[] result = Main.getBookNames();

        /* Assert */
        TestRunner.assertThat(result[0].equals("Genesis"),
                              "\n\nFIRST BOOK SHOULD BE GENESIS\n");
//
        return 0;
    }


    public static int
    test_getBookNames_endsWithRevelation_givenEmptyCmdArgs() {
        /* Arrange */

        /* Act */
        String[] result = Main.getBookNames();

        /* Assert */
        TestRunner.assertThat(result[65].equals("Revelation"),
                              "\n\nLAST BOOK SHOULD BE REVELATION\n");
        return 0;
    }


    public static int
    test_getBookNames_secondBookIsExodus_givenEmptyCmdArgs() {
        /* Arrange */

        /* Act */
        String[] result = Main.getBookNames();

        /* Assert */
        TestRunner.assertThat(result[1].equals("Exodus"),
                              "\n\n2ND BOOK SHOULD BE EXODUS\n");
//
        return 0;
    }


    public static int
    test_getBookNames_returnsArrayOf66Strings_givenEmptyCmdArgs() {
//        /* Arrange */
//
//
        /* Act */
        String[] result = Main.getBookNames();

        /* Assert */
        TestRunner.assertThat(result.length == 66,
                              "\n\nARRAY OF BOOK NAMES SHOULD HAVE 66 ITEMS\n");
//
        return 0;
    }


    public static int
    test_putNumbersInFront_returnsFirstSamuel_givenArrayOfBookNames() {
        /* Arrange */
        String[] bookNames = new String[] {
                "Genesis", "Samuel1", "Revelation"
        };

        /* Act */
        Main.putNumbersInFront(bookNames);

        /* Assert */
        TestRunner.assertThat(bookNames[1].equals("1 Samuel"),
                              "\n\nNUMBERS SHOULD BE IN FRONT OF NAMES");
        return 0;
    }


    public static int
    test_sortBooksAlphabetically_returnsBooksInAlphabeticalOrder_givenArrayOfBookNames() {
        /* Arrange */
        String[] bookNames = new String[] {
                "Genesis", "1 Samuel", "Revelation"
        };

        /* Act */
        Main.sortBooksAlphabetically(bookNames);

        /* Assert */
        TestRunner.assertThat(bookNames[0].equals("Genesis")
                              && bookNames[1].equals("Revelation")
                              && bookNames[2].equals("1 Samuel"),
                              "\n\nBOOK NAMES SHOULD BE IN ALPHABETICAL ORDER");

        return 0;
    }


    public static int
    test_moveNumbersBehindNames_returnsNumberOneBehindNames_givenBookNamesString() {
        /* Arrange */
        String[] bookNames = new String[] {
                "Genesis", "1 Samuel", "Revelation"
        };

        /* Act */
        Main.moveNumbersBehindNames(bookNames);

        /* Assert */
        TestRunner.assertThat(bookNames[1].equals("Samuel1"),
                              "\n\nNUMBER ONE SHOULD BE BEHIND NAMES\n");

        return 0;
    }


    public static int
    test_moveNumbersBehindNames_returnsNumberTwoBehindNames_givenBookNamesString() {
        /* Arrange */
        String[] bookNames = new String[] {
                "Genesis", "1 Samuel", "2 Samuel", "Revelation"
        };

        /* Act */
        Main.moveNumbersBehindNames(bookNames);

        /* Assert */
        TestRunner.assertThat(bookNames[2].equals("Samuel2"),
                              "\n\nNUMBER TWO SHOULD BE BEHIND NAMES\n");

        return 0;
    }


    public static int
    test_moveNumbersBehindNames_returnsNumberThreeBehindNames_givenBookNamesString() {
        /* Arrange */
        String[] bookNames = new String[] {
                "Genesis", "1 Samuel", "2 Samuel", "3 John", "Revelation"
        };

        /* Act */
        Main.moveNumbersBehindNames(bookNames);

        /* Assert */
        TestRunner.assertThat(bookNames[3].equals("John3"),
                              "\n\nNUMBER THREE SHOULD BE BEHIND NAMES\n");

        return 0;
    }

}

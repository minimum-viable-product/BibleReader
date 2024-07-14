class BibleTests {
    public static void
    main(String[] args) {
        /* Run all tests in class */
        Test.run(BibleTests.class, args);
    }

    public static int
    test_open_returnsGenesisFirstVerse_givenNoArguments() {
        /* Arrange */
        String result;
        /* Act */
        result = Bible.open();
        /* Assert */
        TestRunner.assertThat(
            result.equals("In the beginning God created the heaven and the earth."),
            "\n\nTEXT SHOULD MATCH\n"
        );
        return 0;
    }

    public static int
    test_open_returnsGenesisFirstVerse_givenOnlyBookArgument() {
        /* Arrange */
        String result;
        /* Act */
        result = Bible.open("genesis");
        /* Assert */
        TestRunner.assertThat(
            result.equals("In the beginning God created the heaven and the earth."),
            "\n\nTEXT SHOULD MATCH\n"
        );
        return 0;
    }

    public static int
    test_open_returnsGenesisFirstVerse_givenBookAndVerse() {
        /* Arrange */
        String result;
        /* Act */
        result = Bible.open("genesis", 1);
        /* Assert */
        TestRunner.assertThat(
            result.equals("In the beginning God created the heaven and the earth."),
            "\n\nTEXT SHOULD MATCH\n"
        );
        return 0;
    }

    public static int
    test_open_returnsExodus2Verse3_givenBookChapterVerse() {
        /* Arrange */
        String result;
        /* Act */
        result = Bible.open("exodus", 2, 3);
        /* Assert */
        TestRunner.assertThat(
            result.equals("And when she could not longer hide him, she took for him an ark of bulrushes, and daubed it with slime and with pitch, and put the child therein; and she laid it in the flags by the river's brink."),
            "\n\nTEXT SHOULD MATCH\n"
        );
        return 0;
    }

    public static int
    test_getReader_doesNotReturnNull_givenBogusPath() {
        /* Arrange */
        java.io.BufferedReader result;

        /* Act */
        result = Bible.getReader("");

        /* Assert */
        TestRunner.assertThat(result != null, "\n\nRESULT SHOULD NOT BE NULL\n");

        return 0;
    }

    public static int
    test_getBeginning_returnsLineNumber_givenBookGenesis() {
        /* Arrange */
        String book = "genesis";
        int lineNumber;

        /* Act */
        lineNumber = Bible.getBeginning(book);

        /* Assert */
        TestRunner.assertThat(lineNumber == 2, "\n\nLINE NUMBER SHOULD MATCH\n");

        return 0;
    }

    public static int
    test_getBeginning_returnsLineNumber_givenBookExodus() {
        /* Arrange */
        String book = "exodus";
        int lineNumber;

        /* Act */
        lineNumber = Bible.getBeginning(book);

        /* Assert */
        TestRunner.assertThat(lineNumber == 1535, "\n\nLINE NUMBER SHOULD MATCH\n");

        return 0;
    }

    public static int
    test_getBeginning_returnsLineNumber_givenBookRevelation() {
        /* Arrange */
        String book = "revelation";
        int lineNumber;

        /* Act */
        lineNumber = Bible.getBeginning(book);

        /* Assert */
        TestRunner.assertThat(lineNumber == 30700, "\n\nLINE NUMBER SHOULD MATCH\n");

        return 0;
    }
}

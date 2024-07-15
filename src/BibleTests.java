import java.io.BufferedReader;

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

        /* Act (interface) */
        result = Bible.open("genesis", 1);

        /* Assert (runtime implementation) */
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
    test_getBookBeginning_returnsLineNumber_givenBookGenesis() {
        /* Arrange */
        String book = "genesis";
        BufferedReader reader = Bible.getReader("../data/kjv-.txt");
        int lineNumber = 0;

        /* Act */
        lineNumber = Bible.getBookBeginning(reader, book);

        /* Assert */
        TestRunner.assertThat(lineNumber == 2, "\n\nLINE NUMBER SHOULD MATCH\n");

        return 0;
    }

    public static int
    test_getBeginning_returnsLineNumber_givenBookExodus() {
        /* Arrange */
        String book = "exodus";
        BufferedReader reader = Bible.getReader("../data/kjv-.txt");
        int lineNumber;

        /* Act */
        lineNumber = Bible.getBookBeginning(reader, book);

        /* Assert */
        TestRunner.assertThat(lineNumber == 1535, "\n\nLINE NUMBER SHOULD MATCH\n");

        return 0;
    }

    public static int
    test_getBeginning_returnsLineNumber_givenBookRevelation() {
        /* Arrange */
        String book = "revelation";
        BufferedReader reader = Bible.getReader("../data/kjv-.txt");
        int lineNumber;

        /* Act */
        lineNumber = Bible.getBookBeginning(reader, book);

        /* Assert */
        TestRunner.assertThat(lineNumber == 30700, "\n\nLINE NUMBER SHOULD MATCH\n");

        return 0;
    }

    public static int
    test_getChapterLineNumber_returnsLineNumber_givenGenesisOne() {
        /* Arrange */
        int chapterNumber = 1;
        int chapterLineNumber;
        BufferedReader reader = Bible.getReader("../data/kjv-.txt");
        int bookBeginning = Bible.getBookBeginning(reader, "genesis");

        /* Act */
        chapterLineNumber = Bible.getChapterBeginning(
                reader,
                bookBeginning,
                chapterNumber);

        /* Assert */
        TestRunner.assertThat(chapterLineNumber == 2,
                "\n\nLINE NUMBER SHOULD MATCH\n");

        return 0;
    }

        public static int
    test_getChapterBeginning_TOTALLY_BOGUS_NAME() {
//        /* Arrange */
//        int chapterNumber = 2;
//        int chapterLineNumber;
//        BufferedReader reader = Bible.getReader("../data/kjv-.txt");
//        int bookBeginning = Bible.getBookBeginning(reader, "exodus");
//
//        /* Act */
//        chapterLineNumber = Bible.getChapterBeginning(
//                reader,
//                bookBeginning,
//                chapterNumber);
//
//        /* Assert */
//        TestRunner.assertThat(chapterLineNumber == 1557,
//                "\n\nLINE NUMBER SHOULD MATCH\n");

        return 0;
    }
}

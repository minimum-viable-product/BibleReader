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
            result.equals("And when she could not longer hide him, she took for him an ark of bulrushes, and daubed it with slime and with pitch, and put the child therein; and she laid [it] in the flags by the river's brink."),
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
    test_open_returnsVerse_givenObject() {
        /* Arrange */
        BibleLocation bibleLocation = new BibleLocation();

        /* Act */
        String result = Bible.open(bibleLocation);

        /* Assert */
        TestRunner.assertThat(result.equals(
                "In the beginning God created the heaven and the earth."),
                "\n\nTEXT SHOULD MATCH\n"
        );

        return 0;
    }

    public static int
    test_newBibleLocation_returnsBookGenesis_givenNoArgConstructor() {
        /* Arrange */

        /* Act */
        BibleLocation result = new BibleLocation();

        /* Assert */
        TestRunner.assertThat(
                result.book.equals("genesis"),
                "\n\nBOOK SHOULD MATCH\n"
        );

        return 0;
    }

    public static int
    test_newBibleLocation_returnsChapterOne_givenNoArgConstructor() {
        /* Arrange */

        /* Act */
        BibleLocation result = new BibleLocation();

        /* Assert */
        TestRunner.assertThat(
                result.chapter.equals("1"),
                "\n\nCHAPTER SHOULD MATCH\n"
        );

        return 0;
    }

    public static int
    test_newBibleLocation_returnsVerseOne_givenNoArgConstructor() {
        /* Arrange */

        /* Act */
        BibleLocation result = new BibleLocation();

        /* Assert */
        TestRunner.assertThat(
                result.verse.equals("1"),
                "\n\nVERSE SHOULD MATCH\n"
        );

        return 0;
    }
}

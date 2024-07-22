import java.io.BufferedReader;

class BibleTests {
    public static void
    main(String[] args) {
        /* Run all tests in class */
        Test.run(BibleTests.class, args);
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

    public static int
    test_openNewBibleLocation_returnsCorrectVerse_givenExodusTwoTwo() {
        /* Arrange */
        BibleLocation bibleLocation;
        String verse;

        /* Act */
        bibleLocation = new BibleLocation("exodus", "2", "2");
        verse = Bible.open(bibleLocation);

        /* Assert */
        TestRunner.assertThat(verse.equals(
                "And the woman conceived, and bare a son: and when she saw him that he [was a] goodly [child], she hid him three months."),
                "\n\nTEXT SHOULD MATCH\n"
        );

        return 0;
    }
}

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




    //public static int
    //test_openBook_() {
    //    assert new Bible()
    //        .openBook("genesis", 2)
    //        .equals("And the earth was without form, and void; and darkness was upon the "+
    //                "face of the deep. And the Spirit of God moved upon the face of the "+
    //                "waters.")
    //        : "\n\nTEXT SHOULD MATCH\n";
    //}

    //public static int
    //test_openBook_() {
    //        assert new Bible()
    //            .openBook("genesis", 3)
    //            .equals("And God said, Let there be light: and there was light.")
    //            : "\n\nTEXT SHOULD MATCH\n";
    //}

//    /** Low level tests... */
//    static int
//    test_openReader_throwsFileNotFoundException() {
//        // THIS TEST IS NOW HANDLED ELSEWHERE!
//        //TODO: Register in user-level test list
//
//        /* Arrange */
//        Bible bible = new Bible();
//        Reader result;
//
//        /* Act */
//        result = bible.openReader("\0");
//
//        return 0;
//    }

    //static int
    //test_BibleFillBuffer() {
    //    //todo: register test in low-level test list
    //    Bible bible = new Bible();
    //    Reader reader = bible.openReader("../data/blank.txt");
    //    assert Reader.class.isInstance(
    //            bible.fillBuffer(0L, reader))
    //            : "SHOULD RETURN A BUFFERED READER INSTANCE";
    //    return 0;
    //}
}

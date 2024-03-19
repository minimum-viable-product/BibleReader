import java.io.*;

class BibleReaderTest {
    static {
        boolean isAssertEnabled = false;
        assert isAssertEnabled = true;
        if (! isAssertEnabled) throw new RuntimeException(
                "\n\nASSERTIONS MUST BE ENABLED WITH: -ea\n");
    }

    public static void
    main(String[] args) {
        runLowLevelTests();
        runHighLevelTests();
        runUserLevelTests();
        //System.out.println("All unit tests passed.");
    }  // main

    static
    int
    runLowLevelTests() {
        System.out.println("Low level testing commencing...");
        test_openBufferedReader_returnsBufferedReader();
        testBibleFillBuffer();
        System.out.println("Low level testing completed.\n");
        return 0;
    }  // low level testing

    static
    int
    runHighLevelTests() {
        System.out.println("High level testing commencing...");

        assert new Bible()
                .openBook("genesis", 1)
                .equals("In the beginning God created the heaven and the earth.")
                : "\n\nTEXT SHOULD MATCH\n";

        assert new Bible()
                .openBook("genesis")
                .equals("In the beginning God created the heaven and the earth.")
                : "\n\nTEXT SHOULD MATCH\n";

        assert new Bible()
                .openBook()
                .equals("In the beginning God created the heaven and the earth.")
                : "\n\nTEXT SHOULD MATCH\n";

        assert new Bible()
                .openBook("genesis", 2)
                .equals("And the earth was without form, and void; and darkness was upon the "+
                        "face of the deep. And the Spirit of God moved upon the face of the "+
                        "waters.")
                : "\n\nTEXT SHOULD MATCH\n";

        assert new Bible()
                .openBook("genesis", 3)
                .equals("And God said, Let there be light: and there was light.")
                : "\n\nTEXT SHOULD MATCH\n";

        System.out.println("High level testing completed.\n");
        return 0;
    }  // high level tests

    static
    int
    runUserLevelTests() {
        System.out.println("User level testing commencing...");
        System.out.println("--> exception expected! <--");

        //testDisplayErrorAndExit();
        test_openBufferedReader_throwsFileNotFoundException();
        return 0;
    }

    /* Low level tests... */

    static
    int
    test_openBufferedReader_returnsBufferedReader() {
        //todo: register in low-level test list
        assert BufferedReader.class
                .isInstance(new Bible().openBufferedReader("kjv.txt"))
                : "SHOULD RETURN A BUFFERED READER INSTANCE";
        return 0;
    }

    static
    int
    test_openBufferedReader_throwsFileNotFoundException() {
        //TODO: Register in user-level test list

        /* Arrange */
        Bible bible = new Bible();
        BufferedReader result;

        /* Act */
        result = bible.openBufferedReader("\0");

        return 0;
    }

    static
    int
    testBibleFillBuffer() {
        //todo: register test in low-level test list
        Bible bible = new Bible();
        BufferedReader bufferedReader = bible.openBufferedReader("blank.txt");
        assert BufferedReader.class.isInstance(
                bible.fillBuffer(0L, bufferedReader))
                : "SHOULD RETURN A BUFFERED READER INSTANCE";
        return 0;
    }

    static
    void
    testDisplayErrorAndExit() {  // INTERGRATION / USER LEVEL ?!
        Bible.DisplayErrorAndExit(new Exception());
    }
}

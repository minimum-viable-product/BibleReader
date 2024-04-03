import java.io.*;

class BibleTest {
    static {
        boolean isAssertEnabled = false;
        assert isAssertEnabled = true;
        if (! isAssertEnabled) throw new RuntimeException(
                "\n\nASSERTIONS MUST BE ENABLED WITH: -ea\n");
    }

    public static void
    main(String[] args) { //TODO: reflection?
        test_openReader_throwsFileNotFoundException();
        runTests();
        System.out.println("Bible tests passed.");
    }

    static int
    runTests() {
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

        return 0;
    }


    /** Low level tests... */
    static int
    test_openReader_throwsFileNotFoundException() {
        // THIS TEST IS NOW HANDLED ELSEWHERE!
        //TODO: Register in user-level test list

        /* Arrange */
        Bible bible = new Bible();
        Reader result;

        /* Act */
        result = bible.openReader("\0");

        return 0;
    }

    static int
    test_BibleFillBuffer() {
        //todo: register test in low-level test list
        Bible bible = new Bible();
        Reader reader = bible.openReader("../data/blank.txt");
        assert Reader.class.isInstance(
                bible.fillBuffer(0L, reader))
                : "SHOULD RETURN A BUFFERED READER INSTANCE";
        return 0;
    }

}

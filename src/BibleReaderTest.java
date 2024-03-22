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
        System.out.println("All tests passed.");
    }

    static
    int
    runLowLevelTests() {
        test_openBufferedReader_returnsBufferedReader();
        test_openBufferedReader_returnsReader();
        testBibleFillBuffer();
        //test_Bible_FillBuffer_withNull();
        System.out.println("Low level testing completed.");
        return 0;
    }

    static
    int
    runHighLevelTests() {
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

        System.out.println("High level testing completed.");
        return 0;
    }

    static
    int
    runUserLevelTests() {
        String[] tests = new String[] {
                "test_Bible_DisplayErrorAndExit",
                "test_openBufferedReader_throwsFileNotFoundException"
        };

        try {
            for (String methodName : tests) {
                Process process = new ProcessBuilder(
                        "java",
                        "ExceptionTests", /* <== Called via reflection! */
                        methodName).start();
                int processReturnCode = process.waitFor();
                if (processReturnCode == 0) throw new Exception(
                        "\n\t"+
                        "ExceptionTests: RETURN CODE SHOULD BE NON-ZERO in..."+
                        "\n\t\t"+ methodName);
            }
        } catch (Exception e) { System.err.println(e); System.exit(1); }

        return 0;
    }


    /* Low level tests... */

    static
    int
    test_openBufferedReader_returnsBufferedReader() {
        //todo: register in low-level test list
        assert BufferedReader.class
                .isInstance(new Bible().openBufferedReader("../data/kjv.txt"))
                : "SHOULD RETURN A BUFFERED READER INSTANCE";
        return 0;
    }

    static
    int
    test_openBufferedReader_returnsReader() {
            //todo: register in low-level test list
        assert Reader.class
                .isInstance(new Bible().openBufferedReader("../data/kjv.txt"))
                : "SHOULD RETURN A READER";
        return 0;
    }

    static
    int
    test_openBufferedReader_throwsFileNotFoundException() {
        //TODO: Register in user-level test list

        /* Arrange */
        Bible bible = new Bible();
        Reader result;

        /* Act */
        result = bible.openBufferedReader("\0");

        return 0;
    }

    static
    int
    testBibleFillBuffer() {
        //todo: register test in low-level test list
        Bible bible = new Bible();
        Reader reader = bible.openBufferedReader("../data/blank.txt");
        assert Reader.class.isInstance(
                bible.fillBuffer(0L, reader))
                : "SHOULD RETURN A BUFFERED READER INSTANCE";
        return 0;
    }


    //static
    //void
    //test_Bible_DisplayErrorAndExit() {  // INTERGRATION / USER LEVEL ?!
    //    Bible.DisplayErrorAndExit(new Exception());
    //}
}

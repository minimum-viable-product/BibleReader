class BibleReaderTest {
    static {
        boolean assertsEnabled = false;
        assert assertsEnabled = true;
        if (! assertsEnabled) throw new RuntimeException(
                "\n\nASSERTIONS MUST BE ENABLED WITH: -ea\n"
        );
    }

    public static void main(String[] args) {
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


        System.out.println("All tests passed.");
    }
}

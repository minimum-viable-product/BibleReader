class BibleReaderTest {
    static {  // Ensures asserts are enabled
        boolean assertsEnabled = false; assert assertsEnabled = true;
        if (! assertsEnabled) throw new RuntimeException("Asserts NOT enabled!");
    }

    public static void main(String[] args) {
        assert new Bible().openBookChapter("genesis", 1).equals(
                "In the beginning God created the heaven and the earth.")
                : "Text doesn't match.";

        assert new Bible().openBookChapter("genesis").equals(
                "In the beginning God created the heaven and the earth.")
                : "Text doesn't match.";

        assert new Bible().openBookChapter().equals(
                "In the beginning God created the heaven and the earth.")
                : "Text doesn't match.";

        assert new Bible().openBookChapter("genesis", 2).equals(
                "And the earth was without form, and void; and darkness was upon the "+
                "face of the deep. And the Spirit of God moved upon the face of the "+
                "waters.")
                : "Text doesn't match.";

        System.out.println("All tests passed.");
    }
}

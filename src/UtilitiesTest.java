import java.io.Reader;

class UtilitiesTest {
    public static void main(String[] args) {
        test_BibleFillBuffer();
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

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


class Bible {
    char[] mCharBuffer = new char[5504282];
    BufferedReader mBufferedReader;

    Bible() {
        try {
            mBufferedReader = new BufferedReader(
                    new FileReader("kjv.txt"));
        } catch (FileNotFoundException e) { System.err.println(e); }
    }

    String openBookChapter(String book, int chapter) {
        try {
            mBufferedReader.skip(0x12839);
            return mBufferedReader.readLine();
        } catch (IOException e) { System.err.println(e); }

        return "";
    }

    String openBookChapter(String book) { return openBookChapter(book, 1); }
    String openBookChapter() { return openBookChapter("genesis", 1); }

}

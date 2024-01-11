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
        long location = 0;
        if (chapter == 1) location = 0x12839;
        else if (chapter == 2) location = 0x12876L;

        try {
            mBufferedReader.skip(location);
            mBufferedReader.read(mCharBuffer, 0, 512);
        } catch (IOException e) { System.err.println(e); }

        String string = new String(mCharBuffer);
        string = string
                .substring(0, string.indexOf('^'))
                .replace("\n", "")
                .replaceAll("   ", " ")
                .trim()
                ;
        return string;
    }

    String openBookChapter(String book) { return openBookChapter(book, 1); }
    String openBookChapter() { return openBookChapter("genesis", 1); }

}

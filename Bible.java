import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


class Bible {
    char[]
    mCharBuffer = new char[5504282];

    BufferedReader
    mBufferedReader;

    Bible() {
        try {
            mBufferedReader = new BufferedReader(
                    new FileReader("kjv.txt"));
        } catch (FileNotFoundException e) { System.err.println(e); }
    }

    String
    openBook(String book, int chapter) {
        long location = 0L;
        if (chapter == 1) location = 0x12839L;
        else if (chapter == 2) location = 0x12876L;
        else if (chapter == 3) location = 0x12911L;

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

    String
    openBook(String book) {
        return openBook(book, 1);
    }

    String
    openBook() {
        return openBook("genesis", 1);
    }

    void
    findBooks() {
        String line;
        long count = 0;
        try {
            while ((line = mBufferedReader.readLine()) != null) {
                if (line.trim().equals("Chapter 1")) {
                    ++count;
                    System.out.println(line + count);
                }
            }
        } catch (IOException e) { System.err.println(e); }
    }
}

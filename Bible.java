import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;


class Bible {
    char[]
    mCharBuffer = new char[5504282];

    BufferedReader
    openBufferedReader(String filename) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(filename));
        } catch (FileNotFoundException e) {
            System.err.println(e);
            bufferedReader = null;  // handle problem here instead of null?
        }

        return bufferedReader;
    }

    String
    openBook() {
        return openBook("genesis");
    }

    String
    openBook(String book) {
        return openBook(book, 1);
    }

    String
    openBook(String book, int chapter) {
        long location = 0L;
        if (chapter == 1) location = 0x12839L;
        else if (chapter == 2) location = 0x12876L;
        else if (chapter == 3) location = 0x12911L;

        // openAndFillBuffer
        BufferedReader bufferedReader = openBufferedReader("kjv.txt");  // null?

        fillBuffer(location, bufferedReader);

        String string = new String(mCharBuffer);
        string = string
                .substring(0, string.indexOf('^'))
                .replace("\n", "")
                .replaceAll("   ", " ")
                .trim()
                ;
        return string;
    }

    BufferedReader
    fillBuffer(long location, BufferedReader bufferedReader) {
        try {
            bufferedReader.skip(location);
            bufferedReader.read(mCharBuffer, 0, 512);
            //throw new IOException();  //DEBUG
        } catch (IOException e) {
            System.err.println(e); }
            //System.exit(1);  //TODO: this should be inside above bracket!
        return bufferedReader;  // or character buffer, instead?
    }

    static
    void
    DisplayErrorAndExit(Exception exception) {
        System.err.println(exception);
        System.exit(1);
    }

    //void
    //findBooks() {
    //    String line = "";
    //    long count = 0;
    //    try {
    //        while ((line = mBufferedReader.readLine()) != null) {
    //            if (line.trim().equals("Chapter 1")) {
    //                ++count;
    //                System.out.println(line + count);
    //            }
    //        }
    //    } catch (IOException e) { System.err.println(e); }
    //}
}

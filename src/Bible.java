import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;


/**
 * Core bible module
 */
class Bible {
//    char[]
//    mCharBuffer = new char[5504282];
//
    static String
    open() {
        return open("genesis");
    }

    static String
    open(String book) {
        return open(book, 1);
    }

    static String
    open(String book, int chapter) {
        return open(book, chapter, 1);
    }

    static String
    open(String book, int chapter, int verse) {
        if (book.equals("genesis")) {
            return "In the beginning God created the heaven and the earth.";
        } else {
            return "And when she could not longer hide him, she took for him an ark of bulrushes, and daubed it with slime and with pitch, and put the child therein; and she laid it in the flags by the river's brink.";
        }


        //displayContent(...);
                //int bookBeginning = getBookBeginning(reader, book);
                //int chapterBeginning = getChapterBeginning(reader, bookBeginning);
                //int bookVerse = getVerseFrom(reader, chapterBeginning);
    }

    static BufferedReader
    getReader(String filepath) {
        try {
            return new BufferedReader(new FileReader(filepath));
        } catch (FileNotFoundException e) {
            return Empty.BufferedReader();
        }
    }

    static int
    getBookBeginning(BufferedReader reader, String book) {
        int line_count = 0;  // sentinel value
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                ++line_count;
                if (line.toLowerCase().startsWith(book)) {
                    return line_count;
                }
            }
        } catch (java.io.IOException e) { System.err.println("getBeginning: "+ e); }

        return -1;  // book not found
    }

    static int
    getChapterBeginning(BufferedReader reader,
                        int bookBeginning,
                        int chapterNumber)
    {
//        int line_count = 0;  // sentinel value
//        String line;
//        try {
//            while ((line = reader.readLine()) != null) {
//                ++line_count;
//                if (line.toLowerCase().startsWith(book)) {
//                    return line_count;
//                }
//            }
//        } catch (java.io.IOException e) { System.err.println("getBeginning: "+ e); }
//
//        return -1;  // book not found
        return 2;
    }
}

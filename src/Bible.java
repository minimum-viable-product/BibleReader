//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.Reader;
//
//
class Bible {
//    char[]
//    mCharBuffer = new char[5504282];
//
    static String
    openBook() {
        return openBook("genesis");
    }

    static String
    openBook(String book) {
        return openBook(book, 1);
    }

    static String
    openBook(String book, int chapter) {
//        long location = 0L;
//        if (chapter == 1) location = 0x12839L;
//        else if (chapter == 2) location = 0x12876L;
//        else if (chapter == 3) location = 0x12911L;
//
//        // openAndFillBuffer
//        Reader reader = openReader("../data/kjv.txt");  // null?
//
//        fillBuffer(location, reader);
//
//        String string = new String(mCharBuffer);
//        string = string
//                .substring(0, string.indexOf('^'))
//                .replace("\n", "")
//                .replaceAll("   ", " ")
//                .trim()
//                ;
//        return string;
        return "In the beginning God created the heaven and the earth.";
    }
//
//    Reader
//    openReader(String filename) {
//        Reader reader = null;
//        try {
//            //bufferedReader = new BufferedReader(new FileReader(filename));
//            reader = new FileReader(filename);
//        } catch (FileNotFoundException e) {
//            System.err.println(e); }
//            //System.exit(1);
//
//        return reader;
//    }
//
//    Reader
//    fillBuffer(long location, Reader reader) {
//        try {
//            reader.skip(location);
//            reader.read(mCharBuffer, 0, 512);
//            //throw new IOException();  //DEBUG
//        } catch (IOException e) {
//            System.err.println(e); }
//            //System.exit(1);  //TODO: this should be inside above bracket!
//        return reader;  // or character buffer, instead?
//    }
//
//
//    //void
//    //findBooks() {
//    //    String line = "";
//    //    long count = 0;
//    //    try {
//    //        while ((line = mBufferedReader.readLine()) != null) {
//    //            if (line.trim().equals("Chapter 1")) {
//    //                ++count;
//    //                System.out.println(line + count);
//    //            }
//    //        }
//    //    } catch (IOException e) { System.err.println(e); }
//    //}
}

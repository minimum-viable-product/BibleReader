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
    }


//-------------------------
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
// ----------------------------------
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
}

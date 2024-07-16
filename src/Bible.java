import java.io.BufferedReader;
import java.io.IOException;
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
        BufferedReader bufferedReader = getReader("../data/kjv-no-bom.txt");

        try {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.toLowerCase().startsWith(
                        book +" "+ chapter +":"+ verse +"\t")) {
                    //System.out.println(line.split("\t")[1].replaceAll("’", "'"));  // DEBUG
                    return line.split("\t")[1].replaceAll("’", "'");
                }
            }
        } catch (IOException e) { System.err.println(e); }

        return "";
    }

    static BufferedReader
    getReader(String filepath) {
        try {
            return new BufferedReader(new FileReader(filepath));
        } catch (FileNotFoundException e) {
            return Empty.BufferedReader();
        }
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;


/**
 * Core bible module
 */
class Bible {
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
    open(BibleLocation b) {
        //return "In the beginning God created the heaven and the earth.";
        return open(b.book);
    }

    static String
    open(String book, int chapter, int verse) {
        BufferedReader bufferedReader = getReader("/data/kjv-no-bom.txt");

        try {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.toLowerCase().startsWith(
                        book +" "+ chapter +":"+ verse +"\t")) {
                    return line.split("\t")[1].replaceAll("’", "'");  // UTF-8!
                }
            }
        } catch (IOException e) { System.err.println(e); }

        return "";
    }

    static BufferedReader
    getReader(String filepath) {
        try {
            return new BufferedReader(new InputStreamReader(
                    Bible.class.getResource(filepath).openStream()
            ));
        } catch (IOException e) {
            return Empty.BufferedReader();
        }
    }
}


class BibleLocation {
    String book    = "genesis";
    String chapter = "1";
    String verse   = "1";
}

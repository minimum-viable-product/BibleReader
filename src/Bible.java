import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.Locale;


/**
 * Core bible module
 */
class Bible {
    static String
    open(BibleLocation bibleLocation) {
        BufferedReader bufferedReader = getReader("/data/kjv-no-bom.txt");

        try {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.toLowerCase(new Locale("","","")).startsWith(
                        bibleLocation.book +" "+
                        bibleLocation.chapter +":"+
                        bibleLocation.verse +"\t"))
                {
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

    BibleLocation() { }
    BibleLocation(String book, String chapter, String verse) {
        this.book = book;
        this.chapter = chapter;
        this.verse = verse;
    }
}

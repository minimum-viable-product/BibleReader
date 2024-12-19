class Books {
    static String[]
    getNames() {
        java.io.BufferedReader reader = Bible.getReader("/data/kjv-no-bom.txt");

        String[] bookNames = new String[66];
        java.util.Arrays.fill(bookNames, "");

        String alreadySeen = "";
        String line = "";
        String prefix = "";
        try {
            for (
                    int i = 0, bookCount = 0;
                    bookCount < bookNames.length;
                    ++i)
            {
                if ((line = reader.readLine()) == null) break;

                try {
                    /* Get book name & chapter number */
                    prefix = line.substring(0, line.indexOf(':'));
                } catch (IndexOutOfBoundsException e) {
                    continue;
                }

                /* Continue outer loop if there's no whitespace */
                int trailing = -1;
                if ((trailing = prefix.lastIndexOf(' ')) == -1) continue;

                /* Chop off chapter number */
                String bookName = prefix.substring(0, trailing);

                /* Add to book names if it's not already there */
                if (! bookName.equals(alreadySeen)) {
                    bookNames[bookCount++] = bookName;
                    alreadySeen = bookName;
                }

            }
        } catch (java.io.IOException e) { System.err.println(e); }

        return bookNames;
    }


    /** Move numbers behind names, for sorting */
    static String[]
    moveNumbersBehindNames(String[] bookNames) {
        for (int i=0; i < bookNames.length; ++i) {
            if (bookNames[i].charAt(0) == '1'
                    || bookNames[i].charAt(0) == '2'
                    || bookNames[i].charAt(0) == '3')
            {
                bookNames[i] = bookNames[i].substring(2)
                                    + bookNames[i].substring(0,1);
            }
        }
        return bookNames;
    }


    /** Return book names with numbers in front */
    static String[]
    putNumbersInFront(String[] bookNames) {
        for (int i=0; i < bookNames.length; ++i) {
            if (bookNames[i].endsWith("1")
                    || bookNames[i].endsWith("2")
                    || bookNames[i].endsWith("3"))
            {
                bookNames[i] =
                        bookNames[i].charAt(bookNames[i].length() - 1)
                        + " "
                        + bookNames[i].substring(0, bookNames[i].length() - 1);
            }
        }

        return bookNames;
    }


    /** Return book names in alphabetical order. */
    static String[]
    sortAlphabetically(String[] bookNames) {
        moveNumbersBehindNames(bookNames);
        java.util.Arrays.sort(bookNames);
        putNumbersInFront(bookNames);
        return bookNames;
    }
}

class Main {
    /**
     * Main entry-point.  (Not unit test-driven.)
     */
    public static void
    main(String[] args) {
        checkCommandLine(args);
        displayBookNames();

        System.out.println(
                Bible.open(new BibleLocation(
                        args[0],  /* book */
                        args[1],  /* chapter */
                        args[2]   /* verse */
                ))
        );
    }

    static boolean
    checkCommandLine(String[] cmdLineArgs) {
        if (cmdLineArgs.length != 3) {
            Exit.displayError("EXPECTED: BibleReader <book> <chapter> <verse>");
        }

        return true;
    }


    /**
     * Display list of books linearly.
     */
    static int
    displayBookNames() {
        String[] bookNames = getBookNames();

        for (int i=0; i < bookNames.length; ++i) {
            System.out.println(bookNames[i]);
        }

        return 0;
    }


    /**
     * Return book names in alphabetical order.
     */
    static int
    sortBooksAlphabetically(String[] bookNames) {
        moveNumbersBehindNames(bookNames);
        java.util.Arrays.sort(bookNames);
        putNumbersInFront(bookNames);
        return 0;
    }

    /**
     *
     */
    static int
    moveNumbersBehindNames(String[] bookNames) {
        /* Move numbers behind names, for sorting */
        for (int i=0; i < bookNames.length; ++i) {
            if (bookNames[i].charAt(0) == '1'
                    || bookNames[i].charAt(0) == '2'
                    || bookNames[i].charAt(0) == '3')
            {
                bookNames[i] = bookNames[i].substring(2)
                                    + bookNames[i].substring(0,1);
            }
        }

        return 0;
    }


    /**
     * Return book names with numbers in front.
     */
    static int
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

        return 0;
    }


    /**
     * Returns String of book names.
     */
    static String[]
    getBookNames() {  // Snapshot test instead!
        String[] bookNames = new String[66];
        java.util.Arrays.fill(bookNames, "");

        java.io.BufferedReader reader = Bible.getReader("/data/kjv-no-bom.txt");
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
}

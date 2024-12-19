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


    static void
    checkCommandLine(String[] args) {
        boolean result = isExactly(3, args.length);
        displayErrorExitOnBad(result);
        return;
    }



    /** Displays book names in 14 rows x 5 column format. */
    static String[]
    columnize(String[] names) {
        String[] strings = new String[14];  // Consider StringBuilder instead?
        for (int i=0; i < 14; ++i) {
            strings[i] = "";
            if (i < names.length) strings[i] += pad(names[i]).concat(" ");
            if (i+14 < names.length) strings[i] += pad(names[i+14]).concat(" ");
            if (i+28 < names.length) strings[i] += pad(names[i+28]).concat(" ");
            if (i+42 < names.length) strings[i] += pad(names[i+42]).concat(" ");
            if (i+56 < names.length) strings[i] += names[i+56];
        }

        return strings;
        //String[] strings = new String[14];
        //strings[0] = "Name1            Name15";
        //strings[1] = "Name2            Name16";
        //return strings;
    }


    static void
    displayBookNames() {
        //String[] rows = columnize(Books.getNames());
        String[] rows = Books.getNames();

        /* display list of books */
        for (int i=0; i < rows.length; ++i) {
            System.out.println(rows[i]);
        }
    }


    /** Exit and display error message if incorrect arguments */
    static void
    displayErrorExitOnBad(boolean result) {
        if (! result) {
            Exit.displayError("EXPECTED: BibleReader <book> <chapter> <verse>");
        }
    }


    static boolean
    isExactly(int expected_length, int actual_length) {
        return expected_length == actual_length ? true : false;
    }


    /**
     * Pad string with enough trailing space to equal 16 total
     * characters.
     */
    static String
    pad(String string) {
        int spacing = string.length();
        while (spacing < 16) {
            string = string.concat(" ");
            spacing += 1;
        }

        return string;
    }
}

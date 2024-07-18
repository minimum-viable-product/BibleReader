/**
 * Main entry point
 */
class Main {
    public static void
    main(String[] args) {  // Entry-point NOT test-driven!
        checkCommandLine(args);

        String book = args[0];
        String chapter = args[1];
        String verse = args[2];

        System.out.println(
                Bible.open(
                        book,
                        Integer.parseInt(chapter),
                        Integer.parseInt(verse)
                )
        );
    }

    static boolean
    checkCommandLine(String[] cmdLineArgs) {
        if (cmdLineArgs.length != 3) {
            Exit.displayError("EXPECTED: java Main <book> <chapter> <verse>");
        }

        return true;
    }
}

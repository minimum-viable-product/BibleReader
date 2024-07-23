/**
 * Main entry-point
 */
class Main {
    public static void
    main(String[] args) {  /* Entry-point (only) NOT test-driven! */
        checkCommandLine(args);

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
}

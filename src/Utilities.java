//TODO: Rename this class to something that speaks more to it's
//      actual purpose...  ie. ErrorExit ?
class Utilities {
    public static void
    main(String[] args) {
        //TestRunner.runAllTests(Utilities.class);
    }

    static int
    DisplayErrorAndExit(Exception exception) {
        //System.err.println(exception);
        System.exit(1);
        return -2;
    }
}

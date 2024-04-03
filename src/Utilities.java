//TODO: Rename this class to something that speaks more to it's
//      actual purpose...  ie. ErrorExit ?
class Utilities {

    //TODO: offer overload that doesn't require exception arg?
    static int
    DisplayErrorAndExit(Exception exception) {
        System.err.println(exception);
        System.exit(1);
        return -2;
    }
}

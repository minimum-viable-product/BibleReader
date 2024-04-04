//TODO: Rename this class to something that speaks more to it's
//      actual purpose...  ie. ErrorExit ?
class Utilities {

    //TODO: offer overload that takes a string instead of an exception?
    //TODO: offer overload that doesn't require exception arg?
    static void
    DisplayErrorAndExit(Exception exception) {
        System.err.println("\n"
                           + exception.getStackTrace()[0]
                           + exception.getLocalizedMessage()
        );
        System.exit(1);
    }
}

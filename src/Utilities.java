//TODO: Rename this class to something that speaks more to it's
//      actual purpose...  ie. ErrorExit ?
class Utilities {

    //TODO: offer overload that takes a string instead of an exception?
    //TODO: offer overload that doesn't require exception arg?

    /** Called when a reflectively invoked method
     *  throws an AssertionError.
     */
    static void  //TODO: Disable and test textual output back into existance!
    displayErrorAndExit(Throwable throwable) {
        System.err.println(new Exception(throwable).getLocalizedMessage());
        StackTraceElement[] stackTrace = throwable.getStackTrace();
        System.err.println(stackTrace[0]);
        System.exit(1);
    }

    static void  //TODO: Disable and test textual output back into existance!
    displayErrorAndExit(Exception exception) {
        //exception.printStackTrace();
        System.err.println("\n"+ exception.getStackTrace()[0] +
                           "\n"+ exception.getLocalizedMessage()
        );
        System.exit(1);
    }
}

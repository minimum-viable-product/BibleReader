class Exit {

    //TODO: offer overload that takes a string instead of an exception?
    //TODO: offer overload that doesn't require exception arg?

    /** Called when a reflectively invoked method
     *  throws an AssertionError.
     */
    static void  //TODO: Disable and test textual output back into existance!
    displayError(Throwable throwable) {
        System.err.println("\n"+ throwable.getStackTrace()[0]);
        System.err.println(new Exception(throwable).getLocalizedMessage());
        System.exit(1);
    }

    static void  //TODO: Disable and test textual output back into existance!
    displayError(Exception exception) {
        System.err.println("\n"+ exception.getStackTrace()[0] +
                           "\n"+ exception.getLocalizedMessage()
        );
        System.exit(1);
    }
}

/**
 * Display errors and exit
 *
 * TODO: offer overload that takes a string instead of an exception?
 * TODO: offer overload that doesn't require exception arg?
 */
class Exit {
    /**
     * Displays error and exits
     * when a reflectively invoked method throws an AssertionError.
     *
     * TODO: Disable and test textual output back into existance!
     */
    static void
    displayError(Throwable throwable) {
        System.err.println("\n"+ throwable.getStackTrace()[0]);
        System.err.println(new Exception(throwable).getLocalizedMessage());
        System.exit(1);
    }

    /**
     * Displays error and exits
     *
     * TODO: Disable and test textual output back into existance!
     */
    static void
    displayError(Exception exception) {
        System.err.println("\n"+ exception.getStackTrace()[0] +
                           "\n"+ exception.getLocalizedMessage()
        );
        System.exit(1);
    }
}

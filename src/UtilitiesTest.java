//TODO: Rename this class to something that speaks more to it's
//      actual purpose...  ie. ErrorExit ?
class UtilitiesTest {
    public static void
    main(String[] args) {
        Class[] classes = UtilitiesTest.class.getDeclaredClasses();

        if (args.length == 1) {
            String nestedClassName = args[0];
            Class cls = null;

            for (int i=0; i < classes.length; ++i) {
                if (classes[i].getName().equals(nestedClassName)) {
                    cls = classes[i];
                    break;
                }
            }

            NewTestProcess.run(cls);

        } else if (args.length == 0) {
            for (int i=0; i < classes.length; ++i) {
                NewTestProcess.run(classes[i]);
            }
        } else {
            System.err.println("ERROR: WRONG NUMBER OF ARGUMENTS!");
            System.exit(1);
        }
    }

    public static
    class DisplayErrorAndExitTest_returnsOne_givenException {
        public static final int
        expectedReturnCode = 1;

        public static void
        main(String[] args) {
            Utilities.displayErrorAndExit(
                    new Exception("This is an expected test exception..."));
        }
    }

    public static
    class DisplayErrorAndExitTest_returnsOne_givenThrowable {
        public static final int
        expectedReturnCode = 1;

        public static void
        main(String[] args) {
            Utilities.displayErrorAndExit(
                    new Throwable("This is an expected test exception..."));
        }
    }
}

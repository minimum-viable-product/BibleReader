//TODO: Rename this class to something that speaks more to it's
//      actual purpose...  ie. ErrorExit ?
class UtilitiesTest {
    public static void
    main(String[] args) {
        //TestRunner.requireAssertEnabled();
        //TestRunner.runAllTests(UtilitiesTest.class);
        if (args.length == 2) {
            Process process = NewTestProcess.run(UtilitiesTest.class, args);
            NewTestProcess.checkReturnCode(process, args);
        } else if (args.length == 1) {
            String methodName = args[0];
            try {
                UtilitiesTest.class.getMethod(methodName, new Class[0])
                        .invoke(new Object(), new Object[0]);
            } catch (Exception e) {
                System.err.println(e);
                System.exit(1);
            }
        } else if (args.length == 0) {
            // TODO: else getMethods & invoke all methods (in new processes)
        } else {
            System.err.println("TOO MANY ARGUMENTS!");
            System.exit(1);
        }
    }

    class DisplayErrorAndExitTest implements Runnable {
        public static final int
        expectedReturnValue = 1;

        public void
        run() {
            Utilities.DisplayErrorAndExit(
                    new Exception("This is an expected test exception..."));
        }
    }
}

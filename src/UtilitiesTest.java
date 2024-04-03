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
            try {
                UtilitiesTest.class.getMethod(args[0], new Class[0])
                        .invoke(new Object(), new Object[0]);
            } catch (Exception e) {
                System.err.println(e);
                System.exit(1);
            }
        } // TODO: else getMethods & invoke all methods (in new processes)
    }

    public static int
    test_Bible_DisplayErrorAndExit() {
        //System.out.println("In error / exit test!");
        Utilities.DisplayErrorAndExit(
                new Exception("This is a test exception..."));
        return -2;
    }
}

import java.io.Reader;

//TODO: Rename this class to something that speaks more to it's
//      actual purpose...  ie. ErrorExit ?
class UtilitiesTest {
    public static void
    main(String[] args) {
        //TestRunner.requireAssertEnabled();
        //TestRunner.runAllTests(UtilitiesTest.class);
        if (args.length > 0) {
            Process process = NewTestProcess.run(UtilitiesTest.class, args);
            NewTestProcess.checkReturnCode(process, args);
        }
    }

    public static int
    test_Bible_DisplayErrorAndExit() {
        //System.out.println("In error / exit test!");
        Utilities.DisplayErrorAndExit(
                new Exception("This is a new exception..."));
        return -2;
    }
}

//TODO: Rename this class to something that speaks more to it's
//      actual purpose...  ie. ErrorExit ?
class UtilitiesTest {
    public static void
    main(String[] args) {
        //TestRunner.requireAssertEnabled();
        //TestRunner.runAllTests(UtilitiesTest.class);
        if (args.length == 1) {
            String className = args[0];
            //System.out.println(className);
            Class[] classes = UtilitiesTest.class.getDeclaredClasses();
            Class cls = null;

            for (int i=0; i < classes.length; ++i) {
                //System.out.println(classes[i].getName());
                if (classes[i].getName().equals(className)) {
                    //System.out.println(classes[i].getName());
                    cls = classes[i];
                    break;
                }
            }

            Process process = NewTestProcess.run(cls);
            //NewTestProcess.checkReturnCode(process,
            //        UtilitiesTest.DisplayErrorAndExitTest.class.expectedReturnValue);
        } else if (args.length == 2) {
            String methodName = args[0];
            String dontLaunchNewProcess = args[1];

            System.exit(0); // DEBUG; TODO: REMOVE ME!

            try {
                UtilitiesTest.class.getMethod(methodName, new Class[0])
                        .invoke(new Object(), new Object[0]);
            } catch (Exception e) {
                System.err.println(e);
                System.exit(1);
            }
        } else if (args.length == 0) {
            System.err.println("No arguments passed!");
            // TODO: else getMethods & invoke all methods (in new processes)
        } else {
            System.err.println("TOO MANY ARGUMENTS!");
            System.exit(1);
        }
    }

    static class DisplayErrorAndExitTest {
        static final int
        expectedReturnValue = 1;

        static void
        run() {
            Utilities.DisplayErrorAndExit(
                    new Exception("This is an expected test exception..."));
        }
    }
}

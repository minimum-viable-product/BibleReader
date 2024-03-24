import java.lang.reflect.InvocationTargetException;

class ExceptionTests {
    /* Runs as native process... */
    public static void
    main(String[] args) {
        try {
            ExceptionTests.class.getMethod(args[0]).invoke(null);
        } catch (NoSuchMethodException |
                 IllegalAccessException |
                 InvocationTargetException e) {
            System.exit(2);
        }
    }

    /* Called via reflection... */
    public static void
    test_Bible_DisplayErrorAndExit() {
        // Register in test list! (Decorate!)
        Utilities.DisplayErrorAndExit(new Exception("Exception Suceeded!"));
    }
}

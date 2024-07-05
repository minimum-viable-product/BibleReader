import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

class TestRunner {
	/** Replace assert keyword */
    public static void
    assertThat(boolean assertion, String detailMessage) {
        AssertionError assertionError = new AssertionError(detailMessage);
        StackTraceElement[] stackTrace = assertionError.getStackTrace();
        System.arraycopy(stackTrace, 1, stackTrace, 0, stackTrace.length-1);
        assertionError.setStackTrace(stackTrace);
        if (! assertion) throw assertionError;
    }


    /**
	 * Run tests
	 */
    public static void
    main(String[] args) {
        if (args.length == 0) {
            System.err.println("ERROR: Missing package name argument");
            System.exit(1);
        }

        String packageName = args[0];

        runAllTestClasses(packageName);
        //runLowLevelTests();
        //runHighLevelTests();

        System.out.println("\nTesting complete.");
    }


    static int
    runAllTestClasses(String packageName) {
        if (packageName.equals(".")) {
            packageName = "./";
        } else {
            packageName = packageName.replace('.', '/');
        }

        File[] files = new File(packageName).listFiles();
        if (files == null) {
            System.err.println("ERROR: Bad package name");
            System.exit(1);
        }

        for (int i=0; i < files.length; ++i) {
            String fileName = files[i].getName();
            if (fileName.endsWith("Tests.class")) {
                //URL resource = Temp.class.getResource(fileName);
                String name = fileName.substring(0, fileName.length()-6);
                try {
                    //System.out.println(Class.forName(name).getName());
                    Class cls = Class.forName(name);
                    Method method = cls.getMethod(
                            "main",
                            new Class[] { String[].class }
                    );
                    method.invoke(new Object(), new Object[] { new String[0] });
                } catch (java.lang.ReflectiveOperationException e) {
                    System.err.println(e);
                    System.exit(1);
                }
            }
        }

        return 0;
    }
}

class EmptyTests {
	public static void
    main(String[] args) {
		/* Run all tests in class */
        Test.run(EmptyTests.class, args);
    }

	public static int
	test_newBufferedReader_returnsEmptyInstance_givenEmptyReader() {
		/* Arrange */
		java.io.BufferedReader bufferedReader;
		java.io.Reader reader = new Empty().new Reader();

		/* Act */
		bufferedReader = new Empty().new BufferedReader(reader);

		return 0;
	}

	public static int
	test_newReader_returnsEmptyInstance_givenNoArgs() {
		/* Arrange */
		java.io.Reader reader;

		/* Act */
		reader = new Empty().new Reader();

		return 0;
	}

	public static int
	test_emptyReader_returnsReader_givenNoArgs() {
		/* Arrange */
		java.io.Reader reader;

		/* Act */
		reader = Empty.Reader();

		return 0;
	}

	public static int
	test_emptyBufferedReader_returnsBufferedReader_givenNoArgs() {
		/* Arrange */
		java.io.BufferedReader reader;

		/* Act */
		reader = Empty.BufferedReader();

		return 0;
	}

	public static int
	test_lines_inEmptyImplementation_onEmptyBufferedReader() {
		/* Arrange */
		java.util.stream.Stream stream;

		/* Act */
		stream = Empty.BufferedReader().lines();

		return 0;
	}

	public static int
	test_readLine_inEmptyImplementation_onEmptyBufferedReader() {
		/* Arrange */
		String string;

		/* Act */
		try {
            string = Empty.BufferedReader().readLine();
        } catch (java.io.IOException e) {
            System.err.println("SHOULD NOT CAUSE EXCEPTION");
        }

		return 0;
	}
}

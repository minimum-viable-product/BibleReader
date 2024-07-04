class EmptyTests {
	public static void
    main(String[] args) {
		/* Run all tests in class */
        Test.run(EmptyTests.class, args);
    }

	public static int
	test_() {
		/* Arrange */
		java.io.BufferedReader bufferedReader;
		java.io.Reader reader = new Empty().new Reader();

		/* Act */
		bufferedReader = new Empty().new BufferedReader(reader); //.readLine();

		/* Assert */

		return 0;
	}

	public static int
	test_newReader_returnsEmptyInstance_givenNoArgs() {
		/* Arrange */
		java.io.Reader reader;

		/* Act */
		reader = new Empty().new Reader();

		/* Assert */

		return 0;
	}
}

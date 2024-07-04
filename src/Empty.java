class Empty {
	class BufferedReader extends java.io.BufferedReader {
		BufferedReader(java.io.Reader r) { super(r); }
    }

	class Reader extends java.io.Reader {
		@Override public void
		close() { }

		@Override public int
		read(char[] ca, int i, int j) { return 0; }
	}
}

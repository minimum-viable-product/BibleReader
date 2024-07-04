class Empty {
	public class
	BufferedReader extends java.io.BufferedReader {
		BufferedReader(java.io.Reader r) { super(r); }
    }

	public class
	Reader extends java.io.Reader {
		@Override public void
		close() { }

		@Override public int
		read(char[] ca, int i, int j) { return 0; }
	}

	static Reader
	Reader() { return new Empty().new Reader(); }

	static BufferedReader
	BufferedReader() { return new Empty().new BufferedReader(Reader()); }
}

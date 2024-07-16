/**
 * Main entry point
 */
class Main {
    public static void
    main(String[] args) {
        String book = args[0];
        String chapter = args[1];
        String verse = args[2];
        System.out.println(
                Bible.open(
                        book,
                        Integer.parseInt(chapter),
                        Integer.parseInt(verse)
                )
        );
    }
}

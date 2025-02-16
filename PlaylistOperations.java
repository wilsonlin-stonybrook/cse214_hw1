import java.util.Scanner;

/**
 * The <code>PlaylistOperations</code> class is used to test the methods of
 * the playlist class, and it allows the user to manipulate
 * a single playlist object.
 */
public class PlaylistOperations {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        Scanner input = new Scanner(System.in);
        String option;
        int songCount = 0;
        do {
            printMenu();
            System.out.println("Select a menu option: ");
            option = input.next().toUpperCase();
            input.nextLine();
            switch (option) {
                case "A":
                    try {
                        System.out.println("Enter the song title: ");
                        String title = input.nextLine();
                        System.out.println("Enter the song artist: ");
                        String artist = input.nextLine();
                        System.out.println("Enter the song length (minutes): ");
                        int minutes = input.nextInt();
                        System.out.println("Enter the song length (seconds): ");
                        int seconds = input.nextInt();
                        System.out.println("Enter the position: ");
                        int position = input.nextInt();
                        System.out.println("Song added: " + title + " by " + artist);
                        SongRecord songRecord = new SongRecord();
                        songRecord.setTitle(title);
                        songRecord.setArtist(artist);
                        songRecord.setMinutes(minutes);
                        songRecord.setSeconds(seconds);
                        playlist.addSong(songRecord, position);
                    }
                    catch (IllegalArgumentException | FullPlaylistException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case "B":
                    System.out.println("Enter the artist: ");
                    String artist = input.nextLine();
                    System.out.println(Playlist.getSongsByArtist(playlist, artist));
                    break;
                case "G":
                    System.out.println("Enter the position: ");
                    int position = input.nextInt();
                    System.out.printf("%-10s%-18s%-19s%-20s\n", "Song#", "Title", "Artist", "Length");
                    System.out.println("-----------------------------------------------------");
                    System.out.println(playlist.getSong(position));
                    break;
                case "R":
                    try {
                        System.out.println("Enter the position: ");
                        int position1 = input.nextInt();
                        playlist.removeSong(position1);
                    }
                    catch (IllegalArgumentException e) {
                        System.out.println("Error " + e.getMessage());
                    }
                    break;
                case "P":
                    playlist.printAllSongs();
                    break;
                case "S":
                    System.out.println("There are " + playlist.size() + " song(s) in the current playlist.");
                    break;
                case "Q":
                    System.out.println("Program terminating normally...");
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice.");
            }
        }
        while (option != "Q");
    }

    /**
     * A method to print a menu for the user to choose from.
     */
    private static void printMenu() {
        System.out.println("A) Add Song");
        System.out.println("B) Print Songs by Artist");
        System.out.println("G) Get Song");
        System.out.println("R) Remove Song");
        System.out.println("P) Print All Songs");
        System.out.println("S) Size");
        System.out.println("Q) Quit");

    }
}

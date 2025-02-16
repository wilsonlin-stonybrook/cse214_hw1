
/**
 * The <code>Playlist</code> class uses an array to represent a playlist of song records.
 * It allows for adding, removing, listing, cloning, and checking for equality of songs in
 * the playlist.
 */
public class Playlist {
    private static final int MAX_SONGS = 50;
    private SongRecord[] playlist;
    private int songCount;

    /**
     * Default constructor for creating a playlist object with default values.
     * Sets playlist to a new song record with a maximum number of songs in the playlist
     * equal to 50 and the song count to 0.
     * <dt>PostCondition:
     *     <dd> The playlist has been initialized to an empty list of song records.
     */
    public Playlist() {
        this.playlist = new SongRecord[MAX_SONGS];
        this.songCount = 0;
    }

    /**
     * A method to clone a playlist.
     * @return
     * Returns a copy of the playlist.
     */
    public Object clone() {
        Playlist copyPlaylist = new Playlist();
        for (int i = 0; i < songCount; i++) {
            copyPlaylist.playlist[i] = new SongRecord(playlist[i].getTitle(),playlist[i].getArtist(),
                    playlist[i].getMinutes(), playlist[i].getSeconds());
        }
        copyPlaylist.songCount = this.songCount;
        return copyPlaylist;
    }

    /**
     * A method to check if two playlist are equal.
     * @param obj
     * Compares object obj with newPlaylist.
     * @return
     * Returns true if the two objects are equal otherwise it will return false.
     */
    public boolean equals(Object obj) {
        if (obj instanceof Playlist) {
            Playlist newPlaylist = (Playlist) obj;
            for (int i = 0; i < songCount; i++) {
                if (playlist[i].equals(newPlaylist.playlist[i])) {
                    return true;
                }
            }
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * A method to check the size of the playlist.
     * @return
     * Returns the number of songs in the playlist.
     */
    public int size() {
        return this.songCount;
    }

    /**
     * A method to add songs to the playlist.
     * @param song
     * The song to be added to the playlist.
     * @param position
     * The position where the song is added to the playlist.
     * @throws IllegalArgumentException
     * Indicates that the position is not within the valid range.
     * @throws FullPlaylistException
     * Indicates that the playlist is full.
     */
    public void addSong(SongRecord song, int position) throws IllegalArgumentException, FullPlaylistException {
        if (position < 1 || position > songCount + 1) {
            throw new IllegalArgumentException("Position is not within the valid range!");
        }
        position -= 1;
        if (songCount >= MAX_SONGS) {
            throw new FullPlaylistException("The playlist is full!");
        }
        for (int i = songCount; i > position - 1; i--) {
            playlist[i + 1] = playlist [i];
        }
        playlist[position] = song;
        songCount++;
    }

    /**
     * A method that removes songs from the playlist.
     * @param position
     * The position of the song to remove from the playlist.
     * @throws IllegalArgumentException
     * Indicates that the position is not within the valid range.
     */
    public void removeSong(int position) throws IllegalArgumentException {
        if (position < 1 || position > songCount + 1) {
            throw new IllegalArgumentException("Position is not within the valid range!");
        }
        if (playlist[position - 1] == null) {
            System.out.println("No song at position " + position + " to remove.");
            return;
        }
        for (int i = position - 1; i < songCount - 1; i++) {
            playlist[i] = playlist[i + 1];
        }
        playlist[songCount - 1] = null;
        songCount--;
        System.out.println("Song Removed at position " + position);
    }

    /**
     * A method to return the song at a certain position in the playlist.
     * @param position
     * The position of the song in the playlist.
     * @return
     * Returns the song at the position in the playlist.
     * @throws IllegalArgumentException
     * Indicates that the position is not within the valid range.
     */
    public SongRecord getSong(int position) throws IllegalArgumentException {
        if (position < 1 || position > songCount + 1) {
            throw new IllegalArgumentException("Position is not within the valid range!");
        }
        if (playlist[position - 1] == null) {
            System.out.println("No song found at position " + position);
        } else {
            System.out.printf("%-10s", (position));
        }
        return playlist[position - 1];
    }

    /**
     * A method to print a table to show all the songs in the playlist.
     */
    public void printAllSongs() {
        System.out.println(toString());
    }

    /**
     * A method to show all songs by a certain artist.
     * @param originalList
     * The playlist to check if there are songs by the artist.
     * @param artist
     * The artist of the songs
     * @return
     * Returns a table of all songs by an artist.
     */
    public static Playlist getSongsByArtist(Playlist originalList, String artist) {
        if (originalList == null || artist == null) {
            return null;
        }
        Playlist newPlaylist = new Playlist();
        int position = 0;
        for (SongRecord songRecord : originalList.playlist) {
            if (songRecord != null && songRecord.getArtist().equals(artist)) {
                newPlaylist.playlist[position++] = songRecord;
            }
        }
        return newPlaylist;
    }

    /**
     * A toString method to represent songs in a playlist as a table.
     * @return
     * Returns a table of all songs inside the playlist.
     */
    public String toString() {
        String format = "";
        format = String.format("%-10s%-18s%-19s%-20s\n", "Song#", "Title", "Artist", "Length");
        format += "-----------------------------------------------------\n";
        for (int i = 0; i < MAX_SONGS; i++) {
            if (playlist[i] != null) {
                format += String.format("%-10s%-15s", (i + 1), playlist[i].toString()) + "\n";
            }
            else {
                format += "";
            }
        }
        return format;
    }
}

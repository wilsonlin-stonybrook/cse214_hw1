
/**
 * The <code>SongRecord</code> class is used for the creation of a song record object.
 * It represents the songs that are being stored in the playlist.
 */
public class SongRecord {
    private String title;
    private String artist;
    private int minutes;
    private int seconds;

    /**
     * Default constructor for creating a song record object with default values.
     * Sets title to empty string, artist to empty string, minutes to 0, and seconds to 0.
     */
    public SongRecord() {
        this.title = "";
        this.artist = "";
        this.minutes = 0;
        this.seconds = 0;
    }
    public SongRecord(String title, String artist, int minutes, int seconds) {
        this.title = title;
        this.artist = artist;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    /**
     * Gets the title of the song record.
     * @return
     * Returns the title of the song record.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the song record.
     * @param title
     * The title to set for the song record.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the artist of the song record.
     * @return
     * Returns the artist of the song record.
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Sets the artist of the song record.
     * @param artist
     * The artist to set for the song record.
     */
    public void setArtist(String artist) {
        this.artist = artist;
    }

    /**
     * Gets the minutes of the song record.
     * @return
     * Returns the minutes of the song record.
     */
    public int getMinutes() {
        return minutes;
    }

    /**
     * Sets the minutes of the song record.
     * @param minutes
     * The minutes of the song record.
     * @throws IllegalArgumentException
     * Indicates that <code>minutes</code> cannot be negative.
     */
    public void setMinutes(int minutes) {
        if (minutes < 0) {
            throw new IllegalArgumentException("Minutes can not be negative");
        }
        this.minutes = minutes;
    }

    /**
     * Gets the seconds of the song record.
     * @return
     * Returns the seconds of the song record.
     */
    public int getSeconds() {
        return seconds;
    }

    /**
     * Sets the seconds of the song record.
     * @param seconds
     * The seconds of the song record.
     * @throws IllegalArgumentException
     * Indicates that <code>seconds</code> must be between 0 and 59.
     */
    public void setSeconds(int seconds) {
        if (seconds < 0 || seconds > 59) {
            throw new IllegalArgumentException("Seconds must be between 0 and 59");
        }
        this.seconds = seconds;
    }

    /**
     * Method to check if the title, artist, minutes, and seconds of song records are equal.
     * @param obj
     * Compares obj with songRecord.
     * @return
     * Returns true if the title, artist, minutes, and seconds of song records are the same otherwise
     * it returns false.
     */
    public boolean equals(Object obj) {
        if (obj instanceof SongRecord) {
            SongRecord songRecord = (SongRecord) obj;
            return (this.title.equals(songRecord.title) && this.artist.equals(songRecord.artist) && this.minutes == songRecord.minutes && this.seconds == songRecord.seconds);
        }
        return false;
    }

    /**
     * Returns a string representation of the song record.
     * @return
     * Returns a formatted string containing the song record's title, artist, minutes, and seconds.
     */
    public String toString() {
        return String.format("%-18s%-19s%2d:%02d", this.title, this.artist, this.minutes, this.seconds);
    }
}

/**
 * The title, album title, artist, and musical genre of a single song.
 * <p>
 * <strong>Do not modify this file in any way!</strong>
 * 
 * @author Ben Liblit
 */

public class Song {

	/** title of the album on which this song appears */
	private final String album;

	/** name of the artist who performed this song */
	private final String artist;

	/** musical genre of this song */
	private final String genre;
	
	/** title of this song */
	private final String title;

	/**
	 * Create a new Song with the given title, album title, artist, and genre.
	 * 
	 * @param title title of this song
	 * @param album title of the album on which this song appears
	 * @param artist name of the artist who performed this song
	 * @param genre musical genre of this song
	 */
	public Song(String title, String album, String artist, String genre) {
		this.title = title;
		this.album = album;
		this.artist = artist;
		this.genre = genre;
	}

	/**
	 * @return album on which this song appears
	 */
	public String getAlbum() {
		return album;
	}

	/**
	 * @return artist who performed this song
	 */
	public String getArtist() {
		return artist;
	}

	/**
	 * @return musical genre of this song
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * @return title of this song
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Test whether this song and another object are both equivalent
	 * songs, with matching titles, album titles, artists, and genres.
	 * 
	 * @return true iff they are the same song
	 */
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Song))
			return false;

		Song song = (Song) other;
		return song.getTitle().equals(title)
		&& song.getArtist().equals(artist)
		&& song.getAlbum().equals(album)
		&& song.getGenre().equals(genre);
	}
	
	@Override
	public String toString() {
		return String.format("\"%s\" (%s) by %s on \"%s\"", title, genre, artist, album);
	}
}
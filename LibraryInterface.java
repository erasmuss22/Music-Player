/**
 * Abstract interface to a music library, consisting of a set of songs.
 * 
 * @author Ben Liblit
 */
public interface LibraryInterface {

	/**
	 * Return the songs from this library that have the given genre.
	 * 
	 * @param genre
	 *            genre of songs to return
	 * @return set of songs with the given genre
	 */
	SimpleSet<Song> songsHavingGenre(String genre);

	/**
	 * Return the songs from this library that are by the given artist.
	 * 
	 * @param artist
	 *            artist of songs to return
	 * @return set of songs by the given artist
	 */
	SimpleSet<Song> songsHavingArtist(String artist);

	/**
	 * Return the songs on the given album.
	 * 
	 * @param album
	 *            album of songs to return
	 * @return set of songs on the given album
	 */
	SimpleSet<Song> songsHavingAlbum(String album);

	/**
	 * Return all songs in this library.
	 * 
	 * @return set of songs in this library
	 */
	SimpleSet<Song> allSongs();

    /**
     * Return all distinct genres of all songs in this library.
     * 
     * @return set of genres of songs in this library
     */
    SimpleSet<String> allGenres();

    /**
     * Return all distinct artists of all songs in this library.
     * 
     * @return set of artists of songs in this library
     */
    SimpleSet<String> allArtists();

    /**
     * Return all distinct albums of all songs in this library.
     * 
     * @return set of albums of songs in this library
     */
    SimpleSet<String> allAlbums();

}
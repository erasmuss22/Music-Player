///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  Browser.java
// File:             Library.java
// Semester:         Spring 2011
//
// Author:           Erin Rasmussen  ejrasmussen2@wisc.edu
// CS Login:         rasmusse
// Lecturer's Name:  Beck Hasti
// Lab Section:      Lecture 2
//
//                   
//////////////////////////// 80 columns wide //////////////////////////////////

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.io.IOException;

/**
 * Concrete implementation of a music library, consisting of a set of songs.
 * <p>
 * <strong>Modify this class to implement the required {@link LibraryInterface}
 * methods along with any private fields or methods you feel are
 * necessary.</strong>
 */
public class Library implements LibraryInterface {
	private LinkedSet<Song> songList = new LinkedSet<Song>();
	private LinkedSet<String> allAlbums = new LinkedSet<String>();
	private LinkedSet<String> allArtists = new LinkedSet<String>();
	private LinkedSet<String> allGenres = new LinkedSet<String>();
	private Iterator<Song> iter;

	/**
	 * Create a new music library, reading song metadata from the given
	 * filename.
	 * 
	 * @param filename
	 *            name of the file containing song metadata
	 * @throws IOException
	 *             if the named file cannot be found or read
	 */
	public Library(final File filename) throws IOException {
		try {
			Scanner in = new Scanner(filename);
			String songTitle;
			String albumTitle;
			String artist;
			String genre;
			int position;
			while (in.hasNextLine()){
				position = 0;
				String a = in.nextLine();
				while(a.charAt(position) != ';'){
					position++;
				}
				songTitle = a.substring(0,position);
				position++;
				int j = position;
				while(a.charAt(position) != ';'){
					position++;
				}
				albumTitle = a.substring(j, position);
				position++;
				j = position;
				while(a.charAt(position) != ';'){
					position++;
				}
				artist = a.substring(j, position);
				position++;
				genre = a.substring(position);
				songList.add(new Song(songTitle, albumTitle, artist, genre));
			}
		} catch(FileNotFoundException e){
			System.out.println("Problem with file: <" + filename + ">");
			System.exit(0);
		} 
		allArtists = (LinkedSet<String>) allArtists();
		allAlbums = (LinkedSet<String>) allAlbums();
		allGenres = (LinkedSet<String>) allGenres();
	}

	@Override
	public SimpleSet<Song> songsHavingGenre(String genre) {
		LinkedSet<Song> sameGenre = new LinkedSet<Song>();
		iter = songList.iterator();
		String g;
		Song s;
		while (iter.hasNext()){
			s = iter.next();
			g = s.getGenre();
			if (g.equals(genre)){
				sameGenre.add(s);
			}
		}
		return sameGenre;
	}

	@Override
	public SimpleSet<Song> songsHavingArtist(String artist) {
		LinkedSet<Song> sameArtist = new LinkedSet<Song>();
		iter = songList.iterator();
		String g;
		Song s;
		while (iter.hasNext()){
			s = iter.next();
			g = s.getArtist();
			if (g.equals(artist)){
				sameArtist.add(s);
			}
		}
		return sameArtist;
	}

	@Override
	public SimpleSet<Song> songsHavingAlbum(String album) {
		LinkedSet<Song> sameAlbum = new LinkedSet<Song>();
		iter = songList.iterator();
		String g;
		Song s;
		while (iter.hasNext()){
			s = iter.next();
			g = s.getAlbum();
			if (g.equals(album)){
				sameAlbum.add(s);
			}
		}
		return sameAlbum;
	}

	@Override
	public SimpleSet<Song> allSongs() {
		return songList;
	}

	@Override
	public SimpleSet<String> allGenres() {
		LinkedSet<String> allGenres = new LinkedSet<String>();
		iter = songList.iterator();
		String g;
		String t;
		while (iter.hasNext()){
			g = iter.next().getGenre();
			Iterator<String> iter2 = allGenres.iterator();
			boolean found = false;
			while(iter2.hasNext() && !found){
				t = iter2.next();
				found = g.equals(t);
			}
			if(!found){
				allGenres.add(g);
			}
		}
		return allGenres;

	}

	@Override
	public SimpleSet<String> allArtists() {
		LinkedSet<String> allArtists = new LinkedSet<String>();
		iter = songList.iterator();
		String g;
		String t;
		while (iter.hasNext()){
			g = iter.next().getArtist();
			Iterator<String> iter2 = allArtists.iterator();
			boolean found = false;
			while(iter2.hasNext() && !found){
				t = iter2.next();
				found = g.equals(t);
			}
			if(!found){
				allArtists.add(g);
			}
		}
		return allArtists;

	}

	@Override
	public SimpleSet<String> allAlbums() {
		LinkedSet<String> allAlbums = new LinkedSet<String>();
		iter = songList.iterator();
		String g;
		String t;
		while (iter.hasNext()){
			g = iter.next().getAlbum();
			Iterator<String> iter2 = allAlbums.iterator();
			boolean found = false;
			while(iter2.hasNext() && !found){
				t = iter2.next();
				found = g.equals(t);
			}
			if(!found){
				allAlbums.add(g);
			}
		}
		return allAlbums;
	}


}
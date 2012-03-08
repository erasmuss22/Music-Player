///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            Music Library
// Files:            Browser.java, Library.java, LibrayInterface.java,
//					 SimpleSet.java, DoubleListnode.java, LinkedSet.java,
//					 LinkedSetIterator.java, Song.java
// Semester:         Spring 2011
//
// Author:           Erin Rasmussen  ejrasmussen2@wisc.edu
// CS Login:         rasmusse
// Lecturer's Name:  Beck Hasti
// Lab Section:      Lecture 2
//
//                   
//                   STUDENTS WHO GET HELP FROM ANYONE OTHER THAN THEIR PARTNER
// Credits:          TA Jason Power
//////////////////////////// 80 columns wide //////////////////////////////////

import java.util.*;
import java.io.File;
import java.io.IOException;

/**
 * Main song browser application.
 */
public class Browser {

	/**
	 * Main song browser application. Build a library of available songs, then
	 * read a series of song browser selections and show the matching songs for
	 * each.
	 * 
	 * @param args
	 *            command-line arguments
	 * @throws IOException 
	 */
	public static void main(final String[] args) throws IOException {
		if (args.length != 2){
			System.out.println("Usage: java Browser <MusicLibraryFileName>" +
			" <SelectionsFileName>");
			System.exit(0);
		}
		//The following are for SimpleSets of genre, album, and artist names
		SimpleSet<String> ge;
		SimpleSet<String> alb;
		SimpleSet<String> art;
		//The following are for SimpleSets of genre, album, and artist songs
		SimpleSet<Song> genre = new LinkedSet<Song>();
		SimpleSet<Song> album= new LinkedSet<Song>();
		SimpleSet<Song> artist = new LinkedSet<Song>();
		//The following are for computing unions and intersections although the
		//names are intended for intersection, they are reused for unions
		SimpleSet<Song> intermediate;
		SimpleSet<Song> intermediateIntersection;
		SimpleSet<Song> intersect;



		Iterator<String> iterString;
		File filename = new File(args[0]);
		Library library = new Library(filename);
		File file2 = new File(args[1]);
		Scanner in = new Scanner(file2);
		String g;
		int count = 1;;
		int position;
		while (in.hasNextLine()){

			if (count == 1){
				ge = new LinkedSet<String>();
				genre = new LinkedSet<Song>();
				intersect = new LinkedSet<Song>();
				intermediate = new LinkedSet<Song>();
				intermediateIntersection = new LinkedSet<Song>();
				g = in.nextLine();
				position = 0;
				boolean found = false;
				if (g.length() != 0){
					for (int i = 0; i < g.length(); i++){
						if (g.charAt(i) == ';'){
							found = true;
						}
					}
					if (found){
						while(g.charAt(position) != ';'){
							position++;
						}
						ge.add((g.substring(0,position)));
						int j = position + 1;
						for (int i = position + 1; i < g.length(); i++){
							if (g.charAt(i) == ';'){
								ge.add(g.substring(j, i));
								j = i + 1;
							}
							if (i == g.length()-1){
								ge.add(g.substring(j));
							}
						}

					}
					else {
						ge.add(g);
					}

				}
				else{
					genre = library.allSongs();
				}
				count = 2;
				iterString = ge.iterator();
				if (iterString.hasNext()){
					intersect = library.songsHavingGenre(iterString.next());
					genre = intersect;
					iterString = ge.iterator();
					while (iterString.hasNext()){
						g = iterString.next();
						intermediate = genre;
						genre = library.songsHavingGenre(g);
						intermediateIntersection = genre.union(intermediate);
						intersect = intersect.union(intermediateIntersection);
					}
					genre = intersect;
				}
			}

			else if(count == 2){
				artist = new LinkedSet<Song>();
				intersect = new LinkedSet<Song>();
				intermediate = new LinkedSet<Song>();
				intermediateIntersection = new LinkedSet<Song>();
				art = new LinkedSet<String>();
				g = in.nextLine();
				position = 0;
				boolean done = false;
				if (g.length() != 0){
					for (int i = 0; i < g.length(); i++){
						if (g.charAt(i) == ';'){
							done = true;
						}
					}
					if (done){
						while(g.charAt(position) != ';'){
							position++;
						}
						art.add((g.substring(0,position)));
						int j = position + 1;
						for (int i = position + 1; i < g.length(); i++){
							if (g.charAt(i) == ';'){
								art.add(g.substring(j, i));
								j = i + 1;
							}
							if (i == g.length()-1){
								art.add(g.substring(j));
							}
						}
					}
					else {
						art.add(g);
					}


				}
				else{
					artist = library.allSongs();
				}
				count = 3;
				iterString = art.iterator();
				if (iterString.hasNext()){
					intersect = library.songsHavingArtist(iterString.next());
					iterString = art.iterator();
					artist = intersect;
					while (iterString.hasNext()){
						g = iterString.next();
						intermediate = artist;
						artist = library.songsHavingArtist(g);
						intermediateIntersection = artist.union(intermediate);
						intersect = intersect.union(intermediateIntersection);
					}
					artist = intersect;
				}
			}

			else if(count == 3){
				album = new LinkedSet<Song>();
				intersect = new LinkedSet<Song>();
				intermediate = new LinkedSet<Song>();
				intermediateIntersection = new LinkedSet<Song>();
				alb = new LinkedSet<String>();
				g = in.nextLine();
				position = 0;
				count = 4;
				boolean finished = false;
				if (g.length() != 0){
					for (int i = 0; i < g.length(); i++){
						if (g.charAt(i) == ';'){
							finished = true;
						}
					}
					if (finished){
						while(g.charAt(position) != ';'){
							position++;
						}
						alb.add((g.substring(0,position)));
						int j = position + 1;
						for (int i = position + 1; i < g.length(); i++){
							if (g.charAt(i) == ';'){
								alb.add(g.substring(j, i));
								j = i + 1;
							}
							if (i == g.length()-1){
								alb.add(g.substring(j));
							}
						}
					}
				}
				else{
					album = library.allSongs();
				}
				iterString = alb.iterator();
				if (iterString.hasNext()){
					intersect = library.songsHavingAlbum(iterString.next());
					iterString = alb.iterator();
					album = intersect;
					while (iterString.hasNext()){
						g = iterString.next();
						intermediate = album;
						album = library.songsHavingAlbum(g);
						intermediateIntersection = album.union(intermediate);
						intersect = intersect.union(intermediateIntersection);

					}
					album = intersect;
				}

			}
			else {
				intersect = artist.intersection(album.intersection(genre));
				printInOrder(intersect);
				System.out.println();
				count = 1;

			}
		}
		intersect = artist.intersection(album.intersection(genre));
		printInOrder(intersect);
		System.out.println();
	}



	private static void printInOrder(SimpleSet<Song> songs) {
		// Do not remove or modify this method!
		ArrayList<String> list = new ArrayList<String>();
		for (Song song : songs)
			list.add(song.toString());
		Collections.sort(list);
		for (String item : list)
			System.out.println(item);
	}

}
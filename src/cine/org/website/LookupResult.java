package cine.org.website;

/**
 * Created with eclipse 9/05/2015 3:12:20 p. m.
 * @Author Juan Sebastian Quiceno <Juan.2114@hotmail.com>
 */
public class LookupResult {
	
	/**
	 * Represents the movie name
	 */
	private final String movieName;
	
	/**
	 * Represents the photo url
	 */
	private final String photoUrl;
	
	/**
	 * Constructs a lookup result
	 * @param photoUrl	the photo url
	 * @param movieName	the movie name
	 */
	public LookupResult(final String movieName, final String photoUrl) {
		this.movieName = movieName;
		this.photoUrl = photoUrl;
	}
	
	/**
	 * Returns the movie name
	 * @return	the movie name
	 */
	public String getMovieName() {
		return movieName;
	}
	
	/**
	 * Returns the photo url
	 * @return	the photo url
	 */
	public String getPhotoUrl() {
		return photoUrl;
	}
}

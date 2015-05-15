package cine.org.website.interfaces;

/**
 * Created with eclipse 9/05/2015 3:16:45 p. m.
 * @Author Juan Sebastian Quiceno <Juan.2114@hotmail.com>
 */
public class Lookup {

	/**
	 * Represents the lookup key
	 */
	private final String key;
	
	/**
	 * Represents the lookup value
	 */
	private final String value;

	/**
	 * Constructs a lookup based on the given key and value
	 * @param key	the key
	 * @param value	the value
	 */
	public Lookup(final String key, final String value) {
		this.key = key;
		this.value = value;
	}
	
	/**
	 * Returns the key
	 * @return	the key
	 */
	public String getKey() {
		return key;
	}
	
	/**
	 * Returns the key
	 * @return	the key
	 */
	public String getValue() {
		return value;
	}
}

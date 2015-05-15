package cine.org.website.interfaces;

import java.util.List;

import cine.org.website.LookupResult;

/**
 * Created with eclipse 9/05/2015 2:55:41 p. m.
 * @Author Juan Sebastian Quiceno <Juan.2114@hotmail.com>
 */
public interface WebsiteInterface<E extends Enum<? extends CityInterface<?>>> {

	/**
	 * Attempts to look up at the website based on the document and the lookups
	 * @param document	the document
	 */
	List<LookupResult> lookUp();
}

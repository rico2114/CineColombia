package cine.org.website;

import cine.org.website.interfaces.CityInterface;
import cine.org.website.interfaces.WebsiteInterface;

/**
 * Created with eclipse 9/05/2015 2:59:07 p. m.
 * @Author Juan Sebastian Quiceno <Juan.2114@hotmail.com>
 */
public abstract class AbstractWebsite<E extends Enum<? extends CityInterface<?>>> implements WebsiteInterface<E> {
	
}

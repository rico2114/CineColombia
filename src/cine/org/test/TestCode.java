package cine.org.test;

import java.io.IOException;
import java.util.List;

import cine.org.website.LookupResult;
import cine.org.website.impl.CineMarkWebsite;
import cine.org.website.impl.CineMarkWebsite.CineMarkCities;

/**
 * Created with eclipse 9/05/2015 3:51:40 p. m.
 * @Author Juan Sebastian Quiceno <Juan.2114@hotmail.com>
 */
public class TestCode {

	public static void main(String[] args) throws IOException {
		/*final CineColombiaWebsite website = CineColombiaWebsite.create(CineColombiaCities.CALI);*/
		final CineMarkWebsite website = CineMarkWebsite.create(CineMarkCities.CALI);
		List<LookupResult> results = website.lookUp();
		int id = 0;
		for (LookupResult result : results) {
			System.out.println("MOVIE [" + result.getMovieName() + ";" + result.getPhotoUrl() + "]");
			//ImageUtils.saveImage("./test/" + (id ++) + ".jpg", ImageUtils.getImage(result.getPhotoUrl()));
		}
	}
}

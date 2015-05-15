package cine.org.website.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import cine.org.utils.ElementUtils;
import cine.org.website.AbstractWebsite;
import cine.org.website.LookupResult;
import cine.org.website.impl.CineColombiaWebsite.CineColombiaCities;
import cine.org.website.interfaces.CityInterface;
import cine.org.website.interfaces.Lookup;

/**
 * Created with eclipse 10/05/2015 2:41:44 p. m.
 * @Author Juan Sebastian Quiceno <Juan.2114@hotmail.com>
 */
public class CineColombiaWebsite extends AbstractWebsite<CineColombiaCities> {

	/**
	 * Represents the default cine colombia url
	 */
	private static final String URL = "http://www.cinecolombia.com/cartelera/"; // we need to fill in city value!
	
	/**
	 * Represents the default cine colombia movie name lookup
	 */
	private static final Lookup MOVIE_NAME_LOOKUP = new Lookup("class", "titulo_pelicula_typo01");

	/**
	 * Represents the default movie image lookup
	 */
	private static final Lookup MOVIE_IMAGE_LOOKUP = new Lookup("class", "field field-name-field-imagen-un-valor");
	
	/**
	 * Represents the local document of the website
	 */
	private final Document document;
	
	/**
	 * Constructs the cinemark website
	 * @param document	the website document
	 */
	private CineColombiaWebsite(final Document document) {
		this.document = document;
	}
	
	@Override
	public List<LookupResult> lookUp() {
		final Elements elements = document.getAllElements();
		final List<LookupResult> results = new ArrayList<>();
		for (Element element : elements) {						
			final Element titleElement = ElementUtils.next(element, MOVIE_NAME_LOOKUP);
			final Element imageElement = ElementUtils.next(element, MOVIE_IMAGE_LOOKUP);

			if (Objects.isNull(titleElement) || Objects.isNull(imageElement))
				continue;
			
			String name = ElementUtils.getValueFromElement(titleElement.toString(), 4, "=", ">");
			name = name.substring(1, name.length() - 1);

			String link = ElementUtils.getValueFromElement(imageElement.toString(), 3, "<", ">");
			link = ElementUtils.getValueFromElement(link, 2, "=", " ");

			results.add(new LookupResult(name, link));
		}
		return results;
	}
	
	/**
	 * Creates an instance of the {@link CineMarkWebsite} used for refference and lookup
	 * @param city	the city
	 * @return	the cine mark website
	 */
	public static final CineColombiaWebsite create(final CineColombiaCities city) {
		try {
			return new CineColombiaWebsite(Jsoup.connect(URL + city.getCityValue()).userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6").get());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public enum CineColombiaCities implements CityInterface<String> {
		ARMENIA("armenia"),
		BARRANQUILLA("barranquilla"),
		BOGOTA("bogota"),
		BUCARAMANGA("bucaramanga"),
		CALI("cali"),
		CARTAGENA("cartagena"),
		IBAGUE("ibague"),
		MANIZALES("manizales"),
		MEDELLIN("medellin"),
		MONTERIA("monteria"),
		PEREIRA("pereira"),
		VILLAVICENCIO("villavicencio");

		private final String keyword;
		
		CineColombiaCities(final String keyword) {
			this.keyword = keyword;
		}
		
		@Override
		public String getCityValue() {
			return keyword;
		}
	}
}

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
import cine.org.website.impl.CineMarkWebsite.CineMarkCities;
import cine.org.website.interfaces.CityInterface;
import cine.org.website.interfaces.Lookup;

/**
 * Created with eclipse 9/05/2015 3:20:55 p. m.
 * @Author Juan Sebastian Quiceno <Juan.2114@hotmail.com>
 */
public class CineMarkWebsite extends AbstractWebsite<CineMarkCities> {

	/**
	 * Represents the default cinemark url
	 */
	private static final String URL = "http://www.cinemark.com.co/newface/cartelera.aspx?ciudad="; // we need to fill in city id!
	
	/**
	 * Represents the default cinemark movie name lookup
	 */
	private static final Lookup MOVIE_NAME_LOOKUP = new Lookup("class", "tex_new_title");
	
	/**
	 * Represents the default movie image lookup
	 */
	private static final Lookup MOVIE_IMAGE_LOOKUP = new Lookup("class", "foto_new_peli");
	
	/**
	 * Represents the local document of the website
	 */
	private final Document document;
	
	/**
	 * Constructs the cinemark website
	 * @param document	the website document
	 */
	private CineMarkWebsite(final Document document) {
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

			String linkWithExtraData = ElementUtils.getValueFromElement(imageElement.toString(), 3, "<", ">");
			String link = ElementUtils.getValueFromElement(linkWithExtraData, 2, "=", " ");
			link = link.substring(1, link.length() - 1); 
			
			String name = ElementUtils.getValueFromElement(titleElement.toString(), 3, ">", "<");

			results.add(new LookupResult(name, link));
		}
		return results;
	}
	
	/**
	 * Creates an instance of the {@link CineMarkWebsite} used for refference and lookup
	 * @param city	the city
	 * @return	the cine mark website
	 */
	public static final CineMarkWebsite create(final CineMarkCities city) {
		try {
			return new CineMarkWebsite(Jsoup.connect(URL + city.getCityValue()).get());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Created with eclipse 9/05/2015 3:20:55 p. m.
	 * @Author Juan Sebastian Quiceno <Juan.2114@hotmail.com>
	 */
	public enum CineMarkCities implements CityInterface<Integer> {
		ARMENIA(1),
		BOGOTA(2),
		BUCARAMANGA(3),
		CALI(4),
		CUCUTA(5),
		FLORENCIA(6),
		IBAGUE(7),
		IPIALES(8),
		MANIZALES(9),
		MEDELLIN(10),
		MONTERIA(11),
		NEIVA(12),
		PALMIRA(13),
		PASTO(14),
		PEREIRA(15),
		SANTA_MARTA(16),
		SOLEDAD(17),
		TUNJA(18),
		VALLEDUPAR(19),
		YOPAL(20);
		
		/**
		 * Represents the city id, as for example some websites use the city id as reference
		 */
		private final int cityId;
		
		/**
		 * Constructs the cine mark cities
		 * @param cityId	the city id
		 */
		CineMarkCities(final int cityId) {
			this.cityId = cityId;
		}
		
		@Override
		public Integer getCityValue() {
			return cityId;
		}
		
	}
}

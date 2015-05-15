package cine.org.test;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * Created with eclipse 9/05/2015 2:35:14 p. m.
 * @Author Juan Sebastian Quiceno <Juan.2114@hotmail.com>
 */
public class TestJsoup {

	public static void main(String[] args) throws IOException {
		Document doc = Jsoup.connect("http://www.cinecolombia.com/").userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
			      .get();
		
		for (Element element : doc.getAllElements()) {
			System.out.println("e: " + element.toString());
		}
	} 
	
}

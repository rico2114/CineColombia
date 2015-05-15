package cine.org.utils;

import java.util.StringTokenizer;

import org.jsoup.nodes.Element;

import cine.org.website.interfaces.Lookup;

/**
 * Created with eclipse 9/05/2015 5:23:22 p. m.
 * @Author Juan Sebastian Quiceno <Juan.2114@hotmail.com>
 */
public class ElementUtils {

	/**
	 * A reference for a null value
	 */
	public static final String NULL = "null";

	/**
	 * Gets a desired value placed in the html by some instructions
	 * @param elementLine the element line
	 * @param parseAt being the stop at instruction (grab by residual)
	 * @param delimiter	the delimiter for the {@link StringTokenizer} 
	 * @param cutter	the finisher to use as reference to crop the text
	 * @return	the string
	 */
	public static String getValueFromElement(String elementLine, int parseAt, String delimiter, String cutter) {
		final StringTokenizer tokenizer = new StringTokenizer(elementLine, delimiter);
		int residual = 1; // one because we use normal number system (1 - 9)
		while (tokenizer.hasMoreTokens()) {
			String next = tokenizer.nextToken();
			
			if ((residual ++ % parseAt) == 0) {
				int index = next.indexOf(cutter);
				next = next.substring(0, index);
				return next;
			}
		}
		return NULL;
	}
	
	/**
	 * Returns the next finding of the 'element' for the 'lookup'
	 * @param element	the element to search in
	 * @param lookup	the lookup to gather
	 * @return	the element from the search
	 */
	public static Element next(Element element, final Lookup lookup) {
		for (Element e : element.getElementsByAttributeValueMatching(lookup.getKey(), lookup.getValue())) {
			return e;
		}
		return null;
	}
}

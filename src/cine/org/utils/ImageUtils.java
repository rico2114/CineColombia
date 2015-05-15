package cine.org.utils;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created with eclipse 9/05/2015 5:59:37 p. m.
 * 
 * @Author Juan Sebastian Quiceno <Juan.2114@hotmail.com>
 */
public class ImageUtils {

	public static final byte [] NULL = new byte [] {
		-1
	};
	
	public static byte[] getImage(final String urlLink) {
		try {
			URL url = new URL(urlLink);
			InputStream in = new BufferedInputStream(url.openStream());
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			int n = 0;
			while (-1 != (n = in.read(buf))) {
				out.write(buf, 0, n);
			}
			out.close();
			in.close();
			return out.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return NULL;
	}
	
	public static void saveImage(final String path, final byte [] data) {
		try {
			FileOutputStream fos = new FileOutputStream(path);
			fos.write(data);
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

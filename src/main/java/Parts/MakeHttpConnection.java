package Parts;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;

public class MakeHttpConnection {
	 public String getHttpConnection(String uri, String param) throws ServletException, IOException {
			URL url = new URL(uri);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			try (OutputStream stream = conn.getOutputStream()) {
				try (BufferedWriter wd = new BufferedWriter(new OutputStreamWriter(stream))) {
					wd.write(param);
				}
			}
			int responseCode = conn.getResponseCode();
			System.out.println(responseCode);
			String line;
			StringBuffer buffer = new StringBuffer();
			try (InputStream stream = conn.getInputStream()) {
				try (BufferedReader rd = new BufferedReader(new InputStreamReader(stream))) {
					while ((line = rd.readLine()) != null) {
						buffer.append(line);
						buffer.append('\r');
					}
				}
			} catch (Throwable e) {
				e.printStackTrace();
			}
			return buffer.toString();
		}
	 public String getHttpConnectionGet(String uri, String param) throws ServletException, IOException {
			URL url = new URL(uri+"?"+param);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			int responseCode = conn.getResponseCode();
			System.out.println(responseCode);
			String line;
			StringBuffer buffer = new StringBuffer();
			try (InputStream stream = conn.getInputStream()) {
				try (BufferedReader rd = new BufferedReader(new InputStreamReader(stream))) {
					while ((line = rd.readLine()) != null) {
						buffer.append(line);
						buffer.append('\r');
					}
				}
			} catch (Throwable e) {
				e.printStackTrace();
			}
			return buffer.toString();
		}
}

package com.lxisoft;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
@RestController
public class TextLocalController {

	
 @RequestMapping("/textlocal/sms")
	public String sms(){
	/* try {
			// Construct data
			String apiKey = "apikey=" + URLEncoder.encode("8129d7828938ba16913f9d9153831a724d27ec3be4d9281dae7ef47d2840bdbf", "UTF-8");
			String message = "&message=" + URLEncoder.encode("This is your message", "UTF-8");
			String sender = "&sender=" + URLEncoder.encode("TXTLCL", "UTF-8");
			String numbers = "&numbers=" + URLEncoder.encode("918907097783", "UTF-8");
			
			// Send data
			String data = "https://api.txtlocal.com/send/?" + apiKey + numbers + message + sender;
			URL url = new URL(data);
			URLConnection conn = url.openConnection();
			conn.setDoOutput(true);
			
			// Get the response
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			String sResult="";
			while ((line = rd.readLine()) != null) {
			// Process line...
				sResult=sResult+line+" ";
			}
			rd.close();
			
			return sResult;
		} catch (Exception e) {
			System.out.println("Error SMS "+e);
			return "Error "+e;
		}
	 */
	 
	 try {
			// Construct data
			String apiKey = "apikey=" + "eXqAUrY3p7E-Ycvl4IaAd8PL0auKDGOk0YWvMaGcT0";
			String message = "&message=" + "This is your message";
			String sender = "&sender=" + "TXTLCL";
			String numbers = "&numbers=" + "917293041900";
			
			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
			String data = apiKey + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();
			
			return stringBuffer.toString();
		} catch (Exception e) {
			System.out.println("Error SMS "+e);
			return "Error "+e;
		}
     }
 
 		@RequestMapping("/contact")
 		public String createContact(){
 			try {
 				// Construct data
 				String apiKey = "apikey=" + "eXqAUrY3p7E-Ycvl4IaAd8PL0auKDGOk0YWvMaGcT0";
 				String numbers = "&numbers=" + "917293041900";
 				String group_id = "&group_id=" + "0";
 				
 				// Send data
 				HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/create_contacts/?").openConnection();
 				String data = apiKey + numbers + group_id;
 				conn.setDoOutput(true);
 				conn.setRequestMethod("POST");
 				conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
 				conn.getOutputStream().write(data.getBytes("UTF-8"));
 				final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
 				final StringBuffer stringBuffer = new StringBuffer();
 				String line;
 				while ((line = rd.readLine()) != null) {
 					stringBuffer.append(line);
 				}
 				rd.close();
 				
 				return stringBuffer.toString();
 			} catch (Exception e) {
 				System.out.println("Error SMS "+e);
 				return "Error "+e;
 			}
 		}
	
 		@RequestMapping("/id")
 		public String groupId(){
 			try {
 				// Construct data
 				String apiKey = "apikey=" + "eXqAUrY3p7E-Ycvl4IaAd8PL0auKDGOk0YWvMaGcT0";
 				
 				// Send data
 				HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/get_groups/?").openConnection();
 				String data = apiKey;
 				conn.setDoOutput(true);
 				conn.setRequestMethod("POST");
 				conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
 				conn.getOutputStream().write(data.getBytes("UTF-8"));
 				final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
 				final StringBuffer stringBuffer = new StringBuffer();
 				String line;
 				while ((line = rd.readLine()) != null) {
 					stringBuffer.append(line);
 				}
 				rd.close();
 				
 				return stringBuffer.toString();
 			} catch (Exception e) {
 				System.out.println("Error SMS "+e);
 				return "Error "+e;
 			}
 		}
}

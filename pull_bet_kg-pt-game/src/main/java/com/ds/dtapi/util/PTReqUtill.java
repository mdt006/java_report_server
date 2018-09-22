package com.ds.dtapi.util;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.text.MessageFormat;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

public class PTReqUtill {
	private Logger logger=Logger.getLogger(PTReqUtill.class);
	public static void main(String[] args) {
		String password="changeit";//O8w1oUxm
    	String entityKey="0668ba1297e7481c05495767b6636b6375287a3dc7436160ab86776c36d064a2012f266be0f4bfc7b4514fd77037b6724786d997119b59806c23c3096f715034";
//        String baseURI="https://kioskpublicapi.grandmandarin88.com";
        String baseURI="https://kioskpublicapi.luckyspin88.com";
        String url=getUrlParam("2018-08-15%2017:00:00", "2018-08-15%2017:30:00", 1, 1);
		try {
			String resp=CallAPI(password, entityKey, baseURI+url);
			System.out.println(baseURI+url);
			System.out.println(resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
        
	}
	
	public static String CallAPI(String password,String entityKey,String url)throws Exception{
		String resp="";
        	 KeyStore ks = KeyStore.getInstance("PKCS12"); 
        	 //E:\\infors\\play.p12
			//get certificate file from test/resources as InputFileStream & load to existing keystore
        	URL filePath=PTReqUtill.class.getClassLoader().getResource("new_pt.p12");
			File file = new File(filePath.getFile());
			
//			System.out.println("filePath:"+filePath);
//			URL fileURL = new File("E:\\devlop\\apache-tomcat-8-2\\webapps\\task_pt_record\\WEB-INF\\classes\\play.p12").toURI().toURL();
//			File file = new File(fileURL.getFile());

//	        System.out.println("file:"+file);        
			FileInputStream fis = new FileInputStream(file);
			ks.load(fis, password.toCharArray());
			
			//Create KeyManagerFactory using loaded keystore
			KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
	        kmf.init(ks, password.toCharArray());
	        KeyManager[] kms = kmf.getKeyManagers();
	        
	        //Crete TrustManager to bypass trusted certificate check
	        TrustManager[] trustAllCerts = new TrustManager[] {
					   new X509TrustManager() {
					      public java.security.cert.X509Certificate[] getAcceptedIssuers() {
					        return null;
					      }
	
					      public void checkClientTrusted(X509Certificate[] certs, String authType) {  }
	
					      public void checkServerTrusted(X509Certificate[] certs, String authType) {  }
	
					   }
					};
	        
	        //Hostname verification bypass method
	        HostnameVerifier allHostsValid = new HostnameVerifier() {
	            public boolean verify(String hostname, SSLSession session) {
	              return true;
	            }
	        };
	        
	        //Set connection properties to use bypass certificate/hostname check methods
	        SSLContext sslContext = null;
	        sslContext = SSLContext.getInstance("TLS");        
	        sslContext.init(kms, trustAllCerts, new SecureRandom());        
	        HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
	        HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
	        
	        //Send API call together with entity key for validation/playername/AYPING4569
	        ///
//	        String url=baseURI+"/customreport/getdata/reportname/PlayerGames/startdate/2017-11-01%2009:35:00/enddate/2017-11-01%2010:00:00/frozen/all/page/1/perPage/1";

//	        String url=baseURI+"/game/flow/startdate/2017-11-01 10:10:53/enddate/2017-11-01 10:17:38/page/1/perPage/1";
	        HttpsURLConnection connection = (HttpsURLConnection) new URL(url).openConnection();		
			connection.setRequestProperty("X_ENTITY_KEY", 
					entityKey);
			connection.setReadTimeout(120000);
			connection.setConnectTimeout(120000);
			
			InputStream response = connection.getInputStream();
			resp = IOUtils.toString(response,"utf-8");	
			connection.disconnect(); 
        
    	return resp;
    }
	
	public static String getUrlParam(String startdate,String enddate,int page,int pageSize){
		String url="/customreport/getdata/reportname/PlayerGames/startdate/{0}/enddate/{1}/frozen/all/page/{2}/perPage/"+pageSize;
		url=MessageFormat.format(url, startdate, enddate, page);
		return url;
	}
	
	public static String getUrlaaa(){
		String url="/customreport/getdata/reportname/PlayerStats/startdate/2018-03-17/enddate/2018-03-17";
		return url;
	}
}

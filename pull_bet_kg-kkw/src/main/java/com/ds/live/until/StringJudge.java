package com.ds.live.until;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Properties;

import com.ds.msg.TelegramMessage;

import net.sf.json.JSONObject;



/**
 * DS 厅太阳城 常量和公用方法
 */
public class StringJudge{
	
	//private static Logger logger = LoggerFactory.getLogger(StringJudge.class);
	
	public static String testSunCityUrl = "http://dsapitest.iasia999.com:81/dsapi/app/api.do";//测试线路
	public static String sunCityUrl = "http://dsapi.dsbet88.com/dsapi/app/api.do";
	//public static String sunhashcode = "ggggggg-df52-46bb-9ac1-bbkkbbbbbbbb"; //测试 hashcode
	//public static String sunhashcode = "5e627ec5-33a9-1e36-e73a-06d6071kgkkw";//线上卡卡湾
	//public static String sunhashcode = "841348ca-6425-dc40-e7ea-843ekgkkwbet";//酷客
	//public static String sunhashcode = "293664a9-aae4-9b3d-875b-fb6mingsheng";//明升
	//public static String sunhashcode = "cf9082e7-3a58-4b39-e62f-2d4fa9e5yifa";//易发--现在的诚信
	
	//菲律宾网
	//public static String sunhashcode = "fevvbgd5-erty-uiop-qw23-qq88ssgbnjmk";
	//public static String sunhashcode = "kkkkkkk-df52-46bb-9ac1-bbbbyfbbbbbb";
	
	//易发 网
	//public static String sunhashcode = "cf9082e7-3a58-4b39-e62f-2d4fa9e5yifa";
	
	//诚信网
	//public static String sunhashcode = "chengxin-dddd-fgbv-sdfg-sdsdsd569llk";
	
	//金煌
	public static String sunhashcode = "jinhuang-cdcc-qqq3-dddv-win7xpwin8dn";
	
	public static Object getSunCityUrl(String key){
		HashMap map = new HashMap();
		map.put("test", testSunCityUrl);
		map.put("kgkkw", sunCityUrl);// 线上 卡卡湾
		map.put("kgkkwbet", sunCityUrl);//线上 酷客
		map.put("mingsheng", sunCityUrl);//线上 明升
		map.put("yifa", sunCityUrl);// 线上 易发
		map.put("feilvbin", sunCityUrl);  //线上 菲律宾
		map.put("chengxinsun", sunCityUrl);//诚信测试线路
		map.put("jinhuang", sunCityUrl);   //金煌
		
		map.put("testkgkkw", testSunCityUrl);//测试线路  卡卡湾
		map.put("testkgkkwbet", testSunCityUrl);//测试线路  卡卡湾
		map.put("testmingsheng", testSunCityUrl);//明升的测试线路
		map.put("testyifa", testSunCityUrl);//易发测试线路
		map.put("testfeilvbin", testSunCityUrl);   //线上 菲律宾
		map.put("testchengxinsun", testSunCityUrl);//诚信正式线路
		map.put("testjinhuang", testSunCityUrl);   //金煌
		
		return map.get(key);
	}
	
	public static Object getSunHashCode(String key){
		HashMap map = new HashMap();
		map.put("test", "ggggggg-df52-46bb-9ac1-bbkkbbbbbbbb");
		map.put("kgkkw", "5e627ec5-33a9-1e36-e73a-06d6071kgkkw");// 线上 卡卡湾
		map.put("kgkkwbet", "841348ca-6425-dc40-e7ea-843ekgkkwbet");//线上 酷客
		map.put("mingsheng", "293664a9-aae4-9b3d-875b-fb6mingsheng");//线上 明升
		map.put("yifa", "cf9082e7-3a58-4b39-e62f-2d4fa9e5yifa");// 线上 易发
		map.put("feilvbin", "fevvbgd5-erty-uiop-qw23-qq88ssgbnjmk"); // 菲律宾线上 hashCode
		map.put("chengxinsun", "chengxin-dddd-fgbv-sdfg-sdsdsd569llk");//诚信正式线路
		map.put("jinhuang", "jinhuang-cdcc-qqq3-dddv-win7xpwin8dn");//金煌
		
		map.put("testkgkkw", "sdsfsss-df53-46bb-9568-aakgkkwaaaaa");//测试线路  卡卡湾
		map.put("testkgkkwbet", "xdxdxdx-df53-46bb-9568-aakgkkwbetaa");//测试线路  酷客
		map.put("testmingsheng", "zdzdzdz-df53-46bb-9568-aamingshenga");//明升的测试线路
		map.put("testyifa", "scscscs-df53-46bb-9568-aayifakwaaaa");//易发测试线路
		map.put("testfeilvbin", "ddccvvfh-df53-46bb-9568-testfeilvbin");//菲律宾测试线路
		map.put("testchengxinsun", "testchengxin-ssss-sfsf-llls-sfoklPNs"); //诚信试玩线路
		map.put("testjinhuang", "testjinhuang-ssss-ffvf-jjyy-3davnika");//金煌
		
		return map.get(key);
	}
	
	public static Object getSunPrefix(String key){
		HashMap map = new HashMap();
		map.put("kgkkw", "kw");
		map.put("kgkkwbet", "kk");
		map.put("mingsheng", "mi");
		map.put("yifa", "yi");
		map.put("chengxinsun", "cx");
		map.put("testchengxinsun", "testcx");
		
		return map.get(key);
	}
	
	/**
	 * HttpPost 方法
	 */
	public static String sunPost(JSONObject obj){
		//HttpPost post = new HttpPost(SiteLiveName.sunCityUrl);
		//HttpResponse response = null;
		//DefaultHttpClient httpclient = new DefaultHttpClient();
		try{
			/*StringEntity entity = new StringEntity(obj.toString(),"utf-8");
			post.setEntity(entity);
			post.setHeader("Content-Type", "application/json;charset=iso-8859-1");
			response = httpclient.execute(post);
			
			if(response.getStatusLine().getStatusCode()==200){ //请求成功
				HttpEntity responseEntity = response.getEntity(); 
				
				BufferedReader reader = new BufferedReader(new InputStreamReader(  
						responseEntity.getContent(), "UTF-8"));
				 
				StringBuffer str = new StringBuffer();
				String temp = null;
				System.out.println("line::" + reader.readLine());
				while((temp = reader.readLine()) != null){
					str.append(temp);
					System.out.println("temp:" + temp);
				}
				 
				
				HttpSiteCommander commander = new HttpSiteCommander();
				SiteResponseObj responseObj = null;
				responseObj = AllyUtil.fromJson(commander.getResponseMsg(response), SiteResponseObj.class);
				System.out.println("errorCode:" + responseObj.getErrorMessage());
				
				 //return str.toString();
			}else{
				logger.info("StringJudge 太阳城请求不到...." + response.getStatusLine().getStatusCode());
			}*/
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 向指定URL 发送 post方法请求
	 * @param url 发送请求的 URL
	 * @param param 请求参数，请求参数应该是 name1=value&name2=value2的形式
	 * @return URL所代表远程资源的响应
	 */
	public static String sendPost1(String url,String param){
		
		PrintWriter out = null;
		BufferedReader in = null;
		StringBuffer result = new StringBuffer();
		
		try{
			
			URL realUrl = new URL(url);
			URLConnection conn = realUrl.openConnection();
			conn.setConnectTimeout(300000);//连接超时时间
			conn.setReadTimeout(300000); 
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent",
			"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
			
			//发送POST请求必须设置如下两行 
			conn.setDoOutput(true);
			conn.setDoInput(true); 
			
			//获取URLConnection对象对应的输出流 
			out = new PrintWriter(conn.getOutputStream()); 
			
			//发送请求参数
			out.print(param); 
			
			//flush输出流的缓冲
			out.flush();
			
			//定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(
			new InputStreamReader(conn.getInputStream()));//报错
			String line; 
			
			while ((line = in.readLine())!= null){
				result.append(line);
				//System.out.println("line::" + line);
				//logger.info(line);
				
			} 
			//System.out.println("line:::" + result);
		}catch(Exception e){
			e.printStackTrace();
			TelegramMessage telegramMessage = TelegramMessage.getInstance();
        	telegramMessage.sendMessage(LiveConfig.BOT_A, LiveConfig.GROUP_JAVA, LiveConfig.TELEGRAM_HTTP_ERROR, 
        			"KKWDS视讯注单拉取请求异常， error："+ErrorUtil.LogExceptionStack(e));
		}
		
		return result.toString();
	}
	
	public static String toMD5(String str){
	     try
	     {
	       MessageDigest md = MessageDigest.getInstance("MD5");
	       md.update(str.getBytes());
	       byte[] byteDigest = md.digest();
	 
	       StringBuffer buf = new StringBuffer("");
	       for (int offset = 0; offset < byteDigest.length; offset++) {
	         int i = byteDigest[offset];
	         if (i < 0)
	           i += 256;
	         if (i < 16)
	           buf.append("0");
	         buf.append(Integer.toHexString(i));
	       }
	 
	       return buf.toString();
	     } catch (NoSuchAlgorithmException e) {
	         e.printStackTrace();
	     }
	     
	     return null;
	}
	
	//判断是否为空
	public static boolean isParam(String website,String username,String uppername,String key){
		
		if(null == website || null == username || null==uppername || null==key){
			return true;
		}
		
		return false;
	}
	
	public static boolean isUppername(String uppername){
		//if(SiteLiveName.kkw_uppername.equals(uppername)){
		//	return false;
		//}
		
		return true;
	}
	
	 private Properties propertie;
	 private FileInputStream inputFile;
	
	public static void main(String[] args) {
		//StringJudge judge = new StringJudge();
		//judge.Configuration();
		String uppername = "testkkw";
		if(uppername.contains("test")){
			System.out.println("test::");
		}else{
			System.out.println("uppername::");
		}
	}
	
	public void Configuration(){
		propertie = new Properties();
		try{
			inputFile = new FileInputStream("../classes/config.properties");
			propertie.load(inputFile);
			System.out.println("hashCode:"+propertie.getProperty("hashCode"));
		}catch(FileNotFoundException ex){
			System.out.println("读取属性文件--->失败！- 原因：文件路径错误或者文件不存在");
			ex.printStackTrace();
		}catch(IOException e){
			System.out.println("装载文件--->失败!");
			e.printStackTrace();
		}
	}
}

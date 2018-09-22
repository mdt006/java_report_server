package com.ds.sgs.util;

import java.io.StringReader;
import java.util.Date;
import java.util.List;

import com.ds.sgs.vo.SgsCsvVo;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;

public class Test {
	
	public static String getBetList() throws Exception{
		
		String client_secret = "FrFBfKlUHvaK9jFMhM6YfEyclWSVljAnc5019KaxaMEi";
		
		
//		String url = "http://sctrapi.sbuat.com/api/report/bethistory?startdate=2018-06-07T09:00:20Z&enddate=2018-06-07T09:30:20Z"
//				+ "&includetestplayers=true&issettled=true";
		
		String url = "http://sctrapi.sbuat.com/api/report/bethistory?startdate=2018-06-26T01:17:48Z&enddate=2018-06-26T01:47:48Z&includetestplayers=true&issettled=true";
		String sgsDate = DateUtils.getUTCTime(new Date(), true);
		System.out.println(sgsDate);
		String sign= client_secret + sgsDate;
			
		String signature = SHA1Utils.genHMAC2(client_secret, sign);
		
		String result = HttpClientUtils.sendSgsGet(url, signature, sgsDate, "DTA");
		return result;
	}
		
		
	public static void main(String[] args) throws Exception {
		String result = getBetList();
//		String result = "ugsbetid,txid,beton\n123123,123,2016-10-25T20:00:00-07:00";
		System.out.println(result);
//		InputStream inputStream = new ByteArrayInputStream(result.getBytes());
		
//		FileInputStream is = new FileInputStream(result);  
//		CSVReader reader = new CSVReader(new InputStreamReader(inputStream));
		
		
		HeaderColumnNameMappingStrategy<SgsCsvVo> mapper = new HeaderColumnNameMappingStrategy<SgsCsvVo>();
		mapper.setType(SgsCsvVo.class);
		CsvToBean<SgsCsvVo> csvToBean = new CsvToBean<SgsCsvVo>(); 
		List<SgsCsvVo> list = csvToBean.parse(mapper,new StringReader(result));
		
		System.out.println("result:--------"+list.size());
		for (SgsCsvVo sgsResult : list) {
//			System.out.println(sgsResult.getUgsBetId()+"--"+sgsResult.getTxid()+"--"+sgsResult.getBetOn());
			
			System.out.println(DateUtils.getGMT8Date(sgsResult.getBetOn()));
			
		}
		
	}
		
}


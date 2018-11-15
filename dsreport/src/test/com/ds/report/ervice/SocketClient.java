package com.ds.report.ervice;

import hprose.client.HproseTcpClient;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @Author: Zhali
 * @Description:
 * @Date: Create in 2018-10-24 11:44
 */
public class SocketClient {
    public static void main(String[] args) throws Throwable {
        HproseTcpClient client = new HproseTcpClient("tcp://100.100.0.145:14321/");

        client.setFullDuplex(true);

        client.setMaxPoolSize(1);

        String json1= "{\"siteId\":1000,\"betTimeBegin\":\"2018-11-12\",\"betTimeEnd\":\"2018-11-12\",\"username\":\"azhu000\",\"agentLevel\":\"Superior\",\"waterType\":0,\"page\":\"1\",\"pageLimit\":\"3000\",\"key\":\"6015011c72d9fd68e60a18cac7392858d8fc8925235\"}";
        JSONObject request1 = JSONObject.fromObject(json1);
        // System.out.println(request.toString());
        String json2= "{\"live\":1,\"live_order\":{\"bb\":2,\"ag\":3,\"og\":4,\"sgs\":5,\"kkwds\":6},\"hongkong\":2,\"hongkong_order\":{\"xiaoyuHongkong\":1},\"lotto\":3,\"lotto_order\":{\"xiaoyuLotto\":1,\"fenfenLotto\":2,\"xingyunLotto\":3},\"sport\":4,\"sport_order\":{\"H8Sport\":1,\"BBSport\":2,\"AGSport\":3},\"game\":[{\"gamewater\":\"50.00\",\"gamelist\":{\"5\":\"5011\"}}],\"game_order\":{\"BBGame\":2,\"AgGame\":3,\"MGGame\":4,\"PTGame\":5,\"SgsGame\":6},\"chess\":6,\"chess_order\":{\"kyChess\":1}}";
        JSONObject request2 = JSONObject.fromObject(json2);
        String json3= "[{\"vgold\":\"1\",\"max_return\":\"100000\",\"percent_detail\":{\"live\":{\"ag\":\"12\",\"bb\":\"10\",\"og\":\"10\",\"sgs\":\"10\",\"lmg\":\"10\",\"kkwds\":\"10\"},\"hongkong\":{\"xiaoyuHongkong\":\"10\"},\"lotto\":{\"fenfenLotto\":\"10\",\"xingyunLotto\":\"10\",\"xiaoyuLotto\":\"10\"},\"sport\":{\"BBSport\":\"10\",\"H8Sport\":\"10\",\"AGSport\":\"10\"},\"game\":{\"AgGame\":\"10\",\"MGGame\":\"10\",\"PTGame\":\"10\",\"SgsGame\":\"10\",\"BBGame\":\"10\"},\"chess\":{\"kyChess\":\"10\"}}},{\"vgold\":\"11\",\"max_return\":\"100000\",\"percent_detail\":{\"live\":{\"ag\":\"11\",\"bb\":\"11\",\"og\":\"11\",\"sgs\":\"11\",\"lmg\":\"11\",\"kkwds\":\"11\"},\"hongkong\":{\"xiaoyuHongkong\":\"11\"},\"lotto\":{\"fenfenLotto\":\"11\",\"xingyunLotto\":\"11\",\"xiaoyuLotto\":\"11\"},\"sport\":{\"BBSport\":\"11\",\"H8Sport\":\"11\",\"AGSport\":\"1\"},\"game\":{\"AgGame\":\"10\",\"MGGame\":\"1\",\"PTGame\":\"1\",\"SgsGame\":\"1\",\"BBGame\":\"1\"},\"chess\":{\"kyChess\":\"11\"}}}]";
        JSONArray request3 = JSONArray.fromObject(json3);
        Object obj= client.invoke("waterReportNewByPage", new Object[]{request1.toString(),request2.toString(),request3.toString()});

        System.out.println( obj );
    }


}
package com.ds.live.vo;

import com.alibaba.fastjson.JSONObject;


public class ReturnResult {
	private   Data data =new Data();
	private  boolean result;
	
	
	public ReturnResult(boolean result, Integer code, String message) {
		super();
		this.result = result;
		this.data.Code=code;
		this.data.Message=message;
	}
	public ReturnResult(boolean result, Integer code, String message,Integer TotalPage,Integer TotalNumber) {
		super();
		this.result = result;
		this.data.Code=code;
		this.data.Message=message;
		this.data.TotalPage = TotalPage;
		this.data.TotalNumber = TotalNumber;
	}
	public boolean isResult() {
		return result;
	}


	public void setResult(boolean result) {
		this.result = result;
	}
	
	public Data getData() {
		return data;
	}


	public void setData(Data data) {
		this.data = data;
	}

	
	
	@Override
	public String toString() {
		return JSONObject.toJSONString(this);
	}
	
	public class Data{
		public  Integer Code;
		public  String  Message;
		public  Integer TotalPage;
		public  Integer TotalNumber;
		public void setCode(Integer code) {
			Code = code;
		}
	
		public void setMessage(String message) {
			Message = message;
		}

		public Integer getCode() {
			return Code;
		}

		public String getMessage() {
			return Message;
		}

		public Integer getTotalPage() {
			return TotalPage;
		}

		public void setTotalPage(Integer totalPage) {
			TotalPage = totalPage;
		}

		public Integer getTotalNumber() {
			return TotalNumber;
		}

		public void setTotalNumber(Integer totalNumber) {
			TotalNumber = totalNumber;
		}
		
		
	}
	
}

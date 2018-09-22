package com.kg.live.contants;

public enum APIEnum {
	DELETE(-50),//删除状态
	CLOSE(0),//未启用
	NORMAL(50),//正常状态
	;
	private int nCode;
    
    private APIEnum(int _nCode) {
        this.nCode = _nCode;
    }
    public int getValue() {
    	return nCode;
    }
    @Override
    public String toString() {
    	return String.valueOf(nCode);
    }
}

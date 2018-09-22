package com.kg.live.contants;
public enum PlatformTypeEnum {
	LIVE(1),
	SPROT(2),
	LOTTO(3),
	GAME(4),
	CHESS(5);
	private int nCode;
    
    private PlatformTypeEnum(int _nCode) {
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

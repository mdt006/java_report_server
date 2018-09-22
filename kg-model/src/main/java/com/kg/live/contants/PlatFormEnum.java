package com.kg.live.contants;

public enum PlatFormEnum {
	AG(2),
	OG(3),
	BBIN(11),
	DS(12),
	H8(13),
	MG(15),
	PT(16),
	PMG(17),
	LMG(18),
	KYCHESS(90);
	private int nCode;
    
    private PlatFormEnum(int _nCode) {
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

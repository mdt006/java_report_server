package com.ds.report.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.ds.report.vo.DsLiveDetailVo;

public class DsReportDetail {
    private Integer siteId;
    
    //添加tableid
    private Integer tableId;

    private Byte liveId;

    private String liveName;

    private String username;

    private Integer betCount;

    private BigDecimal betamount;

    private BigDecimal winlose;

    private BigDecimal validamount;
    
	private Integer gameKind;
	
	private String gameKindName;

    private Integer gameType;
    
    private String gameName;

    private Date betTime;

    private String winloseType;

    private String billNo;

    private String tableNo;

    private String serialId;

    private String shoeInfoid;

    private String roundNo;

    private String result;
    
    private String card;
    private String qishu;
    
    private String pan;
	private String pokerList;
	private String bankResult;
	private String resultList;
    
	private String liveMemberReportDetails;
	
	private List<DsLiveDetailVo> liveMemberDetails;
	
	private String item;
	
	private String play;

    private String playInfo;

    private String odds;
    private String odds2;
    private Integer state;
    
	private BigDecimal beforeCredit;
    
    private BigDecimal balanceAfter;
    /****************/
    private String h8HomeName;
    private String h8AwayName;
    private String h8LeagueName;
    /****************/
    private JSONArray pokerListArr;
    private JSONArray bankResultArr;
    private JSONArray resultListArr;
    
    private String betDetailsId;
    private List<String> betDetailList; 
    private String betOnIdExplain;
    private String betTypeIdExplain;
    private BigDecimal jackpot;
    
    
    public BigDecimal getJackpot() {
		return jackpot;
	}
	public void setJackpot(BigDecimal jackpot) {
		this.jackpot = jackpot;
	}
	public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public Byte getLiveId() {
        return liveId;
    }

    public void setLiveId(Byte liveId) {
        this.liveId = liveId;
    }

    public String getLiveName() {
        return liveName;
    }

    public void setLiveName(String liveName) {
        this.liveName = liveName == null ? null : liveName.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Integer getBetCount() {
        return betCount;
    }

    public void setBetCount(Integer betCount) {
        this.betCount = betCount;
    }

    public BigDecimal getBetamount() {
        return betamount;
    }

    public void setBetamount(BigDecimal betamount) {
        this.betamount = betamount;
    }

    public BigDecimal getWinlose() {
        return winlose;
    }

    public void setWinlose(BigDecimal winlose) {
        this.winlose = winlose;
    }

    public BigDecimal getValidamount() {
        return validamount;
    }

    public void setValidamount(BigDecimal validamount) {
        this.validamount = validamount;
    }


	public Integer getGameKind() {
		return gameKind;
	}

	public void setGameKind(Integer gameKind) {
		this.gameKind = gameKind;
	}

	public String getGameKindName() {
		return gameKindName;
	}

	public void setGameKindName(String gameKindName) {
		this.gameKindName = gameKindName;
	}

	public Integer getGameType() {
		return gameType;
	}

	public void setGameType(Integer gameType) {
		this.gameType = gameType;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

    public Date getBetTime() {
        return betTime;
    }

    public void setBetTime(Date betTime) {
        this.betTime = betTime;
    }

    public String getWinloseType() {
        return winloseType;
    }

    public void setWinloseType(String winloseType) {
        this.winloseType = winloseType == null ? null : winloseType.trim();
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo == null ? null : billNo.trim();
    }

    public String getTableNo() {
        return tableNo;
    }

    public void setTableNo(String tableNo) {
        this.tableNo = tableNo == null ? null : tableNo.trim();
    }

    public String getSerialId() {
        return serialId;
    }

    public void setSerialId(String serialId) {
        this.serialId = serialId == null ? null : serialId.trim();
    }

    public String getShoeInfoid() {
        return shoeInfoid;
    }

    public void setShoeInfoid(String shoeInfoid) {
        this.shoeInfoid = shoeInfoid == null ? null : shoeInfoid.trim();
    }

    public String getRoundNo() {
        return roundNo;
    }

    public void setRoundNo(String roundNo) {
        this.roundNo = roundNo == null ? null : roundNo.trim();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }
    

    public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}
    
    public String getPokerList() {
		return pokerList;
	}

	public void setPokerList(String pokerList) {
		this.pokerList = pokerList;
	}

	public String getLiveMemberReportDetails() {
		return liveMemberReportDetails;
	}

	public void setLiveMemberReportDetails(String liveMemberReportDetails) {
		this.liveMemberReportDetails = liveMemberReportDetails;
	}
	

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getPlay() {
		return play;
	}

	public void setPlay(String play) {
		this.play = play;
	}

	public String getPlayInfo() {
		return playInfo;
	}

	public void setPlayInfo(String playInfo) {
		this.playInfo = playInfo;
	}

	public String getOdds() {
		return odds;
	}

	public void setOdds(String odds) {
		this.odds = odds;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public BigDecimal getBeforeCredit() {
		return beforeCredit;
	}

	public void setBeforeCredit(BigDecimal beforeCredit) {
		this.beforeCredit = beforeCredit;
	}

	public BigDecimal getBalanceAfter() {
		return balanceAfter;
	}

	public void setBalanceAfter(BigDecimal balanceAfter) {
		this.balanceAfter = balanceAfter;
	}

	public String getH8HomeName() {
		return h8HomeName;
	}

	public void setH8HomeName(String h8HomeName) {
		this.h8HomeName = h8HomeName;
	}

	public String getH8AwayName() {
		return h8AwayName;
	}

	public void setH8AwayName(String h8AwayName) {
		this.h8AwayName = h8AwayName;
	}

	public String getH8LeagueName() {
		return h8LeagueName;
	}

	public void setH8LeagueName(String h8LeagueName) {
		this.h8LeagueName = h8LeagueName;
	}

	public String getBankResult() {
		return bankResult;
	}

	public void setBankResult(String bankResult) {
		this.bankResult = bankResult;
	}

	public String getResultList() {
		return resultList;
	}

	public void setResultList(String resultList) {
		this.resultList = resultList;
	}

	public List<DsLiveDetailVo> getLiveMemberDetails() {
		return liveMemberDetails;
	}

	public void setLiveMemberDetails(List<DsLiveDetailVo> liveMemberDetails) {
		this.liveMemberDetails = liveMemberDetails;
	}

	public JSONArray getPokerListArr() {
		return pokerListArr;
	}

	public void setPokerListArr(JSONArray pokerListArr) {
		this.pokerListArr = pokerListArr;
	}

	public JSONArray getBankResultArr() {
		return bankResultArr;
	}

	public void setBankResultArr(JSONArray bankResultArr) {
		this.bankResultArr = bankResultArr;
	}

	public JSONArray getResultListArr() {
		return resultListArr;
	}

	public void setResultListArr(JSONArray resultListArr) {
		this.resultListArr = resultListArr;
	}

	public String getQishu() {
		return qishu;
	}

	public void setQishu(String qishu) {
		this.qishu = qishu;
	}

	public String getBetDetailsId() {
		return betDetailsId;
	}

	public void setBetDetailsId(String betDetailsId) {
		this.betDetailsId = betDetailsId;
	}

	public List<String> getBetDetailList() {
		return betDetailList;
	}

	public void setBetDetailList(List<String> betDetailList) {
		this.betDetailList = betDetailList;
	}

	public String getOdds2() {
		return odds2;
	}

	public void setOdds2(String odds2) {
		this.odds2 = odds2;
	}

	public String getBetOnIdExplain() {
		return betOnIdExplain;
	}

	public void setBetOnIdExplain(String betOnIdExplain) {
		this.betOnIdExplain = betOnIdExplain;
	}

	public String getBetTypeIdExplain() {
		return betTypeIdExplain;
	}

	public void setBetTypeIdExplain(String betTypeIdExplain) {
		this.betTypeIdExplain = betTypeIdExplain;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public Integer getTableId() {
		return tableId;
	}
	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}
	
	
}
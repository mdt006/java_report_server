package com.kg.live.entity;

import java.math.BigDecimal;
import java.util.Date;

public class DsAgHunterBuyFishInfo {
    private Long id;

    private Integer siteId;

    private String namepre;

    private String userId;

    private String username;

    private String billId;

    private String billNo;

    private String cashBill;

    private Byte winLossType;

    private String userType;

    private String playerName;

    private String pid;

    private String fishId;

    private Byte fishTypeId;

    private String roomid;

    private Integer sroomId;

    private BigDecimal roombet;

    private BigDecimal userCashBefore;

    private BigDecimal userCashAfter;

    private String hunterUid;

    private String hunterPid;

    private String hunterUserType;

    private String hunterUserName;

    private String fishLife;

    private Integer flag;

    private String read;

    private Integer bulletInFish;

    private BigDecimal bullletCostInFish;

    private BigDecimal bullletCost;

    private BigDecimal netAmount;

    private BigDecimal fishCost;

    private BigDecimal validBetAmount;

    private BigDecimal betAmount;

    private BigDecimal exBonusReturn;

    private Date huntedTime;

    private Date betTime;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public String getNamepre() {
        return namepre;
    }

    public void setNamepre(String namepre) {
        this.namepre = namepre == null ? null : namepre.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId == null ? null : billId.trim();
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo == null ? null : billNo.trim();
    }

    public String getCashBill() {
        return cashBill;
    }

    public void setCashBill(String cashBill) {
        this.cashBill = cashBill == null ? null : cashBill.trim();
    }

    public Byte getWinLossType() {
        return winLossType;
    }

    public void setWinLossType(Byte winLossType) {
        this.winLossType = winLossType;
    }

  

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName == null ? null : playerName.trim();
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public String getFishId() {
        return fishId;
    }

    public void setFishId(String fishId) {
        this.fishId = fishId == null ? null : fishId.trim();
    }

    public Byte getFishTypeId() {
        return fishTypeId;
    }

    public void setFishTypeId(Byte fishTypeId) {
        this.fishTypeId = fishTypeId;
    }

    public String getRoomid() {
        return roomid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid == null ? null : roomid.trim();
    }

    public Integer getSroomId() {
        return sroomId;
    }

    public void setSroomId(Integer sroomId) {
        this.sroomId = sroomId;
    }

    public BigDecimal getRoombet() {
        return roombet;
    }

    public void setRoombet(BigDecimal roombet) {
        this.roombet = roombet;
    }

    public BigDecimal getUserCashBefore() {
        return userCashBefore;
    }

    public void setUserCashBefore(BigDecimal userCashBefore) {
        this.userCashBefore = userCashBefore;
    }

    public BigDecimal getUserCashAfter() {
        return userCashAfter;
    }

    public void setUserCashAfter(BigDecimal userCashAfter) {
        this.userCashAfter = userCashAfter;
    }

    public String getHunterUid() {
        return hunterUid;
    }

    public void setHunterUid(String hunterUid) {
        this.hunterUid = hunterUid == null ? null : hunterUid.trim();
    }

    public String getHunterPid() {
        return hunterPid;
    }

    public void setHunterPid(String hunterPid) {
        this.hunterPid = hunterPid == null ? null : hunterPid.trim();
    }

    public String getHunterUserType() {
        return hunterUserType;
    }

    public void setHunterUserType(String hunterUserType) {
        this.hunterUserType = hunterUserType == null ? null : hunterUserType.trim();
    }

    public String getHunterUserName() {
        return hunterUserName;
    }

    public void setHunterUserName(String hunterUserName) {
        this.hunterUserName = hunterUserName == null ? null : hunterUserName.trim();
    }

    public String getFishLife() {
        return fishLife;
    }

    public void setFishLife(String fishLife) {
        this.fishLife = fishLife == null ? null : fishLife.trim();
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getRead() {
        return read;
    }

    public void setRead(String read) {
        this.read = read == null ? null : read.trim();
    }

    public Integer getBulletInFish() {
        return bulletInFish;
    }

    public void setBulletInFish(Integer bulletInFish) {
        this.bulletInFish = bulletInFish;
    }

    public BigDecimal getBullletCostInFish() {
        return bullletCostInFish;
    }

    public void setBullletCostInFish(BigDecimal bullletCostInFish) {
        this.bullletCostInFish = bullletCostInFish;
    }

    public BigDecimal getBullletCost() {
        return bullletCost;
    }

    public void setBullletCost(BigDecimal bullletCost) {
        this.bullletCost = bullletCost;
    }

    public BigDecimal getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(BigDecimal netAmount) {
        this.netAmount = netAmount;
    }

    public BigDecimal getFishCost() {
        return fishCost;
    }

    public void setFishCost(BigDecimal fishCost) {
        this.fishCost = fishCost;
    }

    public BigDecimal getValidBetAmount() {
        return validBetAmount;
    }

    public void setValidBetAmount(BigDecimal validBetAmount) {
        this.validBetAmount = validBetAmount;
    }

    public BigDecimal getBetAmount() {
        return betAmount;
    }

    public void setBetAmount(BigDecimal betAmount) {
        this.betAmount = betAmount;
    }

    public BigDecimal getExBonusReturn() {
        return exBonusReturn;
    }

    public void setExBonusReturn(BigDecimal exBonusReturn) {
        this.exBonusReturn = exBonusReturn;
    }

    public Date getHuntedTime() {
        return huntedTime;
    }

    public void setHuntedTime(Date huntedTime) {
        this.huntedTime = huntedTime;
    }

    public Date getBetTime() {
        return betTime;
    }

    public void setBetTime(Date betTime) {
        this.betTime = betTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

	/**
	 * @return the userType
	 */
	public String getUserType() {
		return userType;
	}

	/**
	 * @param userType the userType to set
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}
    
}
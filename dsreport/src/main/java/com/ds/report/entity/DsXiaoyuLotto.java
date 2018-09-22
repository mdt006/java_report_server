package com.ds.report.entity;

import java.math.BigDecimal;
import java.util.Date;

public class DsXiaoyuLotto {
    private Long id;

    private String transId;

    private String billno;

    private String username;

    private Integer siteId;

    private String currency;

    private String lottoName;

    private String lottoType;

    private Integer qishu;

    private BigDecimal betAmount;

    private BigDecimal validAmount;

    private BigDecimal payOff;

    private String item;

    private Date betTime;

    private String play;

    private String playInfo;

    private String odds;

    private Integer state;

    private Byte winLossType;

    private String ip;

    private Integer flag;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTransId() {
        return transId;
    }

    public void setTransId(String transId) {
        this.transId = transId == null ? null : transId.trim();
    }

    public String getBillno() {
        return billno;
    }

    public void setBillno(String billno) {
        this.billno = billno == null ? null : billno.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public String getLottoName() {
        return lottoName;
    }

    public void setLottoName(String lottoName) {
        this.lottoName = lottoName == null ? null : lottoName.trim();
    }

    public String getLottoType() {
        return lottoType;
    }

    public void setLottoType(String lottoType) {
        this.lottoType = lottoType == null ? null : lottoType.trim();
    }

    public Integer getQishu() {
        return qishu;
    }

    public void setQishu(Integer qishu) {
        this.qishu = qishu;
    }

    public BigDecimal getBetAmount() {
        return betAmount;
    }

    public void setBetAmount(BigDecimal betAmount) {
        this.betAmount = betAmount;
    }

    public BigDecimal getValidAmount() {
        return validAmount;
    }

    public void setValidAmount(BigDecimal validAmount) {
        this.validAmount = validAmount;
    }

    public BigDecimal getPayOff() {
        return payOff;
    }

    public void setPayOff(BigDecimal payOff) {
        this.payOff = payOff;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item == null ? null : item.trim();
    }

    public Date getBetTime() {
        return betTime;
    }

    public void setBetTime(Date betTime) {
        this.betTime = betTime;
    }

    public String getPlay() {
        return play;
    }

    public void setPlay(String play) {
        this.play = play == null ? null : play.trim();
    }

    public String getPlayInfo() {
        return playInfo;
    }

    public void setPlayInfo(String playInfo) {
        this.playInfo = playInfo == null ? null : playInfo.trim();
    }

    public String getOdds() {
        return odds;
    }

    public void setOdds(String odds) {
        this.odds = odds == null ? null : odds.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Byte getWinLossType() {
        return winLossType;
    }

    public void setWinLossType(Byte winLossType) {
        this.winLossType = winLossType;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
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
}
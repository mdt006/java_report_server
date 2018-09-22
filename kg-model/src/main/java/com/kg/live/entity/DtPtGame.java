package com.kg.live.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class DtPtGame {
    private Long id;

    private Integer siteId;

    private String username;

    private String playername;

    private String windowcode;

    private Integer gameid;

    private String gamecode;

    private String gametype;

    private String gamename;

    private String sessionid;

    private BigDecimal bet;

    private BigDecimal win;

    private BigDecimal progressivebet;

    private BigDecimal progressivewin;

    private BigDecimal balance;

    private BigDecimal currentbet;

    private Integer rnum;

    private Date gamedate;

    private String livenetwork;

    private Date createTime;

    private Date updateTime;
    
    private String info;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }
    
	@JSONField(name = "PLAYERNAME") 
    public String getPlayername() {
        return playername;
    }
	
	@JSONField(name = "PLAYERNAME")
    public void setPlayername(String playername) {
        this.playername = playername == null ? null : playername.trim();
    }
	
	@JSONField(name = "WINDOWCODE")
    public String getWindowcode() {
        return windowcode;
    }
	
	@JSONField(name = "WINDOWCODE")
    public void setWindowcode(String windowcode) {
        this.windowcode = windowcode == null ? null : windowcode.trim();
    }
	
	@JSONField(name = "GAMEID")
    public Integer getGameid() {
        return gameid;
    }
	
	@JSONField(name = "GAMEID")
    public void setGameid(Integer gameid) {
        this.gameid = gameid;
    }
	
	@JSONField(name = "GAMECODE")
    public String getGamecode() {
        return gamecode;
    }
	
	@JSONField(name = "GAMECODE")
    public void setGamecode(String gamecode) {
        this.gamecode = gamecode == null ? null : gamecode.trim();
    }
	
	@JSONField(name = "GAMETYPE")
    public String getGametype() {
        return gametype;
    }
	
	@JSONField(name = "GAMETYPE")
    public void setGametype(String gametype) {
        this.gametype = gametype == null ? null : gametype.trim();
    }
	
	@JSONField(name = "GAMENAME")
    public String getGamename() {
        return gamename;
    }
	
	@JSONField(name = "GAMENAME")
    public void setGamename(String gamename) {
        this.gamename = gamename == null ? null : gamename.trim();
    }
	
	@JSONField(name = "SESSIONID")
    public String getSessionid() {
        return sessionid;
    }
	
	@JSONField(name = "SESSIONID")
    public void setSessionid(String sessionid) {
        this.sessionid = sessionid == null ? null : sessionid.trim();
    }
	
	@JSONField(name = "BET")
    public BigDecimal getBet() {
        return bet;
    }
	
	@JSONField(name = "BET")
    public void setBet(BigDecimal bet) {
        this.bet = bet;
    }
	
	@JSONField(name = "WIN")
    public BigDecimal getWin() {
        return win;
    }
	
	@JSONField(name = "WIN")
    public void setWin(BigDecimal win) {
        this.win = win;
    }
	
	@JSONField(name = "PROGRESSIVEBET")
    public BigDecimal getProgressivebet() {
        return progressivebet;
    }
	
	@JSONField(name = "PROGRESSIVEBET")
    public void setProgressivebet(BigDecimal progressivebet) {
        this.progressivebet = progressivebet;
    }
	
	@JSONField(name = "PROGRESSIVEWIN")
    public BigDecimal getProgressivewin() {
        return progressivewin;
    }
	
	@JSONField(name = "PROGRESSIVEWIN")
    public void setProgressivewin(BigDecimal progressivewin) {
        this.progressivewin = progressivewin;
    }
	
	@JSONField(name = "BALANCE")
    public BigDecimal getBalance() {
        return balance;
    }
	
	@JSONField(name = "BALANCE")
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
	
	@JSONField(name = "CURRENTBET")
    public BigDecimal getCurrentbet() {
        return currentbet;
    }
	
	@JSONField(name = "CURRENTBET")
    public void setCurrentbet(BigDecimal currentbet) {
        this.currentbet = currentbet;
    }
	
	@JSONField(name = "RNUM")
    public Integer getRnum() {
        return rnum;
    }
	
	@JSONField(name = "RNUM")
    public void setRnum(Integer rnum) {
        this.rnum = rnum;
    }
	
	@JSONField(name = "GAMEDATE")
    public Date getGamedate() {
        return gamedate;
    }
	
	@JSONField(name = "GAMEDATE")
    public void setGamedate(Date gamedate) {
        this.gamedate = gamedate;
    }
	
	@JSONField(name = "LIVENETWORK")
    public String getLivenetwork() {
        return livenetwork;
    }

	@JSONField(name = "LIVENETWORK")
    public void setLivenetwork(String livenetwork) {
        this.livenetwork = livenetwork == null ? null : livenetwork.trim();
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
    
	@JSONField(name = "INFO")
	public String getInfo() {
		return info;
	}
	
	@JSONField(name = "INFO")
	public void setInfo(String info) {
		this.info = info;
	}
    
    
}
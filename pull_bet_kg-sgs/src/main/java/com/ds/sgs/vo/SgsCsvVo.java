package com.ds.sgs.vo;

import java.math.BigDecimal;

import com.opencsv.bean.CsvBindByName;

/**   
 *
 * @author worf 
 * @date 2018年6月7日 下午5:13:53  
 */
public class SgsCsvVo {
	
	@CsvBindByName(column = "ugsbetid")
    private String ugsBetId;

    @CsvBindByName(column = "txid")
    private String txid;

    @CsvBindByName(column = "betid")
    private String betId;

    @CsvBindByName(column = "beton")
    private String betOn;
    
    @CsvBindByName(column = "betclosedon")
    private String betClosedOn;

    @CsvBindByName(column = "betupdatedon")
    private String betUpdatedOn;

    @CsvBindByName(column = "timestamp")
    private String timestamp;

    @CsvBindByName(column = "roundid")
    private String roundid;

    @CsvBindByName(column = "roundstatus")
    private String roundStatus;

    @CsvBindByName(column = "userid")
    private String userid;

    @CsvBindByName(column = "username")
    private String username;

    @CsvBindByName(column = "riskamt")
    private BigDecimal riskamt;

    @CsvBindByName(column = "winamt")
    private BigDecimal winamt;

    @CsvBindByName(column = "winloss")
    private BigDecimal winloss;

    @CsvBindByName(column = "beforebal")
    private BigDecimal beforebal;

    @CsvBindByName(column = "postbal")
    private BigDecimal postbal;

    @CsvBindByName(column = "cur")
    private String currency;

    @CsvBindByName(column = "gameprovider")
    private String gameProvider;

    @CsvBindByName(column = "gameprovidercode")
    private String gameProviderCode;

    @CsvBindByName(column = "gamename")
    private String gameName;

    @CsvBindByName(column = "gameid")
    private String gameId;

    @CsvBindByName(column = "platformtype")
    private String platformType;

    @CsvBindByName(column = "ipaddress")
    private String ipAddress;

    @CsvBindByName(column = "bettype")
    private String betType;

    @CsvBindByName(column = "playtype")
    private String playType;

    @CsvBindByName(column = "playertype")
    private Byte playerType;

    @CsvBindByName(column = "turnover")
    private BigDecimal turnover;

    @CsvBindByName(column = "validbet")
    private BigDecimal validbet;

	public String getUgsBetId() {
		return ugsBetId;
	}

	public void setUgsBetId(String ugsBetId) {
		this.ugsBetId = ugsBetId;
	}

	public String getTxid() {
		return txid;
	}

	public void setTxid(String txid) {
		this.txid = txid;
	}

	public String getBetId() {
		return betId;
	}

	public void setBetId(String betId) {
		this.betId = betId;
	}

	public String getBetOn() {
		return betOn;
	}

	public void setBetOn(String betOn) {
		this.betOn = betOn;
	}

	public String getBetClosedOn() {
		return betClosedOn;
	}

	public void setBetClosedOn(String betClosedOn) {
		this.betClosedOn = betClosedOn;
	}

	public String getBetUpdatedOn() {
		return betUpdatedOn;
	}

	public void setBetUpdatedOn(String betUpdatedOn) {
		this.betUpdatedOn = betUpdatedOn;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getRoundid() {
		return roundid;
	}

	public void setRoundid(String roundid) {
		this.roundid = roundid;
	}

	public String getRoundStatus() {
		return roundStatus;
	}

	public void setRoundStatus(String roundStatus) {
		this.roundStatus = roundStatus;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public BigDecimal getRiskamt() {
		return riskamt;
	}

	public void setRiskamt(BigDecimal riskamt) {
		this.riskamt = riskamt;
	}

	public BigDecimal getWinamt() {
		return winamt;
	}

	public void setWinamt(BigDecimal winamt) {
		this.winamt = winamt;
	}

	public BigDecimal getWinloss() {
		return winloss;
	}

	public void setWinloss(BigDecimal winloss) {
		this.winloss = winloss;
	}

	public BigDecimal getBeforebal() {
		return beforebal;
	}

	public void setBeforebal(BigDecimal beforebal) {
		this.beforebal = beforebal;
	}

	public BigDecimal getPostbal() {
		return postbal;
	}

	public void setPostbal(BigDecimal postbal) {
		this.postbal = postbal;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getGameProvider() {
		return gameProvider;
	}

	public void setGameProvider(String gameProvider) {
		this.gameProvider = gameProvider;
	}

	public String getGameProviderCode() {
		return gameProviderCode;
	}

	public void setGameProviderCode(String gameProviderCode) {
		this.gameProviderCode = gameProviderCode;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

	public String getPlatformType() {
		return platformType;
	}

	public void setPlatformType(String platformType) {
		this.platformType = platformType;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getBetType() {
		return betType;
	}

	public void setBetType(String betType) {
		this.betType = betType;
	}

	public String getPlayType() {
		return playType;
	}

	public void setPlayType(String playType) {
		this.playType = playType;
	}

	public Byte getPlayerType() {
		return playerType;
	}

	public void setPlayerType(Byte playerType) {
		this.playerType = playerType;
	}

	public BigDecimal getTurnover() {
		return turnover;
	}

	public void setTurnover(BigDecimal turnover) {
		this.turnover = turnover;
	}

	public BigDecimal getValidbet() {
		return validbet;
	}

	public void setValidbet(BigDecimal validbet) {
		this.validbet = validbet;
	}

}

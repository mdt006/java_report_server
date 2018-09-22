
package com.ds.report.vo;

import java.math.BigDecimal;
import java.util.Date;

public class HunterDetailRecordVo {

		private Integer siteId;
		private String dataType;
		private String username;
		private String tradeNo;	
		private Byte winLossType;
		private String sceneId;
		private String playerName;
		private Byte type;
		private Date sceneStartTime;
		private Date sceneEndTime;
		private String roomid;
		private BigDecimal earn;
		private BigDecimal winLoss;
		private BigDecimal jackpotcomm;
		private BigDecimal validBetAmount;
		private BigDecimal betAmount;
		private String flag;
		private Date betTime;
		private BigDecimal hunterAward;
		private BigDecimal drawAward;
		private BigDecimal hunterAwardAll;
		private BigDecimal drawAwardAll;
		
		
		public Integer getSiteId() {
			return siteId;
		}

		public void setSiteId(Integer siteId) {
			this.siteId = siteId;
		}

		public String getDataType() {
			return dataType;
		}

		public void setDataType(String dataType) {
			this.dataType = dataType == null ? null : dataType.trim();
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username == null ? null : username.trim();
		}

		public Byte getWinLossType() {
			return winLossType;
		}

		public void setWinLossType(Byte winLossType) {
			this.winLossType = winLossType;
		}

		public String getSceneId() {
			return sceneId;
		}

		public void setSceneId(String sceneId) {
			this.sceneId = sceneId == null ? null : sceneId.trim();
		}
		public String getPlayerName() {
			return playerName;
		}

		public void setPlayerName(String playerName) {
			this.playerName = playerName == null ? null : playerName.trim();
		}

		public Byte getType() {
			return type;
		}

		public void setType(Byte type) {
			this.type = type;
		}

		public Date getSceneStartTime() {
			return sceneStartTime;
		}

		public void setSceneStartTime(Date sceneStartTime) {
			this.sceneStartTime = sceneStartTime;
		}
		public Date getSceneEndTime() {
			return sceneEndTime;
		}

		public void setSceneEndTime(Date sceneEndTime) {
			this.sceneEndTime = sceneEndTime;
		}

		public String getRoomid() {
			return roomid;
		}

		public void setRoomid(String roomid) {
			this.roomid = roomid == null ? null : roomid.trim();
		}

		public BigDecimal getEarn() {
			return earn;
		}

		public void setEarn(BigDecimal earn) {
			this.earn = earn;
		}

		public BigDecimal getJackpotcomm() {
			return jackpotcomm;
		}

		public void setJackpotcomm(BigDecimal jackpotcomm) {
			this.jackpotcomm = jackpotcomm;
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


		public String getFlag() {
			return flag;
		}
		
		public void setFlag(String flag) {
			this.flag = flag == null ? null : flag.trim();
		}

		public Date getBetTime() {
			return betTime;
		}

		public void setBetTime(Date betTime) {
			this.betTime = betTime;
		}

		public String getTradeNo() {
			return tradeNo;
		}

		public void setTradeNo(String tradeNo) {
			this.tradeNo = tradeNo;
		}

		public BigDecimal getHunterAward() {
			return hunterAward;
		}

		public void setHunterAward(BigDecimal hunterAward) {
			this.hunterAward = hunterAward;
		}

		public BigDecimal getDrawAward() {
			return drawAward;
		}

		public void setDrawAward(BigDecimal drawAward) {
			this.drawAward = drawAward;
		}

		public BigDecimal getHunterAwardAll() {
			return hunterAwardAll;
		}

		public void setHunterAwardAll(BigDecimal hunterAwardAll) {
			this.hunterAwardAll = hunterAwardAll;
		}

		public BigDecimal getDrawAwardAll() {
			return drawAwardAll;
		}

		public void setDrawAwardAll(BigDecimal drawAwardAll) {
			this.drawAwardAll = drawAwardAll;
		}

		public BigDecimal getWinLoss() {
			return winLoss;
		}

		public void setWinLoss(BigDecimal winLoss) {
			this.winLoss = winLoss;
		}

		
	
}
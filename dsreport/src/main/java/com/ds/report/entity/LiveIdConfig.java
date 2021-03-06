package com.ds.report.entity;

public class LiveIdConfig {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column c_live_id_config.id
	 * @mbggenerated  Thu Nov 26 14:04:23 CST 2015
	 */
	private Long id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column c_live_id_config.table_name
	 * @mbggenerated  Thu Nov 26 14:04:23 CST 2015
	 */
	private String tableName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column c_live_id_config.live_id
	 * @mbggenerated  Thu Nov 26 14:04:23 CST 2015
	 */
	private Integer liveId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column c_live_id_config.game_kind
	 * @mbggenerated  Thu Nov 26 14:04:23 CST 2015
	 */
	private Integer gameKind;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column c_live_id_config.game_kind_name
	 * @mbggenerated  Thu Nov 26 14:04:23 CST 2015
	 */
	private String gameKindName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column c_live_id_config.time_type
	 * @mbggenerated  Thu Nov 26 14:04:23 CST 2015
	 */
	private Integer timeType;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column c_live_id_config.table_game_kind
	 * @mbggenerated  Thu Nov 26 14:04:23 CST 2015
	 */
	private String tableGameKind;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column c_live_id_config.table_bet_time
	 * @mbggenerated  Thu Nov 26 14:04:23 CST 2015
	 */
	private String tableBetTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column c_live_id_config.table_bet_amount
	 * @mbggenerated  Thu Nov 26 14:04:23 CST 2015
	 */
	private String tableBetAmount;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column c_live_id_config.table_validate_amount
	 * @mbggenerated  Thu Nov 26 14:04:23 CST 2015
	 */
	private String tableValidateAmount;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column c_live_id_config.table_win_lose_amount
	 * @mbggenerated  Thu Nov 26 14:04:23 CST 2015
	 */
	private String tableWinLoseAmount;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column c_live_id_config.memo
	 * @mbggenerated  Thu Nov 26 14:04:23 CST 2015
	 */
	private String memo;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column c_live_id_config.id
	 * @return  the value of c_live_id_config.id
	 * @mbggenerated  Thu Nov 26 14:04:23 CST 2015
	 */
	public Long getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column c_live_id_config.id
	 * @param id  the value for c_live_id_config.id
	 * @mbggenerated  Thu Nov 26 14:04:23 CST 2015
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column c_live_id_config.table_name
	 * @return  the value of c_live_id_config.table_name
	 * @mbggenerated  Thu Nov 26 14:04:23 CST 2015
	 */
	public String getTableName() {
		return tableName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column c_live_id_config.table_name
	 * @param tableName  the value for c_live_id_config.table_name
	 * @mbggenerated  Thu Nov 26 14:04:23 CST 2015
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName == null ? null : tableName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column c_live_id_config.live_id
	 * @return  the value of c_live_id_config.live_id
	 * @mbggenerated  Thu Nov 26 14:04:23 CST 2015
	 */
	public Integer getLiveId() {
		return liveId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column c_live_id_config.live_id
	 * @param liveId  the value for c_live_id_config.live_id
	 * @mbggenerated  Thu Nov 26 14:04:23 CST 2015
	 */
	public void setLiveId(Integer liveId) {
		this.liveId = liveId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column c_live_id_config.game_kind
	 * @return  the value of c_live_id_config.game_kind
	 * @mbggenerated  Thu Nov 26 14:04:23 CST 2015
	 */
	public Integer getGameKind() {
		return gameKind;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column c_live_id_config.game_kind
	 * @param gameKind  the value for c_live_id_config.game_kind
	 * @mbggenerated  Thu Nov 26 14:04:23 CST 2015
	 */
	public void setGameKind(Integer gameKind) {
		this.gameKind = gameKind;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column c_live_id_config.game_kind_name
	 * @return  the value of c_live_id_config.game_kind_name
	 * @mbggenerated  Thu Nov 26 14:04:23 CST 2015
	 */
	public String getGameKindName() {
		return gameKindName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column c_live_id_config.game_kind_name
	 * @param gameKindName  the value for c_live_id_config.game_kind_name
	 * @mbggenerated  Thu Nov 26 14:04:23 CST 2015
	 */
	public void setGameKindName(String gameKindName) {
		this.gameKindName = gameKindName == null ? null : gameKindName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column c_live_id_config.time_type
	 * @return  the value of c_live_id_config.time_type
	 * @mbggenerated  Thu Nov 26 14:04:23 CST 2015
	 */
	public Integer getTimeType() {
		return timeType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column c_live_id_config.time_type
	 * @param timeType  the value for c_live_id_config.time_type
	 * @mbggenerated  Thu Nov 26 14:04:23 CST 2015
	 */
	public void setTimeType(Integer timeType) {
		this.timeType = timeType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column c_live_id_config.table_game_kind
	 * @return  the value of c_live_id_config.table_game_kind
	 * @mbggenerated  Thu Nov 26 14:04:23 CST 2015
	 */
	public String getTableGameKind() {
		return tableGameKind;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column c_live_id_config.table_game_kind
	 * @param tableGameKind  the value for c_live_id_config.table_game_kind
	 * @mbggenerated  Thu Nov 26 14:04:23 CST 2015
	 */
	public void setTableGameKind(String tableGameKind) {
		this.tableGameKind = tableGameKind == null ? null : tableGameKind
				.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column c_live_id_config.table_bet_time
	 * @return  the value of c_live_id_config.table_bet_time
	 * @mbggenerated  Thu Nov 26 14:04:23 CST 2015
	 */
	public String getTableBetTime() {
		return tableBetTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column c_live_id_config.table_bet_time
	 * @param tableBetTime  the value for c_live_id_config.table_bet_time
	 * @mbggenerated  Thu Nov 26 14:04:23 CST 2015
	 */
	public void setTableBetTime(String tableBetTime) {
		this.tableBetTime = tableBetTime == null ? null : tableBetTime.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column c_live_id_config.table_bet_amount
	 * @return  the value of c_live_id_config.table_bet_amount
	 * @mbggenerated  Thu Nov 26 14:04:23 CST 2015
	 */
	public String getTableBetAmount() {
		return tableBetAmount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column c_live_id_config.table_bet_amount
	 * @param tableBetAmount  the value for c_live_id_config.table_bet_amount
	 * @mbggenerated  Thu Nov 26 14:04:23 CST 2015
	 */
	public void setTableBetAmount(String tableBetAmount) {
		this.tableBetAmount = tableBetAmount == null ? null : tableBetAmount
				.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column c_live_id_config.table_validate_amount
	 * @return  the value of c_live_id_config.table_validate_amount
	 * @mbggenerated  Thu Nov 26 14:04:23 CST 2015
	 */
	public String getTableValidateAmount() {
		return tableValidateAmount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column c_live_id_config.table_validate_amount
	 * @param tableValidateAmount  the value for c_live_id_config.table_validate_amount
	 * @mbggenerated  Thu Nov 26 14:04:23 CST 2015
	 */
	public void setTableValidateAmount(String tableValidateAmount) {
		this.tableValidateAmount = tableValidateAmount == null ? null
				: tableValidateAmount.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column c_live_id_config.table_win_lose_amount
	 * @return  the value of c_live_id_config.table_win_lose_amount
	 * @mbggenerated  Thu Nov 26 14:04:23 CST 2015
	 */
	public String getTableWinLoseAmount() {
		return tableWinLoseAmount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column c_live_id_config.table_win_lose_amount
	 * @param tableWinLoseAmount  the value for c_live_id_config.table_win_lose_amount
	 * @mbggenerated  Thu Nov 26 14:04:23 CST 2015
	 */
	public void setTableWinLoseAmount(String tableWinLoseAmount) {
		this.tableWinLoseAmount = tableWinLoseAmount == null ? null
				: tableWinLoseAmount.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column c_live_id_config.memo
	 * @return  the value of c_live_id_config.memo
	 * @mbggenerated  Thu Nov 26 14:04:23 CST 2015
	 */
	public String getMemo() {
		return memo;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column c_live_id_config.memo
	 * @param memo  the value for c_live_id_config.memo
	 * @mbggenerated  Thu Nov 26 14:04:23 CST 2015
	 */
	public void setMemo(String memo) {
		this.memo = memo == null ? null : memo.trim();
	}
}
package com.kg.live.entity;

public class TotalReportConfig {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column c_total_report_config.id
	 * @mbggenerated  Sun Jan 17 21:14:23 CST 2016
	 */
	private Long id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column c_total_report_config.source_table_name
	 * @mbggenerated  Sun Jan 17 21:14:23 CST 2016
	 */
	private String sourceTableName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column c_total_report_config.temp_table_name
	 * @mbggenerated  Sun Jan 17 21:14:23 CST 2016
	 */
	private String tempTableName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column c_total_report_config.insert_temp_sql
	 * @mbggenerated  Sun Jan 17 21:14:23 CST 2016
	 */
	private String insertTempSql;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column c_total_report_config.state
	 * @mbggenerated  Sun Jan 17 21:14:23 CST 2016
	 */
	private Integer state;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column c_total_report_config.memo
	 * @mbggenerated  Sun Jan 17 21:14:23 CST 2016
	 */
	private String memo;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column c_total_report_config.id
	 * @return  the value of c_total_report_config.id
	 * @mbggenerated  Sun Jan 17 21:14:23 CST 2016
	 */
	public Long getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column c_total_report_config.id
	 * @param id  the value for c_total_report_config.id
	 * @mbggenerated  Sun Jan 17 21:14:23 CST 2016
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column c_total_report_config.source_table_name
	 * @return  the value of c_total_report_config.source_table_name
	 * @mbggenerated  Sun Jan 17 21:14:23 CST 2016
	 */
	public String getSourceTableName() {
		return sourceTableName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column c_total_report_config.source_table_name
	 * @param sourceTableName  the value for c_total_report_config.source_table_name
	 * @mbggenerated  Sun Jan 17 21:14:23 CST 2016
	 */
	public void setSourceTableName(String sourceTableName) {
		this.sourceTableName = sourceTableName == null ? null : sourceTableName
				.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column c_total_report_config.temp_table_name
	 * @return  the value of c_total_report_config.temp_table_name
	 * @mbggenerated  Sun Jan 17 21:14:23 CST 2016
	 */
	public String getTempTableName() {
		return tempTableName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column c_total_report_config.temp_table_name
	 * @param tempTableName  the value for c_total_report_config.temp_table_name
	 * @mbggenerated  Sun Jan 17 21:14:23 CST 2016
	 */
	public void setTempTableName(String tempTableName) {
		this.tempTableName = tempTableName == null ? null : tempTableName
				.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column c_total_report_config.insert_temp_sql
	 * @return  the value of c_total_report_config.insert_temp_sql
	 * @mbggenerated  Sun Jan 17 21:14:23 CST 2016
	 */
	public String getInsertTempSql() {
		return insertTempSql;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column c_total_report_config.insert_temp_sql
	 * @param insertTempSql  the value for c_total_report_config.insert_temp_sql
	 * @mbggenerated  Sun Jan 17 21:14:23 CST 2016
	 */
	public void setInsertTempSql(String insertTempSql) {
		this.insertTempSql = insertTempSql == null ? null : insertTempSql
				.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column c_total_report_config.state
	 * @return  the value of c_total_report_config.state
	 * @mbggenerated  Sun Jan 17 21:14:23 CST 2016
	 */
	public Integer getState() {
		return state;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column c_total_report_config.state
	 * @param state  the value for c_total_report_config.state
	 * @mbggenerated  Sun Jan 17 21:14:23 CST 2016
	 */
	public void setState(Integer state) {
		this.state = state;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column c_total_report_config.memo
	 * @return  the value of c_total_report_config.memo
	 * @mbggenerated  Sun Jan 17 21:14:23 CST 2016
	 */
	public String getMemo() {
		return memo;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column c_total_report_config.memo
	 * @param memo  the value for c_total_report_config.memo
	 * @mbggenerated  Sun Jan 17 21:14:23 CST 2016
	 */
	public void setMemo(String memo) {
		this.memo = memo == null ? null : memo.trim();
	}
}
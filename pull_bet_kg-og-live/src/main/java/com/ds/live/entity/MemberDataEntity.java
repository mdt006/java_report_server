package com.ds.live.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class MemberDataEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	private int ID;
	private String UserName;
	private double Money;
	private String Agents;
	private String World;
	private String Corprator;
	private String Super;
	private String Admin;
	private String CurType;//RMB
	private int Level;
	private int complex;
	private String Bank_Account;//银行金额
	private String Bank_Name;//银行
	private String Province;//省份
	private String City;//城市
	private String Mobile;//移动电话
	private String Phone;//电话
	private String TrueName;
	private String Alias;
	private String Money_password;
	private String PassWord;
	private String Notes;
	private int DepositBankCount;
	private int DepositBankTotalAmount;
	private int DepositBankMaxAmount;
	private int WithdrawalCount;
	private int WithdrawalTotalAmount;
	private int version;    //更新余额的版本号,每次加一
	private String passwordLive;
	
	private Timestamp EditDate;
	
	private int siteId;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public double getMoney() {
		return Money;
	}
	public void setMoney(double money) {
		Money = money;
	}
	public String getAgents() {
		return Agents;
	}
	public void setAgents(String agents) {
		Agents = agents;
	}
	public String getWorld() {
		return World;
	}
	public void setWorld(String world) {
		World = world;
	}
	public String getCorprator() {
		return Corprator;
	}
	public void setCorprator(String corprator) {
		Corprator = corprator;
	}
	public String getSuper() {
		return Super;
	}
	public void setSuper(String super1) {
		Super = super1;
	}
	public String getAdmin() {
		return Admin;
	}
	public void setAdmin(String admin) {
		Admin = admin;
	}
	public String getCurType() {
		return CurType;
	}
	public void setCurType(String curType) {
		CurType = curType;
	}
	public int getLevel() {
		return Level;
	}
	public void setLevel(int level) {
		Level = level;
	}
	public int getComplex() {
		return complex;
	}
	public void setComplex(int complex) {
		this.complex = complex;
	}
	public String getBank_Account() {
		return Bank_Account;
	}
	public void setBank_Account(String bank_Account) {
		Bank_Account = bank_Account;
	}
	public String getBank_Name() {
		return Bank_Name;
	}
	public void setBank_Name(String bank_Name) {
		Bank_Name = bank_Name;
	}
	public String getProvince() {
		return Province;
	}
	public void setProvince(String province) {
		Province = province;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getMobile() {
		return Mobile;
	}
	public void setMobile(String mobile) {
		Mobile = mobile;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getTrueName() {
		return TrueName;
	}
	public void setTrueName(String trueName) {
		TrueName = trueName;
	}
	public String getAlias() {
		return Alias;
	}
	public void setAlias(String alias) {
		Alias = alias;
	}
	public String getMoney_password() {
		return Money_password;
	}
	public void setMoney_password(String money_password) {
		Money_password = money_password;
	}
	public String getPassWord() {
		return PassWord;
	}
	public void setPassWord(String passWord) {
		PassWord = passWord;
	}
	public String getNotes() {
		return Notes;
	}
	public void setNotes(String notes) {
		Notes = notes;
	}
	public int getDepositBankCount() {
		return DepositBankCount;
	}
	public void setDepositBankCount(int depositBankCount) {
		DepositBankCount = depositBankCount;
	}
	public int getDepositBankTotalAmount() {
		return DepositBankTotalAmount;
	}
	public void setDepositBankTotalAmount(int depositBankTotalAmount) {
		DepositBankTotalAmount = depositBankTotalAmount;
	}
	public int getDepositBankMaxAmount() {
		return DepositBankMaxAmount;
	}
	public void setDepositBankMaxAmount(int depositBankMaxAmount) {
		DepositBankMaxAmount = depositBankMaxAmount;
	}
	public int getWithdrawalCount() {
		return WithdrawalCount;
	}
	public void setWithdrawalCount(int withdrawalCount) {
		WithdrawalCount = withdrawalCount;
	}
	public int getWithdrawalTotalAmount() {
		return WithdrawalTotalAmount;
	}
	public void setWithdrawalTotalAmount(int withdrawalTotalAmount) {
		WithdrawalTotalAmount = withdrawalTotalAmount;
	}
	public Timestamp getEditDate() {
		return EditDate;
	}
	public void setEditDate(Timestamp editDate) {
		EditDate = editDate;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String getPasswordLive() {
		return passwordLive;
	}
	public void setPasswordLive(String passwordLive) {
		this.passwordLive = passwordLive;
	}
	
	public int getSiteId() {
		return siteId;
	}
	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}
	@Override
	public String toString() {
		return "MemberDataEntity [ID=" + ID + ", UserName=" + UserName
				+ ", Money=" + Money + ", Agents=" + Agents + ", World="
				+ World + ", Corprator=" + Corprator + ", Super=" + Super
				+ ", Admin=" + Admin + ", CurType=" + CurType + ", Level="
				+ Level + ", complex=" + complex + ", Bank_Account="
				+ Bank_Account + ", Bank_Name=" + Bank_Name + ", Province="
				+ Province + ", City=" + City + ", Mobile=" + Mobile
				+ ", Phone=" + Phone + ", TrueName=" + TrueName + ", Alias="
				+ Alias + ", Money_password=" + Money_password + ", PassWord="
				+ PassWord + ", Notes=" + Notes + ", DepositBankCount="
				+ DepositBankCount + ", DepositBankTotalAmount="
				+ DepositBankTotalAmount + ", DepositBankMaxAmount="
				+ DepositBankMaxAmount + ", WithdrawalCount=" + WithdrawalCount
				+ ", WithdrawalTotalAmount=" + WithdrawalTotalAmount
				+ ", version=" + version + ", passwordLive=" + passwordLive
				+ ", EditDate=" + EditDate + "]";
	}
	
}

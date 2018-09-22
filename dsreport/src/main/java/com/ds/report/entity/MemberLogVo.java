package com.ds.report.entity;

import java.io.Serializable;
import java.util.Date;

public class MemberLogVo implements Serializable {

	/**
	 * @author Arron member_log表的实体类
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private String username;
	private Integer site_id;
	private String site_name;
	private Date create_time;
	private String agents;
	private String world;
	private String corprator;
	private String superior;
	private String company;

	public MemberLogVo() {
		super();
	}

	public MemberLogVo(Long id, String username, Integer site_id, String site_name, Date create_time, String agents,
			String world, String corprator, String superior, String company) {
		super();
		this.id = id;
		this.username = username;
		this.site_id = site_id;
		this.site_name = site_name;
		this.create_time = create_time;
		this.agents = agents;
		this.world = world;
		this.corprator = corprator;
		this.superior = superior;
		this.company = company;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getSite_id() {
		return site_id;
	}

	public void setSite_id(Integer site_id) {
		this.site_id = site_id;
	}

	public String getSite_name() {
		return site_name;
	}

	public void setSite_name(String site_name) {
		this.site_name = site_name;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public String getAgents() {
		return agents;
	}

	public void setAgents(String agents) {
		this.agents = agents;
	}

	public String getWorld() {
		return world;
	}

	public void setWorld(String world) {
		this.world = world;
	}

	public String getCorprator() {
		return corprator;
	}

	public void setCorprator(String corprator) {
		this.corprator = corprator;
	}

	public String getSuperior() {
		return superior;
	}

	public void setSuperior(String superior) {
		this.superior = superior;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "MemberLogVo [id=" + id + ", username=" + username + ", site_id=" + site_id + ", site_name=" + site_name
				+ ", create_time=" + create_time + ", agents=" + agents + ", world=" + world + ", corprator="
				+ corprator + ", superior=" + superior + ", company=" + company + "]";
	}
}
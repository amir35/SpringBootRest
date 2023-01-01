package com.example.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class CustomerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cust_id")
	private int cid;
	
	@Column(name="cust_name")
	private String cname;
	
	@Column(name = "cust_job")
	private String cjob;
	
	private String gender;
	
	@Column(name = "cust_aadhar")
	private String custaadhar;
	
	
	public CustomerEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerEntity(int cid, String cname, String cjob, String gender, String custaadhar) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.cjob = cjob;
		this.gender = gender;
		this.custaadhar = custaadhar;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCjob() {
		return cjob;
	}
	public void setCjob(String cjob) {
		this.cjob = cjob;
	}
	
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCustaadhar() {
		return custaadhar;
	}
	public void setCustaadhar(String custaadhar) {
		this.custaadhar = custaadhar;
	}
	@Override
	public String toString() {
		return "CustomerEntity [cid=" + cid + ", cname=" + cname + ", cjob=" + cjob + ", gender=" + gender
				+ ", custaadhar=" + custaadhar + "]";
	}
	
	
	
	
	
	
}

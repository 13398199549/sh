package org.framestudy.sh.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="t_user_info")
public class UserInfoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2196316057846329907L;

	@Id
	@GenericGenerator(name="hibernate.id",strategy="increment")
	@GeneratedValue(generator="hibernate.id")
	@Column(name="id")
	private Long id;
	
	@Column(name="id_card",length=20)
	private String idCard;
	/** 0-小学，1-初中，2-高中，3-中专，4-大专，5-本科，6-研究生，7-其它*/
	
	@Column(name="education_level")
	private Integer educationLevel;
	
	public UserInfoBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public Integer getEducationLevel() {
		return educationLevel;
	}
	public void setEducationLevel(Integer educationLevel) {
		this.educationLevel = educationLevel;
	}
	@Override
	public String toString() {
		return "UserInfoBean [id=" + id + ", idCard=" + idCard + ", educationLevel=" + educationLevel + "]";
	}
}

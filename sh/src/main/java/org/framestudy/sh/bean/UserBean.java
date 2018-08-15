package org.framestudy.sh.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;

@Entity
@Table(name = "t_user")
@OptimisticLocking(type = OptimisticLockType.VERSION)
public class UserBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7037091124811989776L;

	@Id
	@GenericGenerator(name = "hibernate.id", strategy = "increment")
	@GeneratedValue(generator = "hibernate.id")
	@Column(name = "id")
	private Long id;

	@Column(name = "login_name", length = 20)
	private String loginName;

	@Column(name = "user_name", length = 20)
	private String userName;

	@Column(name = "password", length = 32)
	private String password;

	@Column(name = "create_time")
	private Date createTime;

	@Column(name = "update_time")
	private Date updateTime;

	@Version
	private Integer version;
	/**
	 * 单向关联
	 */

	@OneToOne(fetch = FetchType.LAZY)
	@Cascade(value = { CascadeType.SAVE_UPDATE, CascadeType.REFRESH })
	@JoinColumn(name = "fk_user_info_id")
	private UserInfoBean userInfo;
	/**
	 * 单向关联
	 */

	@OneToMany(fetch = FetchType.LAZY)
	@Cascade(value = { CascadeType.SAVE_UPDATE, CascadeType.REFRESH })
	@JoinColumn(name = "fk_user_id")
	private Set<HouseBean> houses;

	public UserBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserBean(Long id, String userName) {
		super();
		this.id = id;
		this.userName = userName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public UserInfoBean getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfoBean userInfo) {
		this.userInfo = userInfo;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public Set<HouseBean> getHouses() {
		return houses;
	}

	public void setHouses(Set<HouseBean> houses) {
		this.houses = houses;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "UserBean [id=" + id + ", loginName=" + loginName + ", userName=" + userName + ", password=" + password
				+ ", createTime=" + createTime + ", updateTime=" + updateTime + ", version=" + version + "]";
	}
}

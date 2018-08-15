package org.framestudy.sh.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
/**
 * 用户房产实体类
 * @author puxubo
 *
 */
@Entity
@Table(name="t_house")
public class HouseBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4953625881451870303L;
	@Id
	@Column(name="id")
	@GenericGenerator(name="hibernate.id",strategy="increment")
	@GeneratedValue(generator="hibernate.id")
	private Long id;
	/**
	 * 具体地址
	 */
	@Column(name="house_address",length=200)
	private String houseAddress;
	/**
	 * 门牌号
	 */
	@Column(name="house_no",length=12)
	private String houseNo;
	public HouseBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getHouseAddress() {
		return houseAddress;
	}
	public void setHouseAddress(String houseAddress) {
		this.houseAddress = houseAddress;
	}
	public String getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
	@Override
	public String toString() {
		return "HouseBean [id=" + id + ", houseAddress=" + houseAddress + ", houseNo=" + houseNo + "]";
	}
	
}

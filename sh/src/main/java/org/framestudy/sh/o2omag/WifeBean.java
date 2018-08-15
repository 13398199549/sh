package org.framestudy.sh.o2omag;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="t_wife")
public class WifeBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6932298865496811627L;

	@Id
	@Column(name="id")
	@GenericGenerator(name="hibernate.id",strategy="uuid.hex")
	@GeneratedValue(generator="hibernate.id")
	private String id;
	
	@Column(name="wife_name",length=20)
	private String wifeName;
	
	@OneToOne(fetch=FetchType.LAZY,mappedBy="wife")
	@Cascade(value= {CascadeType.ALL})
	private HusbandBean husband;

	public WifeBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWifeName() {
		return wifeName;
	}

	public void setWifeName(String wifeName) {
		this.wifeName = wifeName;
	}

	public HusbandBean getHusband() {
		return husband;
	}

	public void setHusband(HusbandBean husband) {
		this.husband = husband;
	}

	@Override
	public String toString() {
		return "WifeBean [id=" + id + ", wifeName=" + wifeName + "]";
	}
}

package org.framestudy.sh.o2omag;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="t_husband")
public class HusbandBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1672374791734096332L;

	
	@Id
	@Column(name="id")
	@GenericGenerator(name="hibernate.id",strategy="uuid.hex")
	@GeneratedValue(generator="hibernate.id")
	private String id;
	
	@Column(name="husband_name",length=20)
	private String husbandName;
	
	@OneToOne(fetch=FetchType.LAZY)
	@Cascade(value= {CascadeType.ALL})
	@JoinColumn(name="fk_wife_id")
	private WifeBean wife;
	
	public HusbandBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHusbandName() {
		return husbandName;
	}

	public void setHusbandName(String husbandName) {
		this.husbandName = husbandName;
	}

	public WifeBean getWife() {
		return wife;
	}

	public void setWife(WifeBean wife) {
		this.wife = wife;
	}

	@Override
	public String toString() {
		return "HubandBean [id=" + id + ", husbandName=" + husbandName + ", wife=" + wife + "]";
	}
	
}

package org.framestudy.sh.extendmag;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
/**
 * @Inheritance(strategy=InheritanceType.SINGLE_TABLE) 表示继承关系为：单表继承
 * 
 * @author puxubo
 *
 */
@Entity
@Table(name="t_pet")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="pet_type",discriminatorType=DiscriminatorType.STRING)
public class PetBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7196700659675176477L;
	@Id
	@Column(name="id")
	@GenericGenerator(name="hibernate.id",strategy="identity")
	@GeneratedValue(generator="hibernate.id")
	private Long id;
	
	@Column(name="pet_name",length=20)
	private String petName;
	
	public PetBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPetName() {
		return petName;
	}
	public void setPetName(String petName) {
		this.petName = petName;
	}
	@Override
	public String toString() {
		return "PetBean [id=" + id + ", petName=" + petName + "]";
	}
}

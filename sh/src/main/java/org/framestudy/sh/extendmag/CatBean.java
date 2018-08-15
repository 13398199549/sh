package org.framestudy.sh.extendmag;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="0")
public class CatBean extends PetBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6722059679015540062L;
	
	@Column
	private Integer fish;

	public CatBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getFish() {
		return fish;
	}

	public void setFish(Integer fish) {
		this.fish = fish;
	}

	@Override
	public String toString() {
		return "CatBean [fish=" + fish + ", getId()=" + getId() + ", getPetName()=" + getPetName() + "]";
	}
}

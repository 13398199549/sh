package org.framestudy.sh.extendmag;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="2")
public class SnakeBean extends PetBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3572463223251712203L;

	@Column
	private Integer mouse;

	public SnakeBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getMouse() {
		return mouse;
	}

	public void setMouse(Integer mouse) {
		this.mouse = mouse;
	}

	@Override
	public String toString() {
		return "SnakeBean [mouse=" + mouse + ", getId()=" + getId() + ", getPetName()=" + getPetName() + "]";
	}
}

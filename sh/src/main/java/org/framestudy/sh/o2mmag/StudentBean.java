package org.framestudy.sh.o2mmag;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="t_student")
public class StudentBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6086864508717623579L;
	
	@Id
	@Column(name="id")
	@GenericGenerator(name="hibernate.id",strategy="identity")
	@GeneratedValue(generator="hibernate.id")
	private Long id;
	
	@Column(name="student_name",length=20)
	private String studentName;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@Cascade(value= {CascadeType.REFRESH,CascadeType.SAVE_UPDATE})
	@JoinColumn(name="fk_class_id")
	private ClassBean cls;
	
	public StudentBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public ClassBean getCls() {
		return cls;
	}
	public void setCls(ClassBean cls) {
		this.cls = cls;
	}
	@Override
	public String toString() {
		return "StudentBean [id=" + id + ", studentName=" + studentName + ", cls=" + cls + "]";
	}
}

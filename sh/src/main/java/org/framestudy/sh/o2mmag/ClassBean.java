package org.framestudy.sh.o2mmag;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="t_class")
public class ClassBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 103616760723112398L;

	@Id
	@Column(name="id")
	@GenericGenerator(name="hibernate.id",strategy="identity")
	@GeneratedValue(generator="hibernate.id")
	private Long id;
	
	@Column(name="class_name",length=20)
	private String className;
	
	//mappedBy="cls" 等同于配置文件中inverse = true,以及property-ref="cls"
	//在交出关联关系维护控制权的一方，不能配置@JoinColumn(name="fk_class_id")
	@OneToMany(fetch=FetchType.LAZY,mappedBy="cls")
	@Cascade(value= {CascadeType.REFRESH})
	private Set<StudentBean> students;

	public ClassBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Set<StudentBean> getStudents() {
		return students;
	}

	public void setStudents(Set<StudentBean> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "ClassBean [id=" + id + ", className=" + className + "]";
	}
}

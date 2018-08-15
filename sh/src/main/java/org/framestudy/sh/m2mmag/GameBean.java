package org.framestudy.sh.m2mmag;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="t_game")
public class GameBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8684707528583745196L;
	
	@Id
	@Column(name="id")
	@GenericGenerator(name="hibernate.id",strategy="identity")
	@GeneratedValue(generator="hibernate.id")
	private Long id;
	
	@Column(name="game_name",length = 20)
	private String gameName;
	
	@ManyToMany(fetch=FetchType.LAZY,mappedBy="games")
	private Set<PlayerBean> players;

	public GameBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public Set<PlayerBean> getPlayers() {
		return players;
	}

	public void setPlayers(Set<PlayerBean> players) {
		this.players = players;
	}

	@Override
	public String toString() {
		return "GameBean [id=" + id + ", gameName=" + gameName + "]";
	}
	
}

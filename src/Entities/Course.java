package Entities;
// Generated Aug 4, 2017 9:03:46 PM by Hibernate Tools 5.2.3.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Course generated by hbm2java
 */
@Entity
@Table(name = "course", catalog = "test")
public class Course implements java.io.Serializable {

	private String id;
	private Topics topics;
	private String description;
	private String username;

	public Course() {
	}

	public Course(String id, Topics topics) {
		this.id = id;
		this.topics = topics;
	}

	public Course(String id, Topics topics, String description, String username) {
		this.id = id;
		this.topics = topics;
		this.description = description;
		this.username = username;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "topic_id", nullable = false)
	public Topics getTopics() {
		return this.topics;
	}

	public void setTopics(Topics topics) {
		this.topics = topics;
	}

	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "username")
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}

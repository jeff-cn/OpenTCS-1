package org.opentcs.util.persistence.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Block {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	String name;

	@OneToMany
	List<Member> members;

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(final List<Member> members) {
		this.members = members;
	}

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

}

package org.opentcs.util.persistence.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Link {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	String point;

	public Integer getId() {
		return id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public String getPoint() {
		return point;
	}

	public void setPoint(final String point) {
		this.point = point;
	}

}

package org.opentcs.util.persistence.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Point {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	String name;

	private Long xPosition = 0L;
	private Long yPosition = 0L;
	private Long zPosition = 0L;
	private Float vehicleOrientationAngle = 0.0F;

	String type;

	@OneToMany
	List<OutgoingPath> outGoingPaths = new ArrayList<>();

	public Long getxPosition() {
		return xPosition;
	}

	public void setxPosition(final Long xPosition) {
		this.xPosition = xPosition;
	}

	public Long getyPosition() {
		return yPosition;
	}

	public void setyPosition(final Long yPosition) {
		this.yPosition = yPosition;
	}

	public Long getzPosition() {
		return zPosition;
	}

	public void setzPosition(final Long zPosition) {
		this.zPosition = zPosition;
	}

	public Float getVehicleOrientationAngle() {
		return vehicleOrientationAngle;
	}

	public void setVehicleOrientationAngle(final Float vehicleOrientationAngle) {
		this.vehicleOrientationAngle = vehicleOrientationAngle;
	}

	public String getType() {
		return type;
	}

	public void setType(final String type) {
		this.type = type;
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

	public List<OutgoingPath> getOutGoingPaths() {
		return outGoingPaths;
	}

	public void setOutGoingPaths(final List<OutgoingPath> outGoingPaths) {
		this.outGoingPaths = outGoingPaths;
	}

}

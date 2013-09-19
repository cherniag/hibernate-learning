package com.gc.test.hibernate.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Action {
	@EmbeddedId
	private SomeId id;
	public SomeId getId() {
		return id;
	}
	public void setId(SomeId id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	private String description;

	public static Action getNewAction(){
		Action action = new Action();
		SomeId id = new SomeId();
		id.setId(29);
		id.setName("complex name");
		action.setId(id);
		action.setDescription("Desc ttt");
		return action;
		
	}
}

package org.training.one_to_one_bi.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int personId;
	private String personName;
	private String personEmail;
	@OneToOne(mappedBy = "person")
	private Pan pan;
	public Pan getPan() {
		return pan;
	}
	public void setPan(Pan pan) {
		this.pan = pan;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getPersonEmail() {
		return personEmail;
	}
	public void setPersonEmail(String personEmail) {
		this.personEmail = personEmail;
	}
	@Override
	public String toString() {
		return "Person [personId=" + personId + ", personName=" + personName + ", personEmail=" + personEmail + "]";
	}
	
}

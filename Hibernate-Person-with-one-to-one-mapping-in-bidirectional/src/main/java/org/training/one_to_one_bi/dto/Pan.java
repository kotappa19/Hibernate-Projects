package org.training.one_to_one_bi.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity
public class Pan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int panId;
	private String panNumber;
	private String panAddress;
	@OneToOne
	@JoinColumn()
	private Person person;
	public int getPanId() {
		return panId;
	}
	public void setPanId(int panId) {
		this.panId = panId;
	}
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public String getPanAddress() {
		return panAddress;
	}
	public void setPanAddress(String panAddress) {
		this.panAddress = panAddress;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	@Override
	public String toString() {
		return "Pan [panId=" + panId + ", panNumber=" + panNumber + ", panAddress=" + panAddress + ", person=" + person
				+ "]";
	}
	
}

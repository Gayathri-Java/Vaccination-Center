package com.example.vaccinationcenter.entities;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity(name = "TBL_VACCINATION_CENTER")
public class VaccinationCenter {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String name;
private String address;
@OneToMany( mappedBy = "center",cascade = CascadeType.REMOVE, orphanRemoval = true)
private List<Citizen> citizenList;
public Long getId() {
return id;
}
public void setId(Long id) {
this.id = id;
}
public String getName() {
return name;
}
public void setName(String name) {
this.name = name;
}
public void setAddress(String city) {
	this.address=address;
		}	
}

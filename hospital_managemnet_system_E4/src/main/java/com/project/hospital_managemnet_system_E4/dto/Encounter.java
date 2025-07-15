package com.project.hospital_managemnet_system_E4.dto;

import java.sql.Time;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.sql.Date;
@Entity
public class Encounter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int encounterId;
	private String encounterType;
	private Date encounterDate;
	private Time encounterTime;
	private String encounterStatus;

}

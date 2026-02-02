package com.solar.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int capacityLph;
    private String filtrationType;
    private String solarSupported;
    private double price;
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
	public int getCapacityLph() {
		return capacityLph;
	}
	public void setCapacityLph(int capacityLph) {
		this.capacityLph = capacityLph;
	}
	public String getFiltrationType() {
		return filtrationType;
	}
	public void setFiltrationType(String filtrationType) {
		this.filtrationType = filtrationType;
	}
	public String isSolarSupported() {
		return solarSupported;
	}
	public void setSolarSupported(String solarSupported) {
		this.solarSupported = solarSupported;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

}

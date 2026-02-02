package com.solar.DTO;

public class ProductRequest {
	private String name;
    private Double price;
    private String description;
    private Integer capacityLph;
    private String filtrationType;
    private Boolean solarSupported;
    private String status;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getCapacityLph() {
		return capacityLph;
	}
	public void setCapacityLph(Integer capacityLph) {
		this.capacityLph = capacityLph;
	}
	public String getFiltrationType() {
		return filtrationType;
	}
	public void setFiltrationType(String filtrationType) {
		this.filtrationType = filtrationType;
	}
	public Boolean getSolarSupported() {
		return solarSupported;
	}
	public void setSolarSupported(Boolean solarSupported) {
		this.solarSupported = solarSupported;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}

package com.solar.DTO;

import java.time.LocalDate;

public class QuotationResponseDTO {
	private Long id;
    private String quotationNumber;
    private Double totalAmount;
    private String sellerName;
    private String sellerAddress;
    private String sellerGST;
    private String buyerName;
    private String buyerAddress;
    private LocalDate quotationDate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getQuotationNumber() {
		return quotationNumber;
	}
	public void setQuotationNumber(String quotationNumber) {
		this.quotationNumber = quotationNumber;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public String getSellerAddress() {
		return sellerAddress;
	}
	public void setSellerAddress(String sellerAddress) {
		this.sellerAddress = sellerAddress;
	}
	public String getSellerGST() {
		return sellerGST;
	}
	public void setSellerGST(String sellerGST) {
		this.sellerGST = sellerGST;
	}
	public String getBuyerName() {
		return buyerName;
	}
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	public String getBuyerAddress() {
		return buyerAddress;
	}
	public void setBuyerAddress(String buyerAddress) {
		this.buyerAddress = buyerAddress;
	}
	public LocalDate getQuotationDate() {
		return quotationDate;
	}
	public void setQuotationDate(LocalDate quotationDate) {
		this.quotationDate = quotationDate;
	}
	
    
    
}

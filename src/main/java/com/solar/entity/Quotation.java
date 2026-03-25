package com.solar.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Quotation {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
        private String quotationNumber;
	    private String sellerName;
	    private String sellerAddress;
	    private String sellerGST;
	    private String buyerName;
	    private String buyerAddress;
	    private LocalDate quotationDate;
        private String paymentTerms;
	    private String deliveryTerms;
	    private String validity;
	    private String notes;

	    private Double totalAmount;

	    @OneToMany(mappedBy = "quotation", cascade = CascadeType.ALL)
	    @JsonManagedReference
	    private List<QuotationItem> items;

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

		public String getPaymentTerms() {
			return paymentTerms;
		}

		public void setPaymentTerms(String paymentTerms) {
			this.paymentTerms = paymentTerms;
		}

		public String getDeliveryTerms() {
			return deliveryTerms;
		}

		public void setDeliveryTerms(String deliveryTerms) {
			this.deliveryTerms = deliveryTerms;
		}

		public String getValidity() {
			return validity;
		}

		public void setValidity(String validity) {
			this.validity = validity;
		}

		public String getNotes() {
			return notes;
		}

		public void setNotes(String notes) {
			this.notes = notes;
		}

		public Double getTotalAmount() {
			return totalAmount;
		}

		public void setTotalAmount(Double totalAmount) {
			this.totalAmount = totalAmount;
		}

		public List<QuotationItem> getItems() {
			return items;
		}

		public void setItems(List<QuotationItem> items) {
			this.items = items;
		}
	
	    
}

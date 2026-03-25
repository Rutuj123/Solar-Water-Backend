package com.solar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.solar.entity.*;
import com.solar.exception.ResourceNotFoundException;
import com.solar.repository.QuotationRepository;
import java.util.List;

	@Service
	public class QuotationService {

	    @Autowired
	    private QuotationRepository repository;

	    public Quotation saveQuotation(Quotation quotation) {

	        // Set parent reference in child
	        for (QuotationItem item : quotation.getItems()) {
	            item.setQuotation(quotation);
	            item.setTotal(item.getQuantity() * item.getUnitPrice());
	        }

	        quotation.setTotalAmount(
	            quotation.getItems()
	                     .stream()
	                     .mapToDouble(QuotationItem::getTotal)
	                     .sum()
	        );

	        return repository.save(quotation);
	    }
	    public List<Quotation> getAllQuotation() {
                 return repository.findAll();
	    }
	    
	    public Quotation updateQuotation(Long id, Quotation updatedQuotation) {

	        Quotation existingQuotation = repository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Quotation not found"));

	        // Update basic fields
	        existingQuotation.setSellerName(updatedQuotation.getSellerName());
	        existingQuotation.setSellerAddress(updatedQuotation.getSellerAddress());
	        existingQuotation.setSellerGST(updatedQuotation.getSellerGST());
	        existingQuotation.setBuyerName(updatedQuotation.getBuyerName());
	        existingQuotation.setBuyerAddress(updatedQuotation.getBuyerAddress());
	        existingQuotation.setQuotationNumber(updatedQuotation.getQuotationNumber());
	        existingQuotation.setQuotationDate(updatedQuotation.getQuotationDate());
	        existingQuotation.setPaymentTerms(updatedQuotation.getPaymentTerms());
	        existingQuotation.setDeliveryTerms(updatedQuotation.getDeliveryTerms());
	        existingQuotation.setValidity(updatedQuotation.getValidity());
	        existingQuotation.setNotes(updatedQuotation.getNotes());
	        existingQuotation.setTotalAmount(updatedQuotation.getTotalAmount());

	        // Clear old items
	        existingQuotation.getItems().clear();

	        // Add new items
	        if (updatedQuotation.getItems() != null) {
	            for (QuotationItem item : updatedQuotation.getItems()) {
	                item.setQuotation(existingQuotation);
	                existingQuotation.getItems().add(item);
	            }
	        }

	        return repository.save(existingQuotation);
	    }
		public void deleteQuotation(Long id) {
			Quotation quotation = repository.findById(id)
		            .orElseThrow(() ->
		                    new ResourceNotFoundException("Quotation not found with id: " + id));
			 repository.delete(quotation);
		}
}
	


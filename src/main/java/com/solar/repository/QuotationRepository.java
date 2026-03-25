package com.solar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solar.entity.Quotation;

public interface QuotationRepository extends JpaRepository<Quotation, Long>{

}

package com.stock.CompanyData.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stock.CompanyData.dto.StockDTO;

import java.util.List;

public interface StockRepository extends JpaRepository<StockDTO, Long> {

    List<StockDTO> findByCompanyCode(String companyCode);
}

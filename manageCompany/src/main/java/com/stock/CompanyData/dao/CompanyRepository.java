package com.stock.CompanyData.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.stock.CompanyData.dto.CompanyDTO;

import java.util.List;

public interface CompanyRepository extends JpaRepository<CompanyDTO, Long> {

    @Query(value = "SELECT c FROM CompanyDTO c WHERE c.companyName LIKE CONCAT('%',:companyName,'%') ")
    List<CompanyDTO> findCompanyNameLike(String companyName);
}

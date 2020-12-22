package com.stock.CompanyData.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stock.CompanyData.dto.IPOdto;

import java.util.List;

public interface IPORepository extends JpaRepository<IPOdto, Long> {
    List<IPOdto> findAllByOrderByOpenDate();
}

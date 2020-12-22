package com.stock.stockmarketmain.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stock.stockmarketmain.dto.MarketDTO;

public interface MarketRepository extends JpaRepository<MarketDTO, Long> {
}

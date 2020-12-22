package com.stock.datasheet.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stock.datasheet.dto.ObjectDTO;

public interface ObjectRepository extends JpaRepository<ObjectDTO, Long> {
}

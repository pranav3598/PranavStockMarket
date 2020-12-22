package com.stock.loginRegister.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stock.loginRegister.entity.DataEntity;

@Repository
public interface DataRepository extends JpaRepository<DataEntity, Long> {

    DataEntity findByUsernameAndPassword(String name, String password);

    DataEntity findByUsername(String name);
}

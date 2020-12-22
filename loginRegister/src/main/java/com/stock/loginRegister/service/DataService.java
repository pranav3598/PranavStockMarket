package com.stock.loginRegister.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stock.loginRegister.dao.DataRepository;
import com.stock.loginRegister.entity.DataEntity;
import com.stock.loginRegister.model.Data;


@Service
public class DataService {

    @Autowired
    DataRepository dataRepository;

    @Transactional
    public Data authenticateLogin(Data data) {
        DataEntity dataEntity = dataRepository.findByUsernameAndPassword(data.getName(), data.getPassword());
        Data dataInfo = null;
        if (dataEntity != null) {
            dataInfo = new Data();
            dataInfo.setRole(dataEntity.getRole());
            dataInfo.setName(dataEntity.getName());
        }
        return dataInfo;
    }

    @Transactional
    public void signUp(Data data) {
        DataEntity dataEntity = new DataEntity();
        BeanUtils.copyProperties(data, dataEntity);
        dataRepository.saveAndFlush(dataEntity);
    }

    @Transactional(readOnly = true)
    public Data retrieveDataProfile(String dataname) {
        Data dataInfo = null;
        DataEntity dataEntity = dataRepository.findByUsername(dataname);
        if (dataEntity != null) {
            dataInfo = new Data();
            BeanUtils.copyProperties(dataEntity, dataInfo);
        }
        return dataInfo;
    }

    @Transactional
    public void updateDataProfile(Data data) {
        DataEntity dataEntity = dataRepository.findByUsername(data.getName());
        if (StringUtils.isNotBlank(data.getPassword())) {
            dataEntity.setPassword(data.getPassword());
        }
        if (StringUtils.isNotBlank(data.getEmail())) {
            dataEntity.setEmail(data.getEmail());
        }
        if (StringUtils.isNotBlank(data.getMobile())) {
            dataEntity.setMobile(data.getMobile());
        }
        dataRepository.saveAndFlush(dataEntity);
    }

    @Transactional
    public void activateDataAccount(String dataname) {
        DataEntity dataEntity = dataRepository.findByUsername(dataname);
        if (dataEntity != null) {
            dataEntity.setConfirmed("Y");
            dataRepository.saveAndFlush(dataEntity);
        }
    }

}

package com.stock.CompanyData.service;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stock.CompanyData.dao.IPORepository;
import com.stock.CompanyData.dto.IPOdto;
import com.stock.CompanyData.model.IPO;

import java.util.ArrayList;
import java.util.List;

@Service
public class IPOService {
    @Autowired
    IPORepository ipoRepository;

    @Transactional
    public List<IPO> retrieveAllIpo() {
        List<IPO> ipos = new ArrayList<>();
        List<IPOdto> ipoList = ipoRepository.findAllByOrderByOpenDate();
        if (CollectionUtils.isNotEmpty(ipoList)) {
            ipoList.forEach(ipoItem -> {
                IPO ipoObj = new IPO();
                BeanUtils.copyProperties(ipoItem, ipoObj);
                ipos.add(ipoObj);
            });
        }
        return ipos;
    }

    @Transactional
    public void insertNewIpo(IPO ipoDetail){
        IPOdto ipoDetailEntity = new IPOdto();
        BeanUtils.copyProperties(ipoDetail,ipoDetailEntity);
        ipoRepository.saveAndFlush(ipoDetailEntity);
    }
}

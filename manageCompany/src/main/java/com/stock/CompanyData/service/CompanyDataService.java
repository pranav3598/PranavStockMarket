package com.stock.CompanyData.service;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stock.CompanyData.dao.CompanyRepository;
import com.stock.CompanyData.dao.StockRepository;
import com.stock.CompanyData.dto.CompanyDTO;
import com.stock.CompanyData.dto.StockDTO;
import com.stock.CompanyData.model.Company;
import com.stock.CompanyData.model.CompareVarious;
import com.stock.CompanyData.model.Stock;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyDataService {
    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    StockRepository stockPriceRepository;

    @Transactional
    public void addNewCompany(Company company) {
        CompanyDTO companyEntity = new CompanyDTO();
        BeanUtils.copyProperties(company, companyEntity);
        companyRepository.saveAndFlush(companyEntity);
    }

    @Transactional
    public List<Company> retrieveAllCompany() {
        List<Company> companyList = new ArrayList<>();
        List<CompanyDTO> companies = companyRepository.findAll();
        if (CollectionUtils.isNotEmpty(companies)) {
            companies.forEach(companyItem -> {
                Company cp = new Company();
                BeanUtils.copyProperties(companyItem, cp);
                companyList.add(cp);
            });
        }
        return companyList;
    }

    @Transactional
    public void updateCompanyInformation(Company company) {
        Optional<CompanyDTO> companyOps = companyRepository.findById(company.getId());
        if (companyOps.isPresent()) {
            CompanyDTO companyEntity = companyOps.get();
            if (StringUtils.isNotBlank(company.getCompanyName())) {
                companyEntity.setCompanyName(company.getCompanyName());
            }
            if (StringUtils.isNotBlank(company.getTurnover())) {
                companyEntity.setTurnover(company.getTurnover());
            }
            if (StringUtils.isNotBlank(company.getCeo())) {
                companyEntity.setCeo(company.getCeo());
            }
            if (StringUtils.isNotBlank(company.getBoardDirector())) {
                companyEntity.setBoardDirector(company.getBoardDirector());
            }
            if (StringUtils.isNotBlank(company.getStockExchange())) {
                companyEntity.setStockExchange(company.getStockExchange());
            }
            if (StringUtils.isNotBlank(company.getSector())) {
                companyEntity.setSector(company.getSector());
            }
            if (StringUtils.isNotBlank(company.getWriteup())) {
                companyEntity.setWriteup(company.getWriteup());
            }
            if (StringUtils.isNotBlank(company.getCompanyCode())) {
                companyEntity.setCompanyCode(company.getCompanyCode());
            }
            companyRepository.saveAndFlush(companyEntity);
        }
    }

    @Transactional
    public List<Company> getCompanyByName(String companyName) {
        List<Company> companyList = new ArrayList<>();
        List<CompanyDTO> companies = companyRepository.findCompanyNameLike(companyName);
        if (CollectionUtils.isNotEmpty(companies)) {
            companies.forEach(companyItem -> {
                Company cp = new Company();
                BeanUtils.copyProperties(companyItem, cp);
                companyList.add(cp);
            });
        }
        return companyList;
    }

    @Transactional
    public CompareVarious compareCompany(CompareVarious request) {
        CompareVarious compareVarious = new CompareVarious();
        List<Stock> companyList1 = new ArrayList<>();
        List<Stock> companyList2 = new ArrayList<>();
        List<StockDTO> company1Data = stockPriceRepository.findByCompanyCode(request.getCompany1());
        if (CollectionUtils.isNotEmpty(company1Data)) {
            company1Data.forEach(stockPriceItem1 -> {
                Stock sp1 = new Stock();
                BeanUtils.copyProperties(stockPriceItem1, sp1);
                companyList1.add(sp1);
            });
            List<String> company1PriceList = groupStockPriceByMonth(companyList1);
            compareVarious.setCompany1Data(company1PriceList);
        }
        List<StockDTO> company2Data = stockPriceRepository.findByCompanyCode(request.getCompany2());
        if (CollectionUtils.isNotEmpty(company2Data)) {
            company2Data.forEach(stockPriceItem2 -> {
                Stock sp2 = new Stock();
                BeanUtils.copyProperties(stockPriceItem2, sp2);
                companyList2.add(sp2);
            });
            List<String> company2PriceList = groupStockPriceByMonth(companyList2);
            compareVarious.setCompany2Data(company2PriceList);
        }
        return compareVarious;
    }

    public List<String> groupStockPriceByMonth(List<Stock> stockPriceList) {
        List<String> companyPriceList = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        for (Stock stockItem : stockPriceList) {
            cal.setTime(stockItem.getChangeDate());
            int month = cal.get(Calendar.MONTH);
            switch (month) {
                case 0:
                    companyPriceList.add(String.valueOf(stockItem.getPrice()));
                    break;
                case 1:
                    companyPriceList.add(String.valueOf(stockItem.getPrice()));
                    break;
                case 2:
                    companyPriceList.add(String.valueOf(stockItem.getPrice()));
                    break;
                case 3:
                    companyPriceList.add(String.valueOf(stockItem.getPrice()));
                    break;
                case 4:
                    companyPriceList.add(String.valueOf(stockItem.getPrice()));
                    break;
                case 5:
                    companyPriceList.add(String.valueOf(stockItem.getPrice()));
                    break;
                case 6:
                    companyPriceList.add(String.valueOf(stockItem.getPrice()));
                    break;
                case 7:
                    companyPriceList.add(String.valueOf(stockItem.getPrice()));
                    break;
                case 8:
                    companyPriceList.add(String.valueOf(stockItem.getPrice()));
                    break;
                case 9:
                    companyPriceList.add(String.valueOf(stockItem.getPrice()));
                    break;
                case 10:
                    companyPriceList.add(String.valueOf(stockItem.getPrice()));
                    break;
                case 11:
                    companyPriceList.add(String.valueOf(stockItem.getPrice()));
                    break;
            }
        }
        return companyPriceList;
    }
}

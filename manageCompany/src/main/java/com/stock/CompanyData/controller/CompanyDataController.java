package com.stock.CompanyData.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.stock.CompanyData.model.Company;
import com.stock.CompanyData.model.CompareVarious;
import com.stock.CompanyData.model.IPO;
import com.stock.CompanyData.service.CompanyDataService;
import com.stock.CompanyData.service.IPOService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/company")
public class CompanyDataController {

    @Autowired
    CompanyDataService companyService;

    @Autowired
    IPOService ipoService;

    @PostMapping("/add")
    public Map<String, String> addNewCompany(@RequestBody Company company) {
        Map<String, String> resultMap = new HashMap<>();
        companyService.addNewCompany(company);
        resultMap.put("addCompanyStatus", "successful");
        return resultMap;
    }

    @GetMapping("/all")
    public List<Company> getAllCompanies() {
        return companyService.retrieveAllCompany();
    }

    @PostMapping("/update")
    public Map<String, String> updateCompanyInfo(@RequestBody Company company) {
        Map<String, String> resultMap = new HashMap<>();
        companyService.updateCompanyInformation(company);
        resultMap.put("updateCompanyStatus", "successful");
        return resultMap;
    }

    @GetMapping("/ipo")
    public List<IPO> getAllIpo() {
        return ipoService.retrieveAllIpo();
    }

    @PostMapping("/ipo/add")
    public Map<String, String> addNewIpo(@RequestBody IPO ipoDetail) {
        Map<String, String> resultMap = new HashMap<>();
        ipoService.insertNewIpo(ipoDetail);
        resultMap.put("addIPOStatus", "successful");
        return resultMap;
    }

    @GetMapping("/search")
    public List<Company> searchCompany(String name){
        return companyService.getCompanyByName(name);
    }

    @PostMapping("/compare")
    public CompareVarious compareCompany(@RequestBody CompareVarious request){
        return companyService.compareCompany(request);
    }
}

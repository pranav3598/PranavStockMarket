package com.rishabh.CompanyData;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.stock.CompanyData.controller.CompanyDataController;
import com.stock.CompanyData.dao.CompanyRepository;
import com.stock.CompanyData.dto.CompanyDTO;
import com.stock.CompanyData.model.Company;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CompanyControllerTest {

    @MockBean
    private CompanyRepository companyRepository;

    @Autowired
    private TestRestTemplate restTemplate;
    
    @Autowired
    private CompanyDataController  companyDataController;
    
    @BeforeAll
    public void setUp() {
    	Company company = new Company(1l,"Maruti",
        	    "BSE","10000000","Dilip","Manoj","Automobile","Good Company","1Dff78");
    	CompanyDTO companyEntity = new CompanyDTO();
    	BeanUtils.copyProperties(company, companyEntity);
    	companyRepository.saveAndFlush(companyEntity);
    }
    
    @Test
    public void canRetrieveByNameWhenExists() {
    	
        List<Company> list = companyDataController.searchCompany("Maruti");
        
        assertThat(list.get(0).getCompanyName().equals("Maruti"));
    }

    @Test
    public void canCreateANewCompany() {
        // when
    	Map<String, String> companyResponse = (Map<String, String>) restTemplate.postForEntity("/add/", new Company(1l,"Maruti",
    	    "BSE","10000000","Dilip","Manoj","Automobile","Good Company","1Dff78"), Company.class);

        // then
        assertThat(companyResponse.containsValue("successful"));
    }

}

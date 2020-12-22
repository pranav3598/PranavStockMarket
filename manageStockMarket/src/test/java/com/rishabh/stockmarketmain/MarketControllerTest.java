package com.rishabh.stockmarketmain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.stock.stockmarketmain.controller.MarketController;
import com.stock.stockmarketmain.dto.MarketDTO;
import com.stock.stockmarketmain.model.Market;

public class MarketControllerTest {
	
	@Autowired
	private MarketController marketController; 
	
    @BeforeAll
    public void setUp() {
    	Market market = new Market(1l, "BSE", "Bombay Stock Exchange", "Mumbai", "One of the oldest");
    	MarketDTO marketDTO = new MarketDTO();
    	BeanUtils.copyProperties(market, marketDTO);
    }
    
    @Test
    public void retrieve_all_Data() {
    	
        List<Market> markets = marketController.getAllStockExchanges();
        
        assertThat(markets.get(0).getStockExchange().equals("BSE"));
    }

    @Test
    public void canCreateANewCompany() {
        // when
    	Map<String, String> marketResponse = marketController.addNewStockExchange(new Market(2l,"NSE",
    	    "National Stock Exchange","Mumbai","Good Company"));

        // then
        assertThat(marketResponse.containsValue("successful"));
    }

}

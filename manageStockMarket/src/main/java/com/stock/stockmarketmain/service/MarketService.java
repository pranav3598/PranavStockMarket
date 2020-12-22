package com.stock.stockmarketmain.service;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stock.stockmarketmain.dao.MarketRepository;
import com.stock.stockmarketmain.dto.MarketDTO;
import com.stock.stockmarketmain.model.Market;

import java.util.ArrayList;
import java.util.List;

@Service
public class MarketService {
    @Autowired
    MarketRepository stockExchangeRepository;

    @Transactional
    public List<Market> retrieveAllMarkets() {
        List<Market> exchangesList = new ArrayList<>();
        List<MarketDTO> exchanges = stockExchangeRepository.findAll();
        if (CollectionUtils.isNotEmpty(exchanges)) {
            exchanges.forEach(exchangeItem -> {
                Market se = new Market();
                BeanUtils.copyProperties(exchangeItem, se);
                exchangesList.add(se);
            });
        }
        return exchangesList;
    }

    @Transactional
    public void addNewMarkets(Market stockExchange) {
        MarketDTO stockExchangeEntity = new MarketDTO();
        BeanUtils.copyProperties(stockExchange, stockExchangeEntity);
        stockExchangeRepository.saveAndFlush(stockExchangeEntity);
    }

}

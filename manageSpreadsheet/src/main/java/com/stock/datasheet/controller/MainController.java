package com.stock.datasheet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.stock.datasheet.dto.ObjectDTO;
import com.stock.datasheet.model.Header;
import com.stock.datasheet.service.MainService;

import java.util.List;

@RestController
@RequestMapping("/excel")
public class MainController {
    @Autowired
    MainService mainService;

    @PostMapping("/upload")
    public ResponseEntity<Header> uploadExcel(@RequestParam("file") MultipartFile file) throws Exception {
        mainService.uploadExcel(file);
        List<ObjectDTO> stockPriceList = mainService.importExcelData2DB(file);
        return new ResponseEntity<>(mainService.getUploadSummary(stockPriceList), HttpStatus.OK);
    }

}

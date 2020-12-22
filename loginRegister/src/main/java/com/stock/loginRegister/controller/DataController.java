package com.stock.loginRegister.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.stock.loginRegister.model.Data;
import com.stock.loginRegister.model.Header;
import com.stock.loginRegister.service.DataService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/Data")
public class DataController {

    @Autowired
    DataService DataService;

    @PostMapping("/registration")
    public Map<String, String> signUp(@RequestBody Data data) {
        DataService.signUp(data);
        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("signUpStatus", "successful");
        return resultMap;
    }

    @PostMapping("/login")
    public ResponseEntity<Header> login(@RequestBody Data data) {
    	Header header = new Header();
        Data DataDetail = DataService.authenticateLogin(data);
        if (DataDetail != null) {
            header.setToken("");
            header.setRole(DataDetail.getRole());
            header.setName(DataDetail.getName());
            header.setStatus("successful");
        } else {
            header.setStatus("login failed");
        }
        return new ResponseEntity<>(header, HttpStatus.OK);
    }

    @GetMapping("/profile/{Dataname}")
    public ResponseEntity<Data> retrieveDataProfile(@PathVariable("Dataname") String Dataname) {
        Data DataDetails = DataService.retrieveDataProfile(Dataname);
        if(DataDetails!=null){
            return new ResponseEntity<>(DataDetails, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/profile/update")
    public Map<String, String> updateDataProfile(@RequestBody Data Data) {
        DataService.updateDataProfile(Data);
        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("updateProfileStatus", "successful");
        return resultMap;
    }

}

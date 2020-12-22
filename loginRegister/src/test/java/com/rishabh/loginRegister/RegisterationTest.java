package com.rishabh.loginRegister;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.stock.loginRegister.controller.DataController;
import com.stock.loginRegister.model.Data;


public class RegisterationTest {
	@Autowired
	private DataController dataController; 
	
    
    @Test
    public void register_new_user() {
    	
    	// when
    	Map<String, String> regiterResponse = dataController.signUp(new Data(1l, "Manoj", "ABC@abc123", "9993371462", "manojsharma12@gmail.com", "user"));

        // then
        assertThat(regiterResponse.containsValue("successful"));
    }


}

package com.ssafy.springtest.controller;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.springtest.dto.CountryStatusDto;
import com.ssafy.springtest.service.CountryStatusService;

@RestController
@CrossOrigin("*")
public class SpringTestController {
    
    
    private static final Logger logger = LoggerFactory.getLogger(SpringTestController.class);

    
    @Autowired
    CountryStatusService cService;

	@GetMapping("/springtest")
	public ResponseEntity<String> springtest() {
		
		// Service > DAO 작성
		
		return new ResponseEntity<String>("Spring Test !!", HttpStatus.OK);
	}
	
	@GetMapping("/country-status")
	public ResponseEntity<List<CountryStatusDto>> selectAll() {
	    List<CountryStatusDto> countryList = cService.getCountryStatusList();
	    logger.debug("list: {}", countryList);
	    return new ResponseEntity<List<CountryStatusDto>>(countryList, HttpStatus.OK);
	}
	
	@GetMapping("/country-status/{cname}")
	public CountryStatusDto select(@PathVariable String cname) {
	    logger.debug("cname: {}", cname);
	    return cService.getCountryByName(cname);
	}
	
	@PostMapping("/insert-country-status")
	public String insertCountryStatus(@RequestBody CountryStatusDto countryStatusDto) {
	    if (cService.insert(countryStatusDto) == 1) {
	        return "1";
	    } else {
	        return "이미 등록된 국가입니다.";
	    }
	}
	
	@PutMapping("/update-country-status")
	public int update(@RequestBody CountryStatusDto countryStatusDto) {
	    return cService.update(countryStatusDto);
	}
	
	@GetMapping("/delete-country-status/{cname}")
	public int delete(@PathVariable String cname) {
	    return cService.delete(cname);
	}
	
	@GetMapping("/country-status-by-order")
    public List<CountryStatusDto> getStatusByOrder() {
        List<CountryStatusDto> countryList = cService.selectOrder();
        return countryList;
    }
	
}

package com.ssafy.springtest.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.springtest.dao.CountryStatusMapper;
import com.ssafy.springtest.dto.CountryStatusDto;

@Service
public class CountryStatusServiceImpl implements CountryStatusService {
    
    @Autowired
    CountryStatusMapper countryStatusMapper;

    @Override
    public List<CountryStatusDto> getCountryStatusList() {
        return countryStatusMapper.selectAll();
    }
    
    public CountryStatusDto getCountryByName(String cname) {
        return countryStatusMapper.select(cname);
    }

    
    public int insert(CountryStatusDto countryStatusDto) {
        try {
            countryStatusMapper.insert(countryStatusDto);
        } catch (Exception e) {
            return 0;
        }
        return 0;
    }
    
    public int update(CountryStatusDto countryStatusDto) {
        return countryStatusMapper.update(countryStatusDto);
    }
    
    public int delete(String cname) {
        return countryStatusMapper.delete(cname);
    }
    
    public List<CountryStatusDto> selectOrder() {
        return countryStatusMapper.selectOrder();
    }

}

package com.ssafy.springtest.service;

import java.util.List;
import com.ssafy.springtest.dto.CountryStatusDto;

public interface CountryStatusService {
    
    List<CountryStatusDto> getCountryStatusList();
    
    CountryStatusDto getCountryByName(String cname);

    int insert(CountryStatusDto countryStatusDto);
    
    int update(CountryStatusDto countryStatusDto);

    int delete(String cname);
    
    List<CountryStatusDto> selectOrder();
    
}

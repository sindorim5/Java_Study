package com.ssafy.springtest.dao;

import java.util.List;
import com.ssafy.springtest.dto.CountryStatusDto;

public interface CountryStatusMapper {
    
    List<CountryStatusDto> selectAll();
    
    CountryStatusDto select(String cname);
    
    int insert(CountryStatusDto countryStatusDto);

    int update(CountryStatusDto countryStatusDto);
    
    int delete(String cname);
    
    List<CountryStatusDto> selectOrder();

}

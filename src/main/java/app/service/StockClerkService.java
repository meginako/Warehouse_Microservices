package app.service;

import app.dto.StockClerkDto;

import java.util.List;

public interface StockClerkService {

    StockClerkDto findById(String id);

    List<StockClerkDto> findAll();

    StockClerkDto save(StockClerkDto stockClerkDto);

    void deleteById(String id);
}

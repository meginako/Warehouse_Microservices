package app.service;

import app.dto.WareTransactionDetailDto;

import java.util.List;

public interface WareTransactionDetailService {

    WareTransactionDetailDto findById(String id);

    List<WareTransactionDetailDto> findByWareTransactionId(String wareTransactionId);
}

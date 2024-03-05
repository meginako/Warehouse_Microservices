package app.controller;

import app.dto.WareTransactionDetailDto;
import app.service.WareTransactionDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ware-transaction-details")
public class WareTransactionDetailController {

    private final WareTransactionDetailService wareTransactionDetailService;

    @Autowired
    public WareTransactionDetailController(WareTransactionDetailService wareTransactionDetailService) {
        this.wareTransactionDetailService = wareTransactionDetailService;
    }

    @GetMapping("{id}")
    public WareTransactionDetailDto findById(@PathVariable String id) {
        return this.wareTransactionDetailService.findById(id);
    }

    @GetMapping
    public List<WareTransactionDetailDto> findByWareTransactionId(@RequestParam String wareTransactionId) {
        return this.wareTransactionDetailService.findByWareTransactionId(wareTransactionId);
    }

}

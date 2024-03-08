package app.service.impl;

import app.dto.WareTransactionDetailDto;
import app.dto.WareTransactionDto;
import app.exception.ResourceNotFoundException;
import app.model.*;
import app.repository.ProductRepository;
import app.repository.ShelfRepository;
import app.repository.StockClerkRepository;
import app.repository.WareTransactionRepository;
import app.service.WareTransactionService;
import app.validation.WareTransactionDtoValidator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WareTransactionServiceImpl implements WareTransactionService {

    private final WareTransactionRepository wareTransactionRepository;
    private final StockClerkRepository stockClerkRepository;
    private final ProductRepository productRepository;
    private final ShelfRepository shelfRepository;
    private final WareTransactionDtoValidator wareTransactionDtoValidator;

    @Autowired
    public WareTransactionServiceImpl(
            WareTransactionRepository wareTransactionRepository,
            StockClerkRepository stockClerkRepository,
            ProductRepository productRepository,
            ShelfRepository shelfRepository,
            WareTransactionDtoValidator wareTransactionDtoValidator) {
        this.wareTransactionRepository = wareTransactionRepository;
        this.stockClerkRepository = stockClerkRepository;
        this.productRepository = productRepository;
        this.shelfRepository = shelfRepository;
        this.wareTransactionDtoValidator = wareTransactionDtoValidator;
    }

    @Override
    public WareTransactionDto findById(String id) {
        WareTransaction wareTransaction = this.wareTransactionRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        return new WareTransactionDto(wareTransaction);
    }

    @Override
    public List<WareTransactionDto> findAll() {
        return this.wareTransactionRepository
                .findAll()
                .stream()
                .map(WareTransactionDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public WareTransactionDto save(WareTransactionDto wareTransactionDto) {
        this.wareTransactionDtoValidator.validate(wareTransactionDto);
        WareTransaction wareTransaction = this.dtoToEntity(wareTransactionDto);
        return new WareTransactionDto(this.wareTransactionRepository.save(wareTransaction));
    }

    @Override
    public void deleteById(String id) {
        this.wareTransactionRepository.deleteById(id);
    }

    private WareTransaction dtoToEntity(WareTransactionDto wareTransactionDto) {
        WareTransaction wareTransaction = new WareTransaction();
        List<WareTransactionDetail> wareTransactionDetails = new ArrayList<>();

        BeanUtils.copyProperties(wareTransactionDto, wareTransaction, "wareTransactionDetails");

        String stockClerkId = wareTransactionDto.getStockClerkId();
        StockClerk stockClerk = this.stockClerkRepository
                .findById(stockClerkId)
                .orElse(null);
        wareTransaction.setStockClerk(stockClerk);

        List<WareTransactionDetailDto> wareTransactionDetailDtos = wareTransactionDto.getWareTransactionDetails();
        if(wareTransactionDetailDtos != null && !wareTransactionDetailDtos.isEmpty()) {
            for(WareTransactionDetailDto wTxDetailDto : wareTransactionDetailDtos) {
                WareTransactionDetail wTxDetail = new WareTransactionDetail();
                BeanUtils.copyProperties(wTxDetailDto, wTxDetail);

                this.productRepository
                        .findById(wTxDetailDto.getProductId()).ifPresent(wTxDetail::setProduct);

                this.shelfRepository
                        .findById(wTxDetailDto.getShelfId()).ifPresent(wTxDetail::setShelf);

                wTxDetail.setWareTransaction(wareTransaction);
                wareTransactionDetails.add(wTxDetail);
            }
        }
        wareTransaction.setWareTransactionDetails(wareTransactionDetails);
        return wareTransaction;
    }
}

package app.service.impl;

import app.dto.WareTransactionDetailDto;
import app.exception.ResourceNotFoundException;
import app.model.Product;
import app.model.Shelf;
import app.model.WareTransaction;
import app.model.WareTransactionDetail;
import app.repository.ProductRepository;
import app.repository.ShelfRepository;
import app.repository.WareTransactionDetailRepository;
import app.repository.WareTransactionRepository;
import app.service.WareTransactionDetailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WareTransactionDetailServiceImpl implements WareTransactionDetailService {

    private final WareTransactionDetailRepository wareTransactionDetailRepository;
    private final WareTransactionRepository wareTransactionRepository;
    private final ProductRepository productRepository;
    private final ShelfRepository shelfRepository;

    @Autowired
    public WareTransactionDetailServiceImpl(
            WareTransactionDetailRepository wareTransactionDetailRepository,
            WareTransactionRepository wareTransactionRepository,
            ProductRepository productRepository,
            ShelfRepository shelfRepository) {
        this.wareTransactionDetailRepository = wareTransactionDetailRepository;
        this.wareTransactionRepository = wareTransactionRepository;
        this.productRepository = productRepository;
        this.shelfRepository = shelfRepository;
    }

    @Override
    public WareTransactionDetailDto findById(String id) {
        WareTransactionDetail wTxDetail = this.wareTransactionDetailRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        return new WareTransactionDetailDto(wTxDetail);
    }

    @Override
    public List<WareTransactionDetailDto> findByWareTransactionId(String wareTransactionId) {
        return this.wareTransactionDetailRepository
                .findByWareTransactionId(wareTransactionId)
                .stream()
                .map(WareTransactionDetailDto::new)
                .collect(Collectors.toList());
    }

    private WareTransactionDetail dtoToEntity(WareTransactionDetailDto wareTransactionDetailDto) {
        WareTransactionDetail wTxDetail = new WareTransactionDetail();
        BeanUtils.copyProperties(wareTransactionDetailDto, wTxDetail);

        String wareTransactionId = wareTransactionDetailDto.getWareTransactionId();
        if (wareTransactionId != null) {
            this.wareTransactionRepository
                    .findById(wareTransactionId).ifPresent(wTxDetail::setWareTransaction);

        }

        String productId = wareTransactionDetailDto.getProductId();
        if (productId != null) {
            this.productRepository
                    .findById(productId).ifPresent(wTxDetail::setProduct);

        }

        String shelfId = wareTransactionDetailDto.getShelfId();
        if (shelfId != null) {
            this.shelfRepository
                    .findById(shelfId).ifPresent(wTxDetail::setShelf);

        }
        return wTxDetail;
    }
}

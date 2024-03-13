package app.service.impl;

import app.common.search.BaseSearchCriteria;
import app.dto.ProductDto;
import app.exception.ResourceNotFoundException;
import app.model.Product;
import app.repository.ProductRepository;
import app.common.search.ProductSearchCriteria;
import app.service.ProductService;
import app.validation.ProductDtoValidator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductDtoValidator productDtoValidator;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductDtoValidator productDtoValidator) {
        this.productRepository = productRepository;
        this.productDtoValidator = productDtoValidator;
    }

    @Override
    public ProductDto findById(String id) {
        Product product = this.productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));

        return new ProductDto(product);
    }

    @Override
    public List<ProductDto> findAll() {
        return this.productRepository.findAll().stream().map(ProductDto::new).collect(Collectors.toList());
    }

    @Override
    public ProductDto save(ProductDto productDto) {
        productDtoValidator.validate(productDto);
        Product product = this.dtoToEntity(productDto);
        Product savedProduct = this.productRepository.save(product);
        return new ProductDto(savedProduct);
    }

    @Override
    public void deleteById(String id) {
        this.productRepository.deleteById(id);
    }

    @Override
    public Page<Product> search(BaseSearchCriteria<ProductSearchCriteria> criteria) {
        return this.productRepository.search(criteria);
    }

    private Product dtoToEntity(ProductDto productDto) {
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        return product;
    }
}

package app.controller;

import app.common.search.BaseSearchCriteria;
import app.dto.ProductDto;
import app.model.Product;
import app.common.search.ProductSearchCriteria;
import app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("{id}")
    public ProductDto findById(@PathVariable String id) {
        return this.productService.findById(id);
    }

    @GetMapping
    public List<ProductDto> findAll() {
        return this.productService.findAll();
    }

    @PostMapping
    public ProductDto save(@RequestBody ProductDto productDto) {
        productDto.setId(null);
        return this.productService.save(productDto);
    }

    @PutMapping
    public ProductDto update(@RequestBody ProductDto productDto) {
        return this.productService.save(productDto);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable String id) {
        this.productService.deleteById(id);
    }

    @PostMapping("search")
    public Page<Product> search(@RequestBody BaseSearchCriteria<ProductSearchCriteria> searchRequest) {
        return this.productService.search(searchRequest);
    }

}

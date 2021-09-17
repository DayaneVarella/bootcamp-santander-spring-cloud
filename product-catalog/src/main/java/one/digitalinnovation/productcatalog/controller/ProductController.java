package one.digitalinnovation.productcatalog.controller;

import one.digitalinnovation.productcatalog.model.Product;
import one.digitalinnovation.productcatalog.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping
    Product create(@RequestBody Product product){
        return productRepository.save(product);
    }

    @GetMapping
    Iterable<Product> listAll(){
        return productRepository.findAll();
    }

    @GetMapping("/{productId}")
    Optional<Product>findById(@PathVariable("productId") Long id){
        return productRepository.findById(id);
    }
}

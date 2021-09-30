package br.com.diego.productcatalog.controller;

import br.com.diego.productcatalog.model.Product;
import br.com.diego.productcatalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping(value = "/products")
public class ProductCatalogController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    public Product create(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @GetMapping
    public List<Product> listProducts() {
        Iterable<Product> productIterable = productRepository.findAll();
        return StreamSupport.stream(productIterable.spliterator(),false).collect(Collectors.toList());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id) {
        Optional<Product> productOptional = productRepository.findById(id);
        return productOptional.map(product -> ResponseEntity.ok().body(product)).orElseGet(() -> ResponseEntity.notFound().build());
    }
}

package br.com.diego.productcatalog.repository;

import br.com.diego.productcatalog.model.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductRepository extends ElasticsearchRepository<Product, String> {
}

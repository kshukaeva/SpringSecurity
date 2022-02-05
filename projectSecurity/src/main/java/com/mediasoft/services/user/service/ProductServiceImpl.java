package com.mediasoft.services.user.service;

import com.mediasoft.services.user.domain.Product;
import com.mediasoft.services.user.repo.ProductRepo;
import com.mediasoft.services.user.repo.RoleRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ProductServiceImpl implements ProductService{
    private final ProductRepo productRepo;
    @Override
    public Product createProduct(Product product) {
        log.info("Saving new product {} the database", product.getName());
        return productRepo.save(product);
    }

    @Override
    public Product getProduct(Integer id) {
        return productRepo.findById(id.longValue()).orElse(null);
    }

    @Override
    public boolean updateProduct(Product product){
        productRepo.save(product);
        return true;
    }

    @Override
    public boolean deleteProduct(long id){
        productRepo.deleteById(id);
        return true;
    }

    @Override
    public List<Product> findAllProducts() {
        return (List<Product>) productRepo.findAll();
    }
}

package com.mediasoft.services.user.service;
import com.mediasoft.services.user.domain.Product;
import com.mediasoft.services.user.domain.User;

import java.util.List;


public interface ProductService {
    public Product createProduct(Product product);
    public Product getProduct(Integer id);
    public boolean updateProduct(Product product);
    public boolean deleteProduct(long id);
    public List<Product> findAllProducts();
}

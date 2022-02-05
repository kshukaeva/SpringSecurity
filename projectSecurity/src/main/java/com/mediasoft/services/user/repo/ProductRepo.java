package com.mediasoft.services.user.repo;

import com.mediasoft.services.user.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {
    public Product findByName(String name);
}

package com.mediasoft.services.user.api;

import com.mediasoft.services.user.domain.Product;
import com.mediasoft.services.user.domain.User;
import com.mediasoft.services.user.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
@Slf4j
public class ProductResource {
    private final ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok().body(productService.findAllProducts());
    }

    @PostMapping("/save")
    public ResponseEntity<Product> saveUser(@RequestBody Product product) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/product/save").toString());
        return ResponseEntity.created(uri).body(productService.createProduct(product));
    }
    @GetMapping("/get/{id}")
    public ResponseEntity getUserById(@PathVariable Integer id) {
        Product productRequest = productService.getProduct(id);
        if (productRequest == null) {
            return new ResponseEntity("Product not found", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(productRequest);
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Product requestProduct) {
        Product product = productService.getProduct(requestProduct.getProductId().intValue());
        if (product != null) {
            product.setName(requestProduct.getName());
            product.setDescription(requestProduct.getDescription());
            product.setPrice(requestProduct.getPrice());
            boolean result = this.productService.updateProduct(product);
            if (result) {
                return ResponseEntity.ok("Updated");
            }
        }
        return ResponseEntity.badRequest().body("bad request");
    }
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        boolean result = this.productService.deleteProduct(id);
        if (result) {
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.badRequest().body("bad request");
    }
}

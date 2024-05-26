package com.foodorder.foodorder.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodorder.foodorder.entity.Product;
import com.foodorder.foodorder.repository.ProductRespository;

@Service
public class ProductService {
    @Autowired
    ProductRespository productRespository;
    public List<Product> getAllProduct(){
        return productRespository.findAll();
    }

    public void addProduct(Product product){
        productRespository.save(product);
    }
    public void removeProductById(long id){
        productRespository.deleteById(id);
    }
    public Optional<Product> getProductById(long id){
        return productRespository.findById(id);

    }
    public List<Product> getAllProductsByCategoryId(int id){
        return productRespository.findAllByCategory_Id(id);
    }
}

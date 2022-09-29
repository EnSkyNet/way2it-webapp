package com.way2it.yk.web.dao;



import com.way2it.yk.web.entity.ProductEntityMTM;

import java.util.List;
import java.util.Optional;

public interface ProductDaoMTM {
    List<ProductEntityMTM> getAllProducts();

    Optional<ProductEntityMTM> getProductById(Integer Id);

    void saveProduct(ProductEntityMTM productEntityMTM);
    void deleteProduct(ProductEntityMTM productEntityMTM);

}

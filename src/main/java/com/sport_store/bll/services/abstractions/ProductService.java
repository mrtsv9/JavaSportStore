package com.sport_store.bll.services.abstractions;

import com.sport_store.bll.models.product_service.GetProduct;
import com.sport_store.bll.models.product_service.PostProduct;
import com.sport_store.bll.models.product_service.PutProduct;

import java.util.List;

public interface ProductService {

    List<GetProduct> getAll();

    void createProduct(PostProduct product);

    void updateProduct(PutProduct product);

    void deleteBook(int id);
}

package com.sport_store.bll.services;

import com.sport_store.bll.models.product_service.GetProduct;
import com.sport_store.bll.models.product_service.PostProduct;
import com.sport_store.bll.models.product_service.ProductTypeForGetProduct;
import com.sport_store.bll.models.product_service.PutProduct;
import com.sport_store.bll.repositories.abstractions.ProductRepository;
import com.sport_store.bll.repositories.abstractions.ProductTypeRepository;
import com.sport_store.bll.services.abstractions.ProductService;
import com.sport_store.dal.entities.ProductEntity;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductTypeRepository productTypeRepository;

    @Override
    public List<GetProduct> getAll() {
        var products = productRepository.findAll();

        var getProductList = new ArrayList<GetProduct>();

        for (ProductEntity product : products) {
            var newProduct = new GetProduct();
            newProduct.setId(product.getId());
            newProduct.setName(product.getName());
            newProduct.setPrice(product.getPrice());

            var productType = new ProductTypeForGetProduct();
            var productTypeExist = productTypeRepository.findById(product.getProductType().getId());
            if (productTypeExist.isEmpty()) throw new IllegalArgumentException();
            productType.setId(productTypeExist.get().id);
            productType.setType(productTypeExist.get().type);

            newProduct.setProductType(productType);
            getProductList.add(newProduct);
        }
        return getProductList;
    }

    @Override
    public void createProduct(@NotNull PostProduct product) {
        var createProduct = new ProductEntity();
        createProduct.setName(product.getName());
        createProduct.setPrice(product.getPrice());
        var productTypeExist = productTypeRepository.findById(product.getProductTypeId());
        if (productTypeExist.isEmpty()) throw new IllegalArgumentException();
        createProduct.setProductType(productTypeExist.get());

        productRepository.save(createProduct);
    }

    @Override
    public void updateProduct(PutProduct product) {
        var updateProduct = productRepository.findById(product.getId());
        if (updateProduct.isEmpty()) throw new IllegalArgumentException();
        updateProduct.get().setName(product.getName());
        updateProduct.get().setPrice(product.getPrice());
        var productTypeExist = productTypeRepository.findById(product.getProductTypeId());
        if (productTypeExist.isEmpty()) throw new IllegalArgumentException();
        updateProduct.get().setProductType(productTypeExist.get());

        productRepository.save(updateProduct.get());
    }

    @Override
    public void deleteBook(int id) {
        productRepository.deleteById(id);
    }

}
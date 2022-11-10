package com.sport_store.bll.services;

import com.sport_store.bll.repositories.abstractions.ProductTypeRepository;
import com.sport_store.bll.services.abstractions.ProductTypeService;
import com.sport_store.dal.entities.ProductTypeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

    @Autowired
    private ProductTypeRepository repository;

    public List<ProductTypeEntity> getAll() {
        return repository.findAll();
    }

}

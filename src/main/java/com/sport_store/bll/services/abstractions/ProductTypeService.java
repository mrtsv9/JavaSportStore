package com.sport_store.bll.services.abstractions;

import com.sport_store.dal.entities.ProductTypeEntity;

import java.util.List;

public interface ProductTypeService {

    List<ProductTypeEntity> getAll();

}

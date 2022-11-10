package com.sport_store.bll.repositories.abstractions;

import com.sport_store.dal.entities.ProductTypeEntity;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductTypeRepository extends JpaRepository<ProductTypeEntity, Integer> {
    @Override
    @NotNull
    List<ProductTypeEntity> findAll();
}

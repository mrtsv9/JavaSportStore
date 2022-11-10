package com.sport_store.bll.repositories.abstractions;

import com.sport_store.dal.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
}

package com.sport_store.bll.repositories.abstractions;

import com.sport_store.dal.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
}

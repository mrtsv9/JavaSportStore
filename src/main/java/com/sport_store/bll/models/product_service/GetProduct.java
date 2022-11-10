package com.sport_store.bll.models.product_service;

import com.sport_store.dal.entities.ProductTypeEntity;
import lombok.*;

@Data
public class GetProduct {

    private int id;
    private String name;
    private int price;
    private ProductTypeForGetProduct productType;

}

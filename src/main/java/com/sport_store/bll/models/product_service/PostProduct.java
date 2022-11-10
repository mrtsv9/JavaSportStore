package com.sport_store.bll.models.product_service;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PostProduct {

    private String name;
    private int price;
    @JsonProperty("product_type_id")
    private int productTypeId;
//    private ProductTypeForPostProduct productType;

}

package com.sport_store.bll.models.product_service;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PutProduct {

    private int id;
    private String name;
    private int price;
    @JsonProperty("product_type_id")
    private int productTypeId;

}

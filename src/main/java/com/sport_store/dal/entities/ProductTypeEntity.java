package com.sport_store.dal.entities;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Service
@Getter
@Setter
@Entity
@Table(name = "product_type")
public class ProductTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int id;
    @Column(name = "type")
    public String type;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productType")
    private List<ProductEntity> product = new ArrayList<>();
}

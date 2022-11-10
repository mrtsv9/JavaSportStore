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
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int id;
    @Column(name = "name")
    public String name;
    @Column(name = "price")
    public int price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_type_id", nullable = false)
    private ProductTypeEntity productType;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<OrderEntity> orderEntities = new ArrayList<>();
}
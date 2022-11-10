package com.sport_store.dal.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "order")
@NoArgsConstructor
public class OrderEntity {

    @EmbeddedId
    private OrderIdEntity id;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private ProductEntity product;
    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private UserEntity user;
    @Column(name = "amount")
    private int amount;

    public OrderEntity(OrderIdEntity id, ProductEntity product, UserEntity user, int amount) {
        this.id = id;
        this.product = product;
        this.user = user;
        this.amount = amount;
    }

}
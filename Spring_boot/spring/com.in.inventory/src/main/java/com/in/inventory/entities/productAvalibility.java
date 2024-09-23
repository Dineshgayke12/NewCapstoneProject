package com.in.inventory.entities;


import jakarta.persistence.*;
import lombok.*;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "productAvalibility")
@Entity
public class productAvalibility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Prodid")
    private int Prodid;

    @Column(name = "productName")
    private String productName;

    @Column(name = "price")
    private String price;

    @Column(name = "productQty")
    private Integer productQty;

    @Column(name = "Unit")
    private String Unit;
}

package com.in.inventory.entities;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "productName")
    private String productName;

    @Column(name = "price")
    private String price;

    @Column(name = "productQty")
    private Integer productQty;


    @Column(name = "date")
    private String date;

    @Column(name = "suplierName")
    private String suplierName;

    @Column(name = "status")
    private String status;


    @Column(name = "Unit")
    private String Unit;


	


}

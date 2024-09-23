package com.in.suplier.Entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Suplier")
public class suplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "SuplierName")
    private String SuplierName;

    @Column(name = "contact")
    private String contact;

    @Column(name = "address")
    private String address;

}

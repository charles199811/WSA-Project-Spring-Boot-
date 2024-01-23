package com.wsa.academy.entity;

import com.wsa.academy.entity.enums.MessuringUnitType;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "item")
//Here we use this lombook anotations without coding constructors and toStrings
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Item {

    @Id
    @Column(name ="Item_Id")
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int itemId;

    @Column(name = "Item_Name", length = 100, nullable = false)
    private String itemName;

    @Enumerated(EnumType.STRING)
    @Column(name = "Messuring_Unit_Type", length = 100, nullable = false)
    private MessuringUnitType messuringUnitType;

    @Column(name = "Balance_Qty", length = 100, nullable = false)
    private double balanceQty;

    @Column(name = "Supplier_Price", length = 100, nullable = false)
    private  double supplierPrice;

    @Column(name = "Selling_Price", length = 100, nullable = false)
    private  double sellingPrice;

    @Column(name = "active_state")
    private boolean active;


}

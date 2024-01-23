package com.wsa.academy.dto.request;

import com.wsa.academy.entity.enums.MessuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemSaveRequestDTO {

    private String itemName;
    private MessuringUnitType messuringUnitType;
    private double balanceQty;
    private  double supplierPrice;
    private  double sellingPrice;
}

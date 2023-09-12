package com.orderPlacement.Order_Placement.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class NewOrderDTO {
    private Long userID;
    private Long itemID;
    private int quantity;
}

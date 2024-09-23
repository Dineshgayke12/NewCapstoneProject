package com.in.inventory.dto;

import lombok.Data;

@Data
public class NotificationDtoResponse {
    private Integer qty;

    public NotificationDtoResponse(Integer qty) {
        this.qty = qty;
    }

}

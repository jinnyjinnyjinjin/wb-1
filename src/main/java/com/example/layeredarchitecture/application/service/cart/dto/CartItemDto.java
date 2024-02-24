package com.example.layeredarchitecture.application.service.cart.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CartItemDto {
	private Long userId;
	private Long itemId;
	private Long optionId;
	private int quantity;
}

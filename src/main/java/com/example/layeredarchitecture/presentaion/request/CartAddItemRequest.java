package com.example.layeredarchitecture.presentaion.request;

import com.example.layeredarchitecture.application.service.cart.dto.CartItemDto;
import lombok.Getter;

@Getter
public class CartAddItemRequest {
	private Long userId;
	private Long itemId;
	private Long optionId;
	private int quantity;

	public CartItemDto toDto() {
		return CartItemDto.builder()
				.userId(userId)
				.itemId(itemId)
				.optionId(optionId)
				.quantity(quantity)
				.build();
	}
}

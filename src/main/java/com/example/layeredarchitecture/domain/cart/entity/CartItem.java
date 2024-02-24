package com.example.layeredarchitecture.domain.cart.entity;

import com.example.layeredarchitecture.domain.item.entity.Item;
import com.example.layeredarchitecture.domain.item.entity.Option;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class CartItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	private Cart cart;

	@ManyToOne(fetch = FetchType.LAZY)
	private Item item;

	private int quantity;

	@ManyToOne(fetch = FetchType.LAZY)
	private Option option;

	public CartItem() {
	}

	public CartItem(Cart cart, Item item, Option option, int quantity) {
		this.cart = cart;
		this.item = item;
		this.option = option;
		this.quantity += quantity;
	}

	public static CartItem create(Cart cart, Item item, Option option, int quantity) {
		return new CartItem(cart, item, option, quantity);
	}

	public void increaseQuantity(int quantity) {
		if (quantity <= 0) {
			throw new IllegalArgumentException("수량은 0보다 커야합니다.");
		}
		this.quantity += quantity;
	}

	public boolean hasSameOptionItem(Long itemId, Long optionId) {
		return this.item.getId().equals(itemId) && this.option.getId().equals(optionId);
	}
}

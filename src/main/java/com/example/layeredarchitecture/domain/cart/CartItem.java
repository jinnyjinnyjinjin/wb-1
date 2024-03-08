package com.example.layeredarchitecture.domain.cart;

import com.example.layeredarchitecture.domain.product.Product;
import com.example.layeredarchitecture.domain.product.Option;
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
	private Product product;

	private int quantity;

	@ManyToOne(fetch = FetchType.LAZY)
	private Option option;

	public CartItem() {
	}

	public CartItem(Cart cart, Product product, Option option, int quantity) {
		this.cart = cart;
		this.product = product;
		this.option = option;
		this.quantity += quantity;
	}

	public static CartItem create(Cart cart, Product product, Option option, int quantity) {
		return new CartItem(cart, product, option, quantity);
	}

	public void increaseQuantity(int quantity) {
		if (quantity <= 0) {
			throw new IllegalArgumentException("수량은 0보다 커야합니다.");
		}
		this.quantity += quantity;
	}

	public boolean hasSameOptionItem(Long itemId, Long optionId) {
		return this.product.getId().equals(itemId) && this.option.getId().equals(optionId);
	}
}

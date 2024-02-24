package com.example.layeredarchitecture.presentaion;

import com.example.layeredarchitecture.application.service.cart.CartAddItemService;
import com.example.layeredarchitecture.presentaion.request.CartAddItemRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cart-items")
public class CartController {

	private final CartAddItemService cartAddItemService;

	@PostMapping
	public ResponseEntity<Object> addItem(@RequestBody CartAddItemRequest request) {
		cartAddItemService.addItem(request.toDto());
		return ResponseEntity.ok().build();
	}
}

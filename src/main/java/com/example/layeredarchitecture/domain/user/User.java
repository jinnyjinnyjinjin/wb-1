package com.example.layeredarchitecture.domain.user;

import com.example.layeredarchitecture.domain.cart.Cart;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@OneToOne
	@JoinColumn(name = "cart_id")
	private Cart cart;

	public User() {
	}

	public User(String name) {
		this.name = name;
	}

	public static User create(String name) {
		return new User(name);
	}

}

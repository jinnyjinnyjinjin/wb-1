package com.example.layeredarchitecture.domain.item;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "items")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
}

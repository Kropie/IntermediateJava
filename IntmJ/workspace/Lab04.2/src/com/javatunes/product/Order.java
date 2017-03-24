/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.product;

public class Order<T extends ShoppingCart<? extends Product>> {
	private String id;

	public Order(String id) {
		this.id = id;
	}

	/**
	 * TODO: get the items from the cart and iterate over them, print each
	 * item's product code get cart total and print
	 */
	public void processCart(T cart) {
		for (Product item : cart.allItems()) {
			System.out.println(item.toString() + " code " + item.getCode());
		}
		System.out.println("Cart total = $" + cart.total());
	}

	public String getId() {
		return id;
	}

	public void processAllCarts(T... carts) {
		for (T cart : carts) {
			processCart(cart);
		}
	}
}
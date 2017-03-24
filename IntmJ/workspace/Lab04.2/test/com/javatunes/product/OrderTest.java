package com.javatunes.product;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class OrderTest {
	private ShoppingCart<Product> productCart;
	private ShoppingCart<MusicItem> musicCart;
	private ShoppingCart<MediaPlayer> mediaCart;

	private Order<ShoppingCart<? extends Product>> productOrder;
	private Order<ShoppingCart<? extends Product>> musicOrder;
	private Order<ShoppingCart<? extends Product>> mediaOrder;
	

	@Before
	public void init() {
		productCart = new ShoppingCart<Product>();
		productCart.addItem(new MusicItem("CD-501"));
		productCart.addItem(new MediaPlayer("MP3-LP150"));

		musicCart = new ShoppingCart<MusicItem>();
		musicCart.addItem(new MusicItem("CD-521"));
		musicCart.addItem(new MusicItem("CD-514"));

		mediaCart = new ShoppingCart<MediaPlayer>();
		mediaCart.addItem(new MediaPlayer("AAC-PL233"));

		mediaOrder = new Order<>("media");
		musicOrder = new Order<>("music");
		productOrder = new Order<>("product");
	}

	// TODO: create new Order for each cart above and pass cart to
	// processOrder()
	@Test
	public void testProcessCart() {
		mediaOrder.processCart(mediaCart);
		musicOrder.processCart(musicCart);
		productOrder.processCart(productCart);
		
		System.out.println("---------- TestProcessCart done -----------\n");
	}
	
	@Test
	public void testProcessAllCarts() {
		mediaOrder.processAllCarts(mediaCart, musicCart, productCart);
		
		System.out.println("------------ TestProcessAllCarts done -----------\n");
	}
}
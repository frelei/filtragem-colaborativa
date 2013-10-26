package recomendador.teste;

import static org.junit.Assert.*;

import org.junit.Test;

import recomendador.modulo.Item;

public class ItemTest {

	@Test
	public void equalitTest() {
		
		Item item = new Item(1,1);
		Item item1 = new Item(1,1);
		Item item2 = new Item(2,2);
		Item item3 = new Item(2,1);
		Item item4 = new Item(3,1);
		Item item5 = new Item(4,1);
		
		assertEquals(item, item1);
		assertEquals(item2, item3);
		assertNotEquals(item4, item5);
		
	}

}

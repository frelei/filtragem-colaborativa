package recomendador.teste;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import recomendador.modulo.Item;
import recomendador.modulo.Util;

public class UtilTest {

	private List<Item> i = new ArrayList<Item>();
	private List<Item> a = new ArrayList<Item>();
	private List<Item> b = new ArrayList<Item>();
	private List<Item> c = new ArrayList<Item>();
	
	@Before
	public void init(){
		i.add(new Item(1, 1));
		i.add(new Item(2, 2));
		i.add(new Item(3, 3));
		i.add(new Item(4, 4));
		i.add(new Item(5, 5));
		i.add(new Item(6, 6));
		
		b.add(new Item(1, 1));
		b.add(new Item(2, 2));
		b.add(new Item(3, 3));
		b.add(new Item(4, 4));
		b.add(new Item(5, 5));
		b.add(new Item(6, 6));
		b.add(new Item(7, 7));
		b.add(new Item(8, 8));
	
		c.add(new Item(1, 1));
		c.add(new Item(8, 2));
		c.add(new Item(10, 3));
		c.add(new Item(4, 4));
		c.add(new Item(5, 5));
		c.add(new Item(30, 6));
		c.add(new Item(7, 7));
		c.add(new Item(8, 8));
		
		a.add(new Item(40, 0));
		a.add(new Item(40, 0));
	}
	
	@Test
	public void testMedia() {
		float resp = Util.average(i);
		float respA = Util.average(a);
		assertEquals(resp, 3.5, 0.0);
		assertEquals(respA, 0, 0.0);
	}

	/*
	@Test
	public void testGetCommon() {
		List<Item> r = Util.getCommon(b, c);
		List<Item> s = Util.getCommon(c, b);
		List<Item> k = Util.getCommon(a, i);
		List<Item> l = Util.getCommon(i, a);
		assertEquals(5, r.size());
		assertEquals(5, s.size());
		assertEquals(0, k.size());
		assertEquals(0, l.size());
	}
*/
	
}

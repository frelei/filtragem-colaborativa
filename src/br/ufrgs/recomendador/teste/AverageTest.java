package br.ufrgs.recomendador.teste;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.ufrgs.recomendador.modulo.Average;
import br.ufrgs.recomendador.modulo.Item;

public class AverageTest {

	
	private List<Item> u1 = new ArrayList<Item>();
	private List<Item> u2 = new ArrayList<Item>();
	
	@Before
	public void init(){
		u1.add(new Item(1, 1));
		u1.add(new Item(2, 2));
		u1.add(new Item(3, 3));
		u1.add(new Item(4, 4));
		
		u2.add(new Item(5, 2));
		u2.add(new Item(2, 2));
		u2.add(new Item(3, 2));
		u2.add(new Item(6, 2));
	}
	
	//teste basico 
	@Test
	public void testMedia() {
		float m = 0;
		//Average a = new Average();
		m = Average.media(u1);
		assertEquals(2.5, m, 0);
	}

	//teste basico 
	@Test
	public void testMediaZero() {
		float m = 0;
		//Average a = new Average();
		m = Average.media(new ArrayList<Item>());
		assertEquals(0, m, 0);
	}
	
	
}

package br.ufrgs.recomendador.teste;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.ufrgs.recomendador.modulo.Item;
import br.ufrgs.recomendador.modulo.Person;

public class PersonTest {

	private List<Item> u1 = new ArrayList<Item>();
	private List<Item> u2 = new ArrayList<Item>();
	private List<Item> u3 = new ArrayList<Item>();
	private List<Item> u4 = new ArrayList<Item>();
	
	
	@Before
	public void init(){
		u1.add(new Item(1, 3));
		u1.add(new Item(2, 4));
		u1.add(new Item(3, 3));
		u1.add(new Item(4, 2));
				
		u2.add(new Item(1, 4));
		u2.add(new Item(2, 4));
		u2.add(new Item(3, 4));
		u2.add(new Item(4, 2));
		
		u3.add(new Item(1, 1));
		u3.add(new Item(2, 1));
		u3.add(new Item(3, 1));
		u3.add(new Item(4, 1));
				
		u4.add(new Item(1, 5));
		u4.add(new Item(2, 5));
		u4.add(new Item(3, 5));
		u4.add(new Item(4, 5));
		
		
		
	}
	
	
	@Test
	public void testCorrelation() {
		Person p = new Person(u1, u2);
		float corr = p.correlation();
		System.out.println(corr);
		assertEquals(0.816, corr, 0.01);
	}

	@Test
	public void testCorrelationEquals() {
		Person p = new Person(u1, u1);
		float corr = p.correlation();
		System.out.println(corr);
		assertEquals(1, corr, 0.01);
	}
	
	@Test
	public void testCorrelationOposite() {
		Person p = new Person(u3, u4);
		float corr = p.correlation();
		System.out.println(corr);
		assertEquals(0, corr, 0.01);
	}
	
}

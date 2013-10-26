package recomendador.teste;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import recomendador.modulo.Item;
import recomendador.modulo.Person;

public class PersonTest {

	private List<Item> u1 = new ArrayList<Item>();
	private List<Item> u2 = new ArrayList<Item>();
	private List<Item> u3 = new ArrayList<Item>();
	private List<Item> u4 = new ArrayList<Item>();
	private List<Item> u5 = new ArrayList<Item>();
	
	private List<Item> i = new ArrayList<Item>();
	private List<Item> a = new ArrayList<Item>();
	private List<Item> b = new ArrayList<Item>();
	private List<Item> c = new ArrayList<Item>();
	
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
		
		u5.add(new Item(1, 0));
		u5.add(new Item(2, 0));
		u5.add(new Item(3, 0));
		u5.add(new Item(4, 0));
		
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
	public void testCorrelation() {
		Person p = new Person(u1, u2);
		float corr = p.correlation();
		assertEquals(0.816, corr, 0.01);
	}

	@Test
	public void testCorrelationEquals() {
		Person p = new Person(u1, u1);
		float corr = p.correlation();
		assertEquals(1, corr, 0.01);
	}
	
	@Test
	public void testCorrelationOposite() {
		Person p = new Person(u3, u4);
		float corr = p.correlation();
		assertEquals(0, corr, 0.01);
	}
	
	@Test
	public void testCorrelationOrder() {
		Person p1 = new Person(u1, u2);
		Person p2 = new Person(u2, u1);
		float corr1 = p1.correlation();
		float corr2 = p2.correlation();
		assertEquals(corr1, corr2, 0.01);
	}
	
	@Test
	public void testCorrelationZero() {
		Person p1 = new Person(u5, u1);
		Person p2 = new Person(u5, u5);
		float corr1 = p1.correlation();
		float corr2 = p2.correlation();
		assertEquals(0, corr1, 0.01);
		assertEquals(0, corr2, 0.01);
	}
	
	
	@Test
	public void testGetCommon() {
		List<Item> r = new Person(u1,u2).getCommon(b, c);
		List<Item> s = new Person(u1,u2).getCommon(c, b);
		List<Item> k = new Person(u1,u2).getCommon(a, i);
		List<Item> l = new Person(u1,u2).getCommon(i, a);
		assertEquals(5, r.size());
		assertEquals(5, s.size());
		assertEquals(0, k.size());
		assertEquals(0, l.size());
	}
}
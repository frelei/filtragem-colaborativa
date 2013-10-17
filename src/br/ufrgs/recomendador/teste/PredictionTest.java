package br.ufrgs.recomendador.teste;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.ufrgs.recomendador.modulo.Item;
import br.ufrgs.recomendador.modulo.Prediction;
import br.ufrgs.recomendador.modulo.Predito;
import br.ufrgs.recomendador.modulo.User;

public class PredictionTest {

	private List<Item> l1 = new ArrayList<Item>();
	private List<Item> l2 = new ArrayList<Item>();
	private List<Item> l3 = new ArrayList<Item>();
	private List<Item> l4 = new ArrayList<Item>();
	private List<Item> l5 = new ArrayList<Item>();
	private List<User> lista = new ArrayList<User>();
	private User u1;
	private User u2;
	private User u3;
	private User u4;
	private User u5;
	
	
	@Before
	public void init(){
		l1.add(new Item(1, 3));
		l1.add(new Item(3, 4));
		l1.add(new Item(4, 3));
		l1.add(new Item(5, 2));
			
		l2.add(new Item(1, 4));
		l2.add(new Item(2, 5));
		l2.add(new Item(3, 4));
		l2.add(new Item(4, 4));
		l2.add(new Item(5, 2));
		
		l3.add(new Item(1, 2));
		l3.add(new Item(2, 1));
		l3.add(new Item(3, 5));
		l3.add(new Item(4, 5));
		l3.add(new Item(5, 3));
				
		l4.add(new Item(1, 4));
		l4.add(new Item(2, 5));
		l4.add(new Item(3, 3));
		l4.add(new Item(4, 3));
		l4.add(new Item(5, 3));
				
		l5.add(new Item(1, 1));
		l5.add(new Item(2, 3));
		l5.add(new Item(4, 2));
				
		u1 = new User(1, (float) 0.5, l1);
		u2 = new User(2, (float) 0.0, l2);
		u3 = new User(3, (float) 0.0, l3);
		u4 = new User(4, (float) 0.0, l4);
		u5 = new User(5, (float) 0.0, l5);
		
		lista.add(u1);
		lista.add(u2);
		lista.add(u3);
		lista.add(u4);
		lista.add(u5);
		
		u1.findSimilares(lista);
		u2.findSimilares(lista);
		u3.findSimilares(lista);
		u4.findSimilares(lista);
		u5.findSimilares(lista);
		
	}
	
	
	@Test
	public void testAverageUserItemsCommonWithAll() {
		float resp = Prediction.averageUserItemsCommonWithAll(u1);
		assertEquals(3, resp, 0.0);
	}

	@Test
	public void testAverageSimilarToUser() {
		float resp = Prediction.averageSimilarToUser(u1, u2);
		assertEquals(3.5, resp, 0.0);
	}

	@Test
	public void testFindItemToRecomendation() {
		Prediction p = new Prediction(u1);
		List<Predito> pre = p.findItemToRecomendation();
		assertEquals(1, pre.size());
		assertEquals(2.8, pre.get(0).getPrediction(), 0.1);
		
	}
	
	
}

package br.ufrgs.recomendador.teste;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.ufrgs.recomendador.modulo.Item;
import br.ufrgs.recomendador.modulo.User;

public class UserTest {

	private List<Item> u1 = new ArrayList<Item>();
	private List<Item> u2 = new ArrayList<Item>();
	private List<Item> u3 = new ArrayList<Item>();
	private List<Item> u4 = new ArrayList<Item>();
	private List<User> lista = new ArrayList<User>();
	private User user1;
	private User user2;
	private User user3;
	private User user4;
	
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
		
		u3.add(new Item(1, 5));
		u3.add(new Item(2, 1));
		u3.add(new Item(3, 3));
		u3.add(new Item(4, 1));
				
		u4.add(new Item(1, 5));
		u4.add(new Item(2, 5));
		u4.add(new Item(3, 4));
		u4.add(new Item(4, 3));

		user1 = new User(1, (float) 0.0, u1);
		user2 = new User(2, (float) 0.0, u2);
		user3 = new User(3, (float) 0.0, u3);
		user4 = new User(4, (float) 0.0, u4);
		
		lista.add(user1);
		lista.add(user2);
		lista.add(user3);
		lista.add(user4);
	}
	
	@Test
	public void testUser() {
		user1.findSimilares(lista);
		user2.findSimilares(lista);
		user3.findSimilares(lista);
		user4.findSimilares(lista);
		
		System.out.println(user1.getSimilares());
		System.out.println(user2.getSimilares());
		System.out.println(user3.getSimilares());
		System.out.println(user4.getSimilares());
		
	}

}

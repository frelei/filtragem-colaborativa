package br.ufrgs.recomendador.teste;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.ufrgs.recomendador.modulo.Filtragem;
import br.ufrgs.recomendador.modulo.Item;

public class FiltragemTest {

	private List<Item> u1 = new ArrayList<Item>();
	private List<Item> u2 = new ArrayList<Item>();
	
	
	@Before
	public void init(){
		u1.add(new Item(1, 1));
		u1.add(new Item(2, 1));
		u1.add(new Item(3, 1));
		u1.add(new Item(4, 1));
		
		u2.add(new Item(5, 2));
		u2.add(new Item(2, 2));
		u2.add(new Item(3, 2));
		u2.add(new Item(6, 2));
	}
	
	/**
	 * Deve retornar o mesmo tipo de elementos
	 */
	
	@Test
	public void testGetCommon() {
		Filtragem filtragem = new Filtragem(u1, u2, 0, 0);
		List<Item> a = filtragem.getCommon(u1, u2);
		List<Item> b = filtragem.getCommon(u2, u1);
		
		assertEquals(a.size(),b.size());
	}

}

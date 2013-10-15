package br.ufrgs.recomendador.modulo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Classe responsável por filtragem Colaborativa
 * @author rodrigo
 *
 */

public class Filtragem {

	private List<Item> u1;
	private List<Item> u2;
	private List<Item> commonU1;
	private List<Item> commonU2;
	private int similarity;
	private int prediction;
	
	public Filtragem(List<Item> u1, List<Item> u2, int similarity, int prediction){
		this.u1 = u1;
		this.u2 = u2;
		this.commonU1 = getCommon(u1, u2);
		this.commonU2 = getCommon(u2, u1);
		this.similarity = similarity;
		this.prediction = prediction;
	}
	
	public List<Item> getCommon(List<Item> u1, List<Item> u2){
		Set<Item> common1to2 = new HashSet<Item>(u1);
		common1to2.retainAll(u2);
		return new ArrayList<Item>(common1to2);
	}
	
	
	
}

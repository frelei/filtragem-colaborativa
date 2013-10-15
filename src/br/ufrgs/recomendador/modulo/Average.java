package br.ufrgs.recomendador.modulo;

import java.util.Collection;
import java.util.List;

public class Average {

	public List<Item> i1;
	public List<Item> i2;
	
	// construtores
	public Average(){}
	
	public Average(List<Item> i1, List<Item> i2){
		this.i1 = i1;
		this.i2 = i2;
	}
	
	// metodos
	public static float media(Collection<Item> item){
		float soma = 0;
		
		if(! item.isEmpty()){
			for (Item i : item) 
				soma += i.getAvaliacao();
			soma = soma / item.size();
		}
		
		return  soma;
	}
	
}

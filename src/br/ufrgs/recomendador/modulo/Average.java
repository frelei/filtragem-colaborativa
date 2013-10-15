package br.ufrgs.recomendador.modulo;

import java.util.Collection;

public class Average {

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

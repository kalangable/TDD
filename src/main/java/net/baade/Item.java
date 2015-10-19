package net.baade;

import lombok.Data;

@Data
public class Item {
	public Item( String descricao, Float valor ) {
		this.descricao = descricao;
		this.valor = valor;
	}
	private String descricao;
	private Float valor;

}

package net.baade.atendimento;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Item {
	public Item( String descricao, BigDecimal valor ) {
		this.descricao = descricao;
		this.valor = valor;
	}
	private String descricao;
	private BigDecimal valor;

}

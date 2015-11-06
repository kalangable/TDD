package net.baade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Recibo {
	private String nomeCliente;
	private String nomeAnimal;
	private BigDecimal valorAtendimento = new BigDecimal( 0 );
	@Setter( AccessLevel.PRIVATE )
	private List<Item> itens;

	public void listaItemAdd( Item item ) {
		if ( itens == null ) {
			itens = new ArrayList<Item>();
		}
		itens.add( item );
		this.valorAtendimento = this.valorAtendimento.add( item.getValor() );
	}
}

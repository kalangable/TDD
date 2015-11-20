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
	private Cliente cliente;
	private BigDecimal valorAtendimento = new BigDecimal( 0 );
	private FormaPagamento formaPagamento;
	@Setter( AccessLevel.PRIVATE )
	private List<Procedimento> itens;

	public void listaItemAdd( Procedimento item ) {
		if ( itens == null ) {
			itens = new ArrayList<Procedimento>();
		}
		itens.add( item );
		this.valorAtendimento = this.valorAtendimento.add( item.getValor() );
	}
}

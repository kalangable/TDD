package net.baade;

import java.math.BigDecimal;
import java.util.List;

public class Financeiro {
	public Boleto gerarFaturamento( List<Fatura> faturas ) {
		Boleto boleto = new Boleto();
		boleto.setCliente( faturas.get( 0 ).getCliente() );
		BigDecimal bd = new BigDecimal( 0 );

		for ( Fatura fatura : faturas ) {
			bd = bd.add( fatura.getValorFatura() );
		}

		boleto.setFaturas( faturas );
		boleto.setValorBoleto( bd );
		return boleto;

	}

}

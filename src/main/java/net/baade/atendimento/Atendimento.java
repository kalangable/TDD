package net.baade.atendimento;

import java.math.BigDecimal;

import net.baade.financas.Fatura;
import net.baade.financas.Recibo;

public class Atendimento {

	public Fatura encerrarAtendimento( Recibo recibo ) {

		Fatura fatura = new Fatura();
		fatura.setCliente( recibo.getCliente() );
		fatura.setProcedimentos( recibo.getItens() );
		BigDecimal bd = new BigDecimal( 0 );
		for ( Procedimento procedimento : recibo.getItens() ) {
			bd = bd.add( procedimento.getValor() );
		}
		fatura.setValorFatura( bd );
		return fatura;

	}

}

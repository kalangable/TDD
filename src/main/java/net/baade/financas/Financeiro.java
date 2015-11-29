package net.baade.financas;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import net.baade.Cliente;
import net.baade.Sociedade;
import net.baade.Socio;

public class Financeiro {

	public List<Boleto> gerarFaturamentoSociedade( final List<Fatura> faturas ) {
		List<Boleto> boletoSocios = new ArrayList<Boleto>();
		BigDecimal total = somaFaturas( faturas );
		Sociedade socios = (Sociedade)faturas.get( 0 ).getCliente();
		for ( Cliente socio : socios.getSocios() ) {
			Socio s = (Socio)socio;
			Boleto boleto = new Boleto();
			boleto.setCliente( s );
			boleto.setFaturas( faturas );
			boleto.setValorBoleto( calcularPercentualFatura( total, s.getParticipacao() ) );
			boletoSocios.add( boleto );
		}

		return boletoSocios;
	}

	private BigDecimal calcularPercentualFatura( BigDecimal valor, Double participacao ) {

		BigDecimal valorParticipacao = new BigDecimal( 0 );
		valorParticipacao = valor.multiply( new BigDecimal( participacao ) );
		return valorParticipacao.divide( new BigDecimal( 100.0 ) );

	}

	public Boleto gerarFaturamento( List<Fatura> faturas ) {
		Boleto boleto = new Boleto();
		boleto.setCliente( faturas.get( 0 ).getCliente() );
		boleto.setFaturas( faturas );
		boleto.setValorBoleto( somaFaturas( faturas ) );
		return boleto;

	}

	private BigDecimal somaFaturas( List<Fatura> faturas ) {
		BigDecimal bd = new BigDecimal( 0 );

		for ( Fatura fatura : faturas ) {
			bd = bd.add( fatura.getValorFatura() );
		}
		return bd;
	}

}

package net.baade;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class IntegratedTest {

	@Test
	public void PagamentoVacinacaoDinheiroFofo() {

		Recibo recibo = new Recibo();
		recibo.setNomeCliente( "Dave" );
		recibo.setNomeAnimal( "Fofo" );
		// recibo.setValorAtendimento( new Float( 13.0 ) );

		recibo.listaItemAdd( new Item( "Consulta de rotina", new BigDecimal( 10.0 ) ) );
		recibo.listaItemAdd( new Item( "Vacinação contra raiva", new BigDecimal( 3.0 ) ) );

		Assert.assertEquals( "Dave", recibo.getNomeCliente() );
		Assert.assertEquals( "Fofo", recibo.getNomeAnimal() );
		Assert.assertEquals( new Float( 13.0 ), recibo.getValorAtendimento() );
		Assert.assertEquals( "Consulta de rotina", recibo.getItens().get( 0 ).getDescricao() );
		Assert.assertEquals( "Vacinação contra raiva", recibo.getItens().get( 1 ).getDescricao() );

	}

}

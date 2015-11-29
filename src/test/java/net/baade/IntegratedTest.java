package net.baade;

import java.math.BigDecimal;

import net.baade.atendimento.Procedimento;
import net.baade.financas.Recibo;

import org.junit.Assert;
import org.junit.Test;

public class IntegratedTest {

	@Test
	public void PagamentoVacinacaoDinheiroFofo() {

		Recibo recibo = new Recibo();
		Cliente cliente = new Cliente();
		Animal animal = new Animal( "Fofo" );
		cliente.setNome( "Dave" );
		cliente.getAnimais().add( animal );
		recibo.setCliente( cliente );
		recibo.listaItemAdd( new Procedimento( "Consulta de rotina", new BigDecimal( 10.0 ) ) );
		recibo.listaItemAdd( new Procedimento( "Vacinação contra raiva", new BigDecimal( 3.0 ) ) );

		Assert.assertEquals( "Dave", recibo.getCliente().getNome() );
		Assert.assertTrue( recibo.getCliente().getAnimais().contains( new Animal( "Fofo" ) ) );
		Assert.assertEquals( new BigDecimal( 13.0 ), recibo.getValorAtendimento() );
		Assert.assertEquals( "Consulta de rotina", recibo.getItens().get( 0 ).getDescricao() );
		Assert.assertEquals( "Vacinação contra raiva", recibo.getItens().get( 1 ).getDescricao() );

	}

}

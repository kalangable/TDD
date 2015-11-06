package feature.net.baade;

import net.baade.Item;
import net.baade.Recibo;

import org.junit.Assert;

import cucumber.api.java8.En;

public class StepAtendimentoRotina implements En {

	Recibo recibo = new Recibo();

	public StepAtendimentoRotina() {
		Given( "^um cliente com nome \"([^\"]*)\" que tem um animal de nome \"([^\"]*)\"$", ( String arg1, String arg2 ) -> {
			recibo.setNomeCliente( arg1 );
			recibo.setNomeAnimal( arg2 );
		} );

		Given( "^(um outro|um) servico de \"([^\"]*)\" que custa ([^\"]*)$", ( String servico, String valor ) -> {
		} );

		Given( "^um servico de \"([^\"]*)\" que custa \"([^\"]*)\"$", ( String arg1, String arg2 ) -> {
			recibo.listaItemAdd( new Item( arg1, new Float( arg2 ) ) );
		} );

		Given( "^um outro servico de \"([^\"]*)\" que custa \"([^\"]*)\"$", ( String arg1, String arg2 ) -> {
			recibo.listaItemAdd( new Item( arg1, new Float( arg2 ) ) );
		} );

		When( "^o cliente pagar em \"([^\"]*)\"", ( String pagamento ) -> {
			Assert.assertTrue( pagamento.equals( "Dinheiro" ) );
		} );

		Then( "^o recibo deve ter (\\d+) servicos$", ( Integer servicos ) -> {
			Assert.assertEquals( new Integer( recibo.getItens().size() ), servicos );
		} );

		Then( "^o servico (\\d+) deve ser \"([^\"]*)\"$", ( Integer arg1, String arg2 ) -> {
			switch ( arg1 ) {
				case 1:
					Assert.assertEquals( arg2, "consulta de rotina" );
					break;

				default:
					Assert.assertEquals( arg2, "vacinacao contra raiva" );
					break;
			}
		} );

		Then( "^o valor total do recibo deve ser \"([^\"]*)\"$", ( String arg1 ) -> {

		} );

	}

	// @Given( "^um outro serviço de \"([^\"]*)\" que custa (\\d+),(\\d+)$" )
	// public void um_outro_servi_o_de_que_custa( String arg1, int arg2, int
	// arg3 ) throws Throwable {
	// // Write code here that turns the phrase above into concrete actions
	// throw new PendingException();
	// }
	//
	// @When( "^o cliente pagar em \"([^\"]*)\"$" )
	// public void o_cliente_pagar_em( String arg1 ) throws Throwable {
	// // Write code here that turns the phrase above into concrete actions
	// throw new PendingException();
	// }
	//
	// @Then( "^o recibo deve ter (\\d+) servicos$" )
	// public void o_recibo_deve_ter_servi_os( int arg1 ) throws Throwable {
	// // Write code here that turns the phrase above into concrete actions
	// throw new PendingException();
	// }
	//
	// @Then( "^o servi�o (\\d+) deve ser \"([^\"]*)\"$" )
	// public void o_servi_o_deve_ser( int arg1, String arg2 ) throws Throwable
	// {
	// // Write code here that turns the phrase above into concrete actions
	// throw new PendingException();
	// }
	//
	// @Given( "^+um serviço de '(.+)' que custa (\\f+)$" )
	// public void servico1( String servico, Float valor ) throws Throwable {
	// }
	//
	// @When( ".+o cliente pagar em '(.+)'" )
	// public void formaPagamento( String pagamento ) {
	// System.out.println( pagamento );
	//
	// }
	//
	// @Then( ".+o recibo deve ter .+ serviços" )
	// public void verificarQuantidade( final int position ) {
	// Assert.assertEquals( recibo.getItens().size(), 1 );
	// }

}

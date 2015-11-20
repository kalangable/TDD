package feature.net.baade;

import java.math.BigDecimal;

import lombok.val;
import net.baade.Animal;
import net.baade.Cliente;
import net.baade.Procedimento;
import net.baade.Recibo;

import org.junit.Assert;

import cucumber.api.java8.En;

public class StepAtendimentoRotina implements En {

	Recibo recibo = new Recibo();
	Cliente cliente = new Cliente();

	public StepAtendimentoRotina() {
		Given( "^um cliente com nome \"([^\"]*)\" que tem um animal de nome \"([^\"]*)\"$", ( String arg1, String arg2 ) -> {

			Animal fofo = new Animal( arg2 );
			cliente.setNome( arg1 );
			cliente.getAnimais().add( fofo );

		} );

		Given( "^(um outro|um) servico de \"([^\"]*)\" que custa ([^\"]*)$", ( String servico, String valor ) -> {
		} );

		Given( "^um servico de \"([^\"]*)\" que custa \"([^\"]*)\"$", ( String arg1, String arg2 ) -> {
			val valorItem = new BigDecimal( arg2 );
			recibo.listaItemAdd( new Procedimento( arg1, valorItem ) );
		} );

		Given( "^um outro servico de \"([^\"]*)\" que custa \"([^\"]*)\"$", ( String arg1, String arg2 ) -> {
			val valorItem = new BigDecimal( arg2 );
			recibo.listaItemAdd( new Procedimento( arg1, valorItem ) );
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
			val valorTotal = new BigDecimal( arg1 );
			Assert.assertEquals( recibo.getValorAtendimento(), valorTotal );
		} );

	}

}

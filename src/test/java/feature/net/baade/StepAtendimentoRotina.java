package feature.net.baade;

import java.math.BigDecimal;

import lombok.val;
import net.baade.Animal;
import net.baade.Cliente;
import net.baade.atendimento.Procedimento;
import net.baade.financas.Recibo;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepAtendimentoRotina {

	Recibo recibo = new Recibo();
	Cliente cliente = new Cliente();

	@Given( "^um cliente com nome \"([^\"]*)\" que tem um animal de nome \"([^\"]*)\"$" )
	public void um_cliente_com_nome_que_tem_um_animal_de_nome( String arg1, String arg2 ) throws Throwable {
		Animal fofo = new Animal( arg2 );
		cliente.setNome( arg1 );
		cliente.getAnimais().add( fofo );
	}

	@Given( "^um servico de \"([^\"]*)\" que custa \"([^\"]*)\"$" )
	public void um_servico_de_que_custa( String arg1, String arg2 ) throws Throwable {
		val valorItem = new BigDecimal( arg2 );
		recibo.listaItemAdd( new Procedimento( arg1, valorItem ) );
	}

	@Given( "^um outro servico de \"([^\"]*)\" que custa \"([^\"]*)\"$" )
	public void um_outro_servico_de_que_custa( String arg1, String arg2 ) throws Throwable {
		val valorItem = new BigDecimal( arg2 );
		recibo.listaItemAdd( new Procedimento( arg1, valorItem ) );
	}

	@When( "^o cliente pagar em \"([^\"]*)\"$" )
	public void o_cliente_pagar_em( String pagamento ) throws Throwable {
		Assert.assertTrue( pagamento.equals( "Dinheiro" ) );
	}

	@Then( "^o recibo deve ter (\\d+) servicos$" )
	public void o_recibo_deve_ter_servicos( Integer servicos ) throws Throwable {
		Assert.assertEquals( new Integer( recibo.getItens().size() ), servicos );
	}

	@Then( "^o servico (\\d+) deve ser \"([^\"]*)\"$" )
	public void o_servico_deve_ser( int arg1, String arg2 ) throws Throwable {
		switch ( arg1 ) {
			case 1:
				Assert.assertEquals( arg2, "consulta de rotina" );
				break;

			default:
				Assert.assertEquals( arg2, "vacinacao contra raiva" );
				break;
		}
	}

	@Then( "^o valor total do recibo deve ser \"([^\"]*)\"$" )
	public void o_valor_total_do_recibo_deve_ser( String arg1 ) throws Throwable {
		val valorTotal = new BigDecimal( arg1 );
		Assert.assertEquals( recibo.getValorAtendimento(), valorTotal );
	}

}

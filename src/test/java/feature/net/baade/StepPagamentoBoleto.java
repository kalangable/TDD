package feature.net.baade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import net.baade.Animal;
import net.baade.Atendimento;
import net.baade.Boleto;
import net.baade.Cliente;
import net.baade.Fatura;
import net.baade.Financeiro;
import net.baade.Medico;
import net.baade.Procedimento;
import net.baade.Recibo;

import org.junit.Assert;

import cucumber.api.java8.En;

public class StepPagamentoBoleto implements En {

	Cliente cliente = new Cliente();
	Recibo recibo = new Recibo();
	Fatura fatura = new Fatura();
	List<Fatura> listaFaturas = new ArrayList<Fatura>();

	public StepPagamentoBoleto() {
		Given( "^\"([^\"]*)\" traz seus dois gatos, \"([^\"]*)\" e \"([^\"]*)\", para serem castrados\\.$", ( String arg1, String arg2,
				String arg3 ) -> {
			cliente.setNome( arg1 );
			cliente.getAnimais().add( new Animal( arg2 ) );
			cliente.getAnimais().add( new Animal( arg3 ) );
			recibo.setCliente( cliente );

		} );

		Given( "^\"([^\"]*)\" realiza as \"([^\"]*)\" \\(que tem uma taxa normal\\)\\.$", ( String arg1, String arg2 ) -> {
			for ( Animal animal : recibo.getCliente().getAnimais() ) {
				recibo.listaItemAdd( new Procedimento( arg2, new BigDecimal( 13.8 ), new Medico( arg1 ) ) );
			}
		} );

		Given( "^\"([^\"]*)\" pega seus gatos naquela noite, mas deseja pagar pelo serviço ao final do mês\\.$", ( String arg1 ) -> {
			Cliente clienteTest = new Cliente();
			clienteTest.setNome( arg1 );

			Assert.assertEquals( recibo.getCliente().getNome(), clienteTest.getNome() );
		} );

		Then( "^Naquele dia, ela recebe uma única fatura com os procedimentos detalhadas\\.$", ( ) -> {
			Atendimento atendimento = new Atendimento();
			fatura = atendimento.encerrarAtendimento( recibo );

			listaFaturas.add( fatura );
			Assert.assertFalse( fatura.getValorFatura().equals( null ) );
		} );

		Then( "^No final do mês, ela recebe um boleto referente àquela conta, com o qual ela paga pelo serviço\\.$", ( ) -> {

			Financeiro finaceiro = new Financeiro();
			Boleto boleto = finaceiro.gerarFaturamento( listaFaturas );
			Assert.assertEquals( boleto.getValorBoleto(), fatura.getValorFatura() );

		} );
	}
}

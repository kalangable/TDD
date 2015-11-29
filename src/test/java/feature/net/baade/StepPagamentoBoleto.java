package feature.net.baade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import net.baade.Animal;
import net.baade.Cliente;
import net.baade.Medico;
import net.baade.atendimento.Atendimento;
import net.baade.atendimento.Procedimento;
import net.baade.financas.Boleto;
import net.baade.financas.Fatura;
import net.baade.financas.Financeiro;
import net.baade.financas.Recibo;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class StepPagamentoBoleto {
	Cliente cliente = new Cliente();
	Recibo recibo = new Recibo();
	Fatura fatura = new Fatura();
	List<Fatura> listaFaturas = new ArrayList<Fatura>();

	@Given( "^\"([^\"]*)\" traz seus dois gatos, \"([^\"]*)\" e \"([^\"]*)\", para serem castrados\\.$" )
	public void traz_seus_dois_gatos_e_para_serem_castrados( String arg1, String arg2, String arg3 ) throws Throwable {
		cliente.setNome( arg1 );
		cliente.getAnimais().add( new Animal( arg2 ) );
		cliente.getAnimais().add( new Animal( arg3 ) );
		recibo.setCliente( cliente );
	}

	@Given( "^\"([^\"]*)\" realiza as \"([^\"]*)\" \\(que tem uma taxa normal\\)\\.$" )
	public void realiza_as_que_tem_uma_taxa_normal( String arg1, String arg2 ) throws Throwable {
		for ( Animal animal : recibo.getCliente().getAnimais() ) {
			recibo.listaItemAdd( new Procedimento( arg2, new BigDecimal( 13.8 ), new Medico( arg1 ) ) );
		}
	}

	@Given( "^\"([^\"]*)\" pega seus gatos naquela noite, mas deseja pagar pelo serviço ao final do mês\\.$" )
	public void pega_seus_gatos_naquela_noite_mas_deseja_pagar_pelo_serviço_ao_final_do_mês( String arg1 ) throws Throwable {
		Cliente clienteTest = new Cliente();
		clienteTest.setNome( arg1 );

		Assert.assertEquals( recibo.getCliente().getNome(), clienteTest.getNome() );
	}

	@Then( "^Naquele dia, ela recebe uma única fatura com os procedimentos detalhadas\\.$" )
	public void naquele_dia_ela_recebe_uma_única_fatura_com_os_procedimentos_detalhadas() throws Throwable {
		Atendimento atendimento = new Atendimento();
		fatura = atendimento.encerrarAtendimento( recibo );

		listaFaturas.add( fatura );
		Assert.assertFalse( fatura.getValorFatura().equals( null ) );
	}

	@Then( "^No final do mês, ela recebe um boleto referente àquela conta, com o qual ela paga pelo serviço\\.$" )
	public void no_final_do_mês_ela_recebe_um_boleto_referente_àquela_conta_com_o_qual_ela_paga_pelo_serviço() throws Throwable {
		Financeiro finaceiro = new Financeiro();
		Boleto boleto = finaceiro.gerarFaturamento( listaFaturas );
		Assert.assertEquals( boleto.getValorBoleto(), fatura.getValorFatura() );
	}

}

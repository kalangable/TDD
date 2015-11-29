package feature.net.baade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import net.baade.Animal;
import net.baade.Cliente;
import net.baade.ClientesAuxiliares;
import net.baade.Medico;
import net.baade.Sociedade;
import net.baade.Socio;
import net.baade.atendimento.Atendimento;
import net.baade.atendimento.Procedimento;
import net.baade.financas.Boleto;
import net.baade.financas.Fatura;
import net.baade.financas.Financeiro;
import net.baade.financas.Recibo;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepCavaloClaudicante {

	Animal animal = new Animal();
	Sociedade sociedade = new Sociedade();

	Recibo recibo = new Recibo();
	Medico medico;

	List<Fatura> listaFatura = new ArrayList<Fatura>();

	@Given( "^um cavalo chamado \"([^\"]*)\"\\.$" )
	public void um_cavalo_chamado( String arg1 ) throws Throwable {
		animal.setApelido( arg1 );
	}

	@Given( "^possuido por:$" )
	public void possuido_por( List<Socio> socios ) throws Throwable {

		sociedade.getSocios().addAll( socios );
		recibo.setCliente( sociedade );

	}

	@Given( "^encaminhado pelo sócio \"([^\"]*)\"$" )
	public void encaminhado_pelo_sócio( String arg1 ) throws Throwable {
		Cliente responsavel = new Cliente();
		responsavel.setNome( arg1 );
		boolean possuiSocio = false;
		for ( Cliente socio : sociedade.getSocios() ) {
			if ( socio.getNome().equals( arg1 ) )
				possuiSocio = true;
		}
		Assert.assertTrue( possuiSocio );

		sociedade.setResponsavelEncaminhamento( responsavel );
	}

	@Given( "^apresentando sinais de \"([^\"]*)\"$" )
	public void apresentando_sinais_de( String arg1 ) throws Throwable {
		// Ficou estranho, mas não sei como testar esse cara!
		Assert.assertEquals( new String( "claudicação" ), arg1 );
	}

	@Given( "^atendido pelo \"([^\"]*)\"$" )
	public void atendido_pelo( String arg1 ) throws Throwable {
		medico = new Medico( arg1 );
	}

	@When( "^o \"([^\"]*)\" receita um \"([^\"]*)\", no valor de \"([^\"]*)\"\\.$" )
	public void o_receita_um_no_valor_de( String arg1, String arg2, String arg3 ) throws Throwable {
		Assert.assertEquals( arg1, medico.getNome() );
		Procedimento procedimento = new Procedimento( arg2, new BigDecimal( arg3 ) );

		recibo.listaItemAdd( procedimento );
	}

	@When( "^cobra \"([^\"]*)\" pela consulta$" )
	public void cobra_pela_consulta( String arg1 ) throws Throwable {
		Procedimento procedimento = new Procedimento( "Consulta", new BigDecimal( arg1 ) );

		recibo.listaItemAdd( procedimento );
	}

	@Then( "^o sócio \"([^\"]*)\" recebe o cavalo$" )
	public void o_sócio_recebe_o_cavalo( String arg1 ) throws Throwable {
		Cliente responsavel = new Cliente();
		responsavel.setNome( arg1 );
		Assert.assertEquals( responsavel.getNome(), sociedade.getResponsavelEncaminhamento().getNome() );
	}

	@Then( "^a fatura no total de \"([^\"]*)\"$" )
	public void a_fatura_no_total_de( String arg1 ) throws Throwable {
		BigDecimal valor = new BigDecimal( arg1 );
		Assert.assertEquals( valor, recibo.getValorAtendimento() );
		Atendimento atendimento = new Atendimento();
		Fatura fatura = atendimento.encerrarAtendimento( recibo );

		listaFatura.add( fatura );
		Assert.assertFalse( fatura.getValorFatura().equals( null ) );
	}

	@Then( "^descriminando os serviços$" )
	public void descriminando_os_serviços() throws Throwable {
		for ( Procedimento procedimento : recibo.getItens() ) {
			System.out.println( procedimento );
		}
	}

	@Then( "^cada socio recebe um bolte no final do mes$" )
	public void cada_socio_recebe_um_bolte_no_final_do_mes( List<ClientesAuxiliares> boletos ) throws Throwable {

		for ( ClientesAuxiliares boleto : boletos ) {
			System.out.println( boleto );
		}

		Financeiro financeiro = new Financeiro();
		List<Boleto> listaBoleto = financeiro.gerarFaturamentoSociedade( listaFatura );
		for ( Boleto boleto : listaBoleto ) {
			System.out.println( boleto );
		}
	}

}

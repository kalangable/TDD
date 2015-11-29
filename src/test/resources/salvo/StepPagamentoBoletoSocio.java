package feature.net.baade;

import java.util.List;

import net.baade.Animal;
import net.baade.Sociedade;
import net.baade.Socio;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java8.En;

public class StepPagamentoBoletoSocio implements En {

	Animal animal;
	Sociedade sociedade = new Sociedade();

	public StepPagamentoBoletoSocio() {
		Given( "^um cavalo chamado \"([^\"]*)\"\\.$", ( String arg1 ) -> {
			animal = new Animal();
			animal.setApelido( arg1 );
		} );

		And( "^possuido por:", ( List<Socio> arg1 ) -> {

			// arg1.forEach( ( chave, valor ) -> {
			// System.out.println( chave + " - " + valor );
			// } );

			// Write code here that turns the phrase above into concrete actions
			// For automatic transformation, change DataTable to one of
			// List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
			// E,K,V must be a scalar (String, Integer, Date, enum etc)
				throw new PendingException();
			} );

		Given( "^encaminhado pelo sócio \"([^\"]*)\"$", ( String arg1 ) -> {
			// Write code here that turns the phrase above into concrete actions
				throw new PendingException();
			} );

		Given( "^apresentando sinais de \"([^\"]*)\"$", ( String arg1 ) -> {
			// Write code here that turns the phrase above into concrete actions
				throw new PendingException();
			} );

		Given( "^atendido pelo \"([^\"]*)\"$", ( String arg1 ) -> {
			// Write code here that turns the phrase above into concrete actions
				throw new PendingException();
			} );

		When( "^o \"([^\"]*)\" receita um \"([^\"]*)\", no valor de \"([^\"]*)\"\\.$", ( String arg1, String arg2, String arg3 ) -> {
			// Write code here that turns the phrase above into concrete actions
				throw new PendingException();
			} );

		When( "^cobra \"([^\"]*)\" pela consulta$", ( String arg1 ) -> {
			// Write code here that turns the phrase above into concrete actions
				throw new PendingException();
			} );

		Then( "^o sócio \"([^\"]*)\" recebe o cavalo$", ( String arg1 ) -> {
			// Write code here that turns the phrase above into concrete actions
				throw new PendingException();
			} );

		Then( "^a fatura no total de \"([^\"]*)\"$", ( String arg1 ) -> {
			// Write code here that turns the phrase above into concrete actions
				throw new PendingException();
			} );

		Then( "^descriminando os serviços$", ( ) -> {
			// Write code here that turns the phrase above into concrete actions
				throw new PendingException();
			} );

		Then( "^cada socio recebe um bolte no final do mes$", ( DataTable arg1 ) -> {
			// Write code here that turns the phrase above into concrete actions
			// For automatic transformation, change DataTable to one of
			// List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
			// E,K,V must be a scalar (String, Integer, Date, enum etc)
				throw new PendingException();
			} );
	}
}

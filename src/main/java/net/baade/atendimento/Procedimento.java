package net.baade.atendimento;

import java.math.BigDecimal;

import net.baade.Medico;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Procedimento {

	public Procedimento( String descricao, BigDecimal valor ) {
		this.descricao = descricao;
		this.valor = valor;
	}

	private String descricao;
	private BigDecimal valor;
	private Medico medico;

}

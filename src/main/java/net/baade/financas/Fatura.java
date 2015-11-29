package net.baade.financas;

import java.math.BigDecimal;
import java.util.List;

import net.baade.Cliente;
import net.baade.atendimento.Procedimento;
import lombok.Data;

@Data
public class Fatura {

	private Cliente cliente;

	private List<Procedimento> procedimentos;

	private BigDecimal valorFatura;

}

package net.baade.financas;

import java.math.BigDecimal;
import java.util.List;

import net.baade.Cliente;
import lombok.Data;

@Data
public class Boleto {

	private Cliente cliente;

	private List<Fatura> faturas;

	private BigDecimal valorBoleto;

}

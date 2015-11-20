package net.baade;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class Boleto {

	private Cliente cliente;

	private List<Fatura> faturas;

	private BigDecimal valorBoleto;

}

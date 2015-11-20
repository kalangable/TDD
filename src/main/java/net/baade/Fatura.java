package net.baade;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class Fatura {

	private Cliente cliente;

	private List<Procedimento> procedimentos;

	private BigDecimal valorFatura;

}

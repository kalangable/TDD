package net.baade;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sociedade extends Cliente {

	private Set<Cliente> socios = new HashSet<>();
	private Cliente responsavelEncaminhamento;
}

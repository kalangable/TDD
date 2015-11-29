package net.baade;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Cliente{
	private String nome;
	private final List<Animal> animais = new ArrayList<Animal>();
}

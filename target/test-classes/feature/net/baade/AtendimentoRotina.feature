Feature: Atendimento Rotina
	To permitir o faturamento dos servicos prestados aos clientes
	
	Scenario: Consulta e vacina
	Given um cliente com nome "Dave Atkins" que tem um animal de nome "Fofo"
		And um servico de "consulta de rotina" que custa "10.22"
		And um outro servico de "vacinacao contra raiva" que custa "20.00"
	When o cliente pagar em "Dinheiro"
	Then o recibo deve ter 2 servicos
		And o servico 1 deve ser "consulta de rotina"
		And o servico 2 deve ser "vacinacao contra raiva"
		And o valor total do recibo deve ser "30.22"
		
		
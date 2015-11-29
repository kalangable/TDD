Feature: Exercicio Cavalo Claudicante
	To: Permitir faturar no final do mês, para cada um que é proprietário emitido um boleto com os dados consumidos e o custo pelo percenntual
	
	Scenario: Pagamento de Boleto para cada Sócio
		Given um cavalo chamado "Mensagem Polimórfica".
			And possuido por:
			|     nome      | participacao |
			| Grady Booch   |  30  |
			| Martin Fowler |  20  |
			| Ralph Johnson |  20  |
			| Erich gama    |  10  |
			| Brian Foote   |  20  |
			And encaminhado pelo sócio "Ralph Johnson"
			And apresentando sinais de "claudicação"
			And atendido pelo "Dr. Roberts" 
		When o "Dr. Roberts" receita um "analgesico", no valor de "12.00".
			And cobra "60.00" pela consulta
		Then o sócio "Ralph Johnson" recebe o cavalo
			And a fatura no total de "72.00"
			And descriminando os serviços
			And cada socio recebe um bolte no final do mes
				| cliente | valorBoleto |
				|Grady Booch| 21.60|
				|Martin Fowler|14.40|
				|Ralph Johnson|14.40|
				|Erich Gama|7.20|
				|Brian Foote|14.40|
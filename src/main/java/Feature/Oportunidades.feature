# language: pt
Funcionalidade: Acessar site CWI e verificar oportunidades de emprego

  Contexto: 
    Dado que estou no site da CWI

	 
  Cenario: Pesquisa no Site da CWI por vaga de emprego
    Quando acesso o menu oportunidades
    Entao verifico se a vaga esta disponivel
    |vaga                     |
    |Analista de Testes Sênior|
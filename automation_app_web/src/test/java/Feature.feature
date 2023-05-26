#language: pt

#Feature
Funcionalidade: Aprender Cumcumber
  Como um aluno
  Eu quero aprender a utilizar Cucumber
  Para que eu possa automazar criterios de aceitcao

# Scenario
#  Given When Then
  Cenario: Deve executar especificacao
    Dado que criei o arquivo corretamente
    Quando executar
    Entao a especificacao deve finalizar com sucesso

  Cenario: Deve incrementar contador
    Dado que o valor do contator é 15
    Quando eu incrementar em 3
    Entao o valor do contator sera 18

  Cenario: Deve incrementar contador
    Dado que o valor do contator é 123
    Quando eu incrementar em 35
    Entao o valor do contator sera 158

  Cenario: Deve calcular atraso na entrega
    Dado que o prazo e dia 05/04/2023
    Quando a entrega atrasar em 2 "dias"
    Entao a entrega sera efetuada em "07/04/2023"

  Cenario: Deve calcular atraso na entrega da China
    Dado que o prazo e dia 05/04/2023
    Quando a entrega atrasar em 2 "meses"
    Entao a entrega sera efetuada em "05/06/2023"

  Cenário: Deve criar steps genéricos para estes passos
    Dado que o ticket é "AF"345
    Dado que o valor da passagem é R$ 230,45
    Dado que o nome do passageiro é "Fulano da Silva"
    Dado que o telefone do passageiro é 9999-9999
    Quando criar os steps
    Então o teste vai funcionar

  Cenário: Deve reaproveitar os steps "Dado" do cenário anterior
    Dado que o ticket é "AB"167
#    Dado que o ticket especial é AB167
    Dado que o valor da passagem é R$ 1120,23
    Dado que o nome do passageiro é "Cicrano de Oliveira"
    Dado que o telefone do passageiro é 9888-8888

  Cenário: Deve negar todos os steps "Dado" dos cenários anteriores
    Dado que o ticket é "CD"123
    Dado que o ticket é "AG"1234
    Dado que o valor da passagem é R$ 1.1345,56
    Dado que o nome do passageiro é "Beltrano Souza Matos de Alcântara Azevedo"
    Dado que o telefone do passageiro é 1234-5678
    Dado que o telefone do passageiro é 999-2223
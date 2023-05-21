# 1º Trabalho Prático – Empresa de Telefonia Celular

## Introdução
Este trabalho consiste em implementar um sistema de cadastro de assinantes de uma empresa de telefonia celular, explorando os conceitos de orientação a objetos estudados até aqui. O sistema deve seguir o diagrama de classes UML mostrado abaixo:

## Descrição do Sistema
O sistema deverá ser baseado em um menu com as seguintes opções:
a) Cadastrar assinante: o sistema deverá solicitar o tipo de assinante, pré-pago ou pós-pago. Depois, solicitar os dados do assinante específico.
b) Listar assinantes: o sistema deverá listar os dados de todos os assinantes pré-pagos e pós-pagos cadastrados.
c) Fazer chamada: o sistema deverá solicitar o tipo de assinante e seu CPF. Depois, solicitar os dados da chamada, data e duração.
d) Fazer recarga: o sistema deverá solicitar o CPF de um assinante pré-pago. Depois, solicitar a data e o valor da recarga.
e) Imprimir faturas: o sistema deverá solicitar o mês e imprimir todas as faturas dos assinantes pré-pagos e pós-pagos.
f) Sair do programa: encerra a execução do programa.

## Descrição das Classes
A seguir serão descritas as classes do sistema:

### Assinante
A classe Assinante possui 3 atributos:
- cpf: CPF do assinante
- nome: nome completo do assinante
- numero: número do telefone celular do assinante

### PrePago
A classe PrePago possui 2 atributos:
- recargas: vetor de referências a objetos da classe Recarga, representa as recargas de crédito feitas pelo assinante
- creditos: representa o número de créditos do assinante

### PosPago
A classe PosPago possui 1 atributo:
- faturas: vetor de referências a objetos da classe Fatura, representa as faturas geradas para o assinante

### Chamada
A classe Chamada possui 2 atributos:
- data: data da realização da chamada (objeto da classe GregorianCalendar)
- duracao: duração da chamada em minutos

### Recarga
A classe Recarga possui 2 atributos:
- data: data da realização da recarga (objeto da classe GregorianCalendar)
- valor: valor em reais da recarga

### Telefonia
A classe Telefonia possui 2 atributos:
- prePagos: um vetor de referências a objetos do tipo PrePago. Representa os assinantes pré-pagos cadastrados pela empresa de telefonia celular.
- posPagos: um vetor de referências a objetos do tipo PosPago. Representa os assinantes pós-pagos cadastrados pela empresa de telefonia celular.

Cada classe possui construtores, métodos de acesso e outros métodos específicos para realizar as operações necessárias no sistema.

### Main
A classe Main é responsável por iniciar o programa, instanciar um objeto da classe Telefonia e interagir com o usuário através do menu, invocando os métodos apropriados de acordo com a seleção do usuário.

## Execução do Programa
Para executar o programa, é necessário criar as classes mencionadas acima e implementar seus métodos de acordo com as especificações descritas. A classe Main será responsável por iniciar o programa e interagir com o usuário.

Após a implementação, basta compilar e executar a classe Main para iniciar o programa e utilizar as funcionalidades do sistema.


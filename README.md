# ACMERescue
Terceiro trabalho avaliativo da disciplina de Porgramação Orientada a Objetos, ministrada pelo professor Marcelo H. Yamaguti.

Apoios a desastres
1. Enunciado geral:
A ACMERescue é uma empresa que oferece serviços de atendimento a desastres naturais
em eventos como ciclones, terremotos e secas. Para os atendimentos a empresa possui várias
equipes e equipamentos distribuídos pelo mundo
Esta empresa deseja que seja desenvolvido um sistema para gerenciar suas equipes,
equipamentos e atendimentos a eventos.
O analista de sistemas definiu as seguintes classes iniciais:

Na definição do sistema o analista também identificou as seguintes características:

• Todo evento possui um código único, uma data e uma localização (latitude e longitude).

• Um evento pode ser:
o Ciclone que possui a velocidade do vento e precipitação da chuva.
o Terremoto que possui a magnitude na escala Richter.
o Seca que possui o número de dias de estiagem.

• Uma equipe possui um codinome único, uma quantidade de membros e a sua localização
(latitude e longitude). Uma equipe pode ter vários equipamentos. Uma equipe só consegue
atender eventos até 5.000 quilômetros de distância.

• Um equipamento possui um identificador único, um nome e o valor de custo por dia.

• Um equipamento pode ser:
o Barco que possui a quantidade de pessoas que pode transportar.
o Caminhão tanque que possui a capacidade, em milhares de litros, de água.
o Escavadeira que possui o combustível (DIESEL, GASOLINA, ALCOOL) e a carga
(em m3) que pode deslocar.

• Cada atendimento possui um código único, uma data de início e uma duração (em dias).
Um atendimento possui um evento e pode ter uma equipe alocada.
o Um atendimento pode estar em um dos estados (status): PENDENTE,
EXECUTANDO, FINALIZADO, CANCELADO. Quando um atendimento é criado
fica no estado PENDENTE, quando há uma equipe é alocada fica no estado
EXECUTANDO, quando o atendimento termina fica no estado FINALIZADO. A
qualquer momento atendimento pode ser CANCELADO.

• O cálculo do custo de um atendimento é realizado da seguinte forma:
custo = custo da equipe + custo dos equipamentos + custo de deslocamento

• O custo da equipe é:
duração x 250 x número de membros de equipe

• O custo dos equipamentos é:
duração x somatório do custo diário dos equipamentos da equipe

• Finalmente, o custo de deslocamento é:
distância de deslocamento da equipe para o evento x (100 x número de pessoas da equipe + 10% do somatório do custo diário dos equipamentos da equipe)

A ACMERescue deseja automatizar o seu negócio e quer que o sistema tenha uma tela cíclica
com o usuário para as seguintes funcionalidades:

• Cadastrar novo evento (solicita e cadastra os dados de um evento. [Se já houver
evento com o código indicado, mostra uma mensagem de erro]. Os eventos são
mantidos em ordem crescente de código).

• Cadastrar nova equipe (solicita e cadastra os dados de uma equipe [se o codinome
já existir, mostra uma mensagem de erro]. As equipes são mantidas em ordem
crescente de codinome).

• Cadastrar novo equipamento (solicita e cadastra os dados de um equipamento [se já
houver equipamento com o identificador indicado mostra uma mensagem de erro]. Os
equipamentos são mantidos em ordem crescente de identificador).

• Cadastrar novo atendimento (mostra os eventos cadastrados para o usuário. O
usuário seleciona um evento, e o sistema solicita e cadastra os dados de um novo
atendimento do evento selecionado, mas sem equipe [se o código já existir ou se o
evento já tiver um atendimento cadastrado, mostra uma mensagem de erro]. O novo
atendimento é colocado em uma fila de atendimentos pendentes).

• Mostrar relatório geral (mostra todos os dados de todos os eventos, equipamentos,
equipes e atendimentos cadastrados [se não há nenhum dado cadastrado, mostra uma
mensagem de erro]).

• Vincular equipamento a equipe (mostra os equipamentos e equipes cadastradas
para o usuário. O usuário seleciona o equipamento e a equipe para vincular e confirma
o vínculo [se o equipamento já estiver vinculado a outra equipe, mostra uma mensagem
de erro]).

• Alocar atendimentos (a partir da fila de atendimentos pendentes; o sistema fará a
alocação automática de um atendimento a uma equipe. Verifica se é possível designar
alguma equipe disponível para cada atendimento, e atualiza o seu estado. Se há
alguma equipe dentro da distância máxima, mas já está alocada para outro
atendimento, o atendimento retorna para a fila de atendimentos pendentes. Se não há
nenhuma equipe dentro da distância máxima para fazer o atendimento, o atendimento
muda para a situação CANCELADO [se não há atendimentos na fila de atendimentos
pendentes, mostra uma mensagem de erro]).

• Consultar todos os atendimentos (mostra todos os atendimentos cadastrados: todos
os dados dos atendimentos, incluindo os dados do evento; se o atendimento possui
uma equipe alocada, mostra os dados da equipe e seus equipamentos e o valor do
custo [se não há atendimentos, mostra uma mensagem de erro]).

• Alterar a situação de um atendimento (solicita o código de um atendimento; mostra
os dados do atendimento; solicita a nova situação [se não há atendimento com o código
indicado, mostra uma mensagem de erro; se o atendimento estiver na situação
FINALIZADO, não pode ser alterado e mostra uma mensagem de erro]).

• Carregar dados iniciais (solicita o nome do arquivo (sem extensão); carrega os dados
dos arquivos para o sistema; os atendimentos devem ser carregados em uma fila de
atendimentos pendentes; ao final da carga de dados iniciais, mostra todos os dados de
eventos, equipamentos, equipes e atendimentos cadastrados [se houver problemas na
carga de dados, mostra uma mensagem de erro]). Veja o Apêndice sobre os formatos
dos arquivos de entrada.

• Salvar dados (solicita ao usuário um nome de arquivo (sem extensão) e salva todos
os dados cadastrados em um ou mais arquivos [se houver algum problema no
salvamento mostra uma mensagem de erro]).

• Carregar dados (solicita ao usuário um nome de arquivo (sem extensão) e carrega
todos os dados de um ou mais arquivos [se houver algum problema no carregamento
mostra uma mensagem de erro]).

• Finalizar sistema (termina a execução do sistema).

2. Definição do trabalho:
O objetivo do trabalho é implementar um sistema de gerenciamento de eventos, equipes,
equipamentos e atendimentos, capaz de atender as necessidades da empresa descrita no
enunciado geral, e que atenda as restrições que seguem:

• É permitida a criação de novas classes, métodos, atributos e relacionamentos, mas as
informações definidas no diagrama de classes original não podem ser removidas.

• Deve haver tratamento de exceções para que não haja interrupção da execução.

• Deve utilizar coleções da API Java ( exceto array [ ] ) para o armazenamento de objetos.

• Todos os atributos devem ser privados (private).

• Nenhum atributo ou método pode ser de classe (static).

• Deve possuir interface gráfica para interação com o usuário.

• Deve ser entregue um relatório do projeto contendo os seguintes capítulos:

1. Diagrama de classes – diagrama com as classes do projeto do sistema ou indicação
do nome do arquivo que possui o diagrama de classes;

2. Coleções de dados – descrição de coleções (listas, filas, pilhas, etc.) que foram
utilizadas e em que partes do sistema;

3. Armazenamento (persistência) de dados – descrição da forma escolhida de
armazenamento de dados em arquivos texto (CSV, JSON, XML, etc.) ou serialização.

3. Critérios de avaliação:
• O trabalho será avaliado conforme os seguintes critérios:
o Nota do Trabalho = 10% apresentação + 90% implementação
o A implementação envolve:
§ Relatório do projeto: 1 ponto.
§ Persistência de dados em arquivos: 1 ponto.
§ Tratamento de exceções: 1 ponto.
§ Interface gráfica com o usuário: 1 ponto.
§ Uso de herança, polimorfismo e coleções: 1 ponto.
§ Implementação e execução do sistema conforme a descrição: 5 pontos.
• Ponto extra (opcional): será atribuído 1 (um) ponto extra, considerando o valor máximo
total de 10 (dez) pontos na avaliação, se o sistema ler e gravar os dados em arquivotexto no formato JSON ou XML.

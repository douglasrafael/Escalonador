# Projeto: Algoritmos de Escalonamento de CPU

Neste projeto você deve implementar um conjunto de algoritmos de escalonamento de CPU e escrever um programa que calcula uma série de estatísticas baseado nestes algoritmos.

Os algoritmos de escalonamento a serem implementados são os seguintes:

- FCFS: First-Come, First-Served
- SJF: Shortest Job First
- RR: Round Robin (com quantum = 2)

O seu programa deverá ler da entrada padrão uma lista de processos com seus respectivos tempos de chegada e de duração e deverá imprimir na saída padrão uma tabela contendo os valores para as seguintes métricas:

- Tempo de retorno médio
- Tempo de resposta médio
- Tempo de espera médio
- Descrição da entrada:

A entrada é composta por uma série de pares de números inteiros separados por um espaço em branco indicando o **tempo de chegada** e a **duração de cada processo**. A entrada termina com o fim do arquivo.

#####Exemplo de entrada 1:
```
0 20
0 10
4 6
4 8
```

###Descrição da saída:
A saída é composta por linhas contendo a sigla de cada um dos três algoritmos e os valores das três métricas solicitadas .

Cada linha apresenta a sigla do algoritmo e os valores médios (com uma casa decimal) para ***tempo de retorno,  tempo de resposta e tempo de espera***, exatamente nesta ordem, separados por um espaço em branco.

#####Exemplo de saída 1 :
```
FCFS 30,5 19,5 19,5
SJF 21,5 10,5 10,5
RR 31,5 2,0 20,5
```

Para facilitar a depuração, apresento a seguir a ordem de execução dos processos do exemplo 1 para cada um dos algoritmos:

######FCFS:
```
Rodar processo [0] de [0] ate [20]
Rodar processo [1] de [20] ate [30]
Rodar processo [2] de [30] ate [36]
Rodar processo [3] de [36] ate [44]
```

######SJF:
```
Rodar processo [1] de [0] ate [10]
Rodar processo [2] de [10] ate [16]
Rodar processo [3] de [16] ate [24]
Rodar processo [0] de [24] ate [44]
```

######RR:
```
Rodar processo [0] de [0] ate [2]
Rodar processo [1] de [2] ate [4]
Rodar processo [0] de [4] ate [6]
Rodar processo [2] de [6] ate [8]
Rodar processo [3] de [8] ate [10]
Rodar processo [1] de [10] ate [12]
Rodar processo [0] de [12] ate [14]
Rodar processo [2] de [14] ate [16]
Rodar processo [3] de [16] ate [18]
Rodar processo [1] de [18] ate [20]
Rodar processo [0] de [20] ate [22]
Rodar processo [2] de [22] ate [24]
Rodar processo [3] de [24] ate [26]
Rodar processo [1] de [26] ate [28]
Rodar processo [0] de [28] ate [30]
Rodar processo [3] de [30] ate [32]
Rodar processo [1] de [32] ate [34]
Rodar processo [0] de [34] ate [36]
Rodar processo [0] de [36] ate [38]
Rodar processo [0] de [38] ate [40]
Rodar processo [0] de [40] ate [42]
Rodar processo [0] de [42] ate [44]
```

#####Exemplo de entrada 2:
```
2 20
2 10
4 6
4 8
```

#####Exemplo de saída 2:
```
FCFS 31,5 20,5 20,5
SJF 22,5 11,5 11,5
RR 31,5 2,0 20,5
```

####Exemplo de entrada 3:
```
0 20
1 10
4 6
4 8
5 10
5 5
6 100
7 10
8 2
9 2
10 2
```

#####Exemplo de saída 3:
```
FCFS 93,7 77,8 77,8
SJF 46,9 31,0 31,0
RR 60,4 8,6 44,5
```

License
-----
MIT

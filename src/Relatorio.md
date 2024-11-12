# Relatório de Projeto - LIB UNCLE PRESSER - Compressão de Dados Gênicos


**Grupo:** Elite Jobs  
**Integrantes:**
- Anna Yagyu - RM550360
- Breno Silva - RM99275
- Danilo Urze - RM99465
- Pedro Henrique - RM550689

**Projeto:** Compressão de Dados Gênicos usando Run-Length Encoding (RLE)  
**Curso:** FIAP - Engenharia de Software

**Data de Entrega:** `[Data Atual]`

---

## 1. Objetivo do Projeto

O objetivo deste projeto é desenvolver uma aplicação para compressão de dados gênicos utilizando o algoritmo de codificação Run-Length Encoding (RLE). Este projeto visa reduzir o espaço de armazenamento necessário para sequências de nucleotídeos representadas em arquivos de texto. A compressão de dados é essencial em bioinformática devido ao grande volume de dados gerados, possibilitando economia de espaço e eficiência em transmissão.

## 2. Estrutura do Projeto

O projeto segue a estrutura do Maven, conforme as instruções. A aplicação principal é desenvolvida na classe `App.java`, localizada no diretório `src/main/java/br/com/fiap/twoespwx/libunclepresser`. A estrutura permite escalabilidade, mantendo a implementação de testes no diretório `src/test/java/br/com/fiap/twoespwx/libunclepresser` para garantir a correta funcionalidade da aplicação.


## 3. Implementação e Funcionamento

A implementação da aplicação foi realizada na classe `App.java`. Esta classe executa as seguintes etapas:
- **Leitura de Arquivo de Entrada:** Carrega a sequência de nucleotídeos do arquivo `input1.txt`.
- **Compressão com Run-Length Encoding (RLE):** Converte sequências repetitivas de caracteres (nucleotídeos) em uma notação compacta.
- **Escrita no Arquivo de Saída:** Gera o arquivo `OUTPUT1.TXT` contendo a sequência compactada.

### Algoritmo Run-Length Encoding (RLE)
O algoritmo RLE identifica sequências de caracteres repetidos e as substitui pelo caractere seguido do número de repetições. Exemplo:
- **Entrada:** `AAACCCGGG`
- **Saída:** `A3C3G3`

### Interface Textual

A interface textual exibe informações sobre o arquivo processado e o algoritmo utilizado. Exemplo:

 -----------------------------------------------------------
           LIB UNCLE PRESSER - GRUPO Nexos                
-----------------------------------------------------------
INPUT FILENAME: input1.txt
OUTPUT FILENAME: OUTPUT1.TXT

INPUT FILE SIZE: 1320 characters

FREQUENCIES:                                              
A: 924 (70,00%)                                        
C: 132 (10,00%)                                        
T: 132 (10,00%)                                        
G: 132 (10,00%)

ALGORITHM: Run-Length Encoding (RLE)                      
TEXT-CODIFICATION: UTF-8                                  
COMPRESSION RATE: 98,79%

OUTPUT FILE SIZE: 16 characters
-----------------------------------------------------------

SCORE: WELL-DONE
                                                           
-----------------------------------------------------------


## 4. Testes

Foram realizados testes unitários com a classe `AppTest.java` para verificar a funcionalidade do algoritmo RLE, utilizando entradas variadas para garantir a consistência dos resultados. O teste avalia a compressão correta de sequências e valida o conteúdo do arquivo de saída.

## 5. Resultados

A aplicação cumpriu os requisitos de compressão, produzindo saídas compactadas e mantendo a integridade dos dados. O algoritmo mostrou-se eficiente para compressão de dados gênicos com repetições.


## 6. Conclusão

O projeto alcançou os objetivos propostos, com uma compressão significativa de dados gênicos. A implementação seguiu práticas recomendadas de organização de código e estrutura de projeto. A aplicação está pronta para futuras melhorias, incluindo algoritmos de compressão mais avançados.

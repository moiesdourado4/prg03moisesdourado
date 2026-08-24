# Documento de Especificação de Requisitos
**Projeto:** App de Informações de Transporte: Linha Barra do Mendes - Irecê

**Data de Criação:** 21/08/2026

**Autor:** Moisés Dourado

**Cargo:** 

**Revisão:** 01

## 1 Introdução
O aplicativo de Informações de Transporte tem como finalidade digitalizar e organizar o acesso aos dados de mobilidade da rota intermunicipal específica que liga Barra do Mendes a Irecê (passando por Ibipeba e Ibititá). O sistema permitirá que a população consulte horários, itinerários nos dois sentidos (ida e volta) e o status da operação.

**Público-alvo:** Usuários frequentes do transporte intermunicipal (trabalhadores, estudantes e pacientes) que se deslocam diariamente entre essas quatro cidades, além de moradores de Ibititá que usam a rota como trajeto intermediário.

### 1.1 Objetivo
Este documento tem como objetivo apresentar de forma detalhada os requisitos funcionais, não funcionais e casos de uso do aplicativo. Ele servirá como guia para o desenvolvimento do software, descrevendo as funcionalidades e interações que serão abordadas na implementação.

### 1.2 Escopo do produto
O escopo deste documento abrange as funcionalidades do aplicativo de consulta de rotas e horários para a linha "Barra do Mendes ↔ Irecê", o recebimento de notificações sobre atrasos, a gestão dessas informações pelo administrador e a possibilidade de o próprio usuário colaborar reportando problemas na viagem.

### 1.3 Definições, Acrônimos e Abreviações
| № | Sigla | Definição |
| :--- | :--- | :--- |
| 01 | RF | Requisito Funcional |
| 02 | RNF | Requisito Não Funcional |
| 03 | UML | Unified Modeling Language (Linguagem de Modelagem Unificada) |
| 04 | ODS | Objetivos de Desenvolvimento Sustentável |

## 2 Descrição geral
### 2.1 Modo de Operação
O sistema opera como um aplicativo mobile/web voltado para a digitalização do acesso à informação do transporte rodoviário dessa rota específica, centralizando os horários oficiais e os avisos operacionais em uma única plataforma interativa.

### 2.2 Funções do produto
| № | Função | Descrição |
| :--- | :--- | :--- |
| 01 | Atualizar Horários | O administrador pode cadastrar e editar os horários oficiais da rota. |
| 02 | Consultar Horários | O cidadão pode buscar os horários de saída e previsão de passagem nas paradas intermediárias (ida e volta). |
| 03 | Emitir Alertas | O sistema notifica o usuário sobre cancelamentos ou atrasos operacionais. |
| 04 | Reportar Problemas | O cidadão envia um reporte rápido caso o ônibus atrase ou atinja a lotação máxima. |

### 2.3 Usuários e sistemas externos
| № | Usuário | Descrição |
| :--- | :--- | :--- |
| 01 | Administrador | Responsável por atualizar as bases de horários oficiais da linha e publicar os alertas gerais. |
| 02 | Cidadão (Passageiro) | Pessoa que utiliza a rota, consulta os horários e envia reportes colaborativos sobre o status da viagem. |

### 2.4 Restrições
| № | Tipo | Descrição |
| :--- | :--- | :--- |
| 01 | Software | O aplicativo deve rodar em dispositivos móveis focando em baixo consumo de dados de internet. |
| 02 | Hardware | O dispositivo do usuário deve ter acesso à internet para receber dados atualizados da rota. |
| 03 | Segurança | O acesso à área de publicação de avisos oficiais deve ser restrito ao perfil Administrador através de login individual. |

### 2.5 Requisitos Adiados
| № | Referência | Detalhes |
| :--- | :--- | :--- |
| 01 | Compra de Passagens | A funcionalidade de reservar ou pagar passagens pelo aplicativo será desenvolvida em uma versão futura. |
| 02 | Rastreamento via GPS | A exibição do ônibus se movendo no mapa em tempo real via GPS foi adiada para integração posterior. |

## 3 Requisitos específicos
### 3.1 Requisitos Funcionais
| Código | Nome | Descrição |
| :--- | :--- | :--- |
| RF01 | Cadastro de Linhas | O administrador deve ser capaz de cadastrar os horários de saída e as previsões de chegada para as cidades da rota. |
| RF02 | Consulta de Sentido e Paradas | O sistema deve permitir que o passageiro selecione o sentido da viagem e a sua cidade de embarque (Barra do Mendes, Ibipeba, Ibititá ou Irecê) para visualizar a previsão de passagem. |
| RF03 | Painel de Avisos | O administrador pode publicar avisos gerais (ex: "Ônibus em manutenção") que serão exibidos na tela inicial do app. |
| RF04 | Canal de Reporte | O cidadão deve ter acesso a um botão para reportar o status atual da viagem (ex: Lotação máxima, Atrasado). |

### 3.2 Casos de Uso (Modelagem UML)
Abaixo estão detalhados os principais casos de uso que mapeiam a interação entre os atores (Cidadão e Administrador) e o sistema.

#### Caso de Uso 01: Consultar Horários da Rota
* **Ator Principal:** Cidadão (Passageiro)
* **Pré-condição:** Cidadão com o aplicativo aberto e conexão com a internet.
* **Fluxo Principal:**
  1. O cidadão seleciona o sentido da viagem (ex: Barra do Mendes → Irecê ou o inverso).
  2. O cidadão escolhe a sua cidade de embarque (Barra do Mendes, Ibipeba, Ibititá ou Irecê).
  3. O sistema processa e exibe a lista atualizada de horários de saída e previsão de passagem na parada selecionada.
* **Pós-condição:** Informação de horário exibida com sucesso na tela do usuário.
* **Relações:** `<<include>> Selecionar Sentido` e `<<include>> Selecionar Parada`

#### Caso de Uso 02: Reportar Problema Operacional
* **Ator Principal:** Cidadão (Passageiro)
* **Pré-condição:** Cidadão autenticado no aplicativo.
* **Fluxo Principal:**
  1. O cidadão clica no botão de reporte na tela principal.
  2. O cidadão seleciona o tipo de ocorrência (ex: Ônibus atrasado, Lotação máxima, Linha cancelada).
  3. O sistema registra o reporte e notifica de forma agregada os demais usuários da linha.
* **Fluxo Alternativo:** Se o usuário estiver sem internet, o sistema armazena o reporte localmente e envia assim que a conexão for restabelecida (`<<extend>>`).
* **Pós-condição:** Ocorrência registrada na base de dados colaborativa.

#### Caso de Uso 03: Gerenciar Horários da Linha
* **Ator Principal:** Administrador
* **Pré-condição:** Administrador autenticado no painel de gestão.
* **Fluxo Principal:**
  1. O administrador acessa o painel restrito.
  2. O administrador insere ou edita os horários oficiais da linha intermunicipal.
  3. O sistema valida os dados e atualiza a grade horária disponível para os cidadãos.
* **Pós-condição:** Grade horária atualizada em tempo real para todos os usuários.

### 3.3 Requisitos Não-Funcionais
#### 3.3.1 Desempenho
| Código | Requisito / Aplicação | Descrição |
| :--- | :--- | :--- |
| RNF01 | Aplicação | O aplicativo deve apresentar tempos de resposta rápidos para a consulta de horários, mesmo em conexões móveis lentas (3G). |

#### 3.3.2 Usabilidade
| Código | Requisito / Aplicação | Descrição |
| :--- | :--- | :--- |
| RNF02 | Design intuitivo | A interface deve ir direto ao ponto, exibindo a busca de horários logo na tela inicial, com fontes de alto contraste para leitura em ambientes externos. |

#### 3.3.3 Segurança
| Código | Requisito / Aplicação | Descrição |
| :--- | :--- | :--- |
| RNF03 | Autenticação segura | A autenticação segura deve ser implementada para acesso ao painel do Administrador. |

#### 3.3.4 Expansibilidade
| Código | Requisito / Aplicação | Descrição |
| :--- | :--- | :--- |
| RNF04 | Arquitetura Modular | O sistema deve ser desenvolvido de forma modular (em Java) para permitir a futura expansão para outras linhas da região do Território de Irecê. |

### 3.4 Requisitos de Interface
#### 3.4.1 Interfaces de Usuário
| № | Nome | Descrição |
| :--- | :--- | :--- |
| 01 | Tela Inicial de Busca | Interface onde o cidadão seleciona o sentido da rota e a parada para ver o horário. |
| 02 | Painel do Administrador | Interface online para o administrador gerenciar horários e emitir avisos. |
| 03 | Tela de Reporte | Formulário simplificado para o cidadão reportar o status do ônibus. |

#### 3.4.2 Interfaces de Hardware
Não aplicável de forma direta no escopo atual (dependência apenas de conexão à rede móvel/Wi-Fi do aparelho celular).

#### 3.4.3 Interfaces de Software
O sistema não exige integrações complexas com softwares terceiros nesta fase inicial.

#### 3.4.4 Interfaces de Comunicação
O aplicativo deverá utilizar mecanismos simples de comunicação HTTP (requisições web) para buscar os horários atualizados do banco de dados na nuvem.

## 4 Restrições e Limitações
* A precisão das previsões de chegada depende das condições de trânsito e da rodovia BA-148, podendo haver variações não refletidas imediatamente no sistema (já que não há rastreamento GPS ativo na versão inicial).
* O funcionamento do envio de reportes pelo cidadão está limitado à disponibilidade de sinal de internet nas áreas rurais entre as cidades da rota.

## 5 Glossário
| Termo | Definição |
| :--- | :--- |
| Sentido da Viagem | Direção em que o ônibus está indo (ex: Rumo a Irecê ou Rumo a Barra do Mendes). |
| Parada Intermediária | Cidades que estão no trajeto entre a origem e o destino final da linha (ex: Ibipeba e Ibititá). |
| Reporte Colaborativo | Informação gerada e enviada pelos próprios passageiros sobre a situação da viagem. |

## 6 Referências
* ONU. Agenda 2030 — Objetivos de Desenvolvimento Sustentável. ODS 11 (Tornar as cidades inclusivas, seguras, resilientes e sustentáveis).

## 7 Aprovação
Este documento foi revisado e aprovado por:

Nome:_____________________________

Cargo:____________________________

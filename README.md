# Sistema de Clínica Médica

Sistema de agendamento de consultas médicas desenvolvido em Java para prática de conceitos de Orientação a Objetos e Design Patterns.

## Estrutura do Projeto

```
clinica/
├── Clinica.java                  (main)
├── model/
│   ├── Pessoa.java               (classe abstrata)
│   ├── Paciente.java
│   ├── Medico.java
│   ├── Consulta.java
│   └── Especialidade.java        (enum)
├── pricing/
│   ├── DescontoStrategy.java     (interface)
│   ├── DescontoConvenio.java     (30% de desconto)
│   └── SemDesconto.java          (valor integral)
└── service/
    └── Agenda.java               (singleton)
```

## Funcionalidades

- Cadastro de médicos com especialidade (Cardiologia, Dermatologia, Ortopedia, Clínico Geral)
- Cadastro de pacientes com ou sem convênio
- Agendamento de consultas com validação de conflito de horário
- Cancelamento de consultas
- Listagem de consultas por médico ou por paciente
- Cálculo automático de desconto para pacientes conveniados

## Conceitos Aplicados

### Orientação a Objetos

| Conceito | Onde |
|---|---|
| Classe abstrata | `Pessoa` |
| Herança | `Paciente` e `Medico` estendem `Pessoa` |
| Polimorfismo | `exibirDados()` com comportamento diferente em cada subclasse |
| Encapsulamento | Atributos `private` com acesso via getters e construtores |
| Composição | `Consulta` composta por `Medico` e `Paciente` |
| Interface | `DescontoStrategy` |
| Enum | `Especialidade` |

### Design Patterns

| Pattern | Onde | Por quê |
|---|---|---|
| **Strategy** | `DescontoStrategy`, `DescontoConvenio`, `SemDesconto` | Permite trocar a regra de desconto sem alterar `Consulta` ou `Paciente`. Novas regras de desconto exigem apenas uma nova implementação da interface. |
| **Singleton** | `Agenda` | Garante uma única instância da agenda da clínica em toda a aplicação. |

## Como executar

```bash
javac -d out src/clinica/**/*.java src/clinica/Clinica.java
java -cp out src.clinica.Clinica
```

## Saída esperada

```
=== Consultas agendadas com sucesso ===

Erro ao agendar: Medico já possui consulta neste horário

=== Resumo da consulta 1 ===
Nome: Joao Pedro, CPF: 123.456.789-00, Telefone: (11) 98888-0001
Dados do médico: Nome: Carlos Silva, CPF: 111.222.333-44, Especialidade: CARDIOLOGIA
Horario da consulta: 10:00 01/04/2026
Valor: R$ 140.0
(com convenio)

=== Resumo da consulta 2 ===
Nome: Maria Lima, CPF: 987.654.321-00, Telefone: (11) 98888-0002
Dados do médico: Nome: Ana Souza, CPF: 555.666.777-88, Especialidade: DERMATOLOGIA
Horario da consulta: 14:00 01/04/2026
Valor: R$ 150.0
(particular)

=== Consultas do Dr. Carlos ===
(consulta do Joao)

=== Cancelando consulta do Joao ===
Consultas do Dr. Carlos apos cancelamento:
Nenhuma consulta encontrada.

=== Consultas da Maria ===
(consulta da Maria com Dra. Ana)
```

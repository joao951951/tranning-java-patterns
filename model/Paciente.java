package src.clinica.model;

import src.clinica.pricing.DescontoStrategy;

public class Paciente extends Pessoa {
    private DescontoStrategy descontoStrategy;

    public Paciente(String nome, String cpf, String telefone, DescontoStrategy descontoStrategy) {
        super(nome, cpf, telefone);
        this.descontoStrategy = descontoStrategy;
    }

    @Override
    public String exibirDados() {
        String dadosPaciente = "Nome: " + this.getNome() +
                ", CPF: " + this.getCpf() +
                ", Telefone: " + this.getTelefone();

        return dadosPaciente;
    }

    public DescontoStrategy getDescontoStrategy() {
        return this.descontoStrategy;
    }
}

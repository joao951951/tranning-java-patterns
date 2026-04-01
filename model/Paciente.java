package src.clinica.model;

import java.util.Objects;

import src.clinica.pricing.DescontoStrategy;

public class Paciente extends Pessoa {
    private DescontoStrategy descontoStrategy;

    public Paciente(String nome, String cpf, String telefone, DescontoStrategy descontoStrategy) {
        super(nome, cpf, telefone);
        this.descontoStrategy = descontoStrategy;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getCpf());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || this.getClass() != obj.getClass())
            return false;
        Paciente outroPaciente = (Paciente) obj;
        return this.getCpf().equals(outroPaciente.getCpf());
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

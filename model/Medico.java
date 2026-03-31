package src.clinica.model;

public class Medico extends Pessoa {
    private Especialidade especialidade;

    public Medico(String nome, String cpf, String telefone, Especialidade especialidade) {
        super(nome, cpf, telefone);
        this.especialidade = especialidade;
    }

    @Override
    public String exibirDados() {
        String dadosMedico = "Nome: " + this.getNome() +
                ", CPF: " + this.getCpf() +
                ", Especialidade: " + especialidade;

        return dadosMedico;
    }
}

package src.clinica.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Consulta {
    private Medico medico;
    private Paciente paciente;
    private double valor;
    private LocalDateTime dataHora;
    private final String datePattern = "HH:mm dd/MM/yyyy";

    public Consulta(Medico medico, Paciente paciente, double valor, LocalDateTime dataHora) {
        this.medico = medico;
        this.paciente = paciente;
        this.valor = valor;
        this.dataHora = dataHora;
    }

    public String exibirResumo() {
        String dadosConsulta = this.paciente.exibirDados() +
                "\nDados do médico: " + this.medico.exibirDados() +
                "\nHorario da consulta: " + this.getDataHoraString() +
                "\nValor: R$ " + this.getValor();

        return dadosConsulta;
    }

    public String getDataHoraString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(datePattern);
        String formattedDateTime = this.dataHora.format(formatter);
        return formattedDateTime;
    }

    public double getValor() {
        return this.paciente.getDescontoStrategy().getDesconto(this.valor);
    }

    public LocalDateTime getDataHora() {
        return this.dataHora;
    }

    public Medico getMedico() {
        return this.medico;
    }

    public Paciente getPaciente() {
        return this.paciente;
    }
}

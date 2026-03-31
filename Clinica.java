package src.clinica;

import java.time.LocalDateTime;
import java.util.ArrayList;

import src.clinica.model.Consulta;
import src.clinica.model.Medico;
import src.clinica.model.Paciente;
import src.clinica.model.Especialidade;
import src.clinica.pricing.DescontoConvenio;
import src.clinica.pricing.SemDesconto;
import src.clinica.service.Agenda;

public class Clinica {
    public static void main(String[] args) {
        // Criando medicos
        Medico drCarlos = new Medico("Carlos Silva", "111.222.333-44", "(11) 99999-0001", Especialidade.CARDIOLOGIA);
        Medico draAna = new Medico("Ana Souza", "555.666.777-88", "(11) 99999-0002", Especialidade.DERMATOLOGIA);

        // Criando pacientes (Joao tem convenio, Maria eh particular)
        Paciente joao = new Paciente("Joao Pedro", "123.456.789-00", "(11) 98888-0001", new DescontoConvenio());
        Paciente maria = new Paciente("Maria Lima", "987.654.321-00", "(11) 98888-0002", new SemDesconto());

        // Criando consultas
        LocalDateTime amanha10h = LocalDateTime.of(2026, 4, 1, 10, 0);
        LocalDateTime amanha14h = LocalDateTime.of(2026, 4, 1, 14, 0);

        Consulta c1 = new Consulta(drCarlos, joao, 200.0, amanha10h);
        Consulta c2 = new Consulta(draAna, maria, 150.0, amanha14h);
        Consulta c3 = new Consulta(drCarlos, maria, 200.0, amanha10h); // conflito: mesmo medico e horario

        // Agendando
        Agenda agenda = Agenda.getInstance();
        agenda.agendar(c1);
        agenda.agendar(c2);
        System.out.println("=== Consultas agendadas com sucesso ===\n");

        // Tentando agendar consulta com conflito de horario
        try {
            agenda.agendar(c3);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao agendar: " + e.getMessage() + "\n");
        }

        // Exibindo resumos
        System.out.println("=== Resumo da consulta 1 ===");
        System.out.println(c1.exibirResumo());
        System.out.println("(com convenio)\n");

        System.out.println("=== Resumo da consulta 2 ===");
        System.out.println(c2.exibirResumo());
        System.out.println("(particular)\n");

        // Listando consultas do Dr. Carlos
        System.out.println("=== Consultas do Dr. Carlos ===");
        ArrayList<Consulta> consultasCarlos = agenda.listarConsultasPorMedico(drCarlos);
        for (Consulta c : consultasCarlos) {
            System.out.println(c.exibirResumo());
        }

        // Cancelando e listando novamente
        System.out.println("\n=== Cancelando consulta do Joao ===");
        agenda.cancelar(c1);

        System.out.println("Consultas do Dr. Carlos apos cancelamento:");
        consultasCarlos = agenda.listarConsultasPorMedico(drCarlos);
        if (consultasCarlos.isEmpty()) {
            System.out.println("Nenhuma consulta encontrada.");
        }

        // Listando consultas da Maria
        System.out.println("\n=== Consultas da Maria ===");
        ArrayList<Consulta> consultasMaria = agenda.listarConsultasPorPaciente(maria);
        for (Consulta c : consultasMaria) {
            System.out.println(c.exibirResumo());
        }
    }
}

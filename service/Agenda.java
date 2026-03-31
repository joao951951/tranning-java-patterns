package src.clinica.service;

import java.util.ArrayList;

import src.clinica.model.Consulta;
import src.clinica.model.Medico;
import src.clinica.model.Paciente;

public class Agenda {
    private ArrayList<Consulta> consultas = new ArrayList<>();
    private static final Agenda agendaInstancia = new Agenda();

    private Agenda() {
    }

    public static Agenda getInstance() {
        return agendaInstancia;
    }

    public void agendar(Consulta consulta) {
        for (Consulta consultaElement : consultas) {
            if (consultaElement.getMedico().equals(consulta.getMedico())
                    && consultaElement.getDataHora().equals(consulta.getDataHora())) {
                throw new IllegalArgumentException("Medico já possui consulta neste horário");
            }
        }
        consultas.add(consulta);
    }

    public void cancelar(Consulta consulta) {
        consultas.remove(consulta);
    }

    public ArrayList<Consulta> listarConsultasPorMedico(Medico medico) {
        ArrayList<Consulta> resultado = new ArrayList<>();
        for (Consulta consulta : consultas) {
            if (consulta.getMedico().equals(medico)) {
                resultado.add(consulta);
            }
        }
        return resultado;
    }

    public ArrayList<Consulta> listarConsultasPorPaciente(Paciente paciente) {
        ArrayList<Consulta> resultado = new ArrayList<>();
        for (Consulta consulta : consultas) {
            if (consulta.getPaciente().equals(paciente)) {
                resultado.add(consulta);
            }
        }
        return resultado;
    }
}

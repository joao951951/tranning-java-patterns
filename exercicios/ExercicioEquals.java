package src.clinica.exercicios;

import java.util.HashSet;

import src.clinica.model.Paciente;
import src.clinica.pricing.DescontoConvenio;
import src.clinica.pricing.SemDesconto;

public class ExercicioEquals {
    public static void main(String[] args) {
        // Dois pacientes com mesmo CPF mas nomes e estrategias diferentes
        Paciente p1 = new Paciente("Joao Pedro", "123.456.789-00", "(11) 98888-0001", new DescontoConvenio());
        Paciente p2 = new Paciente("Joao Silva", "123.456.789-00", "(11) 98888-0002", new SemDesconto());

        // Paciente com CPF diferente
        Paciente p3 = new Paciente("Maria Lima", "987.654.321-00", "(11) 98888-0003", new SemDesconto());

        System.out.println("=== Teste equals() ===");
        System.out.println("p1.equals(p2) [mesmo CPF]    = " + p1.equals(p2) + " (esperado: true)");
        System.out.println("p1.equals(p3) [CPF diferente] = " + p1.equals(p3) + " (esperado: false)");
        System.out.println("p1.equals(null)               = " + p1.equals(null) + " (esperado: false)");
        System.out.println("p1.equals(\"string\")           = " + p1.equals("string") + " (esperado: false)");
        System.out.println("p1.equals(p1) [mesma ref]     = " + p1.equals(p1) + " (esperado: true)");

        System.out.println("\n=== Teste hashCode() ===");
        System.out.println("p1.hashCode() = " + p1.hashCode());
        System.out.println("p2.hashCode() = " + p2.hashCode());
        System.out.println("hashCodes iguais? " + (p1.hashCode() == p2.hashCode()) + " (esperado: true)");

        System.out.println("\n=== Teste HashSet ===");
        HashSet<Paciente> set = new HashSet<>();
        set.add(p1);
        set.add(p2);
        set.add(p3);
        System.out.println("Adicionados p1, p2 (mesmo CPF) e p3 (CPF diferente)");
        System.out.println("set.size() = " + set.size() + " (esperado: 2)");
    }
}

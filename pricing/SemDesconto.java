package src.clinica.pricing;

public class SemDesconto implements DescontoStrategy {

    public double getDesconto(double valorConsulta) {
        return valorConsulta;
    }
}

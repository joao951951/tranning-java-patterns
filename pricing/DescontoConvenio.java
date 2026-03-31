package src.clinica.pricing;

public class DescontoConvenio implements DescontoStrategy {

    private double desconto = 0.3;

    public double getDesconto(double valorConsulta) {
        double porcentualDescontado = 1 - desconto;
        return valorConsulta * porcentualDescontado;
    }
}

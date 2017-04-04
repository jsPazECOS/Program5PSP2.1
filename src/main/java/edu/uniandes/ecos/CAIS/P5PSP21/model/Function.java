/**
 * Programa: Programa 5 - PSP 2.1
 *
 * @author Juan Sebastian Paz Prieto
 * @date 03/04/2017 Clase: Function Descripcion: Clase que representa cada
 * funcion a la cual se le va a calcular la integral
 *
 */
package edu.uniandes.ecos.CAIS.P5PSP21.model;

public class Function {

    private double X;
    private double dof;
    private double P;

    /**
     * Metodo mediante el cual se inicializan las variables X y Dof, leidas
     * desde un archivo plano.
     *
     * @param X
     * @param dof
     */
    public Function(double X, double dof) {
        this.X = X;
        this.dof = dof;
    }

    /**
     * Metodo que permite acceder al valor de X
     *
     * @return un valor <code>Double</code> del valor de X.
     */
    public double getX() {
        return X;
    }

    /**
     * Metodo que permite acceder al valor de dof
     *
     * @return un valor <code>Double</code> del valor de X.
     */
    public double getDof() {
        return dof;
    }

    /**
     * Metodo que permite acceder al valor de P
     *
     * @return un valor <code>Double</code> del valor de P.
     */
    public double getP() {
        return P;
    }

    /**
     * Método que instancia un objeto de tipo Simpson Rule, que hace el calculo
     * de la integral de la función usando la regla de Simpson
     */
    public void calculateP() {
        SimpsonRule rule = new SimpsonRule(10, 0.00001, this.X, this.dof);
        this.P = rule.calculate();
    }
}

package telefonia;

import java.util.GregorianCalendar;

public class PosPago extends Assinante {

	private double assinatura;
    private float creditos;
    private int numRecargas;

    public PosPago(long cpf, String nome, int numero) {
        super(cpf, nome, numero);
    }

}

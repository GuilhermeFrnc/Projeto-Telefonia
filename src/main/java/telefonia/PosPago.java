package telefonia;

import java.util.GregorianCalendar;

public class PosPago extends Assinante {

    private float assinatura = 0;

    public PosPago(long cpf, String nome, long numero) {
        super(cpf, nome, numero);
    }
}

package telefonia;


public class PosPago extends Assinante {

    private float creditos;
    private int numRecargas;

    public PosPago(long cpf, String nome, int numero) {
        super(cpf, nome, numero);
    }

}

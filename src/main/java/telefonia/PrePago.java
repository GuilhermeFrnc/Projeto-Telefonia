package telefonia;

import java.util.ArrayList;


public class PrePago extends Assinante {

    private float creditos;
    private int numRecargas;
    private ArrayList<Recarga> recargas;  //Uma lista para armazenar as informações da recarga.

    public PrePago(long cpf, String nome, int numero) {
        super(cpf, nome, numero);
        this.recargas = new ArrayList<>();  // Cria uma lista para cada assinante que for iniciado na classe PrePago.
    }
}

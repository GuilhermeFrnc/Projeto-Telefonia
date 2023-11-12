package telefonia;

import java.util.ArrayList;

public class Assinante {

    private long cpf;
    private String nome;
    private int numero;
    protected ArrayList<Chamada> chamadas;    // Lista para adicionar o registro das chamadas feitas.
    protected int numChamadas;    // contador.

    public Assinante(long cpf, String nome, int numero) {
        this.cpf = cpf;
        this.nome = nome;
        this.numero = numero;
        this.chamadas = new ArrayList<>();   // Cria uma lista de chamdas para cada assinante que for criado.
        this.numChamadas = 0;
    }
}

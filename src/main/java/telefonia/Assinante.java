package telefonia;

public class Assinante {

    private long cpf;
    private String nome;
    private long numero;
    protected Chamada[] chamadas;    // Lista para adicionar o registro das chamadas feitas.
    protected int numChamadas;    // contador.

    public Assinante(long cpf, String nome, long numero) {
        this.cpf = cpf;
        this.nome = nome;
        this.numero = numero;
        this.chamadas = new Chamada[10];   // Cria uma lista de chamdas para cada assinante que for criado, com o limite de 10 chamadas.
        this.numChamadas = 0;
    }

    public long getCpf() {
        return this.cpf;
    }

    @Override
    public String toString() {
        return "Nome assinante= " + nome
                + ", cpf=" + cpf
                + ", numero=" + numero
                + ", numChamadas=" + numChamadas;
    }
}

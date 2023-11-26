package telefonia;

public class Assinante {

    private long cpf;
    private String nome;
    private int numero;
    protected Chamada[] chamadas;  // Vetor para armazenar as chamadas.
    protected int numChamadas;     // Contador

    public Assinante(long cpf, String nome, int numero, int maxChamadas) {
        this.cpf = cpf;
        this.nome = nome;
        this.numero = numero;
        this.chamadas = new Chamada[maxChamadas];  // Inicializando o vetor com o tamanho máximo
        this.numChamadas = 0;
    }

    public long getCpf() {      // Retornando o número do CPF
        return this.cpf;
    }

    public void adicionarChamada(Chamada chamada) {
        if (numChamadas < chamadas.length) {
            chamadas[numChamadas] = chamada; //Verificando se há espaço no vetor para armazenar novas chamadas
            numChamadas++;
        } else {
            System.out.println("Sem espaço para adicionar mais chamadas.");
        }
    }

    @Override
    public String toString() {
        return "Assinante{"
                + "cpf=" + cpf
                + ", nome='" + nome + '\''
                + ", numero=" + numero
                + ", numChamadas=" + numChamadas
                + '}';
    }
}

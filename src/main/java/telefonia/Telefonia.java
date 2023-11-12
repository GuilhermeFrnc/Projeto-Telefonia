package telefonia;

import java.util.Scanner;

public class Telefonia {

    private int numPrePagos; // contador da quantidade de assinantes pre pagos. 
    private int numPosPagos;  
    private Assinante[] prePagos;  // vetor para adicionar as informaçôes dos assinantes pre pagos.
    private Assinante[] posPagos;  
    private Scanner scanner = new Scanner(System.in);

    public Telefonia() {

        this.numPrePagos = numPrePagos;
        this.numPosPagos = numPosPagos;
        this.posPagos = new PosPago[10];  // Cria uma lista com a capacidade de dez assinantes pós pagos.
        this.prePagos = new PrePago[10];
    }

}

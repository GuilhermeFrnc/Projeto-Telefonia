package telefonia;

import java.util.GregorianCalendar;

public class Chamada {

    private Assinante assinante;
    private GregorianCalendar data;
    private int duracao;

    public Chamada(Assinante assinante, GregorianCalendar data, int duracao) {
        this.assinante = assinante;
        this.data = data;
        this.duracao = duracao;
    }
}

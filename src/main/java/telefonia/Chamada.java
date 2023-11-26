package telefonia;

import java.text.SimpleDateFormat;
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

    public GregorianCalendar getData() {
        return this.data;
    }

    public int getDuracao() {
        return this.duracao;
    }

    @Override
    public String toString() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyy");
        String dataFormatada = formato.format(data.getTime());
        return ", data=" + dataFormatada
                + ", duracao=" + duracao;
    }
}

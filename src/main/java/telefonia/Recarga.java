package telefonia;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;


public class Recarga {
    // Adicionar os atributos e métodos dessa Classe.
private GregorianCalendar data;
private float valor;

//Criando o Construtor para a classe
public Recarga(GregorianCalendar data, float valor) {
this.data = data;
this.valor = valor;
}
public GregorianCalendar getData() { //Pegando a data e retornando.
return data;
}
public float getValor() { //Pegando o valor da recarga e retornando o mesmo.
return valor;
}

public String toString() {
SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Formatando a data de uma maneira especificada (dia/mês/ano)
String formattedDate = dateFormat.format(data.getTime());
return "Data: " + formattedDate + ", Valor R$" + valor; // Retorna a data formata e o valor recarregado.

}
}


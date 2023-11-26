package telefonia;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;


public class Recarga {
	
	
private GregorianCalendar data;
private float valor;

//Criando o Construtor para a classe
public Recarga(GregorianCalendar data, float valor) {
this.data = data;
this.valor = valor; 
}
public GregorianCalendar getData() { // Retornando o Valor e a Data da Recarga.
return data;
}
public float getValor() { 
	return valor;
}

public String toString() {
SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Formatando a data de uma maneira especificada (dia/mês/ano)
String formattedDate = dateFormat.format(data.getTime());
return "Data: " + formattedDate + ", Valor R$" + valor; // Retorna a data formata e o valor recarregado.

}
}


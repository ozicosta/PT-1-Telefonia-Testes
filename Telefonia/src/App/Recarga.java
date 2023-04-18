package App;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Recarga {
	private GregorianCalendar data;
	private float valor;
	public Recarga() {
	
	}
	public GregorianCalendar getData() {
		return data;
	}
	public float getValor() {
		return valor;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		return "Recarga [data=" + formato.format(data) + ", valor=" + valor + "]";
	}
}

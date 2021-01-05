package com.moneyparts;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MoneyParts {
	
	private static List<String> salida = new ArrayList<String>();;
	List<Double> listaDeno;
	List<Double> denominaciones;
	double sumaMontos=0;
	
	public static void main(String[] args) {
		
		MoneyParts mp = new MoneyParts();
		Double monto = 0.5;
		mp.build(monto);
		
	}

	public void build(double monto) {
		listaDeno 	   = new ArrayList<Double>();
		denominaciones = new ArrayList<Double>();
		
		denominaciones.add(0.05);
		denominaciones.add(0.1);
		denominaciones.add(0.2);
		denominaciones.add(0.5);
		denominaciones.add(1.0);
		denominaciones.add(2.0);
		denominaciones.add(5.0);
		denominaciones.add(10.0);
		denominaciones.add(20.0);
		denominaciones.add(50.0);
		denominaciones.add(100.0);
		denominaciones.add(200.0);

		this.recursivo(monto, listaDeno, sumaMontos, denominaciones);

		System.out.println(salida.stream()
									.collect(Collectors.joining(","))
									);

	}

	public void recursivo(double monto, List<Double> listaDeno, double sumaMontos, List<Double> denominaciones) {
		if ((sumaMontos == monto)) {
			salida.add(listaDeno.toString());
		} else {
			for (int i = 0; i < denominaciones.size(); i++) {
				sumaMontos += denominaciones.get(i);
				if (sumaMontos <= monto) {
					listaDeno.add(denominaciones.get(i));
					recursivo(monto, listaDeno, sumaMontos, denominaciones);
					listaDeno.remove(listaDeno.indexOf(denominaciones.get(i)));
				}
				sumaMontos -= denominaciones.get(i);
			}
		}
	}
	
	
}

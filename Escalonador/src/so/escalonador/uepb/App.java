package so.escalonador.uepb;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Douglas, Thiago e Joanes
 */
public class App {
	public static Scanner input;
	public static List<Processo> listaProcessos;

	public static void main(String[] args) {
		listaProcessos = new ArrayList<Processo>();
		input = new Scanner(System.in);

		while (true) {
			String dados_in[] = input.nextLine().split(" ");
			if (dados_in[0].isEmpty() || dados_in[1].isEmpty())
				break;
			listaProcessos.add(new Processo(Integer.parseInt(dados_in[0]), Integer.parseInt(dados_in[1])));
		}
		
        FCFS fcfs = new FCFS(listaProcessos);
        SJF sjf = new SJF(listaProcessos);
        fcfs.printMetricas();
        sjf.printMetricas();
	}

}
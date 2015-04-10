package so.escalonador.uepb;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Douglas, Thiago e Joanes
 */
public class App {
	public static Scanner input = new Scanner(System.in);;
	public static List<Processo> listaProcessos = new ArrayList<Processo>();

	public static void main(String[] args) {
		while (true) {
			String dados_in[] = input.nextLine().split(" ");
			if (dados_in[0].isEmpty() || dados_in[1].isEmpty()) {
				input.close();
				break;
			}
			listaProcessos.add(new Processo(Integer.parseInt(dados_in[0]), Integer.parseInt(dados_in[1])));
		}
		
        FCFS fcfs = new FCFS(listaProcessos);
        SJF sjf = new SJF(listaProcessos);
        RR rr = new RR(listaProcessos);
        fcfs.printMetricas();
        sjf.printMetricas();
        rr.printMetricas();
	}

}
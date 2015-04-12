package so.escalonador.uepb;

import java.util.ArrayList;
import java.util.List;

/**
 * ESCALONADOR NÃO-PREEMPTIVO
 *
 * @author Douglas, Thiago e Joanes
 */
public class FCFS extends Escalonador {

	private static List<Processo> listaProntos;

	/**
	 * Implementação do algoritimo FCFS para calcular as métricas: 
	 * - Tempo de retono médio 
	 * - Tempo de resposta médio 
	 * - Tempo de espera médio
	 * @param processos Lista contendo os processos
	 */
	public FCFS(List<Processo> processos) {
		try {
			listaProntos = new ArrayList<Processo>(processos);
			int tempoRetorno = 0, tempoResposta = 0, tempoEspera = 0;
			int totalProcessos = processos.size();
			int retorno = tempoChegadaMinimo(processos);
			
			// enquanto existir processos na fila de prontos
			while (!listaProntos.isEmpty()) {
				Processo p = listaProntos.remove(0); // obtem o primeiro processo da fila e remove
				retorno += p.getDuracao();
				tempoRetorno += (retorno - p.getTempoChegada());
				tempoEspera += (retorno - p.getTempoChegada() - p.getDuracao()); // TEP = (REP - CHP - TAM)
			}
			tempoResposta = tempoEspera; // Para o FCFS o tempo de resposta é igual ao tempo de espera

			// seta os tempos médios
			super.setRetornoMedio((double) tempoRetorno / totalProcessos);
			super.setRespostaMedio((double) tempoResposta / totalProcessos);
			super.setEsperaMedio((double) tempoEspera / totalProcessos);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	

	/**
	 * Imprime as métricas
	 */
	public void printMetricas() {
		super.printMetricas("FCFS");
	}
}
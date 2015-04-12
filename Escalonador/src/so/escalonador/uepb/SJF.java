package so.escalonador.uepb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ESCALONADOR NÃO-PREEMPTIVO
 *
 * @author Douglas, Thiago e Joanes
 */
public class SJF extends Escalonador {

    private static List<Processo> listaProntos = new ArrayList<Processo>();

    public SJF(List<Processo> processos) {
        try {
            int tempoRetorno = 0, tempoResposta = 0, tempoEspera = 0;
            int totalProcessos = super.getTotalProcessos(processos);
            int retorno = tempoChegadaMinimo(processos);
            preparaListaProntos(processos);

            // enquanto houver processos
			while (!listaProntos.isEmpty()) {
				Processo p = listaProntos.remove(0); // obtem o primeiro processo da fila e remove
				retorno += p.getDuracao();
				tempoRetorno += (retorno - p.getTempoChegada());
				tempoEspera += (retorno - p.getTempoChegada() - p.getDuracao()); // TEP = (REP - CHP - TAM)
			}
			tempoResposta = tempoEspera; // Para o SJF o tempo de resposta é igual ao tempo de espera

            // seta os tempos médios
            super.setRetornoMedio((float) tempoRetorno / totalProcessos);
            super.setRespostaMedio((float) tempoResposta / totalProcessos);
            super.setEsperaMedio((float) tempoEspera / totalProcessos);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    /**
     * Ordena a lista de acordo com o tempo de chegada e duração do processo e prepara uma lista de prontos
     * @param p
     */
	private void preparaListaProntos(List<Processo> processos) {
		List<Processo> p = new ArrayList<Processo>(processos);
		int sumRetorno = 0, menor = 0, pivo = 0;
		// Ordena a lista para garantir a hierarquia de chegada
		Collections.sort(p);
		listaProntos.add(p.remove(0));
		sumRetorno = listaProntos.get(0).getDuracao();

		while(p.size() > 1) {
			pivo = 0;
			for(int i = 1; i < p.size(); i++) {
				if(p.get(pivo).getDuracao() <= p.get(i).getDuracao() && p.get(pivo).getTempoChegada() < sumRetorno)
					menor = pivo;
				else if(p.get(i).getTempoChegada() < sumRetorno) {
					pivo = i;
					menor = i;
				}
			}
			sumRetorno += p.get(menor).getDuracao();
			listaProntos.add(p.remove(menor));
		}
		// add o ultimo processo a lista, na ultima posicao
		if(p.size() == 1)
			listaProntos.add(p.remove(0));
    }

    /**
     * Imprime as métricas
     */
    public void printMetricas() {
        super.printMetricas("SJF");
    }
}
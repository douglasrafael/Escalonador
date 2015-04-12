package so.escalonador.uepb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Douglas, Thiago e Joanes
 */
public class RR extends Escalonador {

    private static final int QUANTUM = 2;
    private static List<Processo> listaProntos = new ArrayList<Processo>();
    private static List<Integer> temposChegada = new ArrayList<Integer>();
    private static Map<Integer, Integer> temposResposta = new HashMap<Integer, Integer>(); 

    public RR(List<Processo> processos) {
        int tempoRetorno = 0, tempoEspera = 0;
        int totalProcessos = super.getTotalProcessos(processos);
        int retorno = tempoChegadaMinimo(processos);
        preparaListaProntos(processos, retorno);

        // enquanto houver processos na lista de prontos
        while (!listaProntos.isEmpty()) {
	            Processo p = listaProntos.remove(0);
	            
            	/**
            	 * Para obter o tempo de resposta (intervalo entre a chegada ao sistema e inicio de sua execução)
            	 * é utilizado um Map (temposReposta), o key é o processo e o value é o tempo em que o processo foi atendido
            	 * Se o processo já foi atendido ele é ignorado e o tempo de resposta não é computado. 
            	 */
                if(!temposResposta.containsKey(p.getId()))
                	temposResposta.put(p.getId(), retorno - p.getTempoChegada());
                
	            /**
	             * Verifica se o processo da vez possui tempo restante maior que o QUANTUM
	             * Caso contrário o resto do tempo é pego e o processo finalizado
	             */
	            if (p.getDuracaoRestante() > QUANTUM) {
	                p.setDuracaoRestante(p.getDuracaoRestante() - QUANTUM);
	                retorno += QUANTUM;
	                preparaListaProntos(processos, retorno);
	               
	                // adiciona o processo no final da lista, pois não foi finalizado
	                listaProntos.add(p);
	            } else {
	                retorno += p.getDuracaoRestante();
	            }

		        /**
		         * Verifica se o processo foi finalizado. 
		         * Se finalizado, é calculado as métricas deste processo
		         */
		        if (!listaProntos.contains(p)) {
		            tempoRetorno += retorno - p.getTempoChegada();
		            tempoEspera += (retorno - p.getTempoChegada() - p.getDuracao()); // TEP = (REP - CHP - TAM)
		        }
        }

        /**
         * Depois que todos os processos foram executados a média das métricas é calculada
         */
        super.setRetornoMedio((float) tempoRetorno / totalProcessos);
        super.setRespostaMedio((float) sumTemposResposta() / totalProcessos);
        super.setEsperaMedio((float) tempoEspera / totalProcessos);
    }
    
    /**
     * Prepara a lista de prontos de acordo com o tempo de chegada
     * @param processos
     * @param retorno
     */
    private void preparaListaProntos(List<Processo> processos, int retorno) {
    	int min = 0;

    	for (Processo p : processos) {
			if(!temposChegada.contains(p.getTempoChegada()) && p.getTempoChegada() <= retorno) {
				if(!listaProntos.contains(p)) {
					min = p.getTempoChegada();
        			temposChegada.add(min);
					for (Processo processo : processos) {
						if(processo.getTempoChegada() == min)
							listaProntos.add(processo);
					}
				}
			}
		}
    }
    

    /**
     * Retorna o somatório do tempo de resposta de tdos os processos
     * @return
     */
    private int sumTemposResposta() {
    	int sumResposta = 0;
    	for (int key : temposResposta.keySet()) {
    		sumResposta += temposResposta.get(key);
		}
    	return sumResposta;
    }
    
    /**
     * Imprime as métricas
     */
    public void printMetricas() {
        super.printMetricas("RR");
    }
}

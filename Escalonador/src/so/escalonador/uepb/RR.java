package so.escalonador.uepb;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Douglas, Thiago e Joanes
 */
public class RR extends Escalonador {

    private static final int QUANTUM = 2;
    private static List<Processo> listaProntos;

    public RR(List<Processo> processos) {
        int tempoRetorno = 0, retorno = 0, tempoResposta = 0, tempoEspera = 0;
        int totalProcessos = super.getTotalProcessos(processos);
        listaProntos = new ArrayList<Processo>(processos);

        // enquanto houver processos
        while (!listaProntos.isEmpty()) {
            Processo p = listaProntos.remove(0);

            if (p.getDuracaoRestante() > QUANTUM) {
                p.setDuracaoRestante(p.getDuracaoRestante() - QUANTUM);
                retorno += QUANTUM;

                // adiciona o processo no final da lista
                listaProntos.add(p);
            } else {
                retorno += p.getDuracaoRestante();
            }

            /**
             * Verifica se o processo foi finalizado (se não estar na lista de
             * prontos). Se finalizado, é calculado as métricas
             */
            if (!listaProntos.contains(p)) {
                tempoRetorno += retorno; // soma todos os tempos de retorno
                tempoResposta += (retorno - p.getTempoChegada()); // soma todos os tempos de resposta
                tempoEspera += (retorno - p.getTempoChegada() - p.getDuracao()); // soma todos os tempos de espera
            }

            // seta os tempos médios
            super.setRetornoMedio((float) tempoRetorno / totalProcessos);
            super.setRespostaMedio((float) tempoResposta / totalProcessos);
            super.setEsperaMedio((float) tempoEspera / totalProcessos);
        }
    }

    /**
     * Imprime as métricas
     */
    public void printMetricas() {
        super.printMetricas("RR");
    }
}

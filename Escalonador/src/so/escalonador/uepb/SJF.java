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

    private static List<Processo> listaProntos;

    public SJF(List<Processo> processos) {
        try {
            int tempoRetorno = 0, retorno = 0, tempoResposta = 0, tempoEspera = 0;
            int totalProcessos = super.getTotalProcessos(processos);

            listaProntos = new ArrayList<Processo>(processos);
            // ordena os processos em ordem crescente de acordo com o tempo de execução
            Collections.sort(listaProntos);

            // enquanto houver processos
            while (!listaProntos.isEmpty()) {
                Processo p = listaProntos.remove(0);
                retorno += p.getDuracao();
                tempoRetorno += retorno; // soma todos os tempos de retorno
                tempoResposta += (retorno - p.getTempoChegada()); // soma todos os tempos de resposta
                tempoEspera += (retorno - p.getTempoChegada() - p.getDuracao()); // soma todos os tempos de espera
            }

            // seta os tempos médios
            super.setRetornoMedio((float) tempoRetorno / totalProcessos);
            super.setRespostaMedio((float) tempoResposta / totalProcessos);
            super.setEsperaMedio((float) tempoEspera / totalProcessos);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Imprime as métricas
     */
    public void printMetricas() {
        super.printMetricas("SJF");
    }
}
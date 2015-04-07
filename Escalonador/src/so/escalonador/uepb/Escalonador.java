package so.escalonador.uepb;

import static java.lang.String.format;
import java.util.List;

/**
 *
 * @author Douglas, Thiago e Joanes
 */
public class Escalonador {

    private float retornoMedio;
    private float respostaMedio;
    private float esperaMedio;

    public float getRetornoMedio() {
        return retornoMedio;
    }

    public void setRetornoMedio(float retornoMedio) {
        this.retornoMedio = retornoMedio;
    }

    public float getRespostaMedio() {
        return respostaMedio;
    }

    public void setRespostaMedio(float respostaMedio) {
        this.respostaMedio = respostaMedio;
    }

    public float getEsperaMedio() {
        return esperaMedio;
    }

    public void setEsperaMedio(float esperaMedio) {
        this.esperaMedio = esperaMedio;
    }

    /**
     * Obter o total de processos na lista.
     *
     * @param processos Lista contendo os processos a serem executados
     * @return int total de processos
     */
    public int getTotalProcessos(List<Processo> processos) {
        return processos.size();
    }

    /**
     * Imprime as métricas do escalonador: - Tempo de retono médio - Tempo de
     * resposta médio - Tempo de espera médio
     *
     * @param siglaEscalonador
     */
    public void printMetricas(String siglaEscalonador) {
        System.out.println(format("%s: %.1f %.1f %.1f", siglaEscalonador, getRetornoMedio(), getEsperaMedio(), getRespostaMedio()));
    }
}
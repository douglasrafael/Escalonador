package so.escalonador.uepb;

import static java.lang.String.format;

import java.util.List;

/**
 *
 * @author Douglas, Thiago e Joanes
 */
public class Escalonador {

    private double retornoMedio;
    private double respostaMedio;
    private double esperaMedio;

    public double getRetornoMedio() {
        return retornoMedio;
    }

    public void setRetornoMedio(double retornoMedio) {
        this.retornoMedio = retornoMedio;
    }

    public double getRespostaMedio() {
        return respostaMedio;
    }

    public void setRespostaMedio(double respostaMedio) {
        this.respostaMedio = respostaMedio;
    }

    public double getEsperaMedio() {
        return esperaMedio;
    }

    public void setEsperaMedio(double esperaMedio) {
        this.esperaMedio = esperaMedio;
    }
    
    public int tempoChegadaMinimo(List<Processo> processos) {
    	int min = Integer.MAX_VALUE;
    	for (Processo p : processos) {
			if(p.getTempoChegada() < min)
				min = p.getTempoChegada();
		}
    	return min;
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
        System.out.println(format("%s: %.1f %.1f %.1f", siglaEscalonador, getRetornoMedio(), getRespostaMedio(), getEsperaMedio()));
    }
    
    
}
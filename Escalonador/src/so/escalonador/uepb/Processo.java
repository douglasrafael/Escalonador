package so.escalonador.uepb;

/**
 *
 * @author Douglas, Thiago e Joanes
 */
public class Processo implements Comparable<Processo> {

    private int tempoChegada;
    private int duracao;
    private int duracaoRestante;

    public Processo(int tempoChegada, int duracao) {
        this.tempoChegada = tempoChegada;
        this.duracao = duracao;
        this.duracaoRestante = duracao;
    }

    public int getTempoChegada() {
        return tempoChegada;
    }

    public void setTempoChegada(int tempoChegada) {
        this.tempoChegada = tempoChegada;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public int getDuracaoRestante() {
        return duracaoRestante;
    }

    public void setDuracaoRestante(int duracaoRestante) {
        this.duracaoRestante = duracaoRestante;
    }

    
    /**
     * Ordena a lista de acordo com a duração
     * @param Processo
     */
    public int compareTo(Processo p) {
        if (p.getDuracao() > this.duracao) {
            return -1;
        } else if (p.getDuracao() < this.duracao) {
            return 1;
        } else {
            return 0;
        }
    }
    
    @Override
    public String toString() {
    	return getTempoChegada() + " - " + getDuracao(); 
    }
}

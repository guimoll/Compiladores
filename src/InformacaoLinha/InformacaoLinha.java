package InformacaoLinha;

public class InformacaoLinha {
    
    private int linha;
    private int posicaoInicio;
    private int posicaoFim;

    public InformacaoLinha() {
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public int getPosicaoInicio() {
        return posicaoInicio;
    }

    public void setPosicaoInicio(int posicaoInicio) {
        this.posicaoInicio = posicaoInicio;
    }

    public int getPosicaoFim() {
        return posicaoFim;
    }

    public void setPosicaoFim(int posicaoFim) {
        this.posicaoFim = posicaoFim;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final InformacaoLinha other = (InformacaoLinha) obj;
        if (this.linha != other.linha) {
            return false;
        }
        if (this.posicaoInicio != other.posicaoInicio) {
            return false;
        }
        if (this.posicaoFim != other.posicaoFim) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "InformacaoLinha{" + "linha=" + linha + ", posicaoInicio=" + posicaoInicio + ", posicaoFim=" + posicaoFim + '}';
    }
    
}

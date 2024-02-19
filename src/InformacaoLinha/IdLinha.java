
package InformacaoLinha;

import java.util.ArrayList;
import java.util.List;

public class IdLinha {

    private List<InformacaoLinha> identificarLinhas(String texto) {
        List<InformacaoLinha> informacoes = new ArrayList<>();
        int linha = 1;
        int posicaoAnterior = 0;
        String[] textos = texto.split("\\n");
        for (String textoA : textos) {
            InformacaoLinha id = new InformacaoLinha();
            id.setLinha(linha);
            id.setPosicaoInicio(posicaoAnterior);
            id.setPosicaoFim(posicaoAnterior + textoA.length());
            informacoes.add(id);

            posicaoAnterior = posicaoAnterior + textoA.length() + 1;
            linha++;
        }
        return informacoes;
    }

    public InformacaoLinha getLinha(String texto, int posicao) throws Exception {
        try{
        List<InformacaoLinha> informacoes = identificarLinhas(texto);
        return informacoes.stream()
                .filter(i -> posicao >= i.getPosicaoInicio() && posicao <= i.getPosicaoFim())
                .findFirst()
                .orElseThrow(() -> new Exception());
        }catch(Exception e){
        }
        return null;
    }

    public String getSimboloInvalido(int posicaoErro, String texto) {
        char simbolo = texto.charAt(posicaoErro);
        return String.valueOf(simbolo);
    }

}

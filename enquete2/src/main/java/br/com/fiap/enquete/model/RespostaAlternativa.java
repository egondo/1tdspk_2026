package br.com.fiap.enquete.model;

public class RespostaAlternativa {

    private Resposta resposta;
    private Alternativa alternativa;

    public RespostaAlternativa(Resposta resposta, Alternativa alternativa) {
        this.resposta = resposta;
        this.alternativa = alternativa;
    }

    public Resposta getResposta() {
        return resposta;
    }

    public void setResposta(Resposta resposta) {
        this.resposta = resposta;
    }

    public Alternativa getAlternativa() {
        return alternativa;
    }

    public void setAlternativa(Alternativa alternativa) {
        this.alternativa = alternativa;
    }
}

package br.com.fiap.enquete.controller;

import br.com.fiap.enquete.controller.dto.PerguntaDto;
import br.com.fiap.enquete.model.Alternativa;
import br.com.fiap.enquete.model.Pergunta;
import br.com.fiap.enquete.model.TipoPergunta;
import br.com.fiap.enquete.service.PerguntaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/perguntas")
@CrossOrigin(origins = "*")
public class PerguntaResource {

    private PerguntaService service;

    public PerguntaResource(PerguntaService service) {
        this.service = service;
    }


/*
{"numero": 1, "texto": "Qual o seu nome?", "tipo": "ABERTA",
    "alternativas": []
}
 */

/*
{"numero": 2, "texto": "Você é brasileiro?", "tipo": "UNICA",
    "alternativas": ["SIM", "NAO"]
}
 */
    @PostMapping
    public ResponseEntity<?> criarPergunta(@RequestBody PerguntaDto pergunta) {
        //Transforma a PerguntaDto em um objeto Pergunta e em uma lista de Alternativas


        Pergunta question = new Pergunta();
        question.setNumero(pergunta.numero());
        question.setTexto(pergunta.texto());
        question.setTipo(TipoPergunta.valueOf(pergunta.tipo()));

        List<Alternativa> alternativas = null;
        if (question.getTipo() != TipoPergunta.ABERTA) {
            alternativas = new ArrayList<>();
            for(String s : pergunta.alternativas()) {
                Alternativa a = new Alternativa();
                a.setTexto(s);
                alternativas.add(a);
            }
        }
        try {
            service.cadastraPergunta(question, alternativas);

        } catch (Exception e) {
            RespostaJson rj = new RespostaJson("Erro na inclusao de Pergunta", e.getMessage(), 404);
            return ResponseEntity.status(404).body(rj);
        }
        RespostaJson rj = new RespostaJson("Cadastrado com sucesso", "/api/v1/perguntas/" + question.getId(), 201);
        return ResponseEntity.status(201).body(rj);

    }

}

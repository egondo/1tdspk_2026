package br.com.fiap.spah.teste;

import br.com.fiap.spah.model.Endereco;
import br.com.fiap.spah.model.Enfermeiro;
import br.com.fiap.spah.model.Ficha;
import br.com.fiap.spah.model.Paciente;
import br.com.fiap.spah.model.type.Risco;
import br.com.fiap.spah.model.type.Status;
import br.com.fiap.spah.model.type.TipoLogradouro;
import br.com.fiap.spah.repository.EnderecoRepository;
import br.com.fiap.spah.repository.FichaRepository;
import br.com.fiap.spah.repository.PacienteRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Teste {


    public static void incluiPaciente(Paciente pac) throws Exception {
        PacienteRepository repPac = new PacienteRepository();
        EnderecoRepository repEnd = new EnderecoRepository();
        repPac.insert(pac);
        repEnd.insert(pac.getEndereco(), pac.getId());
    }

    public static void main(String[] args) {
        Enfermeiro enfermeiro = new Enfermeiro();
        enfermeiro.setId(1);

        Paciente paciente = new Paciente();
        paciente.setId(33);

        FichaRepository rep = new FichaRepository();
        Ficha f = new Ficha();
        f.setChegada(LocalDateTime.now());
        f.setSintomas("Febre alta, tosse e dor de cabeça");
        f.setRisco(Risco.BAIXO);
        f.setStatus(Status.BALCAO);
        f.setEnfermeiro(enfermeiro);
        f.setPaciente(paciente);

        try {
            //rep.insert(f);

            Ficha ficha = rep.search(1);
            System.out.println("ID" + ficha.getId());
            System.out.println("Status" + ficha.getStatus());
            System.out.println("Risco" + ficha.getRisco());
            System.out.println("Chegada" + ficha.getChegada());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main2(String[] args) throws Exception {
        PacienteRepository rep = new PacienteRepository();

        Paciente p = new Paciente();
        p.setNome("Jairzinho");
        p.setTelefone("(11) 919392393");
        p.setNascimento(LocalDate.of(1945, 6, 22));

        Endereco end = new Endereco();
        end.setBairro("Botafogo");
        end.setLogradouro("Rua do Futebol");
        end.setNumero("9");
        end.setCep("02143-200");
        end.setTipo(TipoLogradouro.RESIDENCIAL);

        p.setEndereco(end);

        incluiPaciente(p);

        //int qtd = rep.insert(p);
        //System.out.println("Inserindo o Gerson " + qtd);

        List<Paciente> dados = rep.searchByName("a");
        for(Paciente pac : dados) {
            System.out.println(pac.getId() + " " + pac.getNome() + " " + pac.getNascimento());
        }
    }
}

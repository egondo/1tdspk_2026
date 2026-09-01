package br.com.fiap.spah.teste;

import br.com.fiap.spah.model.Endereco;
import br.com.fiap.spah.model.Paciente;
import br.com.fiap.spah.model.type.TipoLogradouro;
import br.com.fiap.spah.repository.EnderecoRepository;
import br.com.fiap.spah.repository.PacienteRepository;

import java.time.LocalDate;
import java.util.List;

public class Teste {


    public static void incluiPaciente(Paciente pac) throws Exception {
        PacienteRepository repPac = new PacienteRepository();
        EnderecoRepository repEnd = new EnderecoRepository();
        repPac.insert(pac);
        repEnd.insert(pac.getEndereco(), pac.getId());
    }


    public static void main(String[] args) throws Exception {
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

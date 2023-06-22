import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProgramaConsole {
    public static void main(String[] args) {

        Candidato gabriel = new Candidato();
        Contato contatoGabriel = new Contato();
        Endereco enderecoGabriel = new Endereco();
        ExperienciaProfissional expGabriel = new ExperienciaProfissional();
        FaixaSalarial faixaSalarialGabriel = new FaixaSalarial();

        // Cadastrando contato
        contatoGabriel.setCelular("+55-11-9999-99999");
        contatoGabriel.setEmail("email@email.com");
        contatoGabriel.setTelefone("+55-11-2222-2222");
        contatoGabriel.setCelularWhatsApp(true);

        // Cadastrando endereco
        enderecoGabriel.setBairro("Sei la");
        enderecoGabriel.setCidade("São Paulo");
        enderecoGabriel.setComplemento("Casa");
        enderecoGabriel.setEstado("São Paulo");
        enderecoGabriel.setNumero("111");
        enderecoGabriel.setLogradouro("Rua fim do mundo");

        // Cadastrando exp profissional
        expGabriel.setEmpresa("MJV");
        expGabriel.setEmpregoAtual(true);
        expGabriel.setProfissao("Tecnico");
        expGabriel.setSalario(2000.00);

        // Cadastrando fxa salarial
        faixaSalarialGabriel.setValorMaximo(5000.00);
        faixaSalarialGabriel.setValorMinimo(2000.00);

        // cadastrando Candidato
        gabriel.setCpf("111-111-111-11");
        gabriel.setContato(contatoGabriel);
        gabriel.setEndereco(enderecoGabriel);
        gabriel.setNome("Gabriel");
        gabriel.setDataNascimento(LocalDate.of(1996,11,25));
        List<String> habilidadesGabriel = List.of("Java", "Python", "SQL");
        gabriel.setHabilidades(habilidadesGabriel);
        gabriel.setSexo(Genero.MASCULINO);
        gabriel.setExperienciaProfissional(expGabriel);
        gabriel.setFaixaSalarial(faixaSalarialGabriel);
        gabriel.setId(1);

        // Criar uma instância de CandidateSerializer
        CandidateSerializer candidateSerializer = new CandidateSerializer();

        // Criar uma lista de candidatos
        List<Candidato> candidatos = new ArrayList<>();
        //adiciona o objeto de candidatos na lista
        candidatos.add(gabriel);

        //Definir o caminho do arquivo entre outras questões
        String nomeArquivoDelimitado = "cadastro.txt";
        String caminhoDestinoDelimitado = "\\f:\\java\\mjv-java-school\\Candidatos\\jobby\\"+ nomeArquivoDelimitado;


        String nomeArquivoPosicional = "cadastro-" + gabriel.getCpf() + ".txt";
        String caminhoDestinoPosicional = "\\f:\\java\\mjv-java-school\\Candidatos\\jobby\\"+nomeArquivoPosicional;

        // Chamar o método gravarArquivoCSV
        boolean sucessoDelimitado = candidateSerializer.gravarArquivoDelimitado(caminhoDestinoDelimitado, candidatos);
        boolean sucessoPosicional = candidateSerializer.gravarArquivoPosicional(caminhoDestinoPosicional, candidatos);

        // Verificar se o arquivo delimitado foi gravado com sucesso
        if (sucessoDelimitado) {
            System.out.println("Arquivo delimitado gravado com sucesso!");
        } else {
            System.out.println("Erro ao gravar o arquivo delimitado.");
        }

        // Verificar se o arquivo posicional foi gravado com sucesso
        if (sucessoPosicional) {
            System.out.println("Arquivo posicional gravado com sucesso!");
        } else {
            System.out.println("Erro ao gravar o arquivo posicional.");
        }
    }

}

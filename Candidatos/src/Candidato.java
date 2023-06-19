import java.time.LocalDate;
import java.util.List;

public class Candidato {

    // Attributes
    private Integer id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private Genero sexo;
    private Contato Contato;
    private Endereco endereco;
    private ExperienciaProfissional experienciaProfissional;
    private List<String> habilidades;
    private FaixaSalarial faixaSalarial;




    // Getters and Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Genero getSexo() {
        return sexo;
    }

    public void setSexo(Genero sexo) {
        this.sexo = sexo;
    }

    public Contato getContato() {
        return Contato;
    }

    public void setContato(Contato contato) {
        Contato = contato;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public ExperienciaProfissional getExperienciaProfissional() {
        return experienciaProfissional;
    }

    public void setExperienciaProfissional(ExperienciaProfissional experienciaProfissional) {
        this.experienciaProfissional = experienciaProfissional;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

    public FaixaSalarial getFaixaSalarial() {
        return faixaSalarial;
    }

    public void setFaixaSalarial(FaixaSalarial faixaSalarial) {
        this.faixaSalarial = faixaSalarial;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

import java.time.LocalDate;

public class Cliente {

    String nome;
    LocalDate dataNascimento;

    private Cliente(String nome, LocalDate dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public static Cliente criarCliente(String nome, LocalDate dataNascimento) {
        return new Cliente(nome, dataNascimento);
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
}

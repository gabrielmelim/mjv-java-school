import java.time.LocalDate;

public class Cliente {

    String nome;
    LocalDate dataNascimento;

    public Cliente(String nome, LocalDate dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }
}

import java.time.LocalDateTime;
import java.util.Date;

public class Transacao {

    private LocalDateTime data;
    private String descricao;


    Transacao(LocalDateTime data, String descricao) {
        this.data = data;
        this.descricao = descricao;
    }


   LocalDateTime getData() {
        return data;
    }

    String getDescricao() {
        return descricao;
    }
}


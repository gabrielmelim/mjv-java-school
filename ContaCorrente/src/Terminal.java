import java.time.LocalDate;
import java.time.LocalDateTime;

public class Terminal {
    public static void main(String[] args) {

        //Cadastrando clientes:
        Cliente gabriel = Cliente.criarCliente("Gabriel", LocalDate.of(1996, 11, 25));
        Cliente luciana = Cliente.criarCliente("Luciana", LocalDate.of(2004, 8, 15));

        //Cadastrando Contas:
        ContaBancaria contaGabriel = ContaBancaria.criarContaBancaria(123,023,gabriel,1000.0,true);
        ContaBancaria contaLuciana = ContaBancaria.criarContaBancaria(321,023,luciana,1000.0,true);

        // testando os métodos.
        // consultar saldo da contaGabriel
        contaGabriel.consultarSaldo();
        // depositar valor na contaGabriel
        contaGabriel.depositar(1000);
        // sacar valor da contaGabriel
        contaGabriel.sacar(500);
        // transferir valor da contaGabriel para contaLuciana
        contaGabriel.transferir(500, contaLuciana);


        // consultar extrato entre datas especificas na contaGabriel
        System.out.println(contaGabriel.consultarExtratoEntreDatas(
                        LocalDateTime.of(2023, 6, 14, 00, 00),
                        LocalDateTime.of(2023, 6, 15, 00, 00)
                )
        );

        // cancelar a conta com uma justificativa
        contaGabriel.cancelarConta("Juros alto");

    }
}

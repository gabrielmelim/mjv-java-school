import java.time.LocalDate;
import java.time.LocalDateTime;
public class Terminal {
    public static void main(String[] args) {

        //Cadastrando clientes:
        Cliente c1 = new Cliente();
        c1.setNome("Gabriel");
        c1.setDataNascimento(LocalDate.of(1996,11,25));

        Cliente c2 = new Cliente();
        c2.setNome("Luciana");
        c2.setDataNascimento(LocalDate.of(2000,8,25));

        //Cadastrando Contas:
        ContaBancaria conta1 = new ContaBancaria();
        conta1.setCliente(c1);
        conta1.setNumeroConta(123);
        conta1.setNumeroAgencia(2292);
        conta1.setSaldoConta(1000.0);
        conta1.setAtiva(true);

        ContaBancaria conta2 = new ContaBancaria();
        conta2.setCliente(c2);
        conta2.setNumeroConta(321);
        conta2.setNumeroAgencia(2292);
        conta2.setSaldoConta(1000.0);
        conta2.setAtiva(true);

        // testando os métodos.
        // consultar saldo da contaGabriel
        conta1.consultarSaldo();
        // depositar valor na contaGabriel
        conta1.depositar(1000);
        // sacar valor da contaGabriel
        conta1.sacar(500);
        // transferir valor da contaGabriel para contaLuciana
        conta1.transferir(500, conta2);


        // consultar extrato entre datas especificas na contaGabriel
        System.out.println(conta1.consultarExtratoEntreDatas(
                        LocalDateTime.of(2023, 6, 14, 00, 00),
                        LocalDateTime.of(2023, 6, 15, 00, 00)
                )
        );

        // cancelar a conta com uma justificativa
        conta1.cancelarConta("Juros alto");

    }
}

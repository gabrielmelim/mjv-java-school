import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class Terminal {
    public static void main(String[] args) {

        //Cadastrando cliente 'Gabriel'
        Cliente gabriel = new Cliente(
                "gabriel",
                LocalDate.of(1996, 11, 25)
        );

        //Cadastrando cliente 'Luciana'
        Cliente luciana = new Cliente(
                "luciana",
                LocalDate.of(2004, 8, 15)
        );

        //Abrindo uma conta bancaria para o cliente 'Gabriel'
        ContaBancaria contaGabriel = new ContaBancaria(
                123,
                123,
                gabriel,
                1000.0,
                true
        );

        //Abrindo uma conta bancaria para a cliente 'Luciana'
        ContaBancaria contaLuciana = new ContaBancaria(
                321,
                123,
                luciana,
                1000.0,
                true
        );


//
//        // testando os métodos.

        // consultar saldo da contaGabriel
        contaGabriel.consultarSaldo();
        // depositar valor na contaGabriel
        contaGabriel.depositar(1000);
        // sacar valor da contaGabriel
        contaGabriel.sacar(500);
        // transferir valor da contaGabriel para contaLuciana
        contaGabriel.transferir(500,contaLuciana);


        // consultar extrato entre datas especificas na contaGabriel
        System.out.println(contaGabriel.consultarExtratoEntreDatas(
                LocalDateTime.of(2023, 6, 13, 00, 00),
                LocalDateTime.of(2023, 6, 14, 00, 00)
                )
        );

//        System.out.println(contaGabriel.retornaExtrato());
//        System.out.println(contaLuciana.retornaExtrato());



    }
}

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ContaBancaria {
    // Atributos -> variaveis
    private Cliente cliente;
    private Integer numeroConta;
    private Integer numeroAgencia;
    private Double saldoConta = 0.0;
    private boolean ativa;
    private List<Transacao> extrato;

    // Construtor
    ContaBancaria() {extrato = new ArrayList<>();}

    // Método para consultar o saldo atual
    void consultarSaldo() {

        System.out.println("Conta: " + cliente.getNome() + " \nSaldo atual: " + saldoConta + "\n");
    }

    // Método para sacar um valor da conta
    void sacar(double valor) {
        if (valor > saldoConta) {
            System.out.println("Saldo insuficiente.");
        } else {
            saldoConta -= valor;
            System.out.println("Conta: " + cliente.getNome() + "\n" + "Saque de " + valor + " realizado com sucesso.");
            System.out.println("Saldo atual: " + saldoConta + "\n");
            extrato.add(new Transacao(LocalDateTime.now(), "Saque de " + valor + " realizado"));
        }
    }

    // Método para depositar um valor na conta
    void depositar(double valor) {
        saldoConta += valor;
        System.out.println("Conta: " + cliente.getNome() + "\n" + "Depósito de " + valor + " realizado com sucesso.");
        System.out.println("Saldo atual: " + saldoConta + "\n");
        extrato.add(new Transacao(LocalDateTime.now(), "Depósito de " + valor + " realizado"));
    }

    // Método para transferir um valor para outra conta
    void transferir(double valor, ContaBancaria contaDestino) {
        if (valor > saldoConta) {
            System.out.println("Saldo insuficiente para transferência.");
        } else if (contaDestino == null) {
            System.out.println("Conta de destino inválida.");
        } else {
            saldoConta -= valor;
            System.out.println("Conta: " + cliente.getNome() + "\n" + "Transferência de " + valor + " realizada com sucesso.");
            System.out.println("Saldo atual: " + saldoConta + "\n");
            System.out.println("Conta a receber transferência: " + contaDestino.getCliente().getNome());
            contaDestino.depositar(valor);
            extrato.add(new Transacao(LocalDateTime.now(), "Transferência de " + valor + " realizada para conta de " + contaDestino.cliente.nome));
        }
    }

    // Método para consultar o extrato entre duas datas
    List<String> consultarExtratoEntreDatas(LocalDateTime dataInicio, LocalDateTime dataFim) {
        System.out.println("conta: " + cliente.getNome() + "\n" + "Extrato entre " + dataInicio + " e " + dataFim + ":");

        List<String> consultarTransacao = new ArrayList<>();

        for (Transacao transacao : extrato) {
            LocalDateTime dataTransacao = transacao.getData();

            // Verifica se a data da transação está dentro do intervalo especificado
            if (dataTransacao.isAfter(dataInicio) && dataTransacao.isBefore(dataFim)) {
                consultarTransacao.add("\n" + transacao.getData() + " - " + transacao.getDescricao() + "\n");
            }
        }
        return consultarTransacao;
    }

    // Método para cancelar a conta com uma justificativa
    void cancelarConta(String justificativa) {
        if (ativa) {
            ativa = false;
            System.out.println("\n" + "Conta: " + cliente.getNome() + "\nConta cancelada com sucesso.");
            System.out.println("Justificativa: " + justificativa);
        } else {
            System.out.println("A conta já está cancelada.");
        }
    }

    // Getters e Setters

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(Integer numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Integer getNumeroAgencia() {
        return numeroAgencia;
    }

    public void setNumeroAgencia(Integer numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
    }

    public Double getSaldoConta() {
        return saldoConta;
    }

    public void setSaldoConta(Double saldoConta) {
        this.saldoConta = saldoConta;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }
}

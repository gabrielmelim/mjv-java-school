import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class CandidateSerializer {

    public static boolean gravarArquivoDelimitado(String caminhoArquivo, List<Candidato> candidatos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo))) {
//            writer.write("Nome");
//            writer.write(";");
//            writer.write("\t\tCpf");
//            writer.write(";");
//            writer.write("\t\tDataNasc");
//            writer.write(";");
//            writer.write("\tSexo");
//            writer.write(";");
//            writer.write("\t\tCelular");
//            writer.write(";");
//            writer.write("\t  Zap");
//            writer.write(";");
//            writer.write("\t  Tel");
//            writer.write(";");
//            writer.write("\t\t\t\tEmail");
//            writer.write(";");
//            writer.write("\t\tEstado");
//            writer.write(";");
//            writer.write("\t\tCidade");
//            writer.write(";");
//            writer.write("\t\tRua");
//            writer.write(";");
//            writer.write("\t\t N°");
//            writer.write("  Bairro");
//            writer.write(";");
//            writer.write("Comp");
//            writer.write(";");
//            writer.write("Emp");
//            writer.write(";");
//            writer.write("Prof");
//            writer.write(";");
//            writer.write("\t\tSal.");
//            writer.write(";");
//            writer.write("eAtual");
//            writer.write(";");
//            writer.write("\tHab");
//            writer.write(";");
//            writer.write("\t Min");
//            writer.write(";");
//            writer.write("\t Max\n");

            for (Candidato candidato : candidatos) {
                writer.write(formatarCampo(candidato.getNome()));
                writer.write(";");
                writer.write(formatarCampo(candidato.getCpf()));
                writer.write(";");
                writer.write(formatarData(candidato.getDataNascimento()));
                writer.write(";");
                writer.write(formatarEnum(candidato.getSexo()));
                writer.write(";");
                writer.write(formatarCampo(candidato.getContato().getCelular()));
                writer.write(";");
                writer.write(formatarCampoLogico(candidato.getContato().isCelularWhatsApp()));
                writer.write(";");
                writer.write(formatarCampo(candidato.getContato().getTelefone()));
                writer.write(";");
                writer.write(formatarCampo(candidato.getContato().getEmail()));
                writer.write(";");
                writer.write(formatarCampo(candidato.getEndereco().getEstado()));
                writer.write(";");
                writer.write(formatarCampo(candidato.getEndereco().getCidade()));
                writer.write(";");
                writer.write(formatarCampo(candidato.getEndereco().getLogradouro()));
                writer.write(";");
                writer.write(formatarCampo(candidato.getEndereco().getNumero()));
                writer.write(";");
                writer.write(formatarCampo(candidato.getEndereco().getBairro()));
                writer.write(";");
                writer.write(formatarCampo(candidato.getEndereco().getComplemento()));
                writer.write(";");
                writer.write(formatarCampo(candidato.getExperienciaProfissional().getEmpresa()));
                writer.write(";");
                writer.write(formatarCampo(candidato.getExperienciaProfissional().getProfissao()));
                writer.write(";");
                writer.write(formatarDecimal(candidato.getExperienciaProfissional().getSalario()));
                writer.write(";");
                writer.write(formatarCampoLogico(candidato.getExperienciaProfissional().isEmpregoAtual()));
                writer.write(";");

                List<String> habilidades = candidato.getHabilidades();
                if (habilidades.isEmpty()) {
                    writer.write("VAZIO");
                } else {
                    for (String habilidade : habilidades) {
                        writer.write(habilidade);
                        writer.write(";");  // Adicione ponto e vírgula após cada habilidade
                    }
                }

                writer.write(formatarDecimal(candidato.getFaixaSalarial().getValorMinimo()));
                writer.write(";");
                writer.write(formatarDecimal(candidato.getFaixaSalarial().getValorMaximo()));
                writer.write(";");

                writer.newLine();
            }

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    public static boolean gravarArquivoPosicional(String caminhoArquivo, List<Candidato> candidatos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo))) {
            writer.write(campoFormatadoUpperCase("id", 2));
            adicionarEspacamento(writer, 28);
            writer.write(campoFormatadoUpperCase("nome", 30) + "");
            writer.write(campoFormatadoUpperCase("cpf", 11));
            adicionarEspacamento(writer, 19);
            writer.write(campoFormatadoUpperCase("data_nascimento", 15));
            adicionarEspacamento(writer, 15);
            writer.write(campoFormatadoUpperCase("sexo", 4));
            adicionarEspacamento(writer, 26);
            writer.write(campoFormatadoUpperCase("Logradouro", 10));
            adicionarEspacamento(writer, 40);
            writer.write(campoFormatadoUpperCase("numero", 6));
            adicionarEspacamento(writer, 30);
            writer.write(campoFormatadoUpperCase("complemento", 20));
            adicionarEspacamento(writer, 30);
            writer.write(campoFormatadoUpperCase("bairro", 30));
            adicionarEspacamento(writer, 30);
            writer.write(campoFormatadoUpperCase("cidade", 30));
            adicionarEspacamento(writer, 30);
            writer.write(campoFormatadoUpperCase("estado", 30));
            adicionarEspacamento(writer, 30);
            writer.write(campoFormatadoUpperCase("email", 30));
            adicionarEspacamento(writer, 30);
            writer.write(campoFormatadoUpperCase("telefone", 30));
            adicionarEspacamento(writer, 30);
            writer.write(campoFormatadoUpperCase("celular", 30));
            adicionarEspacamento(writer, 30);
            writer.write(campoFormatadoUpperCase("meu_celular_é_whats", 30));
            adicionarEspacamento(writer, 30);
            writer.write(campoFormatadoUpperCase("profissao", 30));
            adicionarEspacamento(writer, 30);
            writer.write(campoFormatadoUpperCase("empresa", 30));
            adicionarEspacamento(writer, 30);
            writer.write(campoFormatadoUpperCase("salario", 30));
            adicionarEspacamento(writer, 30);
            writer.write(campoFormatadoUpperCase("emprego_atual", 30));
            adicionarEspacamento(writer, 30);
            writer.write(campoFormatadoUpperCase("pretensao_minima", 30));
            adicionarEspacamento(writer, 30);
            writer.write(campoFormatadoUpperCase("pretensao_maxima", 30));
            adicionarEspacamento(writer, 30);
            writer.write(campoFormatadoUpperCase("habilidades", 30) + "\n");


            for (Candidato candidato : candidatos) {
                writer.write(campoId(candidato.getId(), 2));
                adicionarEspacamento(writer, 28);
                writer.write(campoFormatadoUpperCase(candidato.getNome(), 30));
                writer.write(contemSomenteDigitos(candidato.getCpf(), 11));
                adicionarEspacamento(writer, 19);
                writer.write(formatarDataPosicional(candidato.getDataNascimento(), 8));
                adicionarEspacamento(writer, 21);
                writer.write(obterCaractereGenero(candidato.getSexo(), 1));
                adicionarEspacamento(writer, 28);
                writer.write(campoFormatadoUpperCase(candidato.getEndereco().getLogradouro(), 40));
                adicionarEspacamento(writer, 10);
                writer.write(preencherComZerosEsquerda(candidato.getEndereco().getNumero(), 5));
                adicionarEspacamento(writer, 31);
                writer.write(campoFormatadoUpperCase(candidato.getEndereco().getComplemento(), 20));
                adicionarEspacamento(writer, 30);
                writer.write(campoFormatadoUpperCase(candidato.getEndereco().getBairro(), 30));
                adicionarEspacamento(writer, 30);
                writer.write(campoFormatadoUpperCase(candidato.getEndereco().getCidade(), 40));
                adicionarEspacamento(writer, 20);
                writer.write(campoFormatadoUpperCase(candidato.getEndereco().getEstado(), 10));
                adicionarEspacamento(writer, 50);
                writer.write(campoFormatadoLowerCase(candidato.getContato().getEmail(), 50));
                adicionarEspacamento(writer, 10);
                writer.write(formatarNumeroTelefone(candidato.getContato().getTelefone(), 10));
                adicionarEspacamento(writer, 48);
                writer.write(formatarNumeroTelefone(candidato.getContato().getCelular(), 11));
                adicionarEspacamento(writer, 49);
                writer.write(formatarNumeroTelefoneWpp(candidato.getContato().getCelular(), 1, candidato.getContato().isCelularWhatsApp()));
                adicionarEspacamento(writer, 57);
                writer.write(campoFormatadoUpperCase(candidato.getExperienciaProfissional().getProfissao(), 30));
                adicionarEspacamento(writer, 30);
                writer.write(campoFormatadoUpperCase(candidato.getExperienciaProfissional().getEmpresa(), 30));
                adicionarEspacamento(writer, 30);
                writer.write(formatarSalario(candidato.getExperienciaProfissional().getSalario(), 10));
                adicionarEspacamento(writer, 50);
                writer.write(formatarCampoLogicoPosicional(candidato.getExperienciaProfissional().isEmpregoAtual(), 1));
                adicionarEspacamento(writer, 59);
                writer.write(formatarSalario(candidato.getFaixaSalarial().getValorMinimo(), 10));
                adicionarEspacamento(writer, 50);
                writer.write(formatarSalario(candidato.getFaixaSalarial().getValorMaximo(), 10));
                adicionarEspacamento(writer, 50);

                List<String> habilidades = candidato.getHabilidades();
                if (habilidades.isEmpty()) {
                    writer.write("VAZIO");
                } else {
                    int tamanhoMaximo = 50; // Defina o tamanho máximo desejado aqui
                    StringBuilder habilidadesFormatadas = new StringBuilder();
                    for (int i = 0; i < habilidades.size(); i++) {
                        String habilidade = habilidades.get(i);
                        String habilidadeFormatada = habilidade.length() > tamanhoMaximo ? habilidade.substring(0, tamanhoMaximo) : habilidade;
                        habilidadesFormatadas.append(habilidadeFormatada);
                        if (i < habilidades.size() - 1) {
                            habilidadesFormatadas.append(",");
                        }
                    }
                    String habilidadesString = habilidadesFormatadas.toString();
                    if (habilidadesString.length() < tamanhoMaximo) {
                        habilidadesString = String.format("%-" + tamanhoMaximo + "s", habilidadesString);
                    }
                    writer.write(habilidadesString);
                }


                writer.newLine();

            }

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Métodos

    public static String ajustarTamanhoString(String valor, int tamanho) {
        if (valor.length() > tamanho) {
            // Se o valor for superior ao tamanho máximo de caracteres, cortar o final do nome
            valor = valor.substring(0, tamanho);
        }
        return valor;
    }

    public static void adicionarEspacamento(BufferedWriter writer, int tamanho) {
        try {
            for (int i = 0; i < tamanho; i++) {
                writer.write(" ");
            }
        } catch (IOException e) {
            // Tratar exceção de escrita
            e.printStackTrace();
        }
    }

    public static String formatarCampoLogico(boolean valor) {
        return valor ? "true" : "false";
    }

    public static String formatarCampoLogicoPosicional(Boolean valor, int tamanho) {
        if (valor == null) {
            return String.format("%" + tamanho + "s", ""); // Retorna um espaço em branco se o valor for nulo
        } else {
            String str = valor.toString();
            return str.substring(0, 1).toUpperCase();
        }
    }

    private static String formatarEnum(Enum<?> valor) {
        return valor.name();
    }

    private static String formatarDecimal(double valor) {
        return String.format("%.2f", valor);
    }

    private static String formatarData(LocalDate data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return data.format(formatter);
    }

    private static String formatarDataPosicional(LocalDate data, int tamanho) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String dataFormatada = data.format(formatter);

        // Preenche os espaços em branco até atingir o tamanho desejado
        int espacosEmBranco = tamanho - dataFormatada.length();
        StringBuilder dataEspacada = new StringBuilder(dataFormatada);
        for (int i = 0; i < espacosEmBranco; i++) {
            dataEspacada.append(" ");
        }

        return dataEspacada.toString();
    }

    private static String campoFormatadoUpperCase(String valor, int tamanho) {
        if (valor == null) {
            valor = "";
        }

        if (valor.length() > tamanho) {
            valor = valor.substring(0, tamanho);
        } else if (valor.length() < tamanho) {
            valor = String.format("%-" + tamanho + "s", valor);
        }

        return valor.toUpperCase();
    }

    private static String campoFormatadoLowerCase(String valor, int tamanho) {
        if (valor == null) {
            valor = "";
        }

        if (valor.length() > tamanho) {
            valor = valor.substring(0, tamanho);
        } else if (valor.length() < tamanho) {
            valor = String.format("%-" + tamanho + "s", valor);
        }

        return valor.toLowerCase();
    }

    private static String campoId(int valor, int tamanho) {
        String valorFormatado = String.valueOf(valor);

        if (valorFormatado.length() > tamanho) {
            valorFormatado = valorFormatado.substring(0, tamanho);
        } else if (valorFormatado.length() < tamanho) {
            valorFormatado = String.format("%-" + tamanho + "s", valorFormatado);
        }

        return valorFormatado.toUpperCase();
    }

    private static String campoFormatadoOriginal(String valor, int tamanho) {
        if (valor == null) {
            valor = "";
        }

        if (valor.length() > tamanho) {
            valor = valor.substring(0, tamanho);
        } else if (valor.length() < tamanho) {
            valor = String.format("%-" + tamanho + "s", valor);
        }

        return valor;
    }

    public static String formatarCampo(String valor) {
        if (valor == null || valor.isEmpty()) {
            return "Vazio";
        } else {
            return ajustarTamanhoString(valor, 30);
        }

    }

    public static String contemSomenteDigitos(String texto, int tamanho) {
        StringBuilder sb = new StringBuilder(texto);

        // Remover caracteres não dígitos
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (!Character.isDigit(sb.charAt(i))) {
                sb.deleteCharAt(i);
            }
        }

        // Preencher espaços em branco
        if (sb.length() < tamanho) {
            sb.append(" ".repeat(tamanho - sb.length()));
        }

        return sb.toString();
    }

    public static String obterCaractereGenero(Genero genero, int tamanho) {
        StringBuilder csvGenero = new StringBuilder();

        if (genero == Genero.MASCULINO) {
            csvGenero.append("M");
        } else if (genero == Genero.FEMININO) {
            csvGenero.append("F");
        }

        // Preenche os espaços em branco até atingir o tamanho desejado
        int espacosEmBranco = tamanho - csvGenero.length();
        for (int i = 0; i < espacosEmBranco; i++) {
            csvGenero.append(" ");
        }

        return csvGenero.toString();
    }

    public static String preencherComZerosEsquerda(String numero, int tamanho) {
        try {
            int num = Integer.parseInt(numero);
            String numeroFormatado = String.format("%05d", num);
            return String.format("%-" + tamanho + "s", numeroFormatado);
        } catch (NumberFormatException e) {
            // Caso não seja possível converter para inteiro, retorna o valor original com espaçamento
            return String.format("%-" + tamanho + "s", numero);
        }
    }

    public static String formatarNumeroTelefone(String numero, int tamanho) {
        if (numero == null || numero.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < tamanho; i++) {
                sb.append('0');
            }
            return sb.toString();
        }

        StringBuilder sb = new StringBuilder();
        for (char c : numero.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append(c);
            }
        }

        if (sb.length() == 0) {
            StringBuilder emptySb = new StringBuilder();
            for (int i = 0; i < tamanho; i++) {
                emptySb.append('0');
            }
            return emptySb.toString();
        }

        try {
            long num = Long.parseLong(sb.toString());
            return String.format("%0" + tamanho + "d", num);
        } catch (NumberFormatException e) {
            StringBuilder errorSb = new StringBuilder();
            for (int i = 0; i < tamanho; i++) {
                errorSb.append('0');
            }
            return errorSb.toString();
        }
    }

    public static String formatarNumeroTelefoneWpp(String numero, int tamanho, boolean isWhatsApp) {
        if (numero == null || numero.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < tamanho; i++) {
                sb.append('0');
            }
            return sb.toString();
        }

        StringBuilder sb = new StringBuilder();
        for (char c : numero.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append(c);
            }
        }

        if (sb.length() == 0) {
            StringBuilder emptySb = new StringBuilder();
            for (int i = 0; i < tamanho; i++) {
                emptySb.append('0');
            }
            return emptySb.toString();
        }

        if (isWhatsApp) {
            return isWhatsApp ? "T" : "F";
        }

        try {
            long num = Long.parseLong(sb.toString());
            return String.format("%0" + tamanho + "d", num);
        } catch (NumberFormatException e) {
            StringBuilder errorSb = new StringBuilder();
            for (int i = 0; i < tamanho; i++) {
                errorSb.append('0');
            }
            return errorSb.toString();
        }
    }

    public static String formatarSalario(double salario, int tamanho) {
        String salarioString = String.valueOf(salario);
        salarioString = salarioString.replaceAll("[^0-9]", ""); // Remove todos os caracteres não numéricos
        salarioString = salarioString.length() < tamanho ? String.format("%0" + tamanho + "d", Long.parseLong(salarioString)) : salarioString;
        return salarioString;
    }

}

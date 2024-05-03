import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaCadastroEnderecos {

    private static List<Usuario> usuarios = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastrar usuário");
            System.out.println("2 - Logar usuário");
            System.out.println("3 - Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarUsuario(scanner);
                    break;
                case 2:
                    logarUsuario(scanner);
                    break;
                case 3:
                    System.out.println("Encerrando sistema...");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void cadastrarUsuario(Scanner scanner) {
        System.out.println("Digite o nome de usuário:");
        String nomeUsuario = scanner.next();

        System.out.println("Digite a senha:");
        String senha = scanner.next();

        Usuario usuario = new Usuario(nomeUsuario, senha);
        usuarios.add(usuario);

        System.out.println("Usuário cadastrado com sucesso!");
    }

    private static void logarUsuario(Scanner scanner) {
        System.out.println("Digite o nome de usuário:");
        String nomeUsuario = scanner.next();

        System.out.println("Digite a senha:");
        String senha = scanner.next();

        Usuario usuario = encontrarUsuario(nomeUsuario);

        if (usuario != null && usuario.getSenha().equals(senha)) {
            System.out.println("Usuário logado com sucesso!");
            menuUsuarioLogado(usuario, scanner);
        } else {
            System.out.println("Usuário ou senha incorretos.");
        }
    }

    private static Usuario encontrarUsuario(String nomeUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNomeUsuario().equals(nomeUsuario)) {
                return usuario;
            }
        }

        return null;
    }

    private static void menuUsuarioLogado(Usuario usuario, Scanner scanner) {
        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastrar endereço");
            System.out.println("2 - Editar endereço");
            System.out.println("3 - Deletar endereço");
            System.out.println("4 - Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarEndereco(usuario, scanner);
                    break;
                case 2:
                    editarEndereco(usuario, scanner);
                    break;
                case 3:
                    deletarEndereco(usuario, scanner);
                    break;
                case 4:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void cadastrarEndereco(Usuario usuario, Scanner scanner) {
        System.out.println("Digite o logradouro:");
        String logradouro = scanner.next();

        System.out.println("Digite o número:");
        int numero = scanner.nextInt();

        System.out.println("Digite o complemento (opcional):");
        String complemento = scanner.next();

        System.out.println("Digite o bairro:");
        String bairro = scanner.next();

        System.out.println("Digite a cidade:");
        String cidade = scanner.next();

        System.out.println("Digite o estado:");
        String estado = scanner.next();

        System.out.println("Digite o CEP:");
        String cep = scanner.next();

        Endereco endereco = new Endereco(logradouro, numero, complemento, bairro, cidade, estado, cep);
        usuario.adicionarEndereco(endereco);

        System.out.println("Endereço cadastrado com sucesso!");
    }

    private static void editarEndereco(Usuario usuario, Scanner scanner) {
        System.out.println("Digite o número do endereço que deseja editar:");
        int numeroEndereco = scanner.nextInt();

        Endereco endereco = usuario.getEndereco(numeroEndereco);

        if (endereco !=

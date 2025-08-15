package main;

import model.Usuario;
import service.UsuarioService;
import service.Criptografia;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UsuarioService service = new UsuarioService();
        int opcao;

        do {
            System.out.println("\u001B[34m=== Sistema de Cadastro de Usuários ===\u001B[0m");
            System.out.println("1. Adicionar usuário");
            System.out.println("2. Listar usuários");
            System.out.println("3. Remover usuário");
            System.out.println("4. Buscar usuário");
            System.out.println("5. Atualizar usuário");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            while (!sc.hasNextInt()) {
                System.out.print("Digite um número válido: ");
                sc.next();
            }
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Nome: ");
                    String nome = sc.nextLine().trim();
                    if (nome.isBlank() || nome.matches(".*\\d.*")) {
                        System.out.println("\u001B[31mNome inválido.\u001B[0m");
                        break;
                    }
                    System.out.print("Email: ");
                    String email = sc.nextLine().trim();
                    if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,}$")) {
                        System.out.println("\u001B[31mEmail inválido.\u001B[0m");
                        break;
                    }
                    System.out.print("Senha (mínimo 6 caracteres): ");
                    String senha = sc.nextLine();
                    if (senha.length() < 6) {
                        System.out.println("\u001B[31mSenha muito curta.\u001B[0m");
                        break;
                    }

                    Usuario u = new Usuario(nome, email, Criptografia.sha256(senha));
                    if (service.adicionarUsuario(u)) {
                        System.out.println("\u001B[32mUsuário adicionado com sucesso!\u001B[0m");
                    } else {
                        System.out.println("\u001B[31mEmail já cadastrado.\u001B[0m");
                    }
                }
                case 2 -> {
                    List<Usuario> lista = service.listarUsuarios();
                    if (lista.isEmpty()) System.out.println("Nenhum usuário cadastrado.");
                    else lista.forEach(System.out::println);
                }
                case 3 -> {
                    System.out.print("Email do usuário a remover: ");
                    String email = sc.nextLine().trim();
                    if (service.removerUsuario(email)) System.out.println("\u001B[32mUsuário removido.\u001B[0m");
                    else System.out.println("\u001B[31mUsuário não encontrado.\u001B[0m");
                }
                case 4 -> {
                    System.out.print("Email do usuário: ");
                    String email = sc.nextLine().trim();
                    Usuario u = service.buscarUsuarioPorEmail(email);
                    if (u != null) System.out.println(u);
                    else System.out.println("\u001B[31mUsuário não encontrado.\u001B[0m");
                }
                case 5 -> {
                    System.out.print("Email do usuário a atualizar: ");
                    String email = sc.nextLine().trim();
                    System.out.print("Novo nome (enter para manter): ");
                    String nome = sc.nextLine().trim();
                    System.out.print("Nova senha (enter para manter): ");
                    String senha = sc.nextLine();

                    if (senha.length() > 0 && senha.length() < 6) {
                        System.out.println("\u001B[31mSenha muito curta.\u001B[0m");
                        break;
                    }

                    if (service.atualizarUsuario(email, nome, senha)) System.out.println("\u001B[32mAtualização realizada!\u001B[0m");
                    else System.out.println("\u001B[31mUsuário não encontrado.\u001B[0m");
                }
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("\u001B[31mOpção inválida!\u001B[0m");
            }

        } while (opcao != 0);

        sc.close();
    }
}

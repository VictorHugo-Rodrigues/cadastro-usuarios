package service;

import model.Usuario;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepositoryArquivo {
    private final File arquivo;

    public UsuarioRepositoryArquivo(String caminho) {
        this.arquivo = new File(caminho);
    }

    public List<Usuario> carregar() {
        List<Usuario> lista = new ArrayList<>();
        if (!arquivo.exists()) return lista;

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";", -1);
                if (partes.length == 3) {
                    lista.add(new Usuario(partes[0], partes[1], partes[2]));
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }
        return lista;
    }

    public void salvarTodos(List<Usuario> usuarios) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(arquivo))) {
            for (Usuario u : usuarios) {
                pw.println(u.getNome() + ";" + u.getEmail() + ";" + u.getSenha());
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo: " + e.getMessage());
        }
    }
}

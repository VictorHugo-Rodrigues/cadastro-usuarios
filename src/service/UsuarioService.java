package service;

import model.Usuario;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UsuarioService {
    private List<Usuario> usuarios;
    private UsuarioRepositoryArquivo repo;

    public UsuarioService() {
        repo = new UsuarioRepositoryArquivo("data/usuarios.csv");
        usuarios = new ArrayList<>(repo.carregar());
    }

    public boolean adicionarUsuario(Usuario usuario) {
        if (buscarUsuarioPorEmail(usuario.getEmail()) != null) return false;
        usuarios.add(usuario);
        repo.salvarTodos(usuarios);
        return true;
    }

    public List<Usuario> listarUsuarios() {
        return new ArrayList<>(usuarios);
    }

    public Usuario buscarUsuarioPorEmail(String email) {
        for (Usuario u : usuarios) {
            if (u.getEmail().equalsIgnoreCase(email)) return u;
        }
        return null;
    }

    public boolean removerUsuario(String email) {
        Iterator<Usuario> it = usuarios.iterator();
        while (it.hasNext()) {
            Usuario u = it.next();
            if (u.getEmail().equalsIgnoreCase(email)) {
                it.remove();
                repo.salvarTodos(usuarios);
                return true;
            }
        }
        return false;
    }

    public boolean atualizarUsuario(String email, String novoNome, String novaSenha) {
        Usuario u = buscarUsuarioPorEmail(email);
        if (u == null) return false;
        if (!novoNome.isBlank()) u.setNome(novoNome);
        if (!novaSenha.isBlank()) u.setSenha(Criptografia.sha256(novaSenha));
        repo.salvarTodos(usuarios);
        return true;
    }
}

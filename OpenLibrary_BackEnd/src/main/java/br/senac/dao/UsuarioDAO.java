package br.senac.dao;

import br.senac.dto.UsuarioDTO;
import jakarta.enterprise.context.ApplicationScoped;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class UsuarioDAO {

    public void Salvar(Connection conn, UsuarioDTO usuario) throws SQLException {
            String sql = "INSERT INTO usuario (id, nome, email, senha) VALUES (?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, usuario.getId());
                stmt.setString(2, usuario.getNome());
                stmt.setString(3, usuario.getEmail());
                stmt.setString(4, usuario.getSenha());

                stmt.executeUpdate();
            }
        }

        public void Atualizar(Connection conn, UsuarioDTO usuario) throws SQLException {
            String sql = "UPDATE usuario SET nome = ?, email = ?, senha = ? WHERE id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, usuario.getNome());
                stmt.setString(2, usuario.getEmail());
                stmt.setString(3, usuario.getSenha());
                stmt.setInt(5, usuario.getId());
                stmt.executeUpdate();
            }
        }

        public void Deletar(Connection conn, int id) throws SQLException {
            String sql = "DELETE FROM usuario WHERE id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, id);
                stmt.executeUpdate();
            }
        }

        public UsuarioDTO PesquisarID(Connection conn, int id) throws SQLException {
            String sql = "SELECT id, nome, email, senha FROM usuario WHERE id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, id);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        UsuarioDTO usuario = new UsuarioDTO();
                        usuario.setId(rs.getInt("id"));
                        usuario.setNome(rs.getString("nome"));
                        usuario.setEmail(rs.getString("email"));
                        usuario.setSenha(rs.getString("senha"));

                        return usuario;
                    }
                }
            }
            return null;
        }

        public List<UsuarioDTO> PesquisarTodos(Connection conn) throws SQLException {
            String sql = "SELECT id, nome, email, senha FROM usuario";
            List<UsuarioDTO> usuarios = new ArrayList<>();
            try (PreparedStatement stmt = conn.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    UsuarioDTO usuario = new UsuarioDTO();
                    usuario.setId(rs.getInt("id"));
                    usuario.setNome(rs.getString("nome"));
                    usuario.setEmail(rs.getString("email"));
                    usuario.setSenha(rs.getString("senha"));

                    usuarios.add(usuario);
                }
            }
            return usuarios;
        }

        public int getNextId(Connection conn) throws SQLException {
            String sql = "SELECT nextval('public.sq_usuario')";
            try (PreparedStatement stmt = conn.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
            return -1;
        }
    }

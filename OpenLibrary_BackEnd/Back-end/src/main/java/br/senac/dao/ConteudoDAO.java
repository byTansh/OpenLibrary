package br.senac.dao;

import br.senac.dto.ConteudoDTO;
import jakarta.enterprise.context.ApplicationScoped;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ConteudoDAO {

        public void Salvar(Connection conn, ConteudoDTO conteudo) throws SQLException {
            String sql = "INSERT INTO conteudo (titulo, lancamento, descricao) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, conteudo.getId());
                stmt.setString(2, conteudo.getTitulo());
                stmt.setString(3, conteudo.getLancamento());
                stmt.setString(4, conteudo.getDescricao());

                stmt.executeUpdate();
            }
        }

        public void Atualizar(Connection conn, ConteudoDTO conteudo) throws SQLException {
            String sql = "UPDATE conteudo SET titulo = ?, lancamento = ?, descricao = ? WHERE id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, conteudo.getId());
                stmt.setString(2, conteudo.getTitulo());
                stmt.setString(3, conteudo.getLancamento());
                stmt.setString(4, conteudo.getDescricao());

                stmt.executeUpdate();
            }
        }

        public void Deletar(Connection conn, int id) throws SQLException {
            String sql = "DELETE FROM conteudo WHERE id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, id);
                stmt.executeUpdate();
            }
        }

        public ConteudoDTO PesquisarID(Connection conn, int id) throws SQLException {
            String sql = "SELECT id, titulo, lancamento, descricao FROM conteudo WHERE id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, id);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        ConteudoDTO conteudo = new ConteudoDTO((rs.getString("titulo")),
                                (rs.getString("lançamento")), (rs.getString("descricao")));

                        conteudo.setId(rs.getInt("id"));
                        conteudo.setTitulo(rs.getString("titulo"));
                        conteudo.setLancamento(rs.getString("lancamento"));
                        conteudo.setDescricao(rs.getString("descricao"));

                        return conteudo;
                    }
                }
            }
            return null;
        }

        public List<ConteudoDTO> PesquisarTodos(Connection conn) throws SQLException {
            String sql = "SELECT id, titulo, lancamento, descricao FROM conteudo";
            List<ConteudoDTO> conteudos = new ArrayList<>();
            try (PreparedStatement stmt = conn.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    ConteudoDTO conteudo = new ConteudoDTO((rs.getString("titulo")),
                            (rs.getString("lancamento")), (rs.getString("descricao")));

                    conteudo.setId(rs.getInt("id"));
                    conteudo.setTitulo(rs.getString("titulo"));
                    conteudo.setLancamento(rs.getString("lancamento"));
                    conteudo.setDescricao(rs.getString("descricao"));

                    conteudos.add(conteudo);
                }
            }
            return conteudos;
        }

        public int getNextId(Connection conn) throws SQLException {
            String sql = "SELECT nextval('sq_conteudo')";
            try (PreparedStatement stmt = conn.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
            return -1;
        }
    }

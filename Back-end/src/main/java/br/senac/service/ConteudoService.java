package br.senac.service;

import br.senac.dao.ConteudoDAO;
import br.senac.dto.ConteudoDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ConteudoService {

    @Inject
    private ConteudoDAO conteudoDAO;

    @Inject
    private DataSource dataSource;

    @Transactional
    public void criarConteudo(ConteudoDTO conteudo) throws SQLException {
        try (Connection conn = dataSource.getConnection()) {
            int nextId = conteudoDAO.getNextId(conn);
            conteudo.setId(nextId);
            conteudoDAO.Salvar(conn, conteudo);

        }
    }


    @Transactional
    public void atualizarConteudo(ConteudoDTO conteudo) throws SQLException {
        try (Connection conn = dataSource.getConnection()) {
            conteudoDAO.Atualizar(conn, conteudo);
        }
    }


    @Transactional
    public void apagarConteudo(int idConteudo) throws SQLException {
        try (Connection conn = dataSource.getConnection()) {
            conteudoDAO.Deletar(conn, idConteudo);
        }
    }


    public List<ConteudoDTO> listarConteudo() throws SQLException {
        List<ConteudoDTO> conteudos = new ArrayList<>();
        try (Connection conn = dataSource.getConnection()) {
            return conteudoDAO.PesquisarTodos(conn);
        }
    }

}

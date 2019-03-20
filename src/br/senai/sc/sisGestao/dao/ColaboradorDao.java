package br.senai.sc.sisgestao.dao;

import br.senai.sc.sisGestao.modelo.CadastrarColaborador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ColaboradorDao extends ConnectionFactory {

    private Connection con;

    public ColaboradorDao() {
        this.con = this.getConnection();
    }

    public void inserir(CadastrarColaborador col) throws SQLException {

        String sql = "insert into colaborador "
                + "(tipo, usuario, "
                + "senha, nome, endereco, Equipe_codEquipe) "
                + "values (?, ?, ?, ?, ?, ?);";

        try (PreparedStatement st = this.con.prepareStatement(sql)) {
            st.setString(1, col.getTipo());
            st.setString(2, col.getUsuario());
            st.setString(3, col.getSenha());
            st.setString(4, col.getNome());
            st.setString(5, col.getEndereco());
            st.setInt(6, col.getEquipe());

            st.execute();
            st.close();
        }

        this.con.close();

    }

    public void eliminar(int codigoC) throws SQLException {

        String sql = "delete from colaborador where codColaborador = ?";

        try (PreparedStatement st = this.con.prepareStatement(sql)) {
            st.setInt(1, codigoC);
            st.execute();
            st.close();
        }

        this.con.close();

    }

    public void alterar(CadastrarColaborador col) throws SQLException {

        String sql = "update colaborador set tipo = ?, usuario = ?, senha = ?, "
                + "nome = ?, endereco = ? where codColaborador = ?";

        try (PreparedStatement st = this.con.prepareStatement(sql)) {
            st.setString(1, col.getTipo());
            st.setString(2, col.getUsuario());
            st.setString(3, col.getSenha());
            st.setString(4, col.getNome());
            st.setString(5, col.getEndereco());

            st.execute();
            st.close();
        }

        this.con.close();

    }

    public List<CadastrarColaborador> listarColaboradores() throws SQLException {
        String sql = "select * from colaborador";
        List<CadastrarColaborador> colaboradores = null;

        try (PreparedStatement st = this.con.prepareStatement(sql)) {
            ResultSet rs = st.executeQuery();

            colaboradores = new ArrayList<CadastrarColaborador>();

            while (rs.next()) {
                CadastrarColaborador c = new CadastrarColaborador();
                c.setTipo("tipo");
                c.setUsuario("usuario");
                c.setSenha("senha");
                c.setNome("nome");
                c.setEndereco("endereco");
               

                colaboradores.add(c);
            }

            rs.close();
            st.close();

        }

        this.con.close();
        return colaboradores;
    }

    public CadastrarColaborador getColaborador(int codColaborador) throws SQLException {
        String sql = "select * from colaborador where codColaborador = ?";
        CadastrarColaborador colaborador = null;

        try (PreparedStatement st = this.con.prepareStatement(sql)) {
            st.setInt(1, codColaborador);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    CadastrarColaborador c = new CadastrarColaborador();
                    c.setTipo("tipo");
                    c.setUsuario("usuario");
                    c.setSenha("senha");
                    c.setNome("nome");
                    c.setEndereco("endereco");

                }
            }
            st.close();
        }

        this.con.close();
        return colaborador;
    }

}

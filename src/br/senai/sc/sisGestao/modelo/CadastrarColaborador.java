
package br.senai.sc.sisGestao.modelo;

import br.senai.sc.sisgestao.dao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class CadastrarColaborador {
    protected String tipo;
    protected String usuario;
    protected String senha;
    protected String nome;
    protected String endereco;
    private int equipe;
    private String adicionarTarefa;
    private String removerTarefa;
    private String editarTarefa;
    
    
  
    public int getEquipe(){
        String sql = "SELECT codEquipe from equipe";
        System.out.println(sql);
        return equipe;
    }
    public void setEquipe(int equipe){
        this.equipe = equipe;
    }
    public String getAdicionarTarefa() {
        return adicionarTarefa;
    }

    public void setAdicionarTarefa(String adicionarTarefa) {
        this.adicionarTarefa = adicionarTarefa;
    }

    public String getRemoverTarefa() {
        return removerTarefa;
    }

    public void setRemoverTarefa(String removerTarefa) {
        this.removerTarefa = removerTarefa;
    }

    public String getEditarTarefa() {
        return editarTarefa;
    }

    public void setEditarTarefa(String editarTarefa) {
        this.editarTarefa = editarTarefa;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    

    public boolean consultar(String login, String senha) {
        boolean autenticado = false;
        String sql;
        try {
            ConnectionFactory con = new ConnectionFactory();
            Connection connection = con.getConnection();
    
            sql = "SELECT codColaborador, usuario, senha, tipo FROM colaborador WHERE usuario=? and senha=?";
            PreparedStatement ps;
            ps = connection.prepareStatement(sql);
            ps.setString(1, login);
            ps.setString(2, senha);
            ResultSet rs;
            rs = ps.executeQuery();
            if (rs.next()) {
                String tipo = rs.getString("tipo");
                int cod = rs.getInt("codColaborador");
                autenticado = true;
            } else {
                ps.close();
                return autenticado;
            }
            
            JOptionPane.showMessageDialog(null, "Login deu certo");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return autenticado;
    }

}
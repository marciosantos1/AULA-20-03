
package br.senai.sc.sisGestao.modelo;


public class CadastrarEquipe {
    protected String nome;
    protected String descricao;
    protected String atualizarNome;
    protected String atualizarDescricao;
    protected String codigoEquipe;
    
    public void setCodEquipe(String cod){
        this.codigoEquipe = cod;
    }
    
    public String getCodEquipe(){
        return this.codigoEquipe;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public void setAtualizarNome(String novoNome){
        this.atualizarNome = novoNome;
    }
    public String getAtualizarNome(){
        return this.atualizarNome;
    }
    
    public void setAtualizarDescricao(String novaDescricao){
       this.atualizarDescricao = novaDescricao;
    }
    
    public String getAtualizarDescricao(){
        return this.atualizarDescricao;
    }
   
    
}

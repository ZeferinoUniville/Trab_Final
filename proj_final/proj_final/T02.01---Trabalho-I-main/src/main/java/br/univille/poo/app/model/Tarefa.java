package br.univille.poo.app.model;

public class Tarefa {

    private int id;
    private String descricao;
    private String prioridade;
    private boolean concluido;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPrioridade() {
        return prioridade;
    }
    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public boolean isConcluido() {
        return concluido;
    }
    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }


    @Override
    public String toString() {
        return  "id= " + id +
                ", descricao= '" + descricao + '\'' +
                ", prioridade= '" + prioridade + '\'' +
                ", concluido= " + concluido;
    }

}

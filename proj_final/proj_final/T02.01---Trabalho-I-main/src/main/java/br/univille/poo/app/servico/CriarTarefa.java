package br.univille.poo.app.servico;

import br.univille.poo.app.model.Tarefa;
import br.univille.poo.app.model.TarefaDAO;

public class CriarTarefa {

    private TarefaDAO dao;

    public CriarTarefa(){
        dao = new TarefaDAO();
    }

    public void criar(Tarefa tarefa) throws Exception {
        if(tarefa.getDescricao() == null || tarefa.getDescricao().length() < 4){
            throw  new Exception("Favor informar a tarefa.");
        }
        dao.inserir(tarefa);
    }

}

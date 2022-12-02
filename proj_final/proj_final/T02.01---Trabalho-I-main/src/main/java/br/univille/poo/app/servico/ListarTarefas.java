package br.univille.poo.app.servico;

import br.univille.poo.app.model.Tarefa;
import br.univille.poo.app.model.TarefaDAO;

import java.util.List;

public class ListarTarefas {

    private TarefaDAO dao;

    public ListarTarefas(){
        dao = new TarefaDAO();
    }

    public List<Tarefa> obterTodos(){
        return dao.obterTodos();
    }

}

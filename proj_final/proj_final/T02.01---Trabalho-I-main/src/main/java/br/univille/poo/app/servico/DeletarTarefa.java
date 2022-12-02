package br.univille.poo.app.servico;

import br.univille.poo.app.model.TarefaDAO;

public class DeletarTarefa {

    private TarefaDAO dao;

    public DeletarTarefa(){
        dao = new TarefaDAO();
    }

    public void delete(int tarefa_id) throws Exception {
        dao.delete(tarefa_id);
    }

}

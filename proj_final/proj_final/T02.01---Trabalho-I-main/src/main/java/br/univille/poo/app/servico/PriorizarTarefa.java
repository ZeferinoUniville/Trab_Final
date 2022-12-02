package br.univille.poo.app.servico;

import br.univille.poo.app.model.TarefaDAO;

public class PriorizarTarefa {
    
    private TarefaDAO dao;

    public PriorizarTarefa(){
        dao = new TarefaDAO();
    }

    public void priorizar(Integer idTarefa, String nvlPriori) throws Exception {
        
        dao.priorizar(idTarefa, nvlPriori);
    }

}




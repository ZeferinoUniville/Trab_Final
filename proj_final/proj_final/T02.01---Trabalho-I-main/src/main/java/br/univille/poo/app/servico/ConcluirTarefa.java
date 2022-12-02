package br.univille.poo.app.servico;

import br.univille.poo.app.model.Tarefa;
import br.univille.poo.app.model.TarefaDAO;

public class ConcluirTarefa {

  private TarefaDAO dao;

  public ConcluirTarefa() {
    dao = new TarefaDAO();
  }

  public void concluir(Tarefa tarefa) throws Exception {
    if (tarefa.getId() < 1) {
      throw new Exception("A tarefa não possui um identificador válido.");
    }
    dao.atualizar(tarefa);
  }

}

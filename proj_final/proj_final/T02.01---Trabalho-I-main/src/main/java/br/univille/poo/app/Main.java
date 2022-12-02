package br.univille.poo.app;

import br.univille.poo.app.model.CriarTabelas;
import br.univille.poo.app.view.ListaDeTarefasView;

public class Main {

  public static void main(String[] args) {

    CriarTabelas.criarTabelas();
    new ListaDeTarefasView();
  }
}

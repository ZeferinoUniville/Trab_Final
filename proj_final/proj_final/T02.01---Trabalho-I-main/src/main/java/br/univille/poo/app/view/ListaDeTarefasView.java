package br.univille.poo.app.view;

import br.univille.poo.app.model.Tarefa;
import br.univille.poo.app.servico.ConcluirTarefa;
import br.univille.poo.app.servico.DeletarTarefa;
import br.univille.poo.app.servico.ListarTarefas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListaDeTarefasView extends JFrame {

  private JPanel listaPanel;
  private ListarTarefas listarTarefasServico;
  private JButton btn;

  public ListaDeTarefasView() {
    setTitle("Listagem de Tarefas");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(400, 400);
    listarTarefasServico = new ListarTarefas();
    configurarJanela();
    setVisible(true);
  }

  private void configurarJanela() {
    listaPanel = new JPanel();
    GroupLayout group = new GroupLayout(listaPanel);
    group.setAutoCreateGaps(true);
    group.setAutoCreateContainerGaps(true);
    listaPanel.setLayout(new BoxLayout(listaPanel, BoxLayout.Y_AXIS));
    JScrollPane scrollPanel = new JScrollPane(listaPanel);

    listaPanel.setBorder(
      BorderFactory.createCompoundBorder(
        BorderFactory.createCompoundBorder(
          BorderFactory.createTitledBorder("Caixa de Entrada"),
          BorderFactory.createEmptyBorder(10, 10, 10, 10)),
        listaPanel.getBorder()));

    listarTarefasServico = new ListarTarefas();
    btn = new JButton("NOVA TAREFA");
    btn.setHorizontalTextPosition(AbstractButton.RIGHT);
    listaPanel.add(btn);
    listaPanel.add(Box.createVerticalStrut(20));
    popularLista();
    add(scrollPanel);

    btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        new AddTarefa();
        dispose();
      }
    });

  }

  private void popularLista() {
    for (Tarefa tarefa : listarTarefasServico.obterTodos()) {
      listaPanel.add(criarItemDaLista(tarefa));
    }
  }

  private JPanel criarItemDaLista(Tarefa item) {
    JPanel panel = new JPanel();

    JLabel label = new JLabel(item.getDescricao());
    JCheckBox CheckBox = new JCheckBox("");
    CheckBox.setSelected(item.isConcluido());
    JButton btnDeletar = new JButton("Deletar");

    btnDeletar.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        DeletarTarefa dt = new DeletarTarefa();
        try {
          dt.delete(item.getId());
        } catch (Exception e1) {
          e1.printStackTrace();
        }
        new ListaDeTarefasView();
        setVisible(false);
      }
    });

    CheckBox.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        item.setConcluido(CheckBox.isSelected());
        ConcluirTarefa ct = new ConcluirTarefa();
        try {
          ct.concluir(item);
        } catch (Exception e1) {
          e1.printStackTrace();
        }
      }
    });

    panel.setBorder(BorderFactory.createEtchedBorder());
    panel.add(label);
    panel.add(CheckBox);
    panel.add(btnDeletar);
    return panel;
  }

}

package br.univille.poo.app.view;

import javax.swing.*;

import br.univille.poo.app.model.Tarefa;
import br.univille.poo.app.servico.CriarTarefa;
import br.univille.poo.app.servico.ListarTarefas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddTarefa extends JFrame {

  private JButton BotaoCancelar;
  private JButton BotaoSalvar;

  public AddTarefa() {
    setTitle("Adiconar nova Tarefa");
    setSize(500, 300);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    configurarJanela();
    setVisible(true);
  }

  public void configurarJanela() {

    JPanel painel = new JPanel();
    GroupLayout JanelaLayout = new GroupLayout(painel);
    painel.setLayout(JanelaLayout);
    JanelaLayout.setAutoCreateGaps(true);
    JanelaLayout.setAutoCreateContainerGaps(true);

    JLabel lbl_tarefa = new JLabel("Tarefa");
    JTextArea txa_tarefa = new JTextArea(5, 5);
    txa_tarefa.setBorder(BorderFactory.createLineBorder(Color.black));

    JLabel lbl_prioridade = new JLabel("Prioridade");
    String[] strings = { "Alta", "Media", "Baixa" };
    JComboBox cbb_prioridade = new JComboBox(strings);
    cbb_prioridade.setSelectedIndex(2);

    JCheckBox chb_finalizado = new JCheckBox("Finalizado");

    BotaoCancelar = new JButton("Cancelar");
    BotaoSalvar = new JButton("Salvar");

    // * Configurar posição dos aspectos do programa*/
    JanelaLayout.setVerticalGroup(
        JanelaLayout.createSequentialGroup()
            .addComponent(lbl_tarefa)
            .addComponent(txa_tarefa)
            .addComponent(lbl_prioridade)
            .addComponent(cbb_prioridade)
            .addComponent(chb_finalizado)
            .addGroup(JanelaLayout.createParallelGroup()
                .addComponent(BotaoCancelar)
                .addComponent(BotaoSalvar)));
    JanelaLayout.setHorizontalGroup(
        JanelaLayout.createParallelGroup()
            .addComponent(lbl_tarefa)
            .addComponent(txa_tarefa)
            .addComponent(lbl_prioridade)
            .addComponent(cbb_prioridade)
            .addComponent(chb_finalizado)
            .addGroup(JanelaLayout.createSequentialGroup()
                .addComponent(BotaoCancelar)
                .addComponent(BotaoSalvar)));
    add(painel);

    BotaoSalvar.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Tarefa task = new Tarefa();
        task.setDescricao(txa_tarefa.getText());
        task.setPrioridade(cbb_prioridade.getSelectedItem().toString());
        task.setConcluido(chb_finalizado.isSelected());
        CriarTarefa CT = new CriarTarefa();
        try {
          CT.criar(task);
          new ListarTarefas(); 
        }catch (Exception ex) {
          ex.printStackTrace();
        }
        new ListaDeTarefasView();
        setVisible(false);
      }
    });
    
    BotaoCancelar.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        new ListaDeTarefasView();
        setVisible(false);
      }
    });
  }
}
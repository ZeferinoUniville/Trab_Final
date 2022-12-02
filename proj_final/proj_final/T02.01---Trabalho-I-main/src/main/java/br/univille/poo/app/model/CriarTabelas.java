package br.univille.poo.app.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class CriarTabelas {

    private final static String CRIAR_TABELA_TAREFA = 
            " create table if not exists tarefa(\n" +
            " id integer primary key autoincrement\n" +
            " ,descricao  varchar(500)\n" +
            " ,prioridade  varchar(500)\n" +
            " ,concluido  boolean\n" +
            " )";

    public static void criarTabelas(){
        List<String> lista = new ArrayList<>();
        lista.add(CRIAR_TABELA_TAREFA);
        for (String comando : lista){
            try(Connection c = FabricaDeConexoes.obterInstancia().obterConexao();
                PreparedStatement p = c.prepareStatement(comando)) {
                p.execute();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

}

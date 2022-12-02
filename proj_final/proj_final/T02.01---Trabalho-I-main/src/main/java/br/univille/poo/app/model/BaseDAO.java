package br.univille.poo.app.model;

import java.sql.Connection;

class BaseDAO {

    protected Connection obterConexao(){
        return FabricaDeConexoes.obterInstancia().obterConexao();
    }

}

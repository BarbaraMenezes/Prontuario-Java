/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bárbara
 */
public class Conexao {

    private Connection conexao;
    //jdbc:postgresql://localhost:5432/
    private final String url = "jdbc:postgresql://localhost:5432/prontuario";

    private final String user = "postgres";
    //"postgres" 

    private final String password = "123456";
//123456
    public Connection Conectar() {
        try {
            conexao = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            System.out.print("Erro ao Conectar ao Banco de Dados! " + ex.toString());
            return null;
        }
        System.out.println("Banco Conectado com Sucesso!");
        return conexao;

    }

    public boolean Desconectar() {
        try {
            if (conexao.isClosed() == false) {
                conexao.close();
            }
        } catch (SQLException ex) {
            System.out.print("Erro ao Desconetar o Banco de dados! " + ex.toString());
            return false;
        }
        System.out.println("Desconectado com Sucesso!");
        return true;
    }
}

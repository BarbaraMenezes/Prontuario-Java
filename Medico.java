/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import com.sun.istack.internal.logging.Logger;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import sun.util.logging.PlatformLogger;

/**
 *
 * @author Bárbara
 */
public class Medico {

    public boolean VerificarLogin(Connection con, Integer CRM, String Senha) throws SQLException {
        String sql = "select nome from medico where crm= ? and senha= ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, CRM);
        stmt.setString(2, Senha);

        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            InformacoesSistema.crm = CRM;
            InformacoesSistema.nome_medico = rs.getString("nome");
            rs.close();
            stmt.close();
            return true;
        } else {
            rs.close();
            stmt.close();
            return false;
        }
    }

    public void Inserir(Connection con, Integer CRM, String Nome, String CPF, String Email, String NumCelular, String DataNasc,
            String Senha) throws SQLException {
        String sql = "insert into medico(crm,nome,cpf,email,numcelular,datanascimento,senha)"
                + "values(?,?,?,?,?,?,?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, CRM);
        stmt.setString(2, Nome);
        stmt.setString(3, CPF);
        stmt.setString(4, Email);
        stmt.setString(5, NumCelular);
        stmt.setString(7, Senha);
        SimpleDateFormat ddd = new SimpleDateFormat("dd/MM/YYYY");
        try {
            java.util.Date data = ddd.parse(DataNasc);
            java.sql.Date datasql = new java.sql.Date(data.getTime());
            stmt.setDate(6, datasql);
        } catch (ParseException ex) {
            java.util.logging.Logger.getLogger(Medico.class.getName()).log(Level.SEVERE, null, ex);
        }
        stmt.executeUpdate();
        stmt.close();
        System.out.println("Dados Inseridos com Sucesso!");
    }

    public void Excluir(Connection con, Integer CRM) throws SQLException {
        String sql = "delete from medico where crm = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, CRM);
        stmt.executeUpdate();
        stmt.close();
    }

    public void Alterar(Connection con, Integer CRM, String Nome, String CPF, String Email, String NumCelular, String DataNasc,
            String Senha) throws  SQLException, ParseException {
        String sql = "update medico set nome =?,cpf=?,email=?,numcelular=?,datanascimento=?,senha=? where crm=?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, Nome);
        stmt.setString(2, CPF);
        stmt.setString(3, Email);
        stmt.setString(4, NumCelular);

        SimpleDateFormat ddd = new SimpleDateFormat("dd/MM/YYYY");
        java.util.Date data = ddd.parse(DataNasc);
        java.sql.Date datasql = new java.sql.Date(data.getTime());

        stmt.setDate(5, datasql);
        stmt.setString(6, Senha);
        stmt.setInt(7, CRM);
        
        stmt.executeUpdate();
        stmt.close();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Bárbara
 */
public class Prontuario {

    public boolean Inserir(Connection con, int crm, int idpaciente, String dataconsulta, String descricao) {

        String sql = "insert into consulta(crm,idpaciente, dataconsulta, descricao) values (?,?,?,?)";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, crm);
            stmt.setInt(2, idpaciente);

            //PASSAR DATA
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date data = sdf.parse(dataconsulta);
            java.sql.Date datasql = new java.sql.Date(data.getTime());
            stmt.setDate(3, datasql);

            stmt.setString(4, descricao);

            int rs = stmt.executeUpdate();

            if (rs == 0) {
                stmt.close();
                return false;
            }

            stmt.close();

        } catch (SQLException | ParseException ex) {
            System.out.println(ex.toString());
        }

        return true;

    }

    //   public void Alterar(Connection con, 
    public void Excluir(Connection con, Integer crm, Integer idpaciente, String dataconsulta) throws ParseException {
        String sql = "delete from consulta where crm = ? and idpaciente = ? and dataconsulta = ?";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
          
            stmt.setInt(1, InformacoesSistema.crm);
            stmt.setInt(2, InformacoesSistema.idpaciente);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date data = sdf.parse(dataconsulta);
            java.sql.Date datasql = new java.sql.Date(data.getTime());
            stmt.setDate(3, datasql);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            JOptionPane.showMessageDialog(null, "Algum Erro Impossibilitou a Exclusão da Consulta!", "Operação Não Realizada", 0);
        }

    }

    public void Alterar(Connection con, Integer crm, Integer idpaciente, String dataconsulta, String descricao) {
        String sql = "update consulta set descricao = ? where crm = ? and idpaciente = ? and dataconsulta=?";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date data = sdf.parse(dataconsulta);
            java.sql.Date datasql = new java.sql.Date(data.getTime());
            stmt.setString(1, descricao);
            stmt.setInt(2, InformacoesSistema.crm);
            stmt.setInt(3, InformacoesSistema.idpaciente);
            stmt.setDate(4, datasql);

            int rs = stmt.executeUpdate();

            if (rs > 0) {
                JOptionPane.showMessageDialog(null, "Dados Alterados com Sucesso", "Operação Realizada!", 1);
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao Alterar os Dados", "Operação Não Realizada!", 0);
            }

            stmt.close();

        } catch (SQLException | ParseException ex) {
            System.out.println(ex.toString());
        }
    }

}

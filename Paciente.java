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
 * @author Alana
 */
public class Paciente {

    public boolean Inserir(Connection con, String nome, String sexo, String datanascimento,
            String endereco, String telefone, String numcelular, String email) throws SQLException, ParseException {

        String sql = "insert into paciente (nome, sexo, datanascimento, endereco, telefone, numcelular, email) "
                + "values (?,?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, nome);
            stmt.setString(2, sexo);

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date data = sdf.parse(datanascimento);
            java.sql.Date datasql = new java.sql.Date(data.getTime());
            stmt.setDate(3, datasql);

            stmt.setString(4, endereco);
            stmt.setString(5, telefone);
            stmt.setString(6, numcelular);
            stmt.setString(7, email);

            int rs = stmt.executeUpdate();

            if (!(rs > 0)) {
                stmt.close();
                return false;
            }

            stmt.close();

        } catch (SQLException | ParseException ex) {
            System.out.println(ex.toString());
            return false;
        }

        return true;
    }

    public boolean Alterar(Connection con, String nome, String sexo,
            String DataNascimento, String endereco, String telefone,
            String NumCelular, String email, int id) {

        String sql = "update paciente set nome = ?, sexo = ?, datanascimento = ?, endereco = ?, telefone = ?, numcelular = ?,"
                + "email = ? where idpaciente = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, nome);
            stmt.setString(2, sexo);

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date data = sdf.parse(DataNascimento);
            java.sql.Date datasql = new java.sql.Date(data.getTime());
            stmt.setDate(3, datasql);

            stmt.setString(4, endereco);
            stmt.setString(5, telefone);
            stmt.setString(6, NumCelular);
            stmt.setString(7, email);
            stmt.setInt(8, id);

            int rs = stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Dados Alterados com Sucesso", "Operação Realizada", 1);

            stmt.close();

        } catch (SQLException | ParseException ex) {
            System.out.println(ex.toString());
            return false;
        }

        return true;
    }

    public void Excluir(Connection con, int id) {
        String sql = "delete from paciente where idpaciente = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);

            int rs = stmt.executeUpdate();

            if (rs > 0) {
                JOptionPane.showMessageDialog(null, "Dados Excluidos com Sucesso", "Operação Realizada!", 1);
            } else {
                JOptionPane.showMessageDialog(null, "Não Foi Possível Excluir os Dados", "Operação Não Realizada!", 0);
            }
            stmt.close();
        } catch (SQLException ex) {
            System.out.println(ex.toString());

        }

    }
}

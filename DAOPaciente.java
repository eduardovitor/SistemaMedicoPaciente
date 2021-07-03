/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Aluno
 */
public class DAOPaciente {
    Connection connection=null;
    PreparedStatement pstatement=null;
    ResultSet rs=null;
public int setPaciente(Paciente paciente){
    int linhasafetadas=0;
    try{
        connection=MyConnection.getConnection();
        String comandosql="insert into paciente(nome,CPF,RG,telefonecontato,codigo,endereco) values(?,?,?,?,?,?)";
        pstatement=(PreparedStatement) connection.prepareStatement(comandosql);
        pstatement.setString(1, paciente.getNome());
        pstatement.setString(2, paciente.getCPF());
        pstatement.setString(3, paciente.getRG());
        pstatement.setString(4, paciente.getTelefone_para_contato());
        pstatement.setInt(5, paciente.getCodigo());
        pstatement.setString(6, paciente.getEndereco());
        linhasafetadas=pstatement.executeUpdate();
    }catch(SQLException e){
        e.printStackTrace();
    }
    finally{
        connection=null;
        pstatement=null;
    }
    return linhasafetadas;
}
public int removerPacienteByCodigo(Integer codigo){
    int linhasafetadas=0;
    try{
    connection=MyConnection.getConnection();
    String comandosql="DELETE from paciente where codigo=?";
    pstatement=(PreparedStatement) connection.prepareStatement(comandosql);
    pstatement.setInt(1,codigo);
    linhasafetadas=pstatement.executeUpdate();
    }catch(SQLException e){
       e.printStackTrace();
    }
    finally{
        connection=null;
        pstatement=null;
    }
    return linhasafetadas;
    }
public ArrayList<Paciente> getAll(){
    ArrayList<Paciente> pacientes=new ArrayList<>();
    try{
       connection=MyConnection.getConnection();
       pstatement=(PreparedStatement) connection.prepareStatement("Select *from paciente");
       rs=pstatement.executeQuery();
       while(rs.next()){
           Paciente paciente=new Paciente();
           paciente.setNome(rs.getString("nome"));
           paciente.setCPF(rs.getString("CPF"));
           paciente.setRG(rs.getString("RG"));
           paciente.setEndereco(rs.getString("endereco"));
           paciente.setTelefone_para_contato(rs.getString("telefonecontato"));
           paciente.setCodigo(rs.getInt("codigo"));
           pacientes.add(paciente);
       }
    }catch(SQLException e){
       e.printStackTrace();
    }
    finally{
        connection=null;
        pstatement=null;
        rs=null;
    }
    return pacientes;
}
public Paciente retornarPacienteByCodigo(Integer codigo){
    Paciente paciente=new Paciente();
    try{
        connection=MyConnection.getConnection();
        pstatement=(PreparedStatement) connection.prepareStatement("select *from paciente where codigo=?");
        pstatement.setInt(1, codigo);
        rs=pstatement.executeQuery();
        if(rs.next()){
            paciente.setNome(rs.getString("nome"));
            paciente.setCPF(rs.getString("CPF"));
            paciente.setRG(rs.getString("RG"));
            paciente.setCodigo(rs.getInt("codigo"));
            paciente.setEndereco(rs.getString("endereco"));
            paciente.setTelefone_para_contato(rs.getString("telefonecontato"));
        }
    }catch(SQLException e){
        e.printStackTrace();
    }
    return paciente;
}
public boolean VerficaSeoPacienteEstaNoBanco(Paciente paciente){
    boolean verificacao=false;
    try{
        connection=MyConnection.getConnection();
        pstatement=(PreparedStatement) connection.prepareStatement("select *from paciente where codigo=?");
        pstatement.setInt(1,paciente.getCodigo());
        rs=pstatement.executeQuery();
        if(rs.next()){
            verificacao=true;
        }
    }catch(SQLException e){
     e.printStackTrace();
    }
    finally{
        connection=null;
        pstatement=null;
        rs=null;
    }
    return verificacao;
}
}


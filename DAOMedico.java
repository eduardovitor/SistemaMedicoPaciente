
package consultorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOMedico {
    Connection connection=null;
    PreparedStatement pstatement=null;
    ResultSet rs=null;
    
public int setMedico(Medico medico){
  int linhasafetadas=0;  
    try{
        connection=MyConnection.getConnection();
        String comandosql="insert into medico(CRM, nome, salario, datadeadmissao) values (?,?,?,?)";
        pstatement=connection.prepareStatement(comandosql);
        pstatement.setString(1, medico.getCRM());
        pstatement.setString(2, medico.getNome());
        pstatement.setDouble(3, medico.getSalario());
        pstatement.setString(4, medico.getData_de_admissao());
        linhasafetadas=pstatement.executeUpdate();
    } catch(SQLException e){
        e.printStackTrace();
    }
    finally{
        connection=null;
        pstatement=null;
    }
    return linhasafetadas;     
   }
public int removerMedicoByCRM(String CRM){
    int linhasafetadas=0;
    try{
        connection=MyConnection.getConnection();
        String comandosql="DELETE from medico where CRM=?";
        pstatement=connection.prepareStatement(comandosql);
        pstatement.setString(1, CRM);
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
public Medico retornarMedicoByCRM(String CRM){
    Medico medico=new Medico();
    try{
        connection=MyConnection.getConnection();
        String comandosql="Select *from medico where CRM=?";
        pstatement=connection.prepareStatement(comandosql);
        pstatement.setString(1, CRM);
        rs=pstatement.executeQuery();
        if(rs.next()){
            medico.setCRM(rs.getString("CRM"));
            medico.setData_de_admissao(rs.getString("datadeadmissao"));
            medico.setNome(rs.getString("nome"));
            medico.setSalario(rs.getFloat("salario"));
        }
    }catch(SQLException e){
        e.printStackTrace();
    }
    finally {
        connection=null;
        pstatement=null;
        rs=null;
    }
    return medico;
}
public ArrayList<Medico> getAll(){
    ArrayList<Medico> medicos=new ArrayList<>();
    try{
        connection=MyConnection.getConnection();
        String comandosql="Select *from medico";
        pstatement=connection.prepareStatement(comandosql);
        rs=pstatement.executeQuery();
        while(rs.next()){
            Medico medico=new Medico();
            medico.setCRM(rs.getString("CRM"));
            medico.setData_de_admissao(rs.getString("datadeadmissao"));
            medico.setNome(rs.getString("nome"));
            medico.setSalario(rs.getFloat("salario"));
            medicos.add(medico);
        }
    }catch(SQLException e){
     e.printStackTrace();
    }
    finally{
        connection=null;
        pstatement=null;
        rs=null;
    }
    return medicos;
}
public boolean VerficaSeoMedicoEstaNoBanco(Medico medico){
    boolean verificacao=false;
    try{
        connection=MyConnection.getConnection();
        pstatement=connection.prepareStatement("select *from medico where CRM=?");
        pstatement.setString(1, medico.getCRM());
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

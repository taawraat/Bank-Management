package finalproject;
import java.sql.*;

public class DBoperation {
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public void ConnectDB(){
        conn = DBconnect.ConnectDB();
    }
    
    public void DisconnectDB(){
        try{
            conn.close();
            System.out.println("DB closed!");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void InsertToDB(String cmd){
        try{
            pst = conn.prepareStatement(cmd);
            pst.execute();
        } catch(Exception e){
            System.out.println(e);
        }
    }
    
    public boolean EmailExists(String email){
        String cmd = "Select Email from Users where Email = \""+ email +"\"";
        
        try{
            pst = conn.prepareStatement(cmd);
            rs = pst.executeQuery();
            
            return rs.next();
        } catch(Exception e){
            System.out.println(e);
        }
        return false;
    }
    
    public boolean AccountExists(String acc_no, String curr_user){
        String cmd = "Select Acc_no from \""+ curr_user +"\" where Acc_no = \""+ acc_no +"\"";
        
        try{
            pst = conn.prepareStatement(cmd);
            rs = pst.executeQuery();
            
            return rs.next();
        } catch(Exception e){
            System.out.println(e);
        }
        return false;
    }
    
    public boolean ValidUser(String userPassword, String email){
        String cmd = "Select Password from Users where Email = \"" + email + "\"";
        
        try{
            pst = conn.prepareStatement(cmd);
            rs = pst.executeQuery();
            
            String password = rs.getString(1);            
            if(password.equals(userPassword))
                   return true;
            
        } catch(Exception e){
            System.out.println(e);
        }
        
        return false;
    }
    
    public void CreateTable(String email){
        String cmd = "Create Table \""+ email + "\" (\"Acc_no\", \"Name\", \"BankName\", \"BankAddress\", \"BankContact\", \"TotalAmount\", \"LastUpdate\")";
        
        try{
            pst = conn.prepareStatement(cmd);
            pst.execute();
        } catch(Exception e){
            System.out.println(e);
        }
        
    }
    
    public ResultSet FetchTable(String email){
        String cmd = "Select \"Acc_no\",\"Name\" from \"" + email +"\"";
        try{
            pst = conn.prepareStatement(cmd);
            rs = pst.executeQuery();
        } catch(Exception e){
            System.out.println(e);
        }
        
        return rs;
    }
    
    public ResultSet FetchTable(String email, String acc_no){
        String cmd = "Select \"Acc_no\",\"Name\" from \"" + email +"\" where Acc_no = \""+ acc_no +"\"";
        try{
            pst = conn.prepareStatement(cmd);
            rs = pst.executeQuery();
        } catch(Exception e){
            System.out.println(e);
        }
        
        return rs;
    }
    
    public ResultSet FetchAll(String email){
        String cmd = "Select * from \"" + email +"\"";
        try{
            pst = conn.prepareStatement(cmd);
            rs = pst.executeQuery();
        } catch(Exception e){
            System.out.println(e);
        }
        
        return rs;
    }
    
    public ResultSet FetchAll(String email, String acc_no){
        String cmd = "Select * from \"" + email +"\" where Acc_no = \""+ acc_no+"\"";
        try{
            pst = conn.prepareStatement(cmd);
            rs = pst.executeQuery();
        } catch(Exception e){
            System.out.println(e);
        }
        
        return rs;
    }
    
    public void UpdateToDb(String cmd){
        try{
            pst = conn.prepareStatement(cmd);
            pst.execute();
        } catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void DeleteFromDB(String cmd){
        try{
            pst = conn.prepareStatement(cmd);
            pst.execute();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}

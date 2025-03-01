/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.UsersDTO;
import mylib.DBUtils;

/**
 *
 * @author Quoc Bao
 */
public class UsersDAO {

    public UsersDTO checkLogin(String email, String password) {
        UsersDTO rs = null;
        Connection cn = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "SELECT username, userId, dateOfBirth, isAdmin, isBlocked\n"
                        + "FROM users\n"
                        + "WHERE email = ? AND password = ?";
                PreparedStatement st = cn.prepareStatement(sql);
                st.setString(1, email);
                st.setString(2, password);
                ResultSet table = st.executeQuery();
                if(table != null){
                    while(table.next()){
                        String username = table.getString("username");
                        String userId = table.getString("userId");
                        String dob = table.getDate("dateOfBirth") + "";
                        int isAdmin = table.getInt("isAdmin");
                        int isBlocked = table.getInt("isBlocked");
                        rs = new UsersDTO(username, password, userId, email, dob, isAdmin, isBlocked);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try{
                if(cn != null) cn.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return rs;
    }
    
}

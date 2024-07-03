package com.app.coffee.Backend.DAO;

import com.app.coffee.Backend.Connect.ConnectionCoffee;
import com.app.coffee.Backend.Model.Role;
import com.app.coffee.Backend.Model.UsersModel;
import com.app.coffee.Database.PasswordUtils;
import static com.app.coffee.Database.PasswordUtils.hashPassword;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAO implements DAOInterface<UsersModel> {

    public static UserDAO getInstance() {
        return new UserDAO();
    }
    
    @Override
    public int Create(UsersModel t) {
        try (Connection conn = ConnectionCoffee.getConnection()) {
            String sql = "INSERT INTO account (username, password, phone,role_id, email, status) VALUES (?, ?, ?, ?, ?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            String hashedPassword = hashPassword(t.getPassword());
            ps.setString(1, t.getUserName());
            ps.setString(2, hashedPassword);
            ps.setString(3, t.getPhone());
            ps.setInt(4,t.getRole().getRole_id());
            ps.setString(5,t.getEmail());          
            ps.setInt(6,t.getStatus());

            int results = ps.executeUpdate();
            System.out.println("Successfully created user: " + t);

            ps.close();
            ConnectionCoffee.closeConnection(conn);

            return results;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int Update(UsersModel t) {
        try (Connection conn = ConnectionCoffee.getConnection()) {
            String sql = "UPDATE account SET username=?, password=?, phone=?, email=?, status=? WHERE account_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            String hashedPassword = PasswordUtils.hashPassword(t.getPassword());
            ps.setString(1, t.getUserName());
            ps.setString(2, hashedPassword);
            ps.setString(3, t.getPhone());
            ps.setString(4, t.getEmail());
            ps.setInt(5, t.getStatus());
            ps.setInt(6, t.getAccount_id());

            int results = ps.executeUpdate();
            System.out.println("Successfully updated user with ID " + t.getAccount_id());

            ps.close();
            ConnectionCoffee.closeConnection(conn);

            return results;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int Delete(UsersModel t) {
        try (Connection conn = ConnectionCoffee.getConnection()) {
            String sql = "DELETE FROM account WHERE account_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, t.getAccount_id());

            int results = ps.executeUpdate();
            System.out.println("Successfully deleted user with ID " + t.getAccount_id());

            ps.close();
            ConnectionCoffee.closeConnection(conn);

            return results;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public ArrayList<UsersModel> selectAll() {
    ArrayList<UsersModel> listUser = new ArrayList<>();
    try (Connection conn = ConnectionCoffee.getConnection()) {
        String sql = "SELECT a.account_id, a.username, a.image,a.password, a.phone, a.role_id, r.name as role_name, a.status, a.email " +
                     "FROM account a " +
                     "JOIN role r ON a.role_id = r.role_id";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            UsersModel user = new UsersModel(
                rs.getInt("account_id"),
                rs.getString("username"),
                rs.getString("image"),
                rs.getString("password"),
                rs.getString("phone"),
                new Role(rs.getInt("role_id"), rs.getString("role_name")), 
                rs.getInt("status"),
                rs.getString("email")
            );
            listUser.add(user);
        }
        rs.close();
        ps.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return listUser;
}

    public boolean checkEmailExists(String email) {
        String sql = "SELECT COUNT(*) FROM account WHERE email = ?";
        try (Connection conn = ConnectionCoffee.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    
    }

    public UsersModel selectById(int userId) {
    UsersModel user = null;
    String sql = "SELECT * FROM account WHERE account_id = ?";
    try (Connection conn = ConnectionCoffee.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, userId);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            user = new UsersModel(
                rs.getInt("account_id"),
                rs.getString("username"),
                rs.getString("image"),
                rs.getString("password"),
                rs.getString("phone"),
                new Role(rs.getInt("role_id"), "role_name"), 
                rs.getInt("status"),
                rs.getString("email")
            );
        }
        rs.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return user;
}
    
     public int DeleteByStatus(int userId) {
    try (Connection conn = ConnectionCoffee.getConnection();
         PreparedStatement ps = conn.prepareStatement("DELETE FROM account WHERE account_id =?")) {
        
        ps.setInt(1, userId);
        
        int results = ps.executeUpdate();
        
        return results;
        
    } catch (SQLException e) {
        e.printStackTrace();
       
    } catch (Exception e) {
        e.printStackTrace();
       
    }
    return 0;
}

    @Override
    public ArrayList<UsersModel> selectByCondition(String condition) {
         ArrayList<UsersModel> listUser = new ArrayList<>();
         return listUser;
         
    }

    @Override
    public UsersModel selectById(UsersModel t) {
        UsersModel user = null;
        return user;
    }

    @Override
    public boolean deleteAccount(int userId) {
        String sql = "UPDATE Account SET status = 0 WHERE account_id = ?";
        try (Connection connection = ConnectionCoffee.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, userId);
            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean restoreAccount(int userId) {
        String sql = "UPDATE Account SET status = 1 WHERE account_id = ?";
        try (Connection connection = ConnectionCoffee.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, userId);
            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    
    
    public class RoleDAO {

    public static List<Role> getAllRoles() {
        List<Role> roles = new ArrayList<>();
        
        roles.add(new Role(1, "Admin"));
        roles.add(new Role(2, "Manager"));
        roles.add(new Role(3, "Staff"));
        return roles;
    }
    
   

  
    
    public boolean checkEmailExists(String email) {
        String sql = "SELECT COUNT(*) FROM account WHERE email = ?";
        try (Connection conn = ConnectionCoffee.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
            return false;
    }
   
    }
} 



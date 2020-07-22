package ledzepelin.calihotel.application.dao;

import ledzepelin.calihotel.application.entity.User;

import java.sql.*;

public class UserDaoImpl implements UserDao {
    @Override
    public void insert(User user) {
        String sql = "INSERT INTO Users(full_name, user_name, encrypted_password, email, permission, salt) VALUES(?,?,?,?,?,?)";
        try (Connection conn = DBUtil.connect();
             PreparedStatement pstmt  = conn.prepareStatement(sql);) {
            pstmt.setString(1,user.getFullName());
            pstmt.setString(2,user.getUserName());
            pstmt.setString(3,user.getEncryptedPassword());
            pstmt.setString(4,user.getEmail());
            pstmt.setInt(5,user.getPermission());
            pstmt.setString(6,user.getSalt());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public User getUserByUserName(String userName) {
        String sql = "SELECT * FROM Users WHERE user_name = ?";
        try (Connection conn = DBUtil.connect();
             PreparedStatement pstmt  = conn.prepareStatement(sql);) {
            pstmt.setString(1,userName);
            ResultSet rs  = pstmt.executeQuery();

            if (rs.next()) {
                String encrypted_password = rs.getString("encrypted_password");
                int permission = rs.getInt("permission");
                String salt = rs.getString("salt");
                User user = new User();
                user.setUserName(userName);
                user.setEncryptedPassword(encrypted_password);
                user.setPermission(permission);
                user.setSalt(salt);
                return user;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}

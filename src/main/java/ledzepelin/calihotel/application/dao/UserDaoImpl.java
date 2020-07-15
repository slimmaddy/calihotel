package ledzepelin.calihotel.application.dao;

import ledzepelin.calihotel.application.entity.User;

import java.sql.*;

public class UserDaoImpl implements UserDao {
    @Override
    public boolean signIn(User user) {
        // TODO: Encrypt password before query.
        String sql = "SELECT * FROM Users WHERE user_name = ? AND password = ?";
        try (Connection conn = DBUtil.connect();
             PreparedStatement pstmt  = conn.prepareStatement(sql);) {
            pstmt.setString(1,user.getUserName());
            pstmt.setString(2,user.getPassword());
            ResultSet rs  = pstmt.executeQuery();

            if (!rs.next()) {
                return false;
            } else {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public void signUp(User user) {

    }
}

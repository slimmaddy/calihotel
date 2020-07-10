package ledzepelin.calihotel.application.dao;

import ledzepelin.calihotel.application.entity.Guest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GuestDaoImpl implements GuestDao {
    @Override
    public void insert(Guest guest) {
        String sql = "INSERT INTO guest(full_name, sex, email) VALUES(?,?,?)";
        try (Connection conn = DBUtil.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, guest.getFullName());
            pstmt.setString(2, guest.getSex());
            pstmt.setString(3, guest.getEmail());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteById(int id) {

    }
}

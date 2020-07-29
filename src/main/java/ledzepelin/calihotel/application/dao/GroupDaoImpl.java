package ledzepelin.calihotel.application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import ledzepelin.calihotel.application.entity.Group;

public class GroupDaoImpl implements GroupDao {
	@Override
	public void insert(Group group) {
		String sql = "INSERT INTO group(group_id, group_name, travel_agency, booker, price, payment_method, comment, arrival, departure, days, status) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		try (Connection conn = DBUtil.connect(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, group.getGroupId());
			pstmt.setString(2, group.getGroupName());
			pstmt.setString(3, group.getTravelAgency());
			pstmt.setInt(4, group.getBooker());
			pstmt.setBigDecimal(5, group.getPrice());

			pstmt.setString(6, group.getPaymentMethod());
			pstmt.setString(7, group.getComment());
			pstmt.setDate(8, java.sql.Date.valueOf(group.getArrival()));
			pstmt.setDate(9, java.sql.Date.valueOf(group.getDeparture()));
			pstmt.setInt(10, group.getDays());
			pstmt.setString(11, group.getStatus());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public List<Group> getGroups() {
		return null;
	}
}
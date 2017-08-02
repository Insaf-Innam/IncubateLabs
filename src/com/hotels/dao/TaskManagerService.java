package com.hotels.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hotels.springservice.domain.*;
import com.hotels.springservice.utility.DBUtility;

public class TaskManagerService {

	private Connection connection;

	public TaskManagerService() {
		connection = DBUtility.getConnection();
	}

	public Hotel addHotel(Hotel hotel) {
		try {
			Statement statement2 = connection.createStatement();
			PreparedStatement preparedStatement = connection.prepareStatement("insert into hotel(name) values (?)");
			preparedStatement.setString(1, hotel.getName());
			int id = 0;
			ResultSet rs = statement2.executeQuery("SELECT MAX(id) FROM hotel");
			while (rs.next()) {
				id = rs.getInt(1);
			}
			PreparedStatement preparedStatement2 = connection
					.prepareStatement("insert into address(no,street,city,hotel_id) values (?,?,?,?)");
			preparedStatement2.setInt(1, hotel.getNo());
			preparedStatement2.setString(2, hotel.getStreet());
			preparedStatement2.setString(3, hotel.getCity());
			preparedStatement2.setInt(4, id + 1);
			preparedStatement.executeUpdate();

			preparedStatement2.executeUpdate();
			// id = 0;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return hotel;

	}

	public List<Hotel> getAllHotels() {
		List<Hotel> hotelList = new ArrayList<Hotel>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from hotel");
			while (rs.next()) {
				int hotelId = rs.getInt("id");
				Hotel hotel = new Hotel();
				hotel.setId(hotelId);
				hotel.setName(rs.getString("name"));
				Statement statement2 = connection.createStatement();
				ResultSet rs2 = statement2.executeQuery("select * from address where hotel_id='" + hotelId + "'");
				while (rs2.next()) {
					hotel.setNo(rs2.getInt("no"));
					hotel.setStreet(rs2.getString("street"));
					hotel.setCity(rs2.getString("city"));
				}
				hotelList.add(hotel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return hotelList;
	}

	public List<Hotel> searchHotelsByCity(String city) {
		List<Hotel> hotelList = new ArrayList<Hotel>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from hotel where name like '%" + city + "%'");
			while (rs.next()) {

				int hotelId = rs.getInt("id");

				Hotel hotel = new Hotel();

				hotel.setId(hotelId);

				hotel.setName(rs.getString("name"));

				Statement statement2 = connection.createStatement();
				ResultSet rs2 = statement2.executeQuery("select * from address where hotel_id='" + hotelId + "'");
				while (rs2.next()) {
					hotel.setNo(rs2.getInt("no"));
					hotel.setStreet(rs2.getString("street"));
					hotel.setCity(rs2.getString("city"));
				}
				hotelList.add(hotel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return hotelList;
	}

}
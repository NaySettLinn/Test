package spring.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import spring.dto.UserDTO;

public class UserRepository {
	
	public int insertUser(UserDTO dto) {
		int i=0;
		Connection con=MyConnection.getConnection();
		
		try {
			PreparedStatement ps=con.prepareStatement("INSERT INTO user (name,email,password) values(?,?,?)");
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getEmail());
			ps.setString(3, dto.getPassword());
			i=ps.executeUpdate();
			
		}catch(SQLException e){
			
			System.out.println("User Insert :"+ e.getMessage());
		}
		return i;
	}
	
	public List<UserDTO> showAllUser(){
		List<UserDTO> userlist = new ArrayList<>();
		Connection con = MyConnection.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("SELECT * FROM user");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				UserDTO dto = new UserDTO();
				dto.setId(rs.getInt("id"));
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
				dto.setPassword(rs.getString("password"));
				
				userlist.add(dto);
				
			    }
			}catch(SQLException e) {
				System.out.println("show all error "+ e);
			}
		return userlist;
		}
	}


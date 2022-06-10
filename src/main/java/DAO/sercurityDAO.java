package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Context.ConnectionProvider;
import entity.Sercurity;

public class sercurityDAO {
	public List<Sercurity> getAllSercurity(){
		List<Sercurity> question = new ArrayList<Sercurity>();
		try {
			String query = "select * from Sercurity";
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Sercurity row = new Sercurity();
				row.setQuestionId(rs.getInt("questionID"));
				row.setQuestion(rs.getString("question"));
				question.add(row);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return question;
	}
	public String InsertNewSercurity(String question) {
		String result ="";
		try {
			String query="insert into sercurity(question) value (?)";
			ConnectionProvider con = new ConnectionProvider();
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			pst.setString(1, question);
			pst.executeUpdate();
			result ="successfully";
		}catch(Exception e) {
			e.printStackTrace();
			result ="failed";
		}
		return result;
	}
	public String DeleteSercurityById(String id ) {
		String result="";
		ConnectionProvider con = new ConnectionProvider();
		try {
			String turnOff = "SET FOREIGN_KEY_CHECKS = 0";
			PreparedStatement pstOff = con.getConnection().prepareStatement(turnOff);
			pstOff.executeUpdate();
			String query="delete from sercurity where questionID = ?";
			PreparedStatement pst = con.getConnection().prepareStatement(query);
			pst.setString(1, id);
			pst.executeUpdate();
			String turnOn = "SET FOREIGN_KEY_CHECKS = 1";
			PreparedStatement pstOn = con.getConnection().prepareStatement(turnOff);
			pstOn.executeUpdate();
			result ="successfully";
		}catch(Exception e) {
			e.printStackTrace();
			result = "failed";
		}
		return result;
	}
}

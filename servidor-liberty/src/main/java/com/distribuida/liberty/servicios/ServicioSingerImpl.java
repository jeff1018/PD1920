package com.distribuida.liberty.servicios;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.sql.DataSource;

import com.distribuida.liberty.dto.Singer;

@ApplicationScoped
public class ServicioSingerImpl implements ServicioSinger {
	
	private final String SQL_INSERT = "INSERT INTO singer (id, first_name, last_name, birth_date) values (?, ?, ?, ?)";
	private final String SQL_FIND = "SELECT id, first_name, last_name,birth_date FROM singer WHERE id = ?";
	private final String SQL_SELECT = "SELECT * FROM singer ORDER BY id";    
	private final String SQL_UPDATE = "UPDATE singer SET first_name = ?, last_name = ?, birth_date = ? WHERE id = ?";
	private final String SQL_DELETE = "DELETE from singer where id=?";
	
	@Inject private DataSource dss;	

	@Override
	public void crear(Singer singer) {
		
		Connection conn = null;
		PreparedStatement sta = null;
		System.out.print("Acceso a crear....");
		try {
			conn = dss.getConnection();
			sta = conn.prepareStatement(SQL_INSERT);
			sta.setInt(1, singer.getId());
			sta.setString(2, singer.getFirstName());
			sta.setString(3, singer.getLastName());
			java.util.Date utilDate = singer.getBirthDate();
			java.sql.Date fechaFinal = new java.sql.Date(utilDate.getTime());			
			sta.setDate(4, fechaFinal);
			sta.execute();
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		} 
	}
		
	@Override
	public void editar(Singer singer, int id) {
		try {
			Connection con = dss.getConnection();
			PreparedStatement pst = con.prepareStatement(SQL_UPDATE);
			int index=1;
			pst.setInt( 4, id );
			pst.setString(1, singer.getFirstName());
			pst.setString(2, singer.getLastName());
			java.util.Date utilDate = singer.getBirthDate();
			java.sql.Date fechaFinal = new java.sql.Date(utilDate.getTime());
			pst.setDate(3,  fechaFinal);
			pst.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void eliminar(Integer id) {
		Connection con = null;
    	PreparedStatement st=null;
        try{
        	ResultSet rs = null;
			 con = dss.getConnection();
			 st = con.prepareStatement(SQL_DELETE);
			 st.setInt(1, id);
			 rs = st.executeQuery(); 	
        	
        }catch(Exception e){
            e.printStackTrace();
        }finally {
    		}	
	}

	@Override
	public List<Singer> listar() {
		Connection con = null;
    	PreparedStatement st=null;
			List<Singer> singerlist = new ArrayList<Singer>();
			try {
				ResultSet rs = null;
				 con = dss.getConnection();
				 st = con.prepareStatement(SQL_SELECT);
				rs = st.executeQuery();
				while (rs.next()) {
					int id = rs.getInt("id");
					String firstName = rs.getString("first_name");
					String lastName = rs.getString("last_name");
					Date birthDate = rs.getDate("birth_date");
					Singer singer = new Singer();
					singer.setId(id);
					singer.setFirstName(firstName);
					singer.setLastName(lastName);
					singer.setBirthDate(birthDate);
					singerlist.add(singer);
				}
				return singerlist;
			} catch (SQLException ex) {
				ex.printStackTrace();
			} finally {  		
	    	}
			return singerlist;
	}

	@Override
	public Singer buscarPorId(Integer id) {
		Singer singer = new Singer();
		try {
			Connection con = dss.getConnection();
			PreparedStatement pst = con.prepareStatement(SQL_FIND);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				singer.setId(rs.getInt(1));
				singer.setBirthDate(rs.getDate(2));
				singer.setFirstName(rs.getString(3));
				singer.setLastName(rs.getString(4));
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return singer;
	}

}

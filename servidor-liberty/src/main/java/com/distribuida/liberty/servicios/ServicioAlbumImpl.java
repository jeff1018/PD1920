package com.distribuida.liberty.servicios;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.sql.DataSource;

import com.distribuida.liberty.dto.Album;


@ApplicationScoped
public class ServicioAlbumImpl implements ServicioAlbum{
	
	private final String SQL_INSERT = "INSERT INTO album (id, singer_id, title, release_date) values (?, ?, ?, ?)";
	private final String SQL_FIND = "SELECT a.id,a.singer_id,a.title,a.release_date,s.first_name,s.last_name,s.birth_date FROM album a,singer s WHERE a.singer_id=s.id and a.id = ?";
	private final String SQL_SELECT = "SELECT * FROM album ORDER BY id";    
	private final String SQL_UPDATE = "UPDATE album SET singer_id = ?, title = ?, release_date = ? WHERE id = ?";
	private final String SQL_DELETE = "DELETE from album where id=?";
	
	@Inject private DataSource dss;
	private PreparedStatement pst;
		
	@Override
	public void crear(Album album) {
		Connection con = null;
		PreparedStatement sta = null;
		System.out.print("ACceso al metodo");
		try {
			con = dss.getConnection();
			pst = con.prepareStatement(SQL_INSERT);
			pst.setInt(1, album.getId());
			pst.setInt(2, album.getSingerId());
			pst.setString(3, album.getTitle());
			java.util.Date utilDate = album.getReleaseDate();
			java.sql.Date fechaFinal = new java.sql.Date(utilDate.getTime());			
			pst.setDate(4,  fechaFinal);
			pst.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void editar(Album album, int id) {
		try {
			Connection con = dss.getConnection();
			pst = con.prepareStatement(SQL_UPDATE);
			pst.setInt(4, id);
			pst.setInt(1, album.getSingerId());
			pst.setString(2, album.getTitle());
			java.util.Date utilDate = album.getReleaseDate();
			java.sql.Date fechaFinal = new java.sql.Date(utilDate.getTime());			
			pst.setDate(3,fechaFinal);
			pst.executeQuery();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void eliminar(Integer id) {
		Connection con = null;
    	PreparedStatement st=null;
		try {
			con = dss.getConnection();
			pst = con.prepareStatement(SQL_DELETE);
			pst.setInt(1, id);
			pst.executeQuery();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Album> listar() {
		Connection con = null;
    	PreparedStatement st=null;
		List<Album> albumsList = new ArrayList<Album>();
		try {
			ResultSet rs = null;
			con = dss.getConnection();
			pst = con.prepareStatement(SQL_SELECT);
			rs = pst.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				int singerid = rs.getInt("singer_id");
				String title = rs.getString("title");
				Date releaseDate = rs.getDate("release_date");
				Album album = new Album();
				album.setId(id);
				album.setSingerId(singerid);
				album.setTitle(title);
				album.setReleaseDate(releaseDate); 	
				albumsList.add(album);
			}
			return albumsList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return albumsList;
	}

	@Override
	public Album buscarPorId(Integer id) {
		Album album = new Album();
		try {
			Connection con = dss.getConnection();
			pst = con.prepareStatement(SQL_FIND);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				album.setId(rs.getInt(1));
				album.setSingerId(rs.getInt(2));
				album.setReleaseDate(rs.getDate(3));
				album.setTitle(rs.getString(4));
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return album;
	}
}

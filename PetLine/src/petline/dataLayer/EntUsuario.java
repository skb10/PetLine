package petline.dataLayer;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import petline.util.ConnectionManager;
import petline.util.HashGenerator;
import petline.valueObject.Usuario;




public class EntUsuario {
	/**
	 * 
	 * @param user
	 * @param pass
	 * @return
	 */
	public boolean isUserValid(String user, String pass) {

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		boolean isValidUser = false;
		try {
			con = ConnectionManager.getConnection();

			StringBuffer query = new StringBuffer();
			query.append( "select * from usuario where UserId=? and Password=?" );

			stmt = con.prepareStatement(query.toString());

			stmt.setString(1, user);
			stmt.setString(2, HashGenerator.convert(pass));
			
			rs = stmt.executeQuery();

			isValidUser = rs.next();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		    if (rs != null) {
		        try {
		            rs.close();
		        } catch (SQLException e) {}
		    }
		    if (stmt != null) {
		        try {
		        	stmt.close();
		        } catch (SQLException e) {}
		    }
		    if (con != null) {
		        try {
		            con.close();
		        } catch (SQLException e) {}
		    }
		}
		return isValidUser;
	}
	/**
	 * 
	 * @param user
	 * @param pass
	 * @return
	 */
	public Usuario getUsuario(String user, String pass) {

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Usuario usuario = null;
		try {
			con = ConnectionManager.getConnection();

			StringBuffer query = new StringBuffer();
			query.append( 	"	select IdUsuario, Nombre, Apellido, CorreoElectronico, UserId from usuario" +
							"	where UserId=? and Password=?" );

			stmt = con.prepareStatement(query.toString());

			stmt.setString(1, user);
			stmt.setString(2, HashGenerator.convert(pass));
			
			rs = stmt.executeQuery();

			if(rs.next()){
				usuario = new Usuario();
				usuario.setIdUsuario(rs.getInt(1));
				usuario.setNombre(rs.getString(2));
				usuario.setApellido(rs.getString(3));
				usuario.setMail(rs.getString(4));
				usuario.setUserId(rs.getString(5));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		    if (rs != null) {
		        try {
		            rs.close();
		        } catch (SQLException e) {}
		    }
		    if (stmt != null) {
		        try {
		        	stmt.close();
		        } catch (SQLException e) {}
		    }
		    if (con != null) {
		        try {
		            con.close();
		        } catch (SQLException e) {}
		    }
		}
		return usuario;
	}
	/**
	 * 
	 * @param idUsuario
	 * @return
	 */
	public Usuario getUsuarioPorId(int idUsuario) {

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Usuario usuario = null;
		try {
			con = ConnectionManager.getConnection();

			StringBuffer query = new StringBuffer();
			query.append( 	"	select IdUsuario, Nombre, Apellido, CorreoElectronico, UserId from usuario" +
							"	where IdUsuario=?" );

			stmt = con.prepareStatement(query.toString());

			stmt.setInt(1, idUsuario);
			
			rs = stmt.executeQuery();

			if(rs.next()){
				usuario = new Usuario();
				usuario.setIdUsuario(rs.getInt(1));
				usuario.setNombre(rs.getString(2));
				usuario.setApellido(rs.getString(3));
				usuario.setMail(rs.getString(4));
				usuario.setUserId(rs.getString(5));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		    if (rs != null) {
		        try {
		            rs.close();
		        } catch (SQLException e) {}
		    }
		    if (stmt != null) {
		        try {
		        	stmt.close();
		        } catch (SQLException e) {}
		    }
		    if (con != null) {
		        try {
		            con.close();
		        } catch (SQLException e) {}
		    }
		}
		return usuario;
	}	
	/**
	 * 
	 * @param userId
	 * @return
	 */
	public Usuario getUsuarioPorAlias(String userId) {

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Usuario usuario = null;
		try {
			con = ConnectionManager.getConnection();

			StringBuffer query = new StringBuffer();
			query.append( 	"	select IdUsuario, Nombre, Apellido, CorreoElectronico, UserId from usuario" +
							"	where UserId=?" );

			stmt = con.prepareStatement(query.toString());

			stmt.setString(1, userId);
			
			rs = stmt.executeQuery();

			if(rs.next()){
				usuario = new Usuario();
				usuario.setIdUsuario(rs.getInt(1));
				usuario.setNombre(rs.getString(2));
				usuario.setApellido(rs.getString(3));
				usuario.setMail(rs.getString(4));
				usuario.setUserId(rs.getString(5));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		    if (rs != null) {
		        try {
		            rs.close();
		        } catch (SQLException e) {}
		    }
		    if (stmt != null) {
		        try {
		        	stmt.close();
		        } catch (SQLException e) {}
		    }
		    if (con != null) {
		        try {
		            con.close();
		        } catch (SQLException e) {}
		    }
		}
		return usuario;
	}		
	/**
	 * 
	 * @param usuario
	 * @throws SQLException
	 */
	public void updateUsuario( Usuario usuario ) throws SQLException{
		Connection con = null;
		PreparedStatement stmt = null;
	
		try {
			con = ConnectionManager.getConnection();

			StringBuffer query = new StringBuffer();
			query.append( 	"	update usuario set Nombre = ?, Apellido = ?, CorreoElectronico = ? " +
							"	where IdUsuario = ?" );

			stmt = con.prepareStatement(query.toString());

			stmt.setString(1, usuario.getNombre());
			stmt.setString(2, usuario.getApellido());
			stmt.setString(3, usuario.getMail());
			stmt.setInt(4, usuario.getIdUsuario());
			
			stmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;			
		} finally {
		    if (stmt != null) {
		        try {
		        	stmt.close();
		        } catch (SQLException e) {}
		    }
		    if (con != null) {
		        try {
		            con.close();
		        } catch (SQLException e) {}
		    }
		}
	}	
	/**
	 * 
	 * @param usuario
	 * @param telefono
	 * @param idBox
	 * @throws SQLException
	 */
	public void registerUsuario( Usuario usuario, String telefono, int idBox ) throws SQLException{
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ConnectionManager.getConnection();

			con.setAutoCommit(false);
			
			stmt = con.prepareStatement(" select IFNULL(max(IdUsuario),0)+1 from usuario");
			
			rs = stmt.executeQuery();
			
			rs.next();
			
			int idUsuario = rs.getInt(1); 
			
			stmt.clearParameters();
			
			stmt.close();
			
			stmt = con.prepareStatement(" insert into usuario (IdUsuario, Nombre, Apellido, CorreoElectronico, Password, UserId) " +
										" values (?, ?, ?, ?, ?, ?); ");
			
			stmt.setInt(1, idUsuario);
			stmt.setString(2, usuario.getNombre());
			stmt.setString(3, usuario.getApellido());
			stmt.setString(4, usuario.getMail());
			stmt.setString(5, usuario.getPass());
			stmt.setString(6, usuario.getUserId());
						
			stmt.execute();
			
			stmt.clearParameters();
			
			stmt.close();
			
			stmt = con.prepareStatement(" insert into telefono (Nro, IdUsuario, Descripcion) values (?, ?, ?); ");
			
			stmt.setString(1, telefono);
			stmt.setInt(2, idUsuario);
			stmt.setString(3, usuario.getNombre());
				
			stmt.execute();
			
			stmt.clearParameters();
			
			stmt.close();
			
			stmt = con.prepareStatement( " insert into usuariobox (idusuariobox, idusuario, idbox) " +
										" select IFNULL(max(idusuariobox),0)+1, ?, ? from usuariobox;");
			
			stmt.setInt(1, idUsuario);
			stmt.setInt(2, idBox);
			
			stmt.execute();

			con.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;			
		} finally {
		    if (stmt != null) {
		        try {
		        	stmt.close();
		        } catch (SQLException e) {}
		    }
		    if (con != null) {
		        try {
		            con.close();
		        } catch (SQLException e) {}
		    }
		}
	}		
	
}

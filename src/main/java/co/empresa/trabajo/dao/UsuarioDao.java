package co.empresa.trabajo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.empresa.trabajo.modelo.User;
import co.empresa.trabajo.utilidades.Conexion;

public class UsuarioDao {

	private Conexion conexion;
	private static final String INSERT_USER_SQL = "INSERT INTO users(nombre, email, pais) VALUES (?, ?, ?);";
	private static final String DELETE_USER_SQL = "DELETE FROM users WHERE id = ?;";
	private static final String UPDATE_USER_SQL = "UPDATE users SET nombre = ?, email = ?, pais = ? WHERE id = ?;";
	private static final String SELECT_USER_BY_ID = "SELECT * FROM users WHERE id = ?;";
	private static final String SELECT_ALL_USERS = "SELECT * FROM users;";

	public UsuarioDao() {

		this.conexion = Conexion.getConexion();
	}

	public void insert(User user) throws SQLException {

		try {
			PreparedStatement preparedStatement = (PreparedStatement)conexion.setPreparedStatement(INSERT_USER_SQL);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPass());
			preparedStatement.setString(3, user.getEmail());
			conexion.execute();
		} catch (SQLException e) {

		}
	}

	public void delete(int id) throws SQLException {

		try {
			PreparedStatement preparedStatement = (PreparedStatement)conexion.setPreparedStatement(DELETE_USER_SQL);
			preparedStatement.setInt(1, id);
			conexion.execute();
		} catch (SQLException e) {

		}
	}

	public void update(User user) throws SQLException {


		try {
			PreparedStatement preparedStatement = (PreparedStatement)conexion.setPreparedStatement(UPDATE_USER_SQL);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(3, user.getPass());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setInt(4, user.getId());
			conexion.execute();		
			} catch (SQLException e)
			
		{
				System.out.println(e.getMessage());
		}

	}

	public List<User> selectAll() {

		List<User> users = new ArrayList<>();

		try {

			PreparedStatement preparedStatement = (PreparedStatement)conexion.setPreparedStatement(SELECT_ALL_USERS);

			ResultSet rs = conexion.query();
			
			while (rs.next()) {

				int id = rs.getInt("id");
				String username = rs.getString("username");
				String pass = rs.getString("pass");
				String email = rs.getString("email");
				users.add(new User(id, username, pass, email));
			}

		} catch (SQLException e) {

		}

		return users;
	}

	public User select(int id) {

		User user = null;

		try {

			PreparedStatement preparedStatement = (PreparedStatement)conexion.setPreparedStatement(SELECT_USER_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet rs = conexion.query();

			while (rs.next()) {

				String username = rs.getString("username");
				String pass = rs.getString("pass");
				String email = rs.getString("email");
				user = new User(id, username, pass, email);
			}

		} catch (SQLException e) {

		}

		return user;
	}

}

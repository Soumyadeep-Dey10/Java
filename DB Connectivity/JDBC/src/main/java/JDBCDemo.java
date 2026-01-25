import java.sql.*;

public class JDBCDemo {

    private static final String URL = "jdbc:mysql://localhost:3000/db_name";
    private static final String USER = "root";
    private static final String PASSWORD = "user";

    public static void main(String[] args) {
        Connection con = null;
        try {
//            getConnection is required to create DB connection
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to DB");
            insertStudent(con, "Alice", "alice@gmail.com");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    private static void insertStudent(Connection conn, String name, String email) {
        String sql = "INSERT INTO student (name, email) VALUES ('" + name + "','" + email + "')";
       //statement is required to execute sql statements
        try (Statement stmt = conn.createStatement()) {
            int rows = stmt.executeUpdate(sql);
            System.out.println("INSERTED: " + rows);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void selectStudents(Connection conn) {
        String sql = "SELECT * FROM student";
        try (Statement stmt = conn.createStatement()) {
            //resultSet is required to hold the results which is fetched from db using query,it is not null
            ResultSet resultSet = stmt.executeQuery(sql);
            System.out.println("Student List: ");
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                System.out.println(id + " : " + name + " : " + email);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void updateStudent(Connection conn, int id, String name, String email) {

        //without preparedStatement
        //String sql = "UPDATE student SET name = '" + name + "', email = '" + email + "' WHERE id=" + id;


       //usage of preparedstatement
        String sql = "UPDATE student SET name = ?, email = ? WHERE id = ?";
//       UPDATE student SET name = 'Alice', email = 'email@gmail.com'
//       WHERE id = 10;
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setInt(3, id);
            int rows = pstmt.executeUpdate();
            System.out.println("UPDATED: " + rows);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private static void deleteStudent(Connection conn, int id) {
        String sql = "DELETE FROM student WHERE id = " + id;
        try (Statement stmt = conn.createStatement()) {
            int rows = stmt.executeUpdate(sql);
            System.out.println("DELETED: " + rows);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


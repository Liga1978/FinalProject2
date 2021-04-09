package Services;

import Models.DBModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

public class DrinkDBService {
    private String url = "jdbc:mysql://localhost:3306/test"; // jdbc:mysql://localhost:3306/favouritedrinksdb
    private String user = "root"; // root
    private String pass = "Hubabuba1978"; // Imants77!
    private Connection conn;

    public DBModel saveFavouriteDrink(String userName, String drinkName) {
        openConnection();
        try {
            PreparedStatement st = conn.prepareStatement("INSERT INTO test.favouritedrinks(userName, drinkName) VALUES(?,?)");
            st.setString(1, userName);
            st.setString(2, drinkName);
            st.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        return null;
    }

    public String showFavouriteDrinks(String username) {
        openConnection();
        ResultSet rs = select(String.format("SELECT * FROM test.favouritedrinks WHERE username='%s'", username));
        try {
            ArrayList<String> drinkList = new ArrayList<>();
            while (rs.next()) {
                drinkList.add(rs.getString("drinkName"));
                System.out.printf("%s | %s\n",
                        rs.getString("username"),
                        rs.getString("drinkName"));
            }
            return drinkList.toString();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        closeConnection();
        return null;
    }

    private ResultSet select(String query) {
        ResultSet result = null;
        try {
            Statement st = conn.createStatement();
            result = st.executeQuery(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    private void openConnection() {
        try {
            conn = DriverManager
                    .getConnection(url, user, pass);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void closeConnection() {
        try {
            Objects.requireNonNull(conn).close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}




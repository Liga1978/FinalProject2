
package Services;

import java.sql.*;
import java.util.Objects;

public class DrinkDBService {
    private String url; // jdbc:mysql://localhost:3306/favouritedrinksdb
    private String user; // root
    private String pass; // Imants77!
    private Connection conn;

    public DrinkDB(String url, String user, String pass, String driver){
        this.url = url;
        this.user = user;
        this.pass = pass;
        getDriver(driver);
    }

    private void getDriver (String driver){
        try {
            Class.forName(driver).newInstance();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public int saveFavouriteDrink(String username, String drinkName){
        return update(String.format("INSERT INTO favouritedrinksbyuser VALUES(%s,%s)", username, drinkName));
    }

    public void showFavouriteDrinks(String username) {
        openConnection();
        ResultSet rs = select(String.format("SELECT * FROM favouritedrinksbyuser WHERE username='%s'", username));
        try{
            while (rs.next()){
                System.out.printf("%s | %s\n",
                        rs.getString("username"),
                        rs.getString("drinkName"));
            }
        } catch (SQLException throwables){
        throwables.printStackTrace();
        }
        closeConnection();
    }

    private int update(String query){
        int result = 0;
       openConnection();

       try {
            Statement st = conn.createStatement();
            result = st.executeUpdate(query);
       } catch (SQLException throwables) {
            throwables.printStackTrace();
       }

       closeConnection();
       return result;
    }

    private ResultSet select(String query){
        ResultSet result = null;
        try {
            Statement st = conn.createStatement();
            result = st.executeQuery(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    return result;
    }

    private void openConnection(){
        try {
            conn = DriverManager
                    .getConnection(url,user,pass);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void closeConnection(){
        try {
            Objects.requireNonNull(conn).close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }}



    // How do we automatically update the data base when user chooses to "save favourite"?


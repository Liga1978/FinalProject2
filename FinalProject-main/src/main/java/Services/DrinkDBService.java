
package Services;

import Models.DBModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DrinkDBService {
    private String url = "jdbc:mysql://localhost:3306/test"; // jdbc:mysql://localhost:3306/favouritedrinksdb
    private String user = "root"; // root
    private String pass = "Hubabuba1978"; // Imants77!
    private Connection conn;

 /*   public void DrinkDBService(String url, String user, String pass, String driver) {
        this.url = url;
        this.user = user;
        this.pass = pass;
        getDriver(driver);
    }

   private void getDriver(String driver) {
        try {
            Class.forName(driver).newInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
*/
    public DBModel saveFavouriteDrink(String userName, String drinkName){
       //openConnection();
        try{
            Connection conn = DriverManager.getConnection(url,user,pass);
            PreparedStatement st = conn.prepareStatement("INSERT INTO test.favouritedrinks(userName, drinkName) VALUES(?,?)");
            st.setString(1,userName);
            st.setString(2, drinkName);
            st.executeUpdate();
            //Statement st = conn.createStatement();
            // st.executeUpdate((String.format("INSERT INTO test.favouritedrinks(username, drinkName) VALUES(%s,%s)",?,?)));
            conn.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
return null;
    }



/*
   public DBModel saveFavouriteDrink(String username, String drinkName){

        update(String.format("INSERT INTO test.favouritedrinks VALUES(%s,%s)", username, drinkName));

        return null;

    }
*/
  //  public DBModel showFavouriteDrinks(String username) {
        public String showFavouriteDrinks(String username){
        openConnection();
        ResultSet rs = select(String.format("SELECT * FROM test.favouritedrinks WHERE username='%s'", username));
        try{
            ArrayList<String>drinkList = new ArrayList<>();
            while (rs.next()){
              drinkList.add(rs.getString("drinkName"));

                System.out.printf("%s | %s\n",
                        rs.getString("username"),
                        rs.getString("drinkName"));
            } return drinkList.toString();
        } catch (SQLException throwables){
        throwables.printStackTrace();
        }
        closeConnection();
        return null;
    }

   /* private int update(String query){
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
*/
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
    }

}


// How do we automatically update the data base when user chooses to "save favourite"?


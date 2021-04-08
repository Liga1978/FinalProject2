package Models;

public class DBModel {
    private String userName;
    private String drinkName;

    public DBModel(String userName, String drinkName) {
        this.userName = userName;
        this.drinkName = drinkName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }
}



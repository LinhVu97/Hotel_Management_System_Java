package hotelManager.main;

import java.sql.*;

public class conn {
    Connection c;
    public Statement s;

    public conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///projecthms", "root", "Linh123456");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

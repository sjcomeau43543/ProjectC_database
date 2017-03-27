import java.sql.*;

/**
 * Created by Sammy on 3/26/2017.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("-------Embedded Java DB Connection Testing --------");
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Java DB Driver not found. Add the classpath to your module.");
            System.out.println("For IntelliJ do the following:");
            System.out.println("File | Project Structure, Modules, Dependency tab");
            System.out.println("Add by clicking on the green plus icon on the right of the window");
            System.out.println("Select JARs or directories. Go to the folder where the Java JDK is installed");
            System.out.println("Select the folder java/jdk1.8.xxx/db/lib where xxx is the version.");
            System.out.println("Click OK, compile the code and run it.");
            e.printStackTrace();
            return;
        }

        System.out.println("Java DB driver registered!");
        Connection connection = null;

        try {
            // substitute your database name for myDB
            connection = DriverManager.getConnection("jdbc:derby:myDB;create=true");
            Statement stmt = connection.createStatement();

            String droproom = "DROP TABLE ROOM";
            String dropdoctor = "DROP TABLE DOCTOR";
            String dropconnection = "DROP TABLE CONNECTION";
            String dropfloor = "DROP TABLE FLOOR";
            String dropbuilding = "DROP TABLE BUILDING";
            String droplocation = "DROP TABLE LOCATION";
            //stmt.execute(str0);

            //change the lists to be an actual list
            String createfloor = "CREATE TABLE FLOOR(roomList CHAR(20))";
            String createroom = "CREATE TABLE ROOM (roomID CHAR(20) NOT NULL Primary Key, floorLoc Floor)";
            String createbuilding = "CREATE TABLE BUILDING(buildingID CHAR(20) NOT NULL Primary Key, name CHAR(20), floor CHAR(20))";
            String createlocation = "CREATE TABLE LOCATION()";
            String createconnection = "CREATE TABLE CONNECTION()";
            String createdoctor = "CREATE TABLE DOCTOR()";




            //stmt.execute(str1);

            String str2 = "INSERT INTO ROOM VALUES (11, 'Jim Bye', 'Buffalo', 34)";
            stmt.execute(str2);
            stmt.execute(str2);
            stmt.execute(str2);


            String str3 = "SELECT * FROM CUSTOMER";
            ResultSet res = stmt.executeQuery(str3);
            System.out.println(res);
            while (res.next()) {
                System.out.println(
                        "  "+res.getInt("SALARY")
                                + ", "+res.getString("NAME")
                                + ", "+res.getString("LOCATION")
                                + ", "+res.getInt("AGE"));
            }

        } catch (SQLException e) {
            System.out.println("Connection failed. Check output console.");
            e.printStackTrace();
            return;
        }
        System.out.println("Java DB connection established!");





    }

}

package LibrarySystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;


public class DbConnections {
    private static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    
    private static final String JDBC_URL = "jdbc:derby:LibraryDB;create=true";
    static Connection con;
     
     public DbConnections (){
         
     }
     //Create connection
     public void connect() throws ClassNotFoundException{
        try {
            Class.forName(DRIVER);
            this.con = DriverManager.getConnection(JDBC_URL);
            if(this.con != null){
                System.out.println("Connected to database");
            }
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
     }
     //Close connection
       public static void closeConnection() {
        if (con!= null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
       }
     //Create Client table
       public void createClientsTable() {
        try {
            String clientTable = "CREATE TABLE Clients (" +
                    "ClientId VARCHAR(100) PRIMARY KEY, " +
                    "Name VARCHAR(100), " +
                    "Surname VARCHAR(100), " +
                    "Address VARCHAR(255))";
            
            this.con.createStatement().execute(clientTable);
        } catch (SQLException ex) {
             ex.printStackTrace();
        }
}
       
       //Create Library table
       public void createLibraryTable() {
        try {
            String libraryTable = "CREATE TABLE Library (" +
                    "BookId VARCHAR(100) PRIMARY KEY, " +
                    "Title VARCHAR(100), " +
                    "Genre VARCHAR(100), " +
                    "Author VARCHAR(100))";
            
            this.con.createStatement().execute(libraryTable);
        } catch (SQLException ex) {
             ex.printStackTrace();
        }
}
        
     //Add client to Clients table
     public void addClient(String ClientId, String Name,String Surname ,String Address){
        try {
            String query = "INSERT INTO Clients VALUES('"+ClientId+"',"
                    + "'"+Name+"','"+Surname+"','"+Address+"' )";
            this.con.createStatement().execute(query);
            System.out.println("Client Added");
        } catch (SQLException ex) {
             ex.printStackTrace();
        }
     }
     
     //Add book 
     public void addBooks(String BookId, String Title,String Genre ,String Author){
        try {
            String query = "INSERT INTO Library VALUES('"+BookId+"',"
                    + "'"+Title+"','"+Genre+"','"+Author+"' )";
            this.con.createStatement().execute(query);
            System.out.println("Book Added");
        } catch (SQLException ex) {
             ex.printStackTrace();
        }
     }
     
     
     //Update a client in Clients Table
     public void updateClient(String clientId, String surname, String name, String address) {
    try {
        String query = "UPDATE Clients SET Surname='" + surname + "', "
                + "Name='" + name + "', Address='" + address + "' WHERE ClientId='" + clientId + "'";
            this.con.createStatement().execute(query);
            System.out.println("Client updated");
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}
     
     //Updates a book
     public void updateLibrary(String BookId, String Title,String Genre ,String Author) {
    try {
        String query = "UPDATE Library SET Title='" + Title + "', "
                + "Genre='" + Genre + "', Author='" + Author + "' WHERE BookId='" + BookId + "'";
            this.con.createStatement().execute(query);
            System.out.println("Book updated");
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}
     
     // Delete Clients
     public void deleteClient(String clientId) {
    try {
        String query = "DELETE FROM Clients WHERE ClientId = '" + clientId + "'";
        this.con.createStatement().executeUpdate(query);
        System.out.println("Client deleted");
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}

// Delete Book
    public void deleteBook(String bookId) {
    try {
        String query = "DELETE FROM Library WHERE BookId = '" + bookId + "'";
        this.con.createStatement().executeUpdate(query);
        System.out.println("Book deleted");
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}
   
    //Adding to BooksTable
    public ArrayList<String[]> viewLibrary(){
        ArrayList<String[]> datalist = new ArrayList<>();
        try {
            String query = "SELECT * FROM Library";
            ResultSet table = this.con.createStatement().executeQuery(query);
            
            while(table.next())
            {
               String id = table.getString("BookId");
               String t = table.getString("Title");
               String g = table.getString("Genre");
               String a = table.getString("Author");
               
               String[] row = {id, t, g, a};
               datalist.add(row);         
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        return datalist;
    }
    
    
    //Adding Search result to table 
    public ArrayList<String[]> searchLibrary(String title){
        ArrayList<String[]> datalist = new ArrayList<>();
        try {
            String query = "SELECT * FROM Library WHERE Title LIKE '%" + title + "%'";
            ResultSet table = this.con.createStatement().executeQuery(query);
            
            while(table.next())
            {
               String id = table.getString("BookId");
               String t = table.getString("Title");
               String g = table.getString("Genre");
               String a = table.getString("Author");
               
               String[] row = {id, t, g, a};
               datalist.add(row);         
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        return datalist;
    }
    
    //Adding to ClientTable
    public ArrayList<String[]> viewClient(){
        ArrayList<String[]> datalist = new ArrayList<>();
        try {
            String query = "SELECT * FROM Clients";
            ResultSet table = this.con.createStatement().executeQuery(query);
            
            while(table.next())
            {
               String id = table.getString("ClientId");
               String n = table.getString("Name");
               String s = table.getString("Surname");
               String a = table.getString("Address");
               
               String[] row = {id, n, s, a};
               datalist.add(row);         
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        return datalist;
    }
    
    
    //Search for Client
    public ArrayList<String[]> searchClient(String search) {
    ArrayList<String[]> datalist = new ArrayList<>();
    try {
        String query = "SELECT * FROM Clients WHERE Surname LIKE '%" + search + "%'";
        ResultSet table = this.con.createStatement().executeQuery(query);
        
        while (table.next()) {
            String clientId = table.getString("ClientId");
            String name = table.getString("Name");
            String surname = table.getString("Surname");
            String address = table.getString("Address");
            
            String[] row = {clientId, name, surname, address};
            datalist.add(row);         
        }
        
    } catch (SQLException ex) {
        ex.printStackTrace();
    } 
    return datalist;
}

    
    
    
}

     
     
    

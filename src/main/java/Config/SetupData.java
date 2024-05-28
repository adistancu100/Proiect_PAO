package Config;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SetupData {

    public void createVeterinarTable(){
        String createTableSql = """
            CREATE TABLE IF NOT EXISTS Veterinar(
                id INT PRIMARY KEY AUTO_INCREMENT,
                nume VARCHAR(50),
                prenume VARCHAR(50),
                varsta INT,
                CNP VARCHAR(50),
                telefon VARCHAR(50),
                specializare VARCHAR(100),
                aniExperienta INT
            )               
                """;
        Connection connection = DatabaseConfig.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            statement.execute(createTableSql);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }


    public void createAnimalTable(){
        String createTableSql = """
        CREATE TABLE IF NOT EXISTS Animal (
            id INT PRIMARY KEY AUTO_INCREMENT,
            numeAnimal VARCHAR(50),
            specie VARCHAR(50),
            varsta INT,
            greutate INT,
            client_id INT,
            FOREIGN KEY (client_id) REFERENCES Client(id)
        )
    """;
        Connection connection = DatabaseConfig.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            statement.execute(createTableSql);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void createClientTable(){
        String createTableSql = """
            CREATE TABLE IF NOT EXISTS Client (
                id INT PRIMARY KEY AUTO_INCREMENT,
                nume VARCHAR(50),
                prenume VARCHAR(50),
                adresa VARCHAR(100),
                numarTelefon VARCHAR(50)
            )    """;
        Connection connection = DatabaseConfig.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            statement.execute(createTableSql);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }


    public void createMedicamentTable(){
        String createTableSql = """
            CREATE TABLE IF NOT EXISTS Medicament (
                id INT PRIMARY KEY AUTO_INCREMENT,
                nume VARCHAR(50),
                pret DOUBLE
            )    """;
        Connection connection = DatabaseConfig.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            statement.execute(createTableSql);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }


}

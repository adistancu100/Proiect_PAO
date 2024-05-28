package Repository;

import Config.DatabaseConfig;
import Domain.Animale.Animal;
import Service.AuditService;

import java.sql.*;

public class AnimalRepository {
    private final AuditService auditService = AuditService.getInstance();

    public void createAnimal(String numeAnimal,String specie,int varsta,int greutate, int client_id){
        String insertSql = "INSERT INTO Animal (numeAnimal, specie, varsta, greutate, client_id) VALUES (?, ?, ?, ?, ?) ";

        Connection connection = DatabaseConfig.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
            preparedStatement.setString(1,numeAnimal);
            preparedStatement.setString(2,specie);
            preparedStatement.setInt(3,varsta);
            preparedStatement.setInt(4,greutate);
            preparedStatement.setInt(5,client_id);

            preparedStatement.executeUpdate();
            auditService.logAction("Creare Animal");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void createAnimalObject(Animal animal){
        if (animal == null){
            System.out.println("Null Animal obj provided");
            return;
        }

        String numeAnimal = animal.getNumeAnimal();
        String specie = animal.getSpecie();
        int varsta = animal.getVarsta();
        int greutate = animal.getGreutate();
        int client_id = getRandomClientId();


        createAnimal(numeAnimal,specie,varsta,greutate,client_id);

        auditService.logAction("Creare Animal: " + animal.getNumeAnimal());
    }

    private int getRandomClientId() {
        String selectSql = "SELECT id FROM Client ORDER BY RAND() LIMIT 1";
        Connection connection = DatabaseConfig.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql);

            if (resultSet.next()) {
                return resultSet.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

    public ResultSet readAnimal(int id){
        String selectSql = "SELECT * FROM Animal WHERE id = ?";
        Connection connection = DatabaseConfig.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            preparedStatement.setInt(1,id);
            auditService.logAction("Citire animal cu id-ul " + id);
            return preparedStatement.executeQuery();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public void updateAnimal(int id,String numeAnimal,String specie,int varsta,int greutate, int client_id){
        String updateSql = "UPDATE Animal Set numeAnimal = ?, specie = ?, varsta = ?, greutate = ?, client_id = ? WHERE id = ?";
        Connection connection = DatabaseConfig.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateSql);
            preparedStatement.setString(1, numeAnimal);
            preparedStatement.setString(2, specie);
            preparedStatement.setInt(3,varsta);
            preparedStatement.setInt(4,greutate);
            preparedStatement.setInt(5,client_id);
            preparedStatement.setInt(6,id);

            preparedStatement.executeUpdate();
            auditService.logAction("Update Animal cu id-ul " + id);

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteAnimal(int id){
        String deleteSql = "DELETE FROM Animal WHERE id = ?";

        Connection connection = DatabaseConfig.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSql);
            preparedStatement.setInt(1,id);

            preparedStatement.executeUpdate();
            auditService.logAction("Delete animal cu id-ul " + id);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void showAllAnimals(){
        String selectSql = "SELECT * FROM Animal";
        Connection connection = DatabaseConfig.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql);

            while (resultSet.next()){
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Nume animal: " + resultSet.getString("numeAnimal"));
                System.out.println("Specie: " + resultSet.getString("specie"));
                System.out.println("Varsta: " + resultSet.getInt("varsta"));
                System.out.println("Greutate : " + resultSet.getInt("greutate"));
                System.out.println("Id-ul clientului: " + resultSet.getInt("client_id"));
                System.out.println("----------------------");


            }
            auditService.logAction("Info animal");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}

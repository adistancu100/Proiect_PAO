package Repository;

import Domain.Angajati.Veterinar;
import Config.DatabaseConfig;
import Service.AuditService;

import java.sql.*;

public class VeterinarRepository {
    private final AuditService auditService = AuditService.getInstance();

    public void createVeterinar(String nume,String prenume,int varsta,String CNP,String telefon, String specializare, int aniExperienta){
        String insertSql = "INSERT INTO Veterinar (nume, prenume, varsta, CNP, telefon, specializare, aniExperienta) VALUES (?, ?, ?, ?, ?, ?, ?) ";

        Connection connection = DatabaseConfig.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
            preparedStatement.setString(1, nume);
            preparedStatement.setString(2, prenume);
            preparedStatement.setInt(3,varsta);
            preparedStatement.setString(4, CNP);
            preparedStatement.setString(5, telefon);
            preparedStatement.setString(6, specializare);
            preparedStatement.setInt(7,aniExperienta);

            preparedStatement.executeUpdate();
            auditService.logAction("Creare Veterinar");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void createVeterinarObject(Veterinar veterinar){
        if (veterinar == null){
            System.out.println("Null Veterinar obj provided");
            return;
        }

        String nume = veterinar.getNume();
        String prenume = veterinar.getPrenume();
        int varsta = veterinar.getVarsta();
        String CNP = veterinar.getCNP();
        String telefon = veterinar.getTelefon();
        String specializare = veterinar.getSpecializare();
        int aniExperienta = veterinar.getAniExperienta();

        createVeterinar(nume,prenume,varsta,CNP,telefon,specializare,aniExperienta);

        auditService.logAction("Creare Veterinar: " + veterinar.getNume());
    }

    public ResultSet readVeterinar(int id){
        String selectSql = "SELECT * FROM Veterinar WHERE id = ?";
        Connection connection = DatabaseConfig.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            preparedStatement.setInt(1,id);
            auditService.logAction("Citire medic veterinar cu id-ul " + id);
            return preparedStatement.executeQuery();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public void updateVeterinar(int id,String nume,String prenume,int varsta,String CNP,String telefon, String specializare, int aniExperienta ){
        String updateSql = "UPDATE Veterinar Set nume = ?, prenume = ?, varsta = ?, CNP = ?, telefon = ?, specializare = ?, aniExperienta = ? WHERE id = ?";
        Connection connection = DatabaseConfig.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateSql);
            preparedStatement.setString(1, nume);
            preparedStatement.setString(2, prenume);
            preparedStatement.setInt(3,varsta);
            preparedStatement.setString(4, CNP);
            preparedStatement.setString(5, telefon);
            preparedStatement.setString(6, specializare);
            preparedStatement.setInt(7,aniExperienta);
            preparedStatement.setInt(8,id);

            preparedStatement.executeUpdate();
            auditService.logAction("Update Veterinar cu id-ul " + id);

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteVeterinar(int id){
        String deleteSql = "DELETE FROM Veterinar WHERE id = ?";

        Connection connection = DatabaseConfig.getDatabaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSql);
            preparedStatement.setInt(1,id);

            preparedStatement.executeUpdate();
            auditService.logAction("Delete medic veterinar cu id-ul " + id);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void showAllVeterinar(){
        String selectSql = "SELECT * FROM Veterinar";
        Connection connection = DatabaseConfig.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql);

            while (resultSet.next()){
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Nume: " + resultSet.getString("nume"));
                System.out.println("Prenume: " + resultSet.getString("prenume"));
                System.out.println("Varsta: " + resultSet.getInt("varsta"));
                System.out.println("CNP: " + resultSet.getString("CNP"));
                System.out.println("Telefon: " + resultSet.getString("telefon"));
                System.out.println("Specializare: " + resultSet.getString("specializare"));
                System.out.println("Ani de experienta: " + resultSet.getInt("aniExperienta"));
                System.out.println("----------------------");


            }
            auditService.logAction("Info medici veterinari");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}

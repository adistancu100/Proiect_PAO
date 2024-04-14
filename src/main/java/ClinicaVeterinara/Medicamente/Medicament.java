package ClinicaVeterinara.Medicamente;

public class Medicament {
    private String nume;
    private double pret;

    public Medicament(String nume, double pret) {
        this.nume = nume;
        this.pret = pret;
    }

    public String getNumeMedicament() {
        return this.nume;
    }

    public double getPret() {
        return this.pret;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    @Override
    public String toString() {
        return "Medicament "  + nume +
                ", pret=" + pret + " lei";
    }
}

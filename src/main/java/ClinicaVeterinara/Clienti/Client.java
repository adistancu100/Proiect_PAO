package ClinicaVeterinara.Clienti;

import ClinicaVeterinara.Animale.Animal;

public class Client {
    private String nume;
    private String prenume;
    private String adresa;
    private String numarTelefon;
    private Animal animal;

    public Client(String nume, String prenume, String adresa, String numarTelefon, Animal animal) {
        this.nume = nume;
        this.prenume = prenume;
        this.adresa = adresa;
        this.numarTelefon = numarTelefon;
        this.animal = animal;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getAdresa() {
        return adresa;
    }

    public String getNumarTelefon() {
        return numarTelefon;
    }

    public Animal getAnimal() {
        return animal;
    }

    @Override
    public String toString() {
        return "Nume client :  " + nume + " " + prenume +
                ", adresa : " + adresa +
                ", numar de telefon : " + numarTelefon +
                ", " + animal;
    }

}

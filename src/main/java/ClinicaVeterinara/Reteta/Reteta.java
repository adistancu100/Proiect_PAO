package ClinicaVeterinara.Reteta;

import ClinicaVeterinara.Animale.Animal;
import ClinicaVeterinara.Medicamente.Medicament;

public class Reteta {
    private Animal animal;
    private Medicament medicament;
    private int dozaj;

    public Reteta(Animal animal, Medicament medicament, int dozaj) {
        this.animal = animal;
        this.medicament = medicament;
        this.dozaj = dozaj;
    }

    public Animal getAnimal() {
        return this.animal;
    }

    public Medicament getMedicament() {
        return this.medicament;
    }

    public int getDozaj() {
        return this.dozaj;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public void setMedicament(Medicament medicament) {
        this.medicament = medicament;
    }

    public void setDozaj(int dozaj) {
        this.dozaj = dozaj;
    }

    @Override
    public String toString() {
        return "Reteta pentru " + animal.getNumeAnimal() +
                ": se va administra medicamentul " + medicament.getNumeMedicament() +
                " cate " + dozaj + " pe zi";
    }
}

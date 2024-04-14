package ClinicaVeterinara.ConsultatiiVeterinare;

import ClinicaVeterinara.Angajati.Veterinar;
import ClinicaVeterinara.Animale.Animal;

import java.time.LocalDate;


public class ConsultatieVeterinara {
    private Animal animal;
    private Veterinar veterinar;
    private LocalDate data;
    private String diagnostic;
    private String tratament;

    public ConsultatieVeterinara(Animal animal, Veterinar veterinar, LocalDate data, String diagnostic, String tratament) {
        this.animal = animal;
        this.veterinar = veterinar;
        this.data = data;
        this.diagnostic = diagnostic;
        this.tratament = tratament;
    }



    public Animal getAnimal() {
        return this.animal;
    }

    public Veterinar getVeterinar() {
        return this.veterinar;
    }

    public LocalDate getData() {
        return this.data;
    }

    public String getDiagnostic() {
        return this.diagnostic;
    }

    public String getTratament() {
        return this.tratament;
    }

    @Override
    public String toString() {
        return "Consultatie pentru " + animal.getNumeAnimal() +
                " de catre medicul veterinar " + veterinar.getNume() + " " + veterinar.getPrenume() +
                " la data de " + data +
                " cu diagnosticul " + diagnostic +
                " si tratamentul " + tratament;
    }


}

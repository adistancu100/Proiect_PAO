package ClinicaVeterinara.Facturi;

import ClinicaVeterinara.Clienti.Client;
import ClinicaVeterinara.ConsultatiiVeterinare.ConsultatieVeterinara;
import ClinicaVeterinara.Medicamente.Medicament;

import java.util.List;

public class Factura {
    private int numarFactura;
    private Client client;
    private List<ConsultatieVeterinara> consultatii;
    private List<Medicament> medicamenteAchizitionate;
    private double totalPlata;

    public Factura(int numarFactura, Client client, List<ConsultatieVeterinara> consultatii, List<Medicament> medicamenteAchizitionate, double totalPlata) {
        this.numarFactura = numarFactura;
        this.client = client;
        this.consultatii = consultatii;
        this.medicamenteAchizitionate = medicamenteAchizitionate;
        this.totalPlata = totalPlata;
    }

    public int getNumarFactura() {
        return this.numarFactura;
    }

    public Client getClient() {
        return this.client;
    }

    public List<ConsultatieVeterinara> getConsultatii() {
        return consultatii;
    }

    public List<Medicament> getMedicamenteAchizitionate() {
        return medicamenteAchizitionate;
    }

    public double getTotalPlata() {
        return this.totalPlata;
    }

    public void adaugaConsultatie(ConsultatieVeterinara consultatie) {
        consultatii.add(consultatie);
    }

    public void adaugaMedicament(Medicament medicament) {
        medicamenteAchizitionate.add(medicament);
        totalPlata += medicament.getPret();
    }

    public void stergeConsultatie(ConsultatieVeterinara consultatie){
        consultatii.remove(consultatie);
    }

    public void stergeMedicament(Medicament medicament){
        medicamenteAchizitionate.remove(medicament);
    }

    public void afiseazaDetalii() {
        System.out.println("Numar factura: " + numarFactura);
        System.out.println("Client: " + client.getNume() + " " + client.getPrenume());
        System.out.println("Consultatii:");
        for (ConsultatieVeterinara consultatie : consultatii) {
            System.out.println("- " + consultatie.getAnimal().getNumeAnimal() + " (" + consultatie.getData() + ")");
        }
        System.out.println("Medicamente achizitionate:");
        for (Medicament medicament : medicamenteAchizitionate) {
            System.out.println("- " + medicament.getNumeMedicament() + " (" + medicament.getPret() + ")");
        }
        System.out.println("Total plata: " + totalPlata);
    }



}

package ClinicaVeterinara;

import ClinicaVeterinara.Angajati.Angajat;
import ClinicaVeterinara.Angajati.Veterinar;
import ClinicaVeterinara.Animale.Animal;
import ClinicaVeterinara.Clienti.Client;
import ClinicaVeterinara.ConsultatiiVeterinare.ConsultatieVeterinara;
import ClinicaVeterinara.Facturi.Factura;
import ClinicaVeterinara.Medicamente.Medicament;
import ClinicaVeterinara.Reteta.Reteta;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //clasa Angajat
        Angajat angajat1 = new Angajat("Marius","Ion", 25,"02532532324","07345354345");

        //clasa veterinar
        Veterinar veterinar1 = new Veterinar("Popescu","Iulian",25,"2234234243","073543543","doctor medic veterinar", 5);
        Veterinar veterinar2 = new Veterinar("Ion","Alexandru",35,"23534634532","063543534","tehnician veterinar",10);

        veterinar1.afisare();
        veterinar2.afisare();

        //clasa Animal
        Animal animal1 = new Animal("Bella", "caine", 1, 10);
        Animal animal2 = new Animal("Lucy","pisica",2,5);

        System.out.println(animal1.toString());
        System.out.println(animal2.toString());

        //clasa Client

        Client client1 = new Client("Popa","Rares","Str. Muncii nr. 4","07354354",animal1);
        Client client2 = new Client("Ionescu","Andrei","Str. Aurei nr. 2", "07345345",animal2);

        System.out.println(client1.toString());
        System.out.println(client2.toString());

        LocalDate data1 = LocalDate.of(2022,6,10);
        LocalDate data2 = LocalDate.of(2023,7,20);

        //clasa ConsultatieVeterinara
        ConsultatieVeterinara cons1 = new ConsultatieVeterinara(animal1,veterinar1,data1,"parvoviroza","antibiotic + vitamine");
        ConsultatieVeterinara cons2 = new ConsultatieVeterinara(animal2, veterinar2, data2, "fisura perianala", "antibiotic local");

        System.out.println(cons1.toString());
        System.out.println(cons2.toString());

        List<ConsultatieVeterinara> consultatii = new ArrayList<>();
        consultatii.add(cons1);
        consultatii.add(cons2);

        //clasa Medicament

        Medicament medicament1 = new Medicament("Gastro Intestinal", 8.5);
        Medicament medicament2 = new Medicament("Capsule Zylkene",15.99);

        System.out.println(medicament1.toString());
        System.out.println(medicament2.toString());

        List<Medicament> medicamente = new ArrayList<>();
        medicamente.add(medicament1);
        medicamente.add(medicament2);


        Reteta reteta1 = new Reteta(animal1, medicament1, 3);
        Reteta reteta2 = new Reteta(animal2, medicament2, 2);
        System.out.println(reteta1.toString());
        System.out.println(reteta2.toString());



        double totalCostMedicamente = 0.0;
        for (Medicament medicament : medicamente){
            totalCostMedicamente += medicament.getPret();
        }

       //clasa Factura
       Factura factura1 = new Factura(1,client1,consultatii,medicamente, totalCostMedicamente);
       factura1.afiseazaDetalii();

    }
}

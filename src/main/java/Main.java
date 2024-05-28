import Config.SetupData;
import Config.DatabaseConfig;
import Domain.Angajati.Angajat;
import Domain.Angajati.Veterinar;
import Domain.Animale.Animal;
import Domain.Clienti.Client;
import Domain.ConsultatiiVeterinare.ConsultatieVeterinara;
import Domain.Facturi.Factura;
import Domain.Medicamente.Medicament;
import Domain.Reteta.Reteta;
import Repository.AnimalRepository;
import Repository.ClientRepository;
import Repository.MedicamentRepository;
import Repository.VeterinarRepository;
import Service.ConsultatieService;


import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.ArrayList;
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
        //Animal animal1 = new Animal("Bella", "caine", 1, 10);
        Animal animal1 = new Animal("Bella","caine",1,10);
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

        System.out.println();


        ConsultatieService consultatieService = new ConsultatieService();
        consultatieService.adaugaConsultatie(cons1);
        consultatieService.adaugaConsultatie(cons2);
        consultatieService.afisareConsultatii();

        System.out.println();

        SetupData setupData = new SetupData();

        setupData.createClientTable();
        setupData.createVeterinarTable();
        setupData.createAnimalTable();
        setupData.createMedicamentTable();

        ClientRepository clientRepository = new ClientRepository();
        VeterinarRepository veterinarRepository = new VeterinarRepository();
        AnimalRepository animalRepository = new AnimalRepository();
        MedicamentRepository medicamentRepository = new MedicamentRepository();


        //Testarea metodelor CRUD pentru Client :
        System.out.println("CRUD : Clienti : ");
        clientRepository.createClient("Marius","Vasile","Strada Garii nr 3","073463454354");
        clientRepository.createClient("Popa","Rares","Strada Vergului nr 4", "07345354354");
        clientRepository.updateClient(1,"Alexandru","Popescu","Strada Marinului nr 3","073543535");
        clientRepository.deleteClient(2);
        clientRepository.showAllClients();


        //Testarea metodelor CRUD pentru Veterinar :
        System.out.println("CRUD: Medici veterinari: ");
        veterinarRepository.createVeterinar("Oprea","Vasile",25,"2352352532","063436436","medic veterinar",4);
        veterinarRepository.createVeterinar("Maria","Vlase",30,"03734634","034535435","asistent",3);
        veterinarRepository.updateVeterinar(1,"Oprea","Vasile",26,"23424324","02325325324","medic veterinar",3);
        veterinarRepository.deleteVeterinar(2);
        veterinarRepository.showAllVeterinar();


        //Testarea metodelor CRUD pentru Animal :
        System.out.println("CRUD: Animale: ");
        animalRepository.createAnimal("Lucy","pisica",7,3,1);
        animalRepository.createAnimal("Bella","caine",1,10,1);
        animalRepository.updateAnimal(2,"Lucy","pisica",3,5,1);
        animalRepository.deleteAnimal(3);
        animalRepository.showAllAnimals();

        //Testarea metodelor CRUD pentru Medicament :

        System.out.println("CRUD: Medicamente: ");
        medicamentRepository.createMedicament("Paracetamol",4);
        medicamentRepository.createMedicament("Gripovit",20);
        medicamentRepository.createMedicament("Nurofen",5);
        medicamentRepository.updateMedicament(2,"Gripovit",30);
        medicamentRepository.deleteMedicament(3);
        medicamentRepository.showAllMeds();

        animalRepository.createAnimalObject(animal1);

        //DatabaseConfig.closeDatabaseConnection();
    }
}

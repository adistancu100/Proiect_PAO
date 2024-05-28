package ClinicaVeterinara.Serviciu;

import ClinicaVeterinara.ConsultatiiVeterinare.ConsultatieVeterinara;

import java.util.ArrayList;
import java.util.List;

public class ConsultatieService {
    private List<ConsultatieVeterinara> consultatii;

    public ConsultatieService() {

        consultatii = new ArrayList<>();
    }

    public void adaugaConsultatie(ConsultatieVeterinara consultatie){
        consultatii.add(consultatie);
    }

    public void stergeConsultatie(ConsultatieVeterinara consultatie){
        consultatii.remove(consultatie);
    }

    public void afisareConsultatii() {
        for(ConsultatieVeterinara consultatie : consultatii){
            System.out.println(consultatie);
        }
    }
}

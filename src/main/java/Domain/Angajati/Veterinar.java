package Domain.Angajati;

public class Veterinar extends Angajat{
    private String specializare;
    private int aniExperienta;

    public Veterinar(String nume, String prenume, int varsta, String CNP, String telefon, String specializare, int aniExperienta) {
        super(nume, prenume, varsta, CNP, telefon);
        this.specializare = specializare;
        this.aniExperienta = aniExperienta;
    }

    public String getSpecializare() {
        return specializare;
    }

    public int getAniExperienta() {
        return aniExperienta;
    }

    @Override
    public void afisare(){
        System.out.println("Angajatul " + nume + " " + prenume + ", cu varsta de " + varsta + " de ani, CNP: " + CNP + " si numar de telefon " + telefon + " are specializarea de " + specializare + " si are experienta de " + aniExperienta + " ani");
    }
}

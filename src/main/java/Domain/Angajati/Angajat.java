package Domain.Angajati;

public class Angajat {
    protected String nume;
    protected String prenume;
    protected int varsta;
    protected String CNP;
    protected String telefon;

    public Angajat(String nume, String prenume, int varsta, String CNP, String telefon) {
        this.nume = nume;
        this.prenume = prenume;
        this.varsta = varsta;
        this.CNP = CNP;
        this.telefon = telefon;
    }
    public String getNume() {
        return this.nume;
    }

    public String getPrenume() {
        return this.prenume;
    }

    public int getVarsta() {
        return this.varsta;
    }

    public String getCNP() {
        return this.CNP;
    }
    public String getTelefon() {
        return this.telefon;
    }

    public void afisare() {}
}

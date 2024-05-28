package Domain.Animale;

public class Animal {
    private String numeAnimal;
    private String specie;
    private int varsta;
    private int greutate;

    public Animal(String numeAnimal, String specie, int varsta, int greutate) {
        this.numeAnimal = numeAnimal;
        this.specie = specie;
        this.varsta = varsta;
        this.greutate = greutate;
    }

    public String getNumeAnimal() {
        return this.numeAnimal;
    }

    public String getSpecie() {
        return this.specie;
    }

    public int getVarsta() {
        return this.varsta;
    }

    public int getGreutate() {
        return this.greutate;
    }

    @Override
    public String toString() {
        return "Nume animal : " + numeAnimal +
                ", specie : " + specie +
                ", varsta: " + varsta +
                ", greutate: " + greutate;
    }
}

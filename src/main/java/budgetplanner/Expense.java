package budgetplanner;

public class Expense {
    
    private String navn;
    private double beløp;

    
    public Expense(String navn, double beløp) {
        if (navn == null || navn.isBlank()) {
            throw new IllegalArgumentException("Navn kan ikke være tom!");
        }
        
        if (beløp < 0) {
            throw new IllegalArgumentException("Beløpet kan ikke være negativt!");
        }

        this.navn = navn;
        this.beløp = beløp;
    }


    public String getNavn() {
        return navn;
    }


    public double getBeløp() {
        return beløp;
    }

    


}
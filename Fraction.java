
public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int num, int denominator){
        this.numerator = num;
        this.denominator = denominator;
    }

    public int getNumerator(){
        return this.numerator;
    }

    public int getDenominator(){
        return this.denominator;
    }

    public void setNumerator(int num){
        this.numerator = num;
    }

    public void setDenominator(int den){
        this.denominator = den;
    }

    public Fraction add(Fraction fraction2) {
        int num = this.numerator * fraction2.getDenominator() + this.denominator * fraction2.getNumerator();
        int den = this.denominator * fraction2.getDenominator();

        Fraction result = new Fraction(num, den);
        return result;
    }

    public String toString(){
        return numerator + "/" + denominator;
    }
}

public class Application {
    public static void main(String args[]){
        int numerator = 3;
        int denominator = 4;

        Fraction fraction1 = new Fraction(numerator, denominator);
        Fraction fraction2 = new Fraction(1, 2);

        System.out.println(fraction1);
        fraction1.setNumerator(6);
        System.out.println(fraction1);

        Fraction result = fraction1.add(fraction2);
        System.out.println(fraction1 + " + " + fraction2 + " + " + result);
    }
}

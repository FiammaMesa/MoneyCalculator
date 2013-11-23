package moneycalculator;

public class Number {
    
    private long numerator;
    private long denominator;
    
    public Number(long numerator, long denominator){
        this.numerator = numerator;      
        this.denominator = denominator;  
    }

    public Number(Number number) {
        this(number.numerator, number.denominator);
    }
    
    public Number(int number){
        this(number, 1);
    }
    
    
    public Number(long number){
        this(number, 1);
    }
    
    public void operator(long numerator, long denominator){
        System.out.println("houston, we have a problem here!");
    }
    
    public void add(long number1){
        numerator += number1;//revisar
    }
    
    public void multiply(long number1){//revisar
        numerator *= number1;
        denominator *= 1;
        numberFromDouble(numerator);        
    }

    private void reduce() {
        int[] primeNumbers = getPrimeNumbers();
        for (int Number : primeNumbers) {
            while (isDivisible(Number)){
                numerator = numerator/Number;
                denominator = denominator/Number;
            }
        }
    }

    private int[] getPrimeNumbers() {
        return new int[] {2, 3, 5, 7, 11, 13, 17, 19, 23};
    }

    private boolean isDivisible(int number) {
        return ((numerator % number == 0) & denominator % number == 0);
    }
    
    public void numberFromDouble(double number){ // static¿
        this.numerator = (long)number;
        this.denominator = 1;
        
        while (number!=numerator){
            number *= 10;
            denominator *= 10;
            numerator = (long)number;
        }
        reduce();
    }
    
}

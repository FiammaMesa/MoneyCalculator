package moneycalculator.Model;

public final class Number {
    
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
    
    public Number(double number){
        numberFromDouble(number);
    }
    
    
    public Number add(Number number){
        number.reduce();
        
        if (number.denominator != denominator){
            number.numerator = number.numerator * denominator + number.denominator*numerator;
            number.denominator*=denominator;
            number.reduce();
        }else{
            number.numerator = number.numerator+numerator;
            number.reduce();
        }
        return number;
        
    }
    
    public static Number multiply(Number number1, Number number2){
        number1.numerator = number1.numerator * number2.numerator;
        number1.denominator = number1.denominator * number2.denominator;
        number1.reduce();
        Number num = new Number(number1.numerator, number1.denominator);
        return num;
    }
    
    public Number divide(Number number){
        number.numerator *= this.denominator;
        number.denominator *= this.numerator;
        number.reduce();
        return number;
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
    
    public void numberFromDouble(double number){
        this.numerator = (long)number;
        this.denominator = 1;
        
        while (number!=numerator){
            number *= 10;
            denominator *= 10;
            numerator = (long)number;
        }
        reduce();
    }

    public long getNumerator() {
        return numerator;
    }

    public long getDenominator() {
        return denominator;
    }
    
    public static Number parseNumber(String value){
        double parse = Double.parseDouble(value);
        Number num = new Number(parse);
        num.reduce();
        return num;
    }
    
    @Override
    public String toString() {
        return  numerator + "/" + denominator;
    }
    
}

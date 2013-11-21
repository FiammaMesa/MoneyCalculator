package moneycalculator;

public class Number {
    
    private long numerator;
    private long denominator;
    
    public Number(int number){
        numerator = number;
        denominator = 1;
    }
    
    public Number(double number){
        numerator = (long)number;
    }
    
    public Number(long number){
        this(number, 1);
    }
    
    public Number(long numerator, long denominator){
        this.numerator = numerator;
        this.denominator = denominator;
    }
    
    public void operator(long numerator, long denominator){
        
    }
    
    public void add(){
    
    }
    
    public void multiply(){
        
    }
}

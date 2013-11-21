package moneycalculator;

import java.util.HashSet;

public class CurrencySet extends HashSet<Currency>{
    
    private static CurrencySet instance;
    private CurrencySet(){
        super();
    }
    
    public static CurrencySet getInstance(){
        if(instance == null) instance = new CurrencySet();
        return instance;
    }
    
    
}
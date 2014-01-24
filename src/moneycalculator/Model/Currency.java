package moneycalculator.Model;

public class Currency {

    private String name;
    private final String code;
    private String symbol;

    public Currency(String name, String code, String symbol) {
        this.name = name;
        this.code = code;
        this.symbol = symbol;
    }


    public Currency(String name, String code) {
        this.name = name;
        this.code = code;
    }
    
    public Currency(String code){
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return code;
    }
    
    
}

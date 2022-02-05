package cloud.deuterium.microstream.model;

/**
 * Created by Milan Stojkovic 12-Oct-2021
 */


public class Atom {
    public int id;
    public String name;
    public String symbol;
    public String description;
    public double mass;

    public Atom() {
    }

    public Atom(int id, String name, String symbol, String description, double mass) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.description = description;
        this.mass = mass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    @Override
    public String toString() {
        return "Atom{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                '}';
    }
}

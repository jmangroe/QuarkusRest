package entity;

public class Countries {
    private String name;
    private String capital;

    public Countries(String name, String capital) {
        this.name = name;
        this.capital = capital;
    }

    public void setName(String name) {
        this.name = name;
    }



    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    @Override
    public String toString() {
        return "Countries{" +
                "name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                '}';
    }
}

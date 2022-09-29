package repository;

import entity.Countries;
import service.CountriesService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CountriesRepository {
    List<Countries> countries= new ArrayList<>();

    public CountriesRepository(){
        countries.add(new Countries("Suriname","Paramaribo"));
        countries.add(new Countries("Frankrijk","Parijs"));
    }
    public List<Countries>getCountries(){return countries;}

    public Optional<Countries> findCountry(String name){
        return countries.stream().filter(p->p.getName().equals(name)).findFirst();
    }

}

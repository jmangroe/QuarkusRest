package service;

import entity.Countries;
import repository.CountriesRepository;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static org.jboss.resteasy.reactive.RestResponse.StatusCode.NOT_FOUND;

@Path("/countries")
@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})

public class CountriesService {
    CountriesRepository countriesRepository = new CountriesRepository();

    @Path("/get/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Countries> countries(){
        return countriesRepository.getCountries();
    }

    @Path("user/restricted/get/countries/name")
    @GET
    @RolesAllowed("user")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
    public Response getCountryUser(@QueryParam("name")String name){
        return countriesRepository.findCountry(name)
                .map(Response::ok)
                .orElseGet(()->Response.status(NOT_FOUND))
                .build();
    }

    @Path("admin/rights/get/countries/name")
    @GET
    @RolesAllowed("admin")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response getCountryAdmin(@QueryParam("name")String name){
        return countriesRepository.findCountry(name)
                .map(Response::ok)
                .orElseGet(()->Response.status(NOT_FOUND))
                .build();
    }

    @Path("/get/countries/name")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML})
    public Response getCountry(@QueryParam("name")String name){
        return countriesRepository.findCountry(name)
                .map(Response::ok)
                .orElseGet(()->Response.status(NOT_FOUND))
                .build();
    }

}

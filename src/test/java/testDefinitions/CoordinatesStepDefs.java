package testDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.Response;
import org.junit.Assert;

import java.math.BigDecimal;

public class CoordinatesStepDefs {
    private WeatherRequester weatherRequester = new WeatherRequester();
    private Response response;

    @When("we are getting coordinates from server")
    public void get_weather(){
        response = weatherRequester.getWeather();
    }

    @Then("lon is (.*)")
    public void check_lon(BigDecimal lon){
        Assert.assertEquals("Wrong LON", lon, response.getCoord().getLon());
    }

    @Then("lat is (.*)")
    public void check_lat(BigDecimal lat){
        Assert.assertEquals("Wrong LAT", lat, response.getCoord().getLat());
    }

}

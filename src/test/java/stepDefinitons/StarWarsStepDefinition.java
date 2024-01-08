package stepDefinitons;

import POJOS.Film;
import POJOS.People;
import POJOS.Planet;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static utils.Utils.isValidYYYYMMDDFormat;

public class StarWarsStepDefinition {

  String uri;
  Response response;
  People peopleResponse;
  Film film2;
  Planet lastPlanetResponse;
  Planet lastPlanetResponseTwo;

  //    1. Test the endpoint people/2/ and check the success response, the skin color to be gold,
  //      and the amount of films it appears on (should be 6).
  @Given("I have the base URL {string}")
  public void iHaveTheBaseURLHttpsSwapiDevApi(String url) {
    uri = url;
  }


  @When("I request the endpoint {string}")
  @And("I requested the endpoint {string}")
  public void iRequestTheEndpointPeople(String endpoint) {
    response = RestAssured.given().baseUri(uri).get(endpoint).then()
        .extract().response();
    peopleResponse = response.as(People.class, ObjectMapperType.GSON);
  }

  @Then("the response status should be {int}")
  public void theResponseStatusShouldBe(int statusCode) {
    assertEquals(response.statusCode(), statusCode);
  }

  @And("the response should contain {string} for the skin color")
  public void theResponseShouldContainForTheSkinColor(String skinColor) {
    assertEquals(peopleResponse.getSkin_color(), skinColor, "Incorrect skin color");
  }

  @And("the response should contain {int} films")
  public void theResponseShouldContainFilms(int filmsSize) {
    assertEquals(peopleResponse.getFilms().size(), filmsSize, "Incorrect size of the films list");
  }

  //  2.  Request the endpoint of the second movie in which people/2/ was present (using the
//     response from people/2/). Check the release date to be in the correct date format, and
//    the response to include characters, planets, starships, vehicles and species, each
//    element including more than 1 element.

  @When("I request the endpoint of the second movie from the response")
  @And("I requested the endpoint of the second movie from the response")
  public void iRequestTheEndpointOfTheSecondMovieFromTheResponse() {
    response = RestAssured.given().baseUri(peopleResponse.getFilms().get(1)).get("/").then()
        .extract().response();
    film2 = response.as(Film.class, ObjectMapperType.GSON);
  }


  @And("the release date should be in the correct date format")
  public void theReleaseDateShouldBeInTheCorrectDateFormat() {
    assertTrue(isValidYYYYMMDDFormat(film2.getRelease_date()), "Incorrect format for the release date");
  }

  @And("the response should contain multiple characters")
  public void theResponseShouldContainMultipleCharacters() {
    assertTrue(film2.getCharacters().size() > 1, "Characters is not including more than 1 element.");
  }

  @And("the response should contain multiple planets")
  public void theResponseShouldContainMultiplePlanets() {
    assertTrue(film2.getPlanets().size() > 1, "Planets  is not including more than 1 element.");
  }

  @And("the response should contain multiple starships")
  public void theResponseShouldContainMultipleStarships() {
    assertTrue(film2.getStarships().size() > 1, "Starships  is not including more than 1 element.");
  }

  @And("the response should contain multiple vehicles")
  public void theResponseShouldContainMultipleVehicles() {
    assertTrue(film2.getVehicles().size() > 1, "Vehicles  is not including more than 1 element.");
  }

  @And("the response should contain multiple species")
  public void theResponseShouldContainMultipleSpecies() {
    assertTrue(film2.getSpecies().size() > 1, "Species  is not including more than 1 element.");
  }
  //    3. Request the endpoint of the first planet present in the last film's response (using the
//    previous response). Check the gravity and the terrains matching the exact same values
//    returned by the request (Use fixtures to store and compare the data of terrains and
//    gravity).


  @And("I requested the endpoint of the first planet from the last film")
  @When("I request the endpoint of the first planet from the last film")
  public void iRequestTheEndpointOfTheFirstPlanetFromTheLastFilm() {
    ArrayList<String> planetUrisList = film2.getPlanets();
    String lastPlanetUri = planetUrisList.get(planetUrisList.size() - 1);
    response = RestAssured.given().baseUri(lastPlanetUri).get("/").then()
        .extract().response();

     lastPlanetResponse = response.as(Planet.class, ObjectMapperType.GSON);
  }

  @And("gravity should match exactly {}")
  public void gravityShouldMatchExactly(String terrains) {
    assertEquals(lastPlanetResponse.getTerrain(), terrains);
  }
  @And("the terrains should match exactly {}")
  public void theTerrainsShouldMatchExactly(String gravity) {

    assertEquals(lastPlanetResponse.getGravity(), gravity);
  }

  //4. On the same response from the planet, grab the url element on the response, and
  //request it. Validate the response being exactly the same from the previous one.

  @When("I request the planet URL")
  public void iRequestThePlanetURL() {
    response = RestAssured.given().baseUri(lastPlanetResponse.getUrl()).get("/").then()
        .extract().response();
    lastPlanetResponseTwo = response.as(Planet.class, ObjectMapperType.GSON);
  }

  @Then("the response should match exactly as the previous one")
  public void theResponseShouldMatchExactlyAsThePreviousOne() {
    assertEquals(lastPlanetResponse.getName(), lastPlanetResponseTwo.getName());
    assertEquals(lastPlanetResponse.getRotation_period(), lastPlanetResponseTwo.getRotation_period());
    assertEquals(lastPlanetResponse.getOrbital_period(), lastPlanetResponseTwo.getOrbital_period());
    assertEquals(lastPlanetResponse.getDiameter(), lastPlanetResponseTwo.getDiameter());
    assertEquals(lastPlanetResponse.getClimate(), lastPlanetResponseTwo.getClimate());
    assertEquals(lastPlanetResponse.getGravity(), lastPlanetResponseTwo.getGravity());
    assertEquals(lastPlanetResponse.getTerrain(), lastPlanetResponseTwo.getTerrain());
    assertEquals(lastPlanetResponse.getSurface_water(), lastPlanetResponseTwo.getSurface_water());
    assertEquals(lastPlanetResponse.getPopulation(), lastPlanetResponseTwo.getPopulation());
    assertEquals(lastPlanetResponse.getResidents(), lastPlanetResponseTwo.getResidents());
    assertEquals(lastPlanetResponse.getFilms(), lastPlanetResponseTwo.getFilms());
    assertEquals(lastPlanetResponse.getCreated(), lastPlanetResponseTwo.getCreated());
    assertEquals(lastPlanetResponse.getEdited(), lastPlanetResponseTwo.getEdited());
    assertEquals(lastPlanetResponse.getUrl(), lastPlanetResponseTwo.getUrl());
  }

  //5. Request the /films/7/ and check the response having a 404 code.


}
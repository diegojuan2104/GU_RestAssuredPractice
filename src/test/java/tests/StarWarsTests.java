package tests;

import POJOS.Film;
import POJOS.People;
import POJOS.Planet;
import data.Provider;
import io.restassured.RestAssured;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import static org.testng.Assert.*;
import static utils.Utils.isValidYYYYMMDDFormat;
import static utils.Utils.readDataFromJson;

public class StarWarsTests {
  final String BASE_URI = "https://swapi.dev/api/";
  Response response;

  @Test(dataProvider = "Data_starWarsTestE2E",
      dataProviderClass = Provider.class
  )
  public void starWarsTestE2E(Map<String, Object> dataE2E) {
//    1. Test the endpoint people/2/ and check the success response, the skin color to be gold,
//      and the amount of films it appears on (should be 6).

    response = RestAssured.given().baseUri(BASE_URI).get("/people/2").then()
        .extract().response();

    assertEquals(response.statusCode(), 200);
    People peopleResponse = response.as(People.class, ObjectMapperType.GSON);

    assertEquals(peopleResponse.getSkin_color(), "gold", "Incorrect skin color");
    assertEquals(peopleResponse.getFilms().size(), 6, "Incorrect size of the films list");

//  2.  Request the endpoint of the second movie in which people/2/ was present (using the
//     response from people/2/). Check the release date to be in the correct date format, and
//    the response to include characters, planets, starships, vehicles and species, each
//    element including more than 1 element.

    response = RestAssured.given().baseUri(peopleResponse.getFilms().get(1)).get("/").then()
        .extract().response();

    assertEquals(response.statusCode(), 200);
    Film film2 = response.as(Film.class, ObjectMapperType.GSON);


    assertTrue(isValidYYYYMMDDFormat(film2.getRelease_date()), "Incorrect format for the release date");

    assertTrue(film2.getCharacters().size() > 1, "Characters is not including more than 1 element.");
    assertTrue(film2.getPlanets().size() > 1, "Planets  is not including more than 1 element.");
    assertTrue(film2.getStarships().size() > 1, "Starships  is not including more than 1 element.");
    assertTrue(film2.getVehicles().size() > 1, "Vehicles  is not including more than 1 element.");

//
//    3. Request the endpoint of the first planet present in the last film's response (using the
//    previous response). Check the gravity and the terrains matching the exact same values
//    returned by the request (Use fixtures to store and compare the data of terrains and
//    gravity).

    ArrayList<String> planetUrisList = film2.getPlanets();
    String lastPlanetUri = planetUrisList.get(planetUrisList.size() - 1);
    response = RestAssured.given().baseUri(lastPlanetUri).get("/").then()
        .extract().response();

    assertEquals(response.statusCode(), 200);
    Planet lastPlanetResponse = response.as(Planet.class, ObjectMapperType.GSON);

    assertEquals(lastPlanetResponse.getTerrain(), dataE2E.get("terrain"));
    assertEquals(lastPlanetResponse.getGravity(),  dataE2E.get("gravity"));

    //4. On the same response from the planet, grab the url element on the response, and
    //request it. Validate the response being exactly the same from the previous one.
    response = RestAssured.given().baseUri(lastPlanetResponse.getUrl()).get("/").then()
        .extract().response();

    assertEquals(response.statusCode(), 200);
    Planet lastPlanetResponseTwo = response.as(Planet.class, ObjectMapperType.GSON);

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

  @Test
  public void test404(){
    response = RestAssured.given().baseUri(BASE_URI).get("/films/7/").then()
        .extract().response();

    assertEquals(response.statusCode(), 404);
  }
}

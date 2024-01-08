package POJOS;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Date;

public class Planet {
  @JsonProperty("name")
  public String getName() {
    return this.name; }
  public void setName(String name) {
    this.name = name; }
  String name;
  @JsonProperty("rotation_period")
  public String getRotation_period() {
    return this.rotation_period; }
  public void setRotation_period(String rotation_period) {
    this.rotation_period = rotation_period; }
  String rotation_period;
  @JsonProperty("orbital_period")
  public String getOrbital_period() {
    return this.orbital_period; }
  public void setOrbital_period(String orbital_period) {
    this.orbital_period = orbital_period; }
  String orbital_period;
  @JsonProperty("diameter")
  public String getDiameter() {
    return this.diameter; }
  public void setDiameter(String diameter) {
    this.diameter = diameter; }
  String diameter;
  @JsonProperty("climate")
  public String getClimate() {
    return this.climate; }
  public void setClimate(String climate) {
    this.climate = climate; }
  String climate;
  @JsonProperty("gravity")
  public String getGravity() {
    return this.gravity; }
  public void setGravity(String gravity) {
    this.gravity = gravity; }
  String gravity;
  @JsonProperty("terrain")
  public String getTerrain() {
    return this.terrain; }
  public void setTerrain(String terrain) {
    this.terrain = terrain; }
  String terrain;
  @JsonProperty("surface_water")
  public String getSurface_water() {
    return this.surface_water; }
  public void setSurface_water(String surface_water) {
    this.surface_water = surface_water; }
  String surface_water;
  @JsonProperty("population")
  public String getPopulation() {
    return this.population; }
  public void setPopulation(String population) {
    this.population = population; }
  String population;
  @JsonProperty("residents")
  public ArrayList<Object> getResidents() {
    return this.residents; }
  public void setResidents(ArrayList<Object> residents) {
    this.residents = residents; }
  ArrayList<Object> residents;
  @JsonProperty("films")
  public ArrayList<String> getFilms() {
    return this.films; }
  public void setFilms(ArrayList<String> films) {
    this.films = films; }
  ArrayList<String> films;
  @JsonProperty("created")
  public Date getCreated() {
    return this.created; }
  public void setCreated(Date created) {
    this.created = created; }
  Date created;
  @JsonProperty("edited")
  public Date getEdited() {
    return this.edited; }
  public void setEdited(Date edited) {
    this.edited = edited; }
  Date edited;
  @JsonProperty("url")
  public String getUrl() {
    return this.url; }
  public void setUrl(String url) {
    this.url = url; }
  String url;
}
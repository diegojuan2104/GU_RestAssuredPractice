package POJOS;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Date;

public class Film{
  @JsonProperty("title")
  public String getTitle() {
    return this.title; }
  public void setTitle(String title) {
    this.title = title; }
  String title;
  @JsonProperty("episode_id")
  public int getEpisode_id() {
    return this.episode_id; }
  public void setEpisode_id(int episode_id) {
    this.episode_id = episode_id; }
  int episode_id;
  @JsonProperty("opening_crawl")
  public String getOpening_crawl() {
    return this.opening_crawl; }
  public void setOpening_crawl(String opening_crawl) {
    this.opening_crawl = opening_crawl; }
  String opening_crawl;
  @JsonProperty("director")
  public String getDirector() {
    return this.director; }
  public void setDirector(String director) {
    this.director = director; }
  String director;
  @JsonProperty("producer")
  public String getProducer() {
    return this.producer; }
  public void setProducer(String producer) {
    this.producer = producer; }
  String producer;
  @JsonProperty("release_date")
  public String getRelease_date() {
    return this.release_date; }
  public void setRelease_date(String release_date) {
    this.release_date = release_date; }
  String release_date;
  @JsonProperty("characters")
  public ArrayList<String> getCharacters() {
    return this.characters; }
  public void setCharacters(ArrayList<String> characters) {
    this.characters = characters; }
  ArrayList<String> characters;
  @JsonProperty("planets")
  public ArrayList<String> getPlanets() {
    return this.planets; }
  public void setPlanets(ArrayList<String> planets) {
    this.planets = planets; }
  ArrayList<String> planets;
  @JsonProperty("starships")
  public ArrayList<String> getStarships() {
    return this.starships; }
  public void setStarships(ArrayList<String> starships) {
    this.starships = starships; }
  ArrayList<String> starships;
  @JsonProperty("vehicles")
  public ArrayList<String> getVehicles() {
    return this.vehicles; }
  public void setVehicles(ArrayList<String> vehicles) {
    this.vehicles = vehicles; }
  ArrayList<String> vehicles;
  @JsonProperty("species")
  public ArrayList<String> getSpecies() {
    return this.species; }
  public void setSpecies(ArrayList<String> species) {
    this.species = species; }
  ArrayList<String> species;
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


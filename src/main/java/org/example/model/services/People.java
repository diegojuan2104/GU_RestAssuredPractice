package org.example.model.services;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Date;

public class People{
  @JsonProperty("name")
  public String getName() {
    return this.name; }
  public void setName(String name) {
    this.name = name; }
  String name;
  @JsonProperty("height")
  public String getHeight() {
    return this.height; }
  public void setHeight(String height) {
    this.height = height; }
  String height;
  @JsonProperty("mass")
  public String getMass() {
    return this.mass; }
  public void setMass(String mass) {
    this.mass = mass; }
  String mass;
  @JsonProperty("hair_color")
  public String getHair_color() {
    return this.hair_color; }
  public void setHair_color(String hair_color) {
    this.hair_color = hair_color; }
  String hair_color;
  @JsonProperty("skin_color")
  public String getSkin_color() {
    return this.skin_color; }
  public void setSkin_color(String skin_color) {
    this.skin_color = skin_color; }
  String skin_color;
  @JsonProperty("eye_color")
  public String getEye_color() {
    return this.eye_color; }
  public void setEye_color(String eye_color) {
    this.eye_color = eye_color; }
  String eye_color;
  @JsonProperty("birth_year")
  public String getBirth_year() {
    return this.birth_year; }
  public void setBirth_year(String birth_year) {
    this.birth_year = birth_year; }
  String birth_year;
  @JsonProperty("gender")
  public String getGender() {
    return this.gender; }
  public void setGender(String gender) {
    this.gender = gender; }
  String gender;
  @JsonProperty("homeworld")
  public String getHomeworld() {
    return this.homeworld; }
  public void setHomeworld(String homeworld) {
    this.homeworld = homeworld; }
  String homeworld;
  @JsonProperty("films")
  public ArrayList<String> getFilms() {
    return this.films; }
  public void setFilms(ArrayList<String> films) {
    this.films = films; }
  ArrayList<String> films;
  @JsonProperty("species")
  public ArrayList<String> getSpecies() {
    return this.species; }
  public void setSpecies(ArrayList<String> species) {
    this.species = species; }
  ArrayList<String> species;
  @JsonProperty("vehicles")
  public ArrayList<Object> getVehicles() {
    return this.vehicles; }
  public void setVehicles(ArrayList<Object> vehicles) {
    this.vehicles = vehicles; }
  ArrayList<Object> vehicles;
  @JsonProperty("starships")
  public ArrayList<Object> getStarships() {
    return this.starships; }
  public void setStarships(ArrayList<Object> starships) {
    this.starships = starships; }
  ArrayList<Object> starships;
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


package classesandenums;

import java.time.LocalDateTime;

public class Person implements Comparable<Person> {
    private Long id;
    private String name;
    private Coordinates coordinates;
    private LocalDateTime creationDate;
    private int height;
    private EColor eyeColor;
    private HColor hairColor;
    private Country nationality;
    private Location location;

    public Person(Long id, String name, Coordinates coordinates, LocalDateTime creationDate, int height,
                  EColor eyeColor, HColor hairColor, Country nationality, Location location) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.height = height;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.nationality = nationality;
        this.location = location;
    }
    public Long getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public Coordinates getCoordinates(){
        return coordinates;
    }
    public LocalDateTime getCreationDate(){
        return creationDate;
    }
    public int getHeight(){
        return height;
    }
    public EColor getEyeColor(){
        return eyeColor;
    }
    public HColor getHairColor(){
        return hairColor;
    }
    public Country getNationality(){
        return nationality;
    }
}
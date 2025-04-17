package com.epf.core.model;

public class Zombies {
    private int id;
    private String name;
    private int healthPoints;
    private float attackRate;
    private int attackDamage;
    private float movementSpeed;
    private String imagePath;
    private int mapId;

    public Zombies() {
    }

    public Zombies(int id, String name, int healthPoints, float attackRate, int attackDamage, float movementSpeed,
                    String imagePath, int mapId) {
        this.id = id;
        this.name = name;
        this.healthPoints = healthPoints;
        this.attackRate = attackRate;
        this.attackDamage = attackDamage;
        this.movementSpeed = movementSpeed;
        this.imagePath = imagePath;
        this.mapId = mapId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public float getAttackRate() {
        return attackRate;
    }

    public void setAttackRate(float attackRate) {
        this.attackRate = attackRate;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public float getMovementSpeed() {
        return movementSpeed;
    }

    public void setMovementSpeed(float movementSpeed) {
        this.movementSpeed = movementSpeed;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getMapId() {
        return mapId;
    }

    public void setMapId(int mapId) {
        this.mapId = mapId;
    }

    @Override
    public String toString() {
        return "Zombies : id=" + this.id + ", name=" + this.name + ", healthpoints=" + this.healthPoints +
                        ", attackrate=" + this.attackRate + ", attackdamage=" + this.attackDamage + ", movementspeed=" +
                        this.movementSpeed + ", imagepath=" + this.imagePath + ", mapid=" + this.mapId;
    }
}

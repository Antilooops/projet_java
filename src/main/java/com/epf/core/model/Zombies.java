package com.epf.core.model;

import com.epf.core.exception.BadAttributeException;

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

    public void setId(int id) throws BadAttributeException {
        if (id < 0) {
            throw new BadAttributeException("Id not set correctly. Cannot be less than 0.");
        } else {
            this.id = id;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws BadAttributeException {
        if (name == "") {
            throw new BadAttributeException("Name not set correctly. Cannot be empty.");
        } else if (name.length() > 255) {
            throw new BadAttributeException("Name not set correctly. Name to long.");
        } else {
            this.name = name;
        }
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) throws BadAttributeException {
        if (healthPoints <= 0) {
            throw new BadAttributeException("Healthpoints not set correctly. Cannot be less than or equal to 0.");
        } else {
            this.healthPoints = healthPoints;
        }
    }

    public float getAttackRate() {
        return attackRate;
    }

    public void setAttackRate(float attackRate) throws BadAttributeException {
        if (attackRate < 0.0f) {
            throw new BadAttributeException("Attackrate not set correctly. Cannot be less than 0.0");
        } else {
            this.attackRate = attackRate;
        }
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) throws BadAttributeException {
        if (attackDamage < 0) {
            throw new BadAttributeException("Attackdamage not set correctly. Cannot be less than 0.");
        } else {
            this.attackDamage = attackDamage;
        }
    }

    public float getMovementSpeed() {
        return movementSpeed;
    }

    public void setMovementSpeed(float movementSpeed) throws BadAttributeException {
        if (movementSpeed < 0.0f) {
            throw new BadAttributeException("Movementspeed not set correctly. Cannot be less than 0.0");
        } else {
            this.movementSpeed = movementSpeed;
        }
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) throws BadAttributeException {
        if (imagePath == null || imagePath.length() <= 255) {
            this.imagePath = imagePath;
        } else {
            throw new BadAttributeException("Name not set correctly. Name to long.");
        }
    }

    public int getMapId() {
        return mapId;
    }

    public void setMapId(int mapId) {
        if (mapId < 0) {
            throw new BadAttributeException("Mapid not set correctly. Cannot be less than 0.");
        } else {
            this.mapId = mapId;
        }
    }

    @Override
    public String toString() {
        return "Zombies : id=" + this.id + ", name=" + this.name + ", healthpoints=" + this.healthPoints +
                        ", attackrate=" + this.attackRate + ", attackdamage=" + this.attackDamage + ", movementspeed=" +
                        this.movementSpeed + ", imagepath=" + this.imagePath + ", mapid=" + this.mapId;
    }
}

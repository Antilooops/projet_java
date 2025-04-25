package com.epf.core.model;

import com.epf.core.exception.BadAttributeException;

public class Plants {
    private int id;
    private String name;
    private int healthPoints;
    private float attackRate;
    private int attackDamage;
    private int price;
    private float sunPerSecond;
    private Effects effect;
    private String imagePath;

    public Plants() {
    }

    public Plants(int id, String name, int healthPoints, float attackRate, int attackDamage, int price,
                    float sunPerSecond, Effects effect, String imagePath) {
        this.id = id;
        this.name = name;
        this.healthPoints = healthPoints;
        this.attackRate = attackRate;
        this.attackDamage = attackDamage;
        this.price = price;
        this.sunPerSecond = sunPerSecond;
        this.effect = effect;
        this.imagePath = imagePath;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
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
        return this.healthPoints;
    }

    public void setHealthPoints(int healthPoints) throws BadAttributeException {
        if (healthPoints <= 0) {
            throw new BadAttributeException("Healthpoints not set correctly. Cannot be less than or equal to 0.");
        } else {
            this.healthPoints = healthPoints;
        }
    }

    public float getAttackRate() {
        return this.attackRate;
    }

    public void setAttackRate(float attackRate) throws BadAttributeException {
        if (attackRate < 0.0f) {
            throw new BadAttributeException("Attackrate not set correctly. Cannot be less than 0.0");
        } else {
            this.attackRate = attackRate;
        }
    }

    public int getAttackDamage() {
        return this.attackDamage;
    }

    public void setAttackDamage(int attackDamage) throws BadAttributeException {
        if (attackDamage < 0) {
            throw new BadAttributeException("Attackdamage not set correctly. Cannot be less than 0.");
        } else {
            this.attackDamage = attackDamage;
        }
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) throws BadAttributeException {
        if (price < 0) {
            throw new BadAttributeException("Price not set correctly. Cannot be less than 0.");
        } else {
            this.price = price;
        }
    }

    public float getSunPerSecond() {
        return this.sunPerSecond;
    }

    public void setSunPerSecond(float sunPerSecond) throws BadAttributeException {
        if (sunPerSecond < 0.0f) {
            throw new BadAttributeException("Sunpersecond not set correctly. Cannot be less than or equal to 0.0");
        } else {
            this.sunPerSecond = sunPerSecond;
        }
    }

    public Effects getEffect() {
        return this.effect;
    }

    public void setEffect(Effects effect) throws BadAttributeException {
        this.effect = effect;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public void setImagePath(String imagePath) throws BadAttributeException {
        if (imagePath == null || imagePath.length() <= 255) {
            this.imagePath = imagePath;
        } else {
            throw new BadAttributeException("Name not set correctly. Name to long.");
        }
    }

    @Override
    public String toString() {
        return "Plants : id=" + this.id + ", name=" + this.name + ", healthpoints=" +
                        this.healthPoints + ", attackrate=" + this.attackRate + ", attackdamage=" +
                        this.attackDamage + ", price=" + this.price + ", sunpersecond=" + this.sunPerSecond +
                        ", effect=" + this.effect + ", imagepath=" + this.imagePath;
    }
}

package com.epf.core.model;

public class Plants {
    private int id;
    private String name;
    private int healthPoints;
    private float attackPerSecond;
    private int attackDamage;
    private int price;
    private float sunPerSecond;
    private Effects effect;
    private String imagePath;

    public Plants() {
    }

    public Plants(int id, String name, int healthPoints, float attackPerSecond, int attackDamage, int price,
                    float sunPerSecond, Effects effect, String imagePath) {
        this.id = id;
        this.name = name;
        this.healthPoints = healthPoints;
        this.attackPerSecond = attackPerSecond;
        this.attackDamage = attackDamage;
        this.price = price;
        this.sunPerSecond = sunPerSecond;
        this.effect = effect;
        this.imagePath = imagePath;
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

    public float getAttackPerSecond() {
        return attackPerSecond;
    }

    public void setAttackPerSecond(float attackPerSecond) {
        this.attackPerSecond = attackPerSecond;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public float getSunPerSecond() {
        return sunPerSecond;
    }

    public void setSunPerSecond(float sunPerSecond) {
        this.sunPerSecond = sunPerSecond;
    }

    public Effects getEffect() {
        return effect;
    }

    public void setEffect(Effects effect) {
        this.effect = effect;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}

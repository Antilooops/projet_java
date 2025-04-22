package com.epf.api.dto;

import com.epf.core.model.Effects;

public class PlantsDTO {
    private int id;
    private String name;
    private int healthPoints;
    private float attackRate;
    private int attackDamage;
    private int price;
    private float sunPerSecond;
    private Effects effect;
    private String imagePath;

    public PlantsDTO() {
    }

    public PlantsDTO(int id, String name, int healthPoints, float attackRate, int attackDamage, int price,
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

    @Override
    public String toString() {
        return "PlantsDTO : id=" + this.id + ", name=" + this.name + ", healthpoints=" +
                        this.healthPoints + ", attackrate=" + this.attackRate + ", attackdamage=" +
                        this.attackDamage + ", price=" + this.price + ", sunpersecond=" + this.sunPerSecond +
                        ", effect=" + this.effect + ", imagepath=" + this.imagePath;
    }
}

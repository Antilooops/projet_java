package com.epf.api.dto;

import com.epf.core.model.Effects;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PlantsDTO {
    @JsonProperty("id_plante")
    private int id;
    @JsonProperty("nom")
    private String name;
    @JsonProperty("point_de_vie")
    private int healthPoints;
    @JsonProperty("attaque_par_seconde")
    private float attackRate;
    @JsonProperty("degat_attaque")
    private int attackDamage;
    @JsonProperty("cout")
    private int price;
    @JsonProperty("soleil_par_seconde")
    private float sunPerSecond;
    @JsonProperty("effet")
    private Effects effect;
    @JsonProperty("chemin_image")
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
        return "Plants : id=" + this.id + ", name=" + this.name + ", healthpoints=" +
                        this.healthPoints + ", attackrate=" + this.attackRate + ", attackdamage=" +
                        this.attackDamage + ", price=" + this.price + ", sunpersecond=" + this.sunPerSecond +
                        ", effect=" + this.effect + ", imagepath=" + this.imagePath;
    }
}

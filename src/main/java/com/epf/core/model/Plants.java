package com.epf.core.model;

import com.epf.core.exception.BadAttributException;

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
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws BadAttributException {
        if (name == "") {
            throw new BadAttributException("Name not set correctly. Cannot be empty.");
        } else if (name.length() > 255) {
            throw new BadAttributException("Name not set correctly. Name to long.");
        } else {
            this.name = name;
        }
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) throws BadAttributException {
        if (healthPoints <= 0) {
            throw new BadAttributException("Healthpoints not set correctly. Cannot be less than or equal to 0.");
        } else {
            this.healthPoints = healthPoints;
        }
    }

    public float getAttackRate() {
        return attackRate;
    }

    public void setAttackRate(float attackRate) throws BadAttributException {
        if (attackRate < 0.0f) {
            throw new BadAttributException("Attackrate not set correctly. Cannot be less than 0.0");
        } else {
            this.attackRate = attackRate;
        }
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) throws BadAttributException {
        if (attackDamage < 0) {
            throw new BadAttributException("Attackdamage not set correctly. Cannot be less than 0.");
        } else {
            this.attackDamage = attackDamage;
        }
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) throws BadAttributException {
        if (price < 0) {
            throw new BadAttributException("Price not set correctly. Cannot be less than 0.");
        } else {
            this.price = price;
        }
    }

    public float getSunPerSecond() {
        return sunPerSecond;
    }

    public void setSunPerSecond(float sunPerSecond) throws BadAttributException {
        if (sunPerSecond < 0.0f) {
            throw new BadAttributException("Sunpersecond not set correctly. Cannot be less than or equal to 0.0");
        } else {
            this.sunPerSecond = sunPerSecond;
        }
    }

    public Effects getEffect() {
        return effect;
    }

    public void setEffect(Effects effect) throws BadAttributException {
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

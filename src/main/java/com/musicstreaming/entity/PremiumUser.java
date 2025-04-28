package com.musicstreaming.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("PREMIUM")
public class PremiumUser extends User {
    private boolean hasAdFreeExperience;

    public boolean isHasAdFreeExperience() {
        return hasAdFreeExperience;
    }

    public void setHasAdFreeExperience(boolean hasAdFreeExperience) {
        this.hasAdFreeExperience = hasAdFreeExperience;
    }
}

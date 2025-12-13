package com.bitspilani.leadmanager.model;

public class Policy {
    private final boolean allowTravelMeals;
    private final boolean allowNonTravelMeals;

    public double getTravelDailyLimit() {
        return travelDailyLimit;
    }

    public double getNonTravelDailyLimit() {
        return nonTravelDailyLimit;
    }

    private final double travelDailyLimit;
    private final double nonTravelDailyLimit;

    public Policy(boolean allowTravelMeals,
                  boolean allowNonTravelMeals,
                  double travelDailyLimit,
                  double nonTravelDailyLimit) {
        this.allowTravelMeals = allowTravelMeals;
        this.allowNonTravelMeals = allowNonTravelMeals;
        this.travelDailyLimit = travelDailyLimit;
        this.nonTravelDailyLimit = nonTravelDailyLimit;
    }

    public boolean isAllowTravelMeals() {
        return allowTravelMeals;
    }

    public boolean isAllowNonTravelMeals() {
        return allowNonTravelMeals;
    }
}
package com.foxforce.study.cubecartobjects;

public class PromotionalCodesObject {
    private String startsDate;
    private String expiresDate;
    private String allowedUses;
    private String  minimumSubtotal;
    private String limitToManufacturer;

    public PromotionalCodesObject(String startsDate, String expiresDate,String allowedUses,
                                  String  minimumSubtotal,String limitToManufacturer) {
        this.startsDate = startsDate;
        this.expiresDate = expiresDate;
        this.allowedUses = allowedUses;
        this.minimumSubtotal = minimumSubtotal;
        this.limitToManufacturer = limitToManufacturer;
    }

    public String getStartsDate() {
        return startsDate;
    }

    public void setStartsDate(String startsDate) {
        this.startsDate = startsDate;
    }

    public String getExpiresDate() {
        return expiresDate;
    }

    public void setExpiresDate(String expiresDate) {
        this.expiresDate = expiresDate;
    }

    public String getAllowedUses() {
        return allowedUses;
    }

    public void setAllowedUses(String allowedUses) {
        this.allowedUses = allowedUses;
    }

    public String  getMinimumSubtotal() {
        return minimumSubtotal;
    }

    public void setMinimumSubtotal(String  minimumSubtotal) {
        this.minimumSubtotal = minimumSubtotal;
    }

    public String getLimitToManufacturer() {
        return limitToManufacturer;
    }

    public void setLimitToManufacturer(String limitToManufacturer) {
        this.limitToManufacturer = limitToManufacturer;
    }
}

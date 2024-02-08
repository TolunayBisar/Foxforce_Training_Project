package com.foxforce.study.cubecartobjects;

public class OrderObject {
    private String customerInfo;
    private String dispatchDate;
    private String shippingMethod;
    private String shippingDate;
    private String deliveryTracking;
    private double weight;
    private int quantity;
    private String productName;
    private double discountAmount;
    private double shippingCost;
    private double taxAmount;
    private String internalNotes;
    private String publicNotes;

    public OrderObject() {
    }

    public OrderObject(String customerInfo, String dispatchDate, String shippingMethod, String shippingDate, String deliveryTracking, double weight, int quantity, String productName, double discountAmount, double shippingCost, double taxAmount, String internalNotes, String publicNotes) {
        this.customerInfo = customerInfo;
        this.dispatchDate = dispatchDate;
        this.shippingMethod = shippingMethod;
        this.shippingDate = shippingDate;
        this.deliveryTracking = deliveryTracking;
        this.weight = weight;
        this.quantity = quantity;
        this.productName = productName;
        this.discountAmount = discountAmount;
        this.shippingCost = shippingCost;
        this.taxAmount = taxAmount;
        this.internalNotes = internalNotes;
        this.publicNotes = publicNotes;
    }

    public String getCustomerInfo() {
        return customerInfo;
    }

    public String getDispatchDate() {
        return dispatchDate;
    }

    public String getShippingMethod() {
        return shippingMethod;
    }

    public String getShippingDate() {
        return shippingDate;
    }

    public String getDeliveryTracking() {
        return deliveryTracking;
    }

    public double getWeight() {
        return weight;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getProductName() {
        return productName;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public double getShippingCost() {
        return shippingCost;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public String getInternalNotes() {
        return internalNotes;
    }

    public String getPublicNotes() {
        return publicNotes;
    }
}

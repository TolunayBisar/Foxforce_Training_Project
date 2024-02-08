package com.foxforce.study.cubecartobjects;

import com.github.javafaker.Stock;

/**
 * @author : Alim Hamut
 * @created : 2023-10-16,10:45 p.m.
 * @Email : alimhamut.job@gmail.com
 **/
public class ProductObjectClass {
    private boolean status, automaticallyGenerateProductCode, includeInFeaturedProducts, includeInLatestProducts, availableForPurchase,
            useStockLevel, taxIncluded, optionDefault, optionNegative;
    private String productName, brand, condition, productCode, productWeight, dimensionUnit, productWidth, productHeight, productDepth,
                    stockLevel, stockLeverWarning, upcCode, eanCode, janCode, isbnCode, gtinCode, mpnCode, googleCategory, description,
                    shortDescription, retailPrice, costPrice, taxClass, maximumQuantityPurchase, categoryName, optionName, optionPrice, optionAbsolutePrice, optionSet, metaTitle, customSeoUrlPath,
                    metaDescription, folderName;
    private int minimumQuantityPurchase, quantity;
    private double price, salePrice;

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isAutomaticallyGenerateProductCode() {
        return automaticallyGenerateProductCode;
    }

    public void setAutomaticallyGenerateProductCode(boolean automaticallyGenerateProductCode) {
        this.automaticallyGenerateProductCode = automaticallyGenerateProductCode;
    }

    public boolean isIncludeInFeaturedProducts() {
        return includeInFeaturedProducts;
    }

    public void setIncludeInFeaturedProducts(boolean includeInFeaturedProducts) {
        this.includeInFeaturedProducts = includeInFeaturedProducts;
    }

    public boolean isIncludeInLatestProducts() {
        return includeInLatestProducts;
    }

    public void setIncludeInLatestProducts(boolean includeInLatestProducts) {
        this.includeInLatestProducts = includeInLatestProducts;
    }

    public boolean isAvailableForPurchase() {
        return availableForPurchase;
    }

    public void setAvailableForPurchase(boolean availableForPurchase) {
        this.availableForPurchase = availableForPurchase;
    }

    public boolean isUseStockLevel() {
        return useStockLevel;
    }

    public void setUseStockLevel(boolean useStockLevel) {
        this.useStockLevel = useStockLevel;
    }

    public boolean isTaxIncluded() {
        return taxIncluded;
    }

    public void setTaxIncluded(boolean taxIncluded) {
        this.taxIncluded = taxIncluded;
    }

    public boolean isOptionDefault() {
        return optionDefault;
    }

    public void setOptionDefault(boolean optionDefault) {
        this.optionDefault = optionDefault;
    }

    public boolean isOptionNegative() {
        return optionNegative;
    }

    public void setOptionNegative(boolean optionNegative) {
        this.optionNegative = optionNegative;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductWeight() {
        return productWeight;
    }

    public void setProductWeight(String productWeight) {
        this.productWeight = productWeight;
    }

    public String getDimensionUnit() {
        return dimensionUnit;
    }

    public void setDimensionUnit(String dimensionUnit) {
        this.dimensionUnit = dimensionUnit;
    }

    public String getProductWidth() {
        return productWidth;
    }

    public void setProductWidth(String productWidth) {
        this.productWidth = productWidth;
    }

    public String getProductHeight() {
        return productHeight;
    }

    public void setProductHeight(String productHeight) {
        this.productHeight = productHeight;
    }

    public String getProductDepth() {
        return productDepth;
    }

    public void setProductDepth(String productDepth) {
        this.productDepth = productDepth;
    }

    public String getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(String stockLevel) {
        this.stockLevel = stockLevel;
    }

    public String getStockLeverWarning() {
        return stockLeverWarning;
    }

    public void setStockLeverWarning(String stockLeverWarning) {
        this.stockLeverWarning = stockLeverWarning;
    }

    public String getUpcCode() {
        return upcCode;
    }

    public void setUpcCode(String upcCode) {
        this.upcCode = upcCode;
    }

    public String getEanCode() {
        return eanCode;
    }

    public void setEanCode(String eanCode) {
        this.eanCode = eanCode;
    }

    public String getJanCode() {
        return janCode;
    }

    public void setJanCode(String janCode) {
        this.janCode = janCode;
    }

    public String getIsbnCode() {
        return isbnCode;
    }

    public void setIsbnCode(String isbnCode) {
        this.isbnCode = isbnCode;
    }

    public String getGtinCode() {
        return gtinCode;
    }

    public void setGtinCode(String gtinCode) {
        this.gtinCode = gtinCode;
    }

    public String getMpnCode() {
        return mpnCode;
    }

    public void setMpnCode(String mpnCode) {
        this.mpnCode = mpnCode;
    }

    public String getGoogleCategory() {
        return googleCategory;
    }

    public void setGoogleCategory(String googleCategory) {
        this.googleCategory = googleCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(String retailPrice) {
        this.retailPrice = retailPrice;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public String getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(String costPrice) {
        this.costPrice = costPrice;
    }

    public String getTaxClass() {
        return taxClass;
    }

    public void setTaxClass(String taxClass) {
        this.taxClass = taxClass;
    }

    public int getMinimumQuantityPurchase() {
        return minimumQuantityPurchase;
    }

    public void setMinimumQuantityPurchase(int minimumQuantityPurchase) {
        this.minimumQuantityPurchase = minimumQuantityPurchase;
    }

    public String getMaximumQuantityPurchase() {
        return maximumQuantityPurchase;
    }

    public void setMaximumQuantityPurchase(String maximumQuantityPurchase) {
        this.maximumQuantityPurchase = maximumQuantityPurchase;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public String getOptionPrice() {
        return optionPrice;
    }

    public void setOptionPrice(String optionPrice) {
        this.optionPrice = optionPrice;
    }

    public String getOptionAbsolutePrice() {
        return optionAbsolutePrice;
    }

    public void setOptionAbsolutePrice(String optionAbsolutePrice) {
        this.optionAbsolutePrice = optionAbsolutePrice;
    }

    public String getOptionSet() {
        return optionSet;
    }

    public void setOptionSet(String optionSet) {
        this.optionSet = optionSet;
    }

    public String getMetaTitle() {
        return metaTitle;
    }

    public void setMetaTitle(String metaTitle) {
        this.metaTitle = metaTitle;
    }

    public String getCustomSeoUrlPath() {
        return customSeoUrlPath;
    }

    public void setCustomSeoUrlPath(String customSeoUrlPath) {
        this.customSeoUrlPath = customSeoUrlPath;
    }

    public String getMetaDescription() {
        return metaDescription;
    }

    public void setMetaDescription(String metaDescription) {
        this.metaDescription = metaDescription;
    }
}

package com.foxforce.study.inventory;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonDataCategory {
    @JsonProperty("CategoryName1")
    private String CategoryName1;
    @JsonProperty("Description")
    private String Description;
    @JsonProperty("FolderName")
    private String FolderName;
    @JsonProperty("MetaTitle")
    private String MetaTitle;
    @JsonProperty("SeoPath")
    private String SeoPath;
    @JsonProperty("MetaDescription")
    private String MetaDescription;
    @JsonProperty("subCategoryName")
    private String subCategoryName;
    @JsonProperty("editCategoryName")
    private String editCategoryName;

    public JsonDataCategory() {
    }

    public String getCategoryName1() {
        return CategoryName1;
    }

    public void setCategoryName1(String categoryName1) {
        CategoryName1 = categoryName1;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getFolderName() {
        return FolderName;
    }

    public void setFolderName(String folderName) {
        FolderName = folderName;
    }

    public String getMetaTitle() {
        return MetaTitle;
    }

    public void setMetaTitle(String metaTitle) {
        MetaTitle = metaTitle;
    }

    public String getSeoPath() {
        return SeoPath;
    }

    public void setSeoPath(String seoPath) {
        SeoPath = seoPath;
    }

    public String getMetaDescription() {
        return MetaDescription;
    }

    public void setMetaDescription(String metaDescription) {
        MetaDescription = metaDescription;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public String getEditCategoryName() {
        return editCategoryName;
    }

    public void setEditCategoryName(String editCategoryName) {
        this.editCategoryName = editCategoryName;
    }

    public JsonDataCategory(String categoryName1, String description, String folderName, String metaTitle, String seoPath, String metaDescription, String subCategoryName, String editCategoryName) {
        CategoryName1 = categoryName1;
        Description = description;
        FolderName = folderName;
        MetaTitle = metaTitle;
        SeoPath = seoPath;
        MetaDescription = metaDescription;
        this.subCategoryName = subCategoryName;
        this.editCategoryName = editCategoryName;
    }
}

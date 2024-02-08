package com.foxforce.study.petstore_api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author : tolunaybisar
 * @created : 8.02.2024,19:50
 * @Email :tolunay.bisar@gmail.com
 **/
public class PayloadsObject {

    /*      {
  "id": 0,
  "category": {
    "id": 0,
    "name": "string"
  },
  "name": "doggie",
  "photoUrls": [
    "string"
  ],
  "tags": [
    {
      "id": 0,
      "name": "string"
    }
  ],
  "status": "available"
} */
    @JsonProperty("id")
    private int id;
    @JsonProperty("category")
    private String category;
    @JsonProperty("name")
    private String name;
    @JsonProperty("tags")
    private String tags;
    @JsonProperty("status")
    private String status;

    public PayloadsObject(int id, String category, String name, String tags, String status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.tags = tags;
        this.status = status;
    }
}

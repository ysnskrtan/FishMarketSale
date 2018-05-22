package com.fishmarket.salerestapi.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sales")
public class Sale {

	@Id
	String id;
	String title;
	String locationId;
	String locationName;
	String userId;
	String price;
	String fishId;
	String fishName;
	boolean isNewFish;
	boolean isNewLocation;
	
	public Sale() {
		
	}
	
	public Sale(String title, String locationId, String locationName, String userId, String price) {
		this.title = title;
		this.locationId = locationId;
		this.locationName = locationName;
		this.userId = userId;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public boolean isNewLocation() {
		return isNewLocation;
	}

	public void setNewLocation(boolean isNewLocation) {
		this.isNewLocation = isNewLocation;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getFishId() {
		return fishId;
	}

	public void setFishId(String fishId) {
		this.fishId = fishId;
	}

	public String getFishName() {
		return fishName;
	}

	public void setFishName(String fishName) {
		this.fishName = fishName;
	}

	public boolean isNewFish() {
		return isNewFish;
	}

	public void setNewFish(boolean isNewFish) {
		this.isNewFish = isNewFish;
	}

}

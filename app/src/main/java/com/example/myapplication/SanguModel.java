package com.example.myapplication;

public class SanguModel {
    String claim_number;
    String title;
    String claimDate;
    String status;
    int totalAmount;
    String categoryName;
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SanguModel(String claim_number, String title, String claimDate, String status, int totalAmount, String categoryName, int id) {
        this.claim_number = claim_number;
        this.title = title;
        this.claimDate = claimDate;
        this.status = status;
        this.totalAmount = totalAmount;
        this.categoryName = categoryName;
        this.id = id;
    }


    public String getClaim_number() {
        return claim_number;
    }

    public void setClaim_number(String claim_number) {
        this.claim_number = claim_number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(String claimDate) {
        this.claimDate = claimDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}

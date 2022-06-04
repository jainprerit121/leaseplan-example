package com.qlick.assignment.dtos.search;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchProductResponse{
    public String provider;
    public String title;
    public String url;
    public String brand;
    public double price;
    public String unit;
    public boolean isPromo;
    public String promoDetails;
    public String image;
}
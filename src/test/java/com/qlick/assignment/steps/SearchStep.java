package com.qlick.assignment.steps;

import com.qlick.assignment.EndPoints;
import com.qlick.assignment.dtos.SearchProductResponse;
import com.qlick.assignment.utils.SerenityRestUtils;
import net.thucydides.core.annotations.Shared;
import net.thucydides.core.annotations.Step;
import org.apache.http.HttpStatus;
import org.junit.Assert;

import java.util.Arrays;
import java.util.Locale;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.*;

public class SearchStep {

    @Shared
    private SerenityRestUtils serenityRestUtils;

    @Step("Search product returns with success")
    public void searchProduct(String product){
        serenityRestUtils.getSuccess(EndPoints.SEARCH_PRODUCT_V1, "PRODUCT", product);
    }

    @Step("Search invalid product returns with error")
    public void searchInvalidProduct(String product){
        serenityRestUtils.get(EndPoints.SEARCH_PRODUCT_V1, "PRODUCT", product, HttpStatus.SC_NOT_FOUND);
    }

    @Step("Verify search product api contains searched product")
    public void verifySearchedProduct(String product){
        Arrays.stream(lastResponse().body().as(SearchProductResponse[].class)).forEach(rec -> {
            if(!rec.getTitle().toLowerCase(Locale.ROOT).contains(product))
                System.out.println(rec.getTitle() + " <======> " + product);
            Assert.assertTrue(rec.getTitle().toLowerCase(Locale.ROOT).contains(product));
        });
    }

    @Step("Verify search response contains error")
    public void verifySearchedProductError(){
        restAssuredThat(response -> response.body("detail.error", equalTo(true)));
    }
}

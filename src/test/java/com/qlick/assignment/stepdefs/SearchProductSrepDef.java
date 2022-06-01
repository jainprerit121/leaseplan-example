package com.qlick.assignment.stepdefs;

import com.qlick.assignment.steps.SearchStep;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class SearchProductSrepDef {
    @Steps
    SearchStep searchStep;

    @When("Search product {string} returns with success")
    public void searchProduct(String product){
        searchStep.searchProduct(product);
    }

    @When("Search invalid product {string} returns with not found error")
    public void searchInvalidProduct(String product){
        searchStep.searchInvalidProduct(product);
    }

    @Then("Verify search product {string} api contains searched product")
    public void verifySearchProduct(String product){
        searchStep.verifySearchedProduct(product);
    }

    @Then("Verify search product response contains error")
    public void verifySearchedProductError(){
        searchStep.verifySearchedProductError();
    }
}

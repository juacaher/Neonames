package co.com.appgate.certification.geonames.stepdefinitions;

import co.com.appgate.certification.geonames.questions.ValidateCountryCode;
import co.com.appgate.certification.geonames.questions.ValidateCountryName;
import cucumber.api.java.en.Then;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;

public class ConsumeApiCountryCodeSuccessStepDefinitions {

    @Then("^he should see the information the success country code for (.*)$")
    public void heShouldSeeTheInformationTheSuccessCountryCodeForChina(String country) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidateCountryCode.verify(country)));
    }
}

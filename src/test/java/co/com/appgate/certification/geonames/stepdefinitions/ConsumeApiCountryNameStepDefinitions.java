package co.com.appgate.certification.geonames.stepdefinitions;

import co.com.appgate.certification.geonames.models.ModelDataInformation;
import co.com.appgate.certification.geonames.questions.ValidateCountryName;
import co.com.appgate.certification.geonames.tasks.ConsultCountryName;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import static co.com.appgate.certification.geonames.utils.Constants.BASE_URL;

import java.util.List;

public class ConsumeApiCountryNameStepDefinitions {

    @Given("^user call an api$")
    public void userCallAnApi() {
        OnStage.setTheStage(OnlineCast.whereEveryoneCan(CallAnApi.at(BASE_URL)));
        SerenityRest.useRelaxedHTTPSValidation();
    }

    @When("^the user consumes the api with the lat and lon parameters$")
    public void theUserConsumesTheApiWithTheLatAndLonParameters(List<ModelDataInformation> dataInformation) {
        OnStage.theActorCalled("Camilo").attemptsTo(
               ConsultCountryName.with(dataInformation)
        );
    }

    @Then("^he should see the information the Country Name for (.*)$")
    public void heShouldSeeTheInformationTheCountryNameForColombia(String country) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidateCountryName.verify(country)));
    }
}

package co.com.appgate.certification.geonames.stepdefinitions;

import co.com.appgate.certification.geonames.models.ModelDataInformation;
import co.com.appgate.certification.geonames.questions.ValidateCountryCode;
import co.com.appgate.certification.geonames.questions.ValidateInvalidUser;
import co.com.appgate.certification.geonames.tasks.ConsultCountryCode;
import co.com.appgate.certification.geonames.tasks.ConsultInvalidUser;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.List;

public class InvalidUserStepDefinitions {

    @When("^the user consumes the api with the lat and lon parameters and user invalid$")
    public void theUserConsumesTheApiWithTheLatAndLonParametersAndUserInvalid(List<ModelDataInformation> dataInformation) {
        OnStage.theActorCalled("Camilo").attemptsTo(
                ConsultInvalidUser.with(dataInformation)
        );
    }

    @Then("^he should see the information the error message$")
    public void heShouldSeeTheInformationTheErrorMessage(List<ModelDataInformation> dataInformation) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidateInvalidUser.verify(dataInformation)));
    }
}

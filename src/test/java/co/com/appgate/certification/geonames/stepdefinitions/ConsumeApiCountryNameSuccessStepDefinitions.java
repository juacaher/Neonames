package co.com.appgate.certification.geonames.stepdefinitions;

import co.com.appgate.certification.geonames.models.ModelDataInformation;
import co.com.appgate.certification.geonames.questions.ValidateCountryName;
import co.com.appgate.certification.geonames.tasks.ConsultCountryCode;
import co.com.appgate.certification.geonames.tasks.ConsultCountryName;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import java.util.List;

public class ConsumeApiCountryNameSuccessStepDefinitions {

    @When("^the user consumes the api with the lat and lon parameters country code$")
    public void theUserConsumesTheApiWithTheLatAndLonParametersCountryCode(List<ModelDataInformation> dataInformation) {
        OnStage.theActorCalled("Camilo").attemptsTo(
                ConsultCountryCode.with(dataInformation)
        );
    }

    @Then("^he should see the information the success country name for (.*)$")
    public void heShouldSeeTheInformationTheSuccessCountryNameForArgentina(String country) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidateCountryName.verify(country)));
    }
}

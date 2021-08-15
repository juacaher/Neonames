package co.com.appgate.certification.geonames.runners;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features ="src/test/resources/features/consume_api_countryname_success.feature",
        glue = "co.com.appgate.certification.geonames.stepdefinitions",
        tags = {"@successJapan, @successArgentina, @successFrance"},
        snippets = SnippetType.CAMELCASE)
public class ConsumeApiCountryNameSuccess {
}

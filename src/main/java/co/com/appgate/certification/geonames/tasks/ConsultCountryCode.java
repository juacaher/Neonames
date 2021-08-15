package co.com.appgate.certification.geonames.tasks;

import co.com.appgate.certification.geonames.models.ModelDataInformation;
import co.com.appgate.certification.geonames.models.ModelGeoNames;
import co.com.appgate.certification.geonames.utils.Headers;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

import java.util.List;

import static co.com.appgate.certification.geonames.utils.Constants.URL_REQUEST;

public class ConsultCountryCode implements Task {

    private List<ModelDataInformation> data;

    public ConsultCountryCode(List<ModelDataInformation> data) {
        this.data = data;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(String.format(URL_REQUEST, data.get(0).getLatitude(), data.get(0).getLength())).with(request -> request
                        .header(Headers.CONTENT_TYPE.getKey(), Headers.CONTENT_TYPE.getValue())
                )
        );
        ModelGeoNames country = new ModelGeoNames();
        country.setCountryCode(SerenityRest.lastResponse().jsonPath().get("countryCode").toString());
        actor.remember("COUNTRYCODE",country.getCountryCode());
    }

    public static ConsultCountryCode with(List<ModelDataInformation> data) {
        return Tasks.instrumented(ConsultCountryCode.class, data);
    }
}

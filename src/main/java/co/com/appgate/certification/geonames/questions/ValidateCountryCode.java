package co.com.appgate.certification.geonames.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;


public class ValidateCountryCode implements Question<Boolean> {

    private String Country;

    public ValidateCountryCode(String country) {
        Country = country;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return Country.equals(actor.recall("COUNTRYCODE"));
    }

    public static ValidateCountryCode verify(String country){
        return new ValidateCountryCode(country);
    }
}

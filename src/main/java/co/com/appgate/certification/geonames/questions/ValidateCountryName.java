package co.com.appgate.certification.geonames.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;


public class ValidateCountryName implements Question<Boolean> {

    private String Country;

    public ValidateCountryName(String country) {
        Country = country;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return Country.equals(actor.recall("COUNTRYNAME"));
    }

    public static ValidateCountryName verify(String country){
        return new ValidateCountryName(country);
    }
}

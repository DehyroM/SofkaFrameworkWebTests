package co.com.automationpractice.webproject.test.helpers;

import co.com.automationpractice.webproject.test.model.Customer;
import co.com.sofka.test.evidence.reports.Report;
import com.github.javafaker.Faker;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static co.com.automationpractice.webproject.test.helpers.Dictionary.*;

public class Helper {

    private Helper(){

    }
    private static int number;

    public static String getProperty(String property){
        Properties properties = new Properties();

        try (FileReader fileReader = new FileReader(CONFIGURATION_PROPERTIES_FILE)){
            properties.load(fileReader);

        }catch (IOException e){
            Report.reportFailure(PROPERTIES_ERROR + CONFIGURATION_PROPERTIES_FILE, e);
        }

        return properties.getProperty(property);
    }

    public static Customer generateCustomer(String emailDomain){

        Faker faker = new Faker();
        number = faker.number().numberBetween(0, 2);

        Customer customer = new Customer();

        customer.setTitle(theTitle(number));
        customer.setFirstName(faker.name().firstName());
        customer.setLastName(faker.name().lastName());
        customer.setEmail(
                customer.getFirstName()
                        .concat("_")
                        .concat(customer.getLastName())
                        .concat(emailDomain)
                        .replace(SPACE_STRING, EMPTY_STRING)
        );

        customer.setPassword(faker.number().digits(8));
        customer.setDayBirth(String.valueOf(faker.number().numberBetween(1, 29)));
        customer.setMonthBirth(String.valueOf(faker.number().numberBetween(1, 13)));
        customer.setYearBirth(String.valueOf(faker.number().numberBetween(1980, 2003)));

        customer.setAddress(faker.address().fullAddress());
        customer.setCity(faker.address().city());
        customer.setPostalCode(String.valueOf(faker.number().numberBetween(10000,99999)));
        customer.setMobilePhone(
                String.valueOf(
                                faker
                                        .number()
                                        .numberBetween(300000000, 399999999))
                        .concat(
                                String.valueOf(
                                        faker.number()
                                                .numberBetween(1, 9)
                                )
                        )
        );
        customer.setState(faker.address().state());
        customer.setAlias(faker.superhero().name().concat(" Home"));

        return customer;
    }

    public static Customer generateCustomerForContactUs(String emailDomain){

        Faker faker = new Faker();

        Customer customer = new Customer();
        number = faker.number().numberBetween(0, 2);

        customer.setFirstName(faker.name().firstName());
        customer.setLastName(faker.name().lastName());
        customer.setEmail(
                customer.getFirstName()
                        .concat("_")
                        .concat(customer.getLastName())
                        .concat(emailDomain)
                        .replace(SPACE_STRING, EMPTY_STRING)
        );

        customer.setProduct(faker.commerce().productName());
        customer.setOrder("Query about "+customer.getProduct());
        customer.setMessage("I would like to know if you have this product: "+customer.getProduct());
        customer.setSubject(theSubject(number));

        return customer;
    }

    public static Title theTitle(int titleItem){
        Title[] titleNames = {Title.MR, Title.MRS};
        return titleNames[titleItem];
    }

    public static Subject theSubject(int subjectItem){
        Subject[] subjectNames = {Subject.CUSTOMER_SERVICE, Subject.WEBMASTER};
        return subjectNames[subjectItem];
    }

}

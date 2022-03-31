package co.com.automationpractice.webproject.test.helpers;


public enum Subject {

    CUSTOMER_SERVICE("Customer service"),
    WEBMASTER("Webmaster");

    private final String value;

    public String getValue(){
        return value;
    }

    Subject(String value){
        this.value = value;
    }

}

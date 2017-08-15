package webstore.domain;

public class Customer {

    private String customerId;
    private String name;
    private int noOfOrdersMade;

    public Customer(){
        super();
    }

    public Customer(String customerId, String name, int noOfOrdersMade) {
        this.customerId = customerId;
        this.name = name;
        this.noOfOrdersMade = noOfOrdersMade;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNoOfOrdersMade() {
        return noOfOrdersMade;
    }

    public void setNoOfOrdersMade(int noOfOrdersMade) {
        this.noOfOrdersMade = noOfOrdersMade;
    }
}

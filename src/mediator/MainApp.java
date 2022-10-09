package mediator;

/**
 * @author Ruobing Shang 2022-10-09 15:03
 */
public class MainApp {
    public static void main(String[] args) {
        Mediator houseMediator = new HouseMediator();
        Landlord landlord = new Landlord("Landlord");
        Tenant tenantA = new Tenant("TenantA");
        Tenant tenantB = new Tenant("TenantB");
        houseMediator.register(landlord);
        houseMediator.register(tenantA);
        houseMediator.register(tenantB);
        landlord.send("I have two houses for rent.");
        tenantA.send("I'd like to rent one of them.");
    }
}

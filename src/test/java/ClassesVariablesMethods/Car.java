package ClassesVariablesMethods;
import org.checkerframework.framework.qual.LiteralKind;
import org.testng.annotations.Test;
//
//Basic Class with Local and Global Variables
public class Car {

    //Definim propietatile clasei:

    //Global variable
    public String Brand;  // declaram variabila

    @Test //TestNG annotation
    //metoda:
    public void DisplayDetails(){
        Brand = "Toyota";  // initializam variabila
        //Local variable
        String Model = "Yaris";
        Integer Year = 2024;
        Boolean ConditionNew = true;
        Double Engine = 1.5;

        //Afisam info de sus:
        System.out.println("Car Specifications: ");
        System.out.println("Brand: " + Brand);
        System.out.println("Model: " + Model);
        System.out.println("Year: " + Year);
        System.out.println("Condition: " + ConditionNew);
        System.out.println("Engine: " + Engine);

        //apelam meteda FuelConsumption de jos
        FuelConsumption();
    }

    public void FuelConsumption(){
        //Local variable
        Integer Liters = 10;
        Integer Km = 217;
        Double Average = (double) Liters / Km * 100  ;   // (double)= converts Integer to a double
        System.out.println("Fuel Consumption (Liters per 100 km): " + Average);
    }

}

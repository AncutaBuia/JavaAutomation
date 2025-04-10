package OOP;



public class Prajitura {

    //Declaram parametri
    public Integer oua;
    public Integer faina;
    public Boolean indulcitor;
    public String aroma;
    public String fructe;

    //Generam constructor 1
    public Prajitura(Integer faina, Integer oua, Boolean indulcitor, String aroma, String fructe) {
        this.faina = faina;
        this.indulcitor = indulcitor;
        this.aroma = aroma;
        this.fructe = fructe;
        this.oua = oua;
    }
    //Generam constructor 2
    public Prajitura(Integer faina, Boolean indulcitor, String aroma) {
        this.faina = faina;
        this.indulcitor = indulcitor;
        this.aroma = aroma;
    }

    public void RetetaPrajitura(){
        System.out.println("cantitate Oua: " + oua);
        System.out.println("Cantitate Faina: " + faina + "grame");
        if(indulcitor = false) {
            System.out.println("Indulcitor " + indulcitor);
             }
            else{
            System.out.println("Fara indulcitor");
            };
        System.out.println("Aroma: " +aroma);
        if(fructe != null){
            System.out.println("Fructe: " + fructe);
        }
    }

}



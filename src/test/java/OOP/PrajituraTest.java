package OOP;

import org.testng.annotations.Test;

public class PrajituraTest {

    @Test
    public void prepararePrajitura(){
        Prajitura reteta1 = new Prajitura(100, false, "ciocolata");
        reteta1.RetetaPrajitura();

        Prajitura reteta2 = new Prajitura(200, true , "vanilie");
        reteta2.RetetaPrajitura();

        Prajitura reteta3 = new Prajitura(100,10,true,"capsuni", "banane");
        reteta3.RetetaPrajitura();

    }


}

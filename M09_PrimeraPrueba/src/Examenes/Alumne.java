package Examenes;

import java.util.concurrent.Callable;

public class Alumne  implements Callable<Float> {
    private float nota;

    public Alumne (float nota){

        this.nota = nota;
    }





    @Override
    public Float call() throws Exception {
        //System.out.println("A"+numAlumne);

        return nota;
    }
}

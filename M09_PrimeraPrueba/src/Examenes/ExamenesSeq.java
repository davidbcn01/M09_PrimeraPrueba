package Examenes;



import java.util.ArrayList;
import java.util.List;

public class ExamenesSeq {
   private float nota;

    public ExamenesSeq(float nota) {
     this.nota= nota;
    }
    public float examinarse() throws Exception{
        return nota;
    }

    public static void main(String[] args) throws Exception {
        List<ExamenesSeq> llistaTasques  = new ArrayList<ExamenesSeq>();
        for (int i = 0; i<10; i++){
            ExamenesSeq examen = new ExamenesSeq( (float)(Math.random()*10));
            llistaTasques.add(examen);
        }
        List<Float> results = new ArrayList<>();


        long t1 = System.currentTimeMillis();
        for (int i = 0; i< llistaTasques.size();i++){
            results.add(llistaTasques.get(i).examinarse());
        }

        long t2 = System.currentTimeMillis();


        results.forEach(r -> System.out.println("Alumno: "+ (int)(Math.random()*1000) +"  Nota: "+r));
        System.out.println("Temps: "+(t2-t1)+"ms");
    }
}


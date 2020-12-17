package Examenes;



import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class ExamenesLlista {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

    ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
    List<Alumne> llistaTasques= new ArrayList<Alumne>();
    for (int i = 0; i < 10; i++) {
        Alumne examen = new Alumne((float)(Math.random()*10));
        llistaTasques.add(examen);
    }



    List<Future<Float>> llistaResultats;
    long t1 = System.currentTimeMillis();
    llistaResultats = executor.invokeAll(llistaTasques);

    executor.shutdown();
    long t2 = System.currentTimeMillis();
   for (int i = 0; i < llistaResultats.size(); i++) {
        Future<Float> resultat = llistaResultats.get(i);
        try {
            System.out.println("Alumno "+i+ ", Nota:" + resultat.get());
        } catch (InterruptedException | ExecutionException e) {
        }
    }
    System.out.println("Temps: "+(t2-t1)+"ms");
}
}


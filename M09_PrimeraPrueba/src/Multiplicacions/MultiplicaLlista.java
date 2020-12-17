package Multiplicacions;

import java.util.*;
import java.util.concurrent.*;

public class MultiplicaLlista {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
        List<Multiplicacio> llistaTasques= new ArrayList<Multiplicacio>();
        for (int i = 0; i < 10; i++) {
            Multiplicacio calcula = new Multiplicacio((int)(Math.random()*10), (int)(Math.random()*10));
            llistaTasques.add(calcula);
        }



        List <Future<Integer>> llistaResultats;
        long t1 = System.currentTimeMillis();
        llistaResultats = executor.invokeAll(llistaTasques);

        executor.shutdown();
        long t2 = System.currentTimeMillis();
        for (int i = 0; i < llistaResultats.size(); i++) {
            Future<Integer> resultat = llistaResultats.get(i);
            try {
                System.out.println("Resultat tasca "+i+ " és:" + resultat.get());
            } catch (InterruptedException | ExecutionException e) {
            }
        }
        System.out.println("Temps: "+(t2-t1)+"ms");
    }
}
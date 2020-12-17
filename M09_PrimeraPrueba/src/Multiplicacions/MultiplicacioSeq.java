package Multiplicacions;

import java.util.ArrayList;
import java.util.List;

public class MultiplicacioSeq {

        private int operador1;
        private int operador2;
        public MultiplicacioSeq(int operador1, int operador2) {
            this.operador1 = operador1;
            this.operador2 = operador2;
        }
        public Integer operar() throws Exception{
            return  operador1 * operador2;
        }

    public static void main(String[] args) throws Exception {
        List<MultiplicacioSeq> llistaTasques  = new ArrayList<MultiplicacioSeq>();
        for (int i = 0; i<10; i++){
            MultiplicacioSeq calcula = new MultiplicacioSeq((int)(Math.random()*10), (int)(Math.random()*10));
            llistaTasques.add(calcula);
        }
        List<Integer> results = new ArrayList<>();


        long t1 = System.currentTimeMillis();
        for (int i = 0; i< llistaTasques.size();i++){
            results.add(llistaTasques.get(i).operar());
        }

        long t2 = System.currentTimeMillis();


        results.forEach(r -> System.out.println(r));
        System.out.println("Temps: "+(t2-t1)+"ms");
        }
    }

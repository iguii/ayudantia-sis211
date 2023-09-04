public class Main {
    public static void main(String[] args) {
        Lista<Integer> lista = new Lista<>();

        lista.add(1);
        lista.add(2);
        lista.add(3);

        for (Integer i : lista) {
            System.out.println(i);
        }

        for(int i =0; i<3; i++){
            System.out.println(lista.get(i));
        }
    }
}
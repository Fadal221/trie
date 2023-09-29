import java.util.Arrays;
import java.util.Random;

public class trieFusion {
    public static void main(String[] args) {

        int[] tableau = genererDonnees(100000000);


        long tempsDebut = System.nanoTime();
        //quicksort(tableau, 0, tableau.length - 1);
        triePeigne1(tableau);
        for (int i = tableau.length-100; i < tableau.length ; i++) {
            System.out.println(tableau[i]);
        }

        long tempsFin = System.nanoTime();
        System.out.println("Temps de calcul en millisecondes: " + ((tempsFin - tempsDebut) / 1000000) );

    }
    public static void triePeigne1(int[] tab){
        int intervale= tab.length;// initialisation de l'intervale
        boolean echange =true ;//pour indiquer si l'échange a été fait
        while(intervale > 1 && echange) {
            echange=false;
            intervale = (int)(intervale / 1.3);//1.3 = facteur de reduction

            if (intervale<1){
                intervale=1;
            }

            for (int i = 0; i < tab.length-intervale; i++) {
                if (tab[i]>tab[i+intervale]){//compare la valeur de i a celle de i+intervale
                    echange = true;
                    int stock = tab[i];
                    tab[i]= tab[i + intervale];//echange les deux nombres
                    tab[i + intervale]= stock;

                }


            }
        }



    }


        public static void quicksort(int[] tab, int gauche, int droite) {
            if (gauche < droite) {
                int pivot = partition(tab, gauche, droite);
                quicksort(tab, gauche, pivot - 1);
                quicksort(tab, pivot + 1, droite);
            }
        }
        public static int partition(int[] tab, int gauche, int droite) {
            int pivot = tab[droite];
            int i = gauche - 1;
            for (int j = gauche; j < droite; j++) {
                if (tab[j] <= pivot) {
                    i++;
                    int temp = tab[i];
                    tab[i] = tab[j];
                    tab[j] = temp;
                }
            }
            int temp = tab[i + 1];
            tab[i + 1] = tab[droite];
            tab[droite] = temp;
            return i + 1;
        }



    public static int[] trie(int[] tableau) {
        if (tableau.length < 2) {
            return tableau;
        }

        int millieu = tableau.length / 2;
        int[] tabgauche = Arrays.copyOfRange(tableau, 0, millieu); // Arrays.copyOfRange pour créer une copie d'un sous tableau d'un autre tableau il prend en paramétre le tableau original, un indice de départ et un indice de fin
        int[] tabdroit = Arrays.copyOfRange(tableau, millieu, tableau.length);//

        tabgauche = trie(tabgauche);
        tabdroit = trie(tabdroit);
        tableau = fusion(tabgauche, tabdroit);

        return tableau;
    }

    public static int[] fusion(int[] tabgauche, int[] tabdroit) {
        int[] resultat = new int[tabgauche.length + tabdroit.length];//tableau pour acceuillir le tableau trier

        int i = 0 , j = 0, k = 0;
        while (i < tabgauche.length && j < tabdroit.length) {
            if (tabgauche[i] <= tabdroit[j]) { // si le nombre a l'indice i du tableau gauche est inférieur au nombre à l'indice j du tableau droit
                resultat[k] = tabgauche[i];//affecte le nombre à l'indice i du tableau de gauche dans le tableau resultat à l'indice k
                i++;
                k++;
            }
            else {
                resultat[k] = tabdroit[j]; // sinon il affecte le nombre à l'indice j du tableau de droite
                j++;
                k++;
            }

        }
        while (i < tabgauche.length) {
            resultat[k] = tabgauche[i];
            i++;
            k++;
        }
        while (j < tabdroit.length) {
            resultat[k] = tabdroit[j];
            j++;
            k++;
        }
        return resultat;
    }

    public static int[] genererDonnees(int n) {
        Random random = new Random();
        int[] t = new int[n];
        for (int i = 0 ; i < t.length ; i++)
            t[i] = random.nextInt(); // tirage aléatoire d'un int quelconque (compris entre -2^31 et 2^31-1)
        return t;
    }
    public static int[] insert(int[] tab){

        for (int i = 0; i < tab.length; i++) {
            int pivot = i;

                if (tab[i + 1] < pivot) {
                    tab[i] = tab[i + 1];
                    tab[i + 1] = pivot;
                }

        }
        return tab;
    }

    public static void triePeigne(int[] tab){
        int intervale= tab.length;
        boolean echange =true ;



        while(intervale > 1 && echange) {
            echange=false;
            intervale = (int)(intervale / 1.3);

            if (intervale<1){
                intervale=1;
            }

            for (int i = 0; i < tab.length-intervale; i++) {
                if (tab[i]>tab[i+intervale]){
                    echange = true;
                    int stock = tab[i];
                    tab[i]= tab[i + intervale];
                    tab[i + intervale]= stock;

                }


            }
        }



    }


}


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int antalAktier =0;
        double kapital = 0;
        double udbyttePrAktie = 0; //efter skat,
        double aktiePris = 0;
        double startKapital = 0;
        int antalNye = 0;
        int måned = 0;
        int udbytteInterval = 0;
        int antalMulige =0;

        boolean genInvester = false;
        boolean running = true;
        while (running) {
           // scanner som bliver indtastet på startkapital, aktiepris, udbyttePrAktie samt måned.

           System.out.println("Indtast din Start kapital");
           double start = input.nextDouble();
           startKapital = start;

            System.out.println("Indtast den ønskede Aktie's aktiekurs");
            double aktieKurs = input.nextDouble();
           aktiePris = aktieKurs;

            System.out.println("Indtast Aktiens Udbytte pr. intetval, helst efter skat frataget");
            double dividend = input.nextDouble();
           udbyttePrAktie =dividend; // helst efter skat, for ikke at gøre det for kompliceret.

            System.out.println("Indtast Intervalet => pr. måned : 1 | pr. kvartal : 3 | pr.halve år : 6 | pr. år : 12");
           int interval = input.nextInt();
           udbytteInterval = interval; // 1 => pr. måned, 3 => pr. kvartal, 6 => pr. halve år, 12 => pr. år.

            System.out.println("Indtast den ønskede investerings tid, i måneder");
            int tid = input.nextInt();
            måned = tid;

            System.out.println("Vil du løbende gen-Investere? 1 = ja | 2 = nej");
            int valg =input.nextInt();
            if (valg==1) {
                genInvester=true;
            } else if(valg==2) {
                System.out.println("investeres ikke løbende");
            }
            else {
                System.out.println("forkert input"); }

           antalAktier += (startKapital/aktiePris);
            System.out.println(antalAktier); //tjek på om det virker?
           kapital = startKapital%aktiePris;
            System.out.println(kapital); //tjek på om det virker?

            for (int i = 1; i<=måned; i++) {
                System.out.println("Måneden : " + i);

                if (i%udbytteInterval==0) {
                    kapital += udbyttePrAktie * antalAktier; // så kapitalet bliver forøget af udbyttet

                    if (genInvester) {
                        antalNye += kapital / aktiePris; // så hvor mange aktier man kan købe af udbyttet => investeres igen

                        kapital = (kapital % aktiePris); //så kapitalet bliver opdateret af købet

                        System.out.println("Antal aktier der kan købes : " + antalNye);
                    } else if (!genInvester){
                        antalMulige = (int) (kapital / aktiePris);

                        System.out.println("Antal Mulige aktier der kan købes : " + antalMulige);}



                    for (int x = 0; x < antalNye; x++ ) { //køber op af aktier så længe der er nok til nye
                        antalAktier++;
                        } antalNye = 0;
                    System.out.println("Nye aktie Beholdning : " + antalAktier);
                    System.out.println("Kapital : " + kapital);
                    System.out.println("---------------------------");
                }
                if (i==måned) {
                    running=false;
                }
            }



        }




    }
}

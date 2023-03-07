package interfata;

import service.EspressorService;
import service.Service;

import java.util.InputMismatchException;
import java.util.Scanner;


public class MeniuEspressor {
    private static final Scanner scanner = new Scanner(System.in);
    EspressorService sr;
    public MeniuEspressor() {
        sr = new EspressorService();
    }

    public void TabEspressor() {
        while (true) {
            tabelEspressor();
            int selectedOptionEspressor = readOptionEspressor();
            processSelectedOptionEspressor(selectedOptionEspressor);
        }
    }
    public void processSelectedOptionEspressor(int selectedOptionEspressor) {

        switch (selectedOptionEspressor){
            case 1:
                sr.prepareShortEspresso();
                break;
            case 2:
                sr.prepareDubleEspresso();
                break;
            case 3:
                sr.prepareSmallLatte();
                break;
            case 4:
                sr.prepareBigLatte();
                break;
            case 5:
                sr.prepareShortCoffe();
                break;
            case 6:
                sr.prepareLongCoffe();
                break;
            case 7:
                System.out.println("Listare:");
                sr.findALL();
                break;
            case 8:
                System.out.println("Se face full-ul");
                sr.refill();
                break;
            case 9:
                Service menu=new Service();
                menu.tabStart();
                break;
        }

    }


    protected static void tabelEspressor(){

        System.out.println("Ce vrei sa prepari?");
        System.out.println("----------------------");
        System.out.println("1. Espresso scurt");
        System.out.println("2. Espresso dublu");
        System.out.println("3. Latte mic");
        System.out.println("4. Latte mare");
        System.out.println("5. Cafea mica");
        System.out.println("6. Cafea mare");
        System.out.println("7. Ce resurse mai am in aparat?");
        System.out.println("8. Refill");
        System.out.println("9. Inapoi");
    }
    public static int readOptionEspressor() {
        do{
            try{
                int optiune = scanner.nextInt();
                if(optiune>9 || optiune<1){
                    System.out.println("Te rog sa alegi alt numar");
                } else {
                    scanner.nextLine();
                    return optiune;
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Optiune inexistenta, incearca din nou");
            }
        } while(true);
    }
}

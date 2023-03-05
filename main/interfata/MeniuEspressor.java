package interfata;

import repository.EspressorRepository;
import service.EspressorService;
import service.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MeniuEspressor {

    EspressorRepository er;
    EspressorService sr;
    public MeniuEspressor() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectjava","root","1234567");
        er = new EspressorRepository(conn);
        sr = new EspressorService(er);
    }

    public void TabEspressor() throws SQLException, ClassNotFoundException {
        while (true) {
            tabelEspressor();
            int selectedOptionEspressor = sr.readOptionEspressor();
            processSelectedOptionEspressor(selectedOptionEspressor);
        }
    }
    public void processSelectedOptionEspressor(int selectedOptionEspressor) throws SQLException, ClassNotFoundException {

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
                System.out.println(er.findAll());
                break;
            case 8:
                System.out.println("Se face full-ul");
                er.updateRefill();
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
}

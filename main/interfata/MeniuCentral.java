package interfata;

import repository.CentralRepository;
import service.CentralService;
import service.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MeniuCentral {

    CentralRepository cr;
    CentralService cs;

    public MeniuCentral() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectjava","root","1234567");
        cr = new CentralRepository(conn);
        cs = new CentralService(cr);
    }

    public void TabCentral() throws SQLException, ClassNotFoundException {
        while (true) {
            tabelCentral();
            int selectedOptionCentral = cs.readOptionCentral();
            processSelectedOptionCentral(selectedOptionCentral);
            break;
        }
    }

    protected static void tabelCentral() {

        System.out.println("Ce vrei sa folosesti?");
        System.out.println("----------------------");
        System.out.println("1. Porneste/opreste centrala");
        System.out.println("2. Seteaza temperatura din centrala");
        System.out.println("3. Ce temperatura este setata?");
        System.out.println("4. Inapoi");
    }

    private void processSelectedOptionCentral(int selectedOptionCentral) throws SQLException, ClassNotFoundException {

        switch (selectedOptionCentral) {
            case 1:
                cs.setPowerCentral();
                TabCentral();
                break;
            case 2:
                cs.changeTemperature();
                TabCentral();
                break;
            case 3:
              cs.readTemperature();
                TabCentral();
                break;
            case 4:
                Service menu=new Service();
                menu.tabStart();
                break;

        }
    }


}

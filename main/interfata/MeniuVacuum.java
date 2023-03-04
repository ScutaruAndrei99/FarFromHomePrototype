package interfata;

import model.Vacuum;
import repository.VacuumRepository;
import service.Service;
import service.VacuumService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MeniuVacuum {
    VacuumService vs;
    VacuumRepository vr;
    public MeniuVacuum() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectjava","root","1234567");
        vr = new VacuumRepository(conn);
        vs = new VacuumService(vr);
    }
    public void TabVacuum() throws SQLException, ClassNotFoundException {
        while (true) {
            tabelVacuum();
            int selectedOptionVacuum = vs.readOptionVacuum();
            processSelectedOptionVacuum(selectedOptionVacuum);
            return;
        }
    }

    private void processSelectedOptionVacuum(int selectedOptionVacuum) throws SQLException, ClassNotFoundException {
        switch (selectedOptionVacuum){
            case 1:
                vs.setPowerVacuum();
                TabVacuum();
                break;
            case 2:
                vs.vacuumWork();
                TabVacuum();
                break;
            case 3:
                Service menu=new Service();
                menu.tabStart();
                break;
        }
    }

    private static void tabelVacuum() {
        System.out.println("Ce vrei sa folosesti?");
        System.out.println("----------------------");
        System.out.println("1. On/Off aspiratorul");
        System.out.println("2. Aspiratorul este pornit?");
        System.out.println("3. Inapoi");
    }
}

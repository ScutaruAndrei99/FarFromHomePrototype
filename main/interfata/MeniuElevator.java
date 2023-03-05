package interfata;

import repository.ElevatorRepository;
import service.ElevatorService;
import service.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MeniuElevator {
    ElevatorRepository elr;
    ElevatorService els;
    public MeniuElevator() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectjava","root","1234567");
        elr = new ElevatorRepository(conn);
        els = new ElevatorService(elr);
    }

    public void TabElevator() throws SQLException, ClassNotFoundException {
        while (true) {
            tabelElevator();
            int selectedOptionElevator = els.readOptionElevator();
            processSelectedOptionElevator(selectedOptionElevator);
            break;
        }
    }

    public static void tabelElevator() {

        System.out.println("Ce vrei sa folosesti?");
        System.out.println("----------------------");
        System.out.println("1. Vreau sa chem liftul");
        System.out.println("2. La ce etaj se afla liftul?");
        System.out.println("3. Inapoi");
    }

    private void processSelectedOptionElevator(int selectedOptionElevator) throws SQLException, ClassNotFoundException {
        switch (selectedOptionElevator) {
            case 1:
                els.call();
                TabElevator();
                break;
            case 2:
                els.statusElevator();
                TabElevator();
                break;
            case 3:
                Service menu=new Service();
                menu.tabStart();
                break;
        }
    }

}

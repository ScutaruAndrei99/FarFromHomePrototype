package interfata;

import repository.CurtainsRepository;
import repository.LightRepository;
import service.CentralService;
import service.CurtainsService;
import service.LightService;
import service.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.InputMismatchException;


public class MeniuCurtains {

    CurtainsRepository crtr;
    CurtainsService crts;
    public MeniuCurtains() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectjava","root","1234567");
        crtr = new CurtainsRepository(conn);
        crts = new CurtainsService(crtr);
    }

    public void TabCurtains() throws SQLException, ClassNotFoundException {
        while (true) {
            tabelCurtains();
            int selectedOptionCurtains = crts.readOptionCurtains();
            processSelectedOptionCurtains(selectedOptionCurtains);
        }
    }


    private void processSelectedOptionCurtains(int selectedOptionCurtains) throws SQLException, ClassNotFoundException {
            switch (selectedOptionCurtains) {
                case 1:
                    crts.setOpenCurtain("Bathroom");
                    break;
                case 2:
                    crts.setOpenCurtain("Bedroom");
                    break;
                case 3:
                    crts.setOpenCurtain("Kitchen");
                    break;
                case 4:
                    crts.setOpenCurtain("Hall");
                    break;
                case 5:
                    crts.setOpenCurtain("LivingRoom");
                    break;
                case 6:
                    crts.setOpenCurtain("Dressing");
                    break;
                case 7:
                    crts.LightStatus();
                    break;
                case 8:
                    Service menu=new Service();
                    menu.tabStart();
                    break;
            }
        }

    private static void tabelCurtains() {
        System.out.println("In which room do you want to change the status of the curtains?");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("1. Bathroom");
        System.out.println("2. Bedroom");
        System.out.println("3. Kitchen");
        System.out.println("4. Hall");
        System.out.println("5. Living room");
        System.out.println("6. Dressing");
        System.out.println("7. What is the curtains status");
        System.out.println("8. Exit");
    }

}

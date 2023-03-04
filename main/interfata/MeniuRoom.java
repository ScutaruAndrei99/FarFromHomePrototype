package interfata;

import repository.LightRepository;
import service.LightService;
import service.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MeniuRoom {
    LightRepository lr;
    LightService ls;

    public MeniuRoom() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectjava","root","1234567");
        lr = new LightRepository(conn);
        ls = new LightService(lr);
    }

    public void TabRoom() throws SQLException, ClassNotFoundException {
        while (true){
            tabelRoom();
            int selectedOptionRoom = ls.readOptionLight();
            processSelectedOptionRoom(selectedOptionRoom);
        }
    }


    private void processSelectedOptionRoom(int selectedOptionLight) throws SQLException, ClassNotFoundException {
        switch (selectedOptionLight) {
            case 1:
                ls.setPowerLight("Bathroom");
                break;
            case 2:
                ls.setPowerLight("Bedroom");
                break;
            case 3:
                ls.setPowerLight("Kitchen");
                break;
            case 4:
                ls.setPowerLight("Hall");
                break;
            case 5:
                ls.setPowerLight("LivingRoom");
                break;
            case 6:
                ls.setPowerLight("Dressing");
                break;
            case 7:
                ls.setPowerLight("Boiler");
                break;
            case 8:
                ls.LightStatus();
                break;
            case 9:
                Service menu=new Service();
                menu.tabStart();
                break;
        }
    }

    private static void tabelRoom() {
        System.out.println("Where do you want to use the light??");
        System.out.println("----------------------");
        System.out.println("1. Bathroom");
        System.out.println("2. Bedroom");
        System.out.println("3. Kitchen");
        System.out.println("4. Hall");
        System.out.println("5. Living room");
        System.out.println("6. Dressing");
        System.out.println("7. Boiler");
        System.out.println("8. Situatia becurilor");
        System.out.println("9. Back");
    }

}


package interfata;

import model.TV;
import repository.TVRepository;
import service.Service;
import service.TVService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class MeniuTV {
    private static final Scanner scanner=new Scanner(System.in);

//    public static TV tv=new TV(3, tv.getChannelPost(),tv.getChannelName(),tv.isPower());
    TVRepository tvr;
    TVService tvs;

    public MeniuTV() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiectjava","root","1234567");
        tvr = new TVRepository(conn);
        tvs = new TVService(tvr);
    }
    public void TabTV() throws SQLException, ClassNotFoundException {
        while (true) {
            tabelTV();
            int selectedOptionTV = tvs.readOptionTV();
            processSelectedOptionTV(selectedOptionTV);
        }
    }


    private void processSelectedOptionTV(int selectedOptionTV) throws SQLException, ClassNotFoundException {
        switch (selectedOptionTV){
            case 1:
                tvs.setPowerTV();
                break;
            case 2:
                tvs.whatIsPower();
                break;
            case 3:
                tvs.changeChannel();
                break;
            case 4:
                tvs.whatChannelIs();
                break;
            case 5:
                Service menu=new Service();
                menu.tabStart();
                break;
        }
    }


    private static void tabelTV() {
        System.out.println("Ce vrei sa folosesti?");
        System.out.println("----------------------");
        System.out.println("1. Vreau sa pornesc/opresc televizorul");
        System.out.println("2. Vreau sa vad cum e televizorul");
        System.out.println("3. Vreau sa mut pe alt canal");
        System.out.println("4. Pe ce Canal este deschis televizorul?");
        System.out.println("5. Inapoi");
    }

}

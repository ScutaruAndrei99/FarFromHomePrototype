package service;

import model.Gate;
import repository.GateRepository;

import java.util.Timer;
import java.util.TimerTask;

public class GateService {
    GateRepository gr;
    public GateService() {gr=new GateRepository();}
    Timer timer = new Timer();
    public void setGate(int switchOpen) {
        Gate gate = gr.findByID();
        if(switchOpen == 1) {
            gate.setOpen(true);
            gate.setStatus(true);
            System.out.println("Poarta se va deschide");
            timeGate(20);
            gr.update(gate);
        } else if (switchOpen == 0) {
            gate.setOpen(false);
            gate.setStatus(true);
            gr.update(gate);
            timeGate(20);
            System.out.println("Poarta se va inchide");
        }
    }
    public void gateWork() {
        Gate gate = gr.findByID();
        if (gate.isOpen()){
            System.out.println("Poarta este deschisa");
        } else {
            System.out.println("Poarta este inchisa");
        }
    }
    public void timeGate(int seconds) {
        timer.schedule(new RemindTaskGate(),seconds * 1000L);
    }
    class RemindTaskGate extends TimerTask {
        GateRepository gr;
        public void run() {
            gr = new GateRepository();
            Gate gate = null;
            gate = gr.findByID();
            gate.setStatus(false);
            gr.update(gate);
        }
    }
}

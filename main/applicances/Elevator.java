package applicances;

public class Elevator {
    private int floor;
    private final int maxFloor;
    private boolean doorsOpen;
    private final boolean used;

    public Elevator(int maxFloor) {
        this.maxFloor = maxFloor;
        doorsOpen = false;
        used = false;
        setFloor(0);
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public void call(int floor) {
        if (used) {
            System.err.println("Appliances.Elevator is in use. Will not come.");
        }
        if (getFloor()==floor){
            System.out.println("Liftul este deja la etajul " + floor);
            return;
        }
        closeDoors();
        setFloor(floor);
        move();
        openDoors();
    }

    private void move() {
            System.out.println("Starting to move from floor " + getFloor());
    }

    void openDoors() {
        this.doorsOpen = true;
        System.out.println("Doors open");
    }

    void closeDoors() {
        this.doorsOpen = false;
        System.out.println("Doors closed");
    }
    public void statusElevator(){
        switch (getFloor()){
            case 0:
                System.out.println("Liftul este la parter");
                break;
            case 1:
                System.out.println("Liftul este la etajul 1");
                break;
            case 2:
                System.out.println("Liftul este la etajul 2");
                break;
        }
    }

}

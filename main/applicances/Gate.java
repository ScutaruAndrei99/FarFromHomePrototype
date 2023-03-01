package applicances;

public class Gate {

    boolean gateOpen;
    final int maxgateOpen;
    private static boolean used;
    public static int open;

    public static boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public Gate(int maxgateOpen) {
        this.maxgateOpen = maxgateOpen;
        gateOpen = false;
        setUsed(false);
    }

    public static int getOpen() {
        return open;
    }

    public void setOpen(int open) {
        this.open = open;
    }

    public void move(int open) {
        if (open < 0 || open > maxgateOpen) {
            System.out.println("Nu poti deschide poarta la mai mult de 3 metri");
            return;
        }
        if (getOpen() == open) {
            System.out.println("Poarta este deja deschisa la " + open + " metri");
        } else {
            System.out.println("Poarta se va deschide acum la " + open + " metri");
            setOpen(open);
        }

    }


    public void setGateClose(){
        if(getOpen()==0){
            System.out.println("Poarta este deja inchisa");
        } else {
            System.out.println("Poarta se inchide acum");
        }
    }
    public void gateSituation(){
        switch (getOpen()){
            case 0:
                System.out.println("Poarta este momentan inchisa");
                break;
            case 1:
                System.out.println("Poarta este deschisa 1 metru");
                break;
            case 2:
                System.out.println("Poarta este deschisa 2 metri");
                break;
            case 3:
                System.out.println("Poarta este deschisa la maxim");
                break;
        }

    }
}

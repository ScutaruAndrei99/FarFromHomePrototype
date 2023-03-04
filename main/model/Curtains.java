package model;

public class Curtains {
    private int idCurtains;
    private boolean bathroom;
    private boolean bedroom;
    private boolean kitchen;
    private boolean hall;
    private boolean livingRoom;
    private boolean dressing;

    public Curtains(int idCurtains, boolean bathroom, boolean bedroom, boolean kitchen, boolean hall, boolean livingRoom, boolean dressing){
        this.idCurtains = idCurtains;
        this.bathroom = bathroom;
        this.bedroom = bedroom;
        this.kitchen = kitchen;
        this.hall = hall;
        this.livingRoom = livingRoom;
        this.dressing = dressing;
    }

    public boolean isBathroom() {
        return bathroom;
    }

    public void setBathroom(boolean bathroom) {
        this.bathroom = bathroom;
    }

    public boolean isBedroom() {
        return bedroom;
    }

    public void setBedroom(boolean bedroom) {
        this.bedroom = bedroom;
    }

    public boolean isKitchen() {
        return kitchen;
    }

    public void setKitchen(boolean kitchen) {
        this.kitchen = kitchen;
    }

    public boolean isHall() {
        return hall;
    }

    public void setHall(boolean hall) {
        this.hall = hall;
    }

    public boolean isLivingRoom() {
        return livingRoom;
    }

    public void setLivingRoom(boolean livingRoom) {
        this.livingRoom = livingRoom;
    }

    public boolean isDressing() {
        return dressing;
    }

    public void setDressing(boolean dressing) {
        this.dressing = dressing;
    }
}

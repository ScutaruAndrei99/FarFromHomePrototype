package model;

public class TV {
    private int idTV;
    private int channelPost;
    private String channelName;
    private boolean power;

    public TV(int idTV,int channelPost, String channelName, boolean power){
        this.idTV=idTV;
        this.channelPost=channelPost;
        this.channelName=channelName;
        this.power=power;
    }

    public int getChannelPost() {
        return channelPost;
    }

    public void setChannelPost(int channelPost) {
        this.channelPost = channelPost;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public boolean isPower() {
        return power;
    }

    public void setPower(boolean power) {
        this.power = power;
    }
}

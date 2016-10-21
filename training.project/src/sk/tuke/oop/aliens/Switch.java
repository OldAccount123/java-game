package sk.tuke.oop.aliens;
public class Switch extends PowerSwitch{
    private Switchable device;
    public Switch(Switchable device){
        super(device);
        this.device = device;
    }
    public void toggle(){
        if(device.isOn() == false){
            device.turnOn();}
        else{
            device.turnOff();
        }
    }
}

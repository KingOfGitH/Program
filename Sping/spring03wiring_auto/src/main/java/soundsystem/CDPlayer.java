package soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CDPlayer {
//    @Autowired
    private CD cd;

//    @Autowired
    private  Power power;

    @Autowired
    public void setCd(CD cd) {
        this.cd = cd;
        System.out.println("调用setCD");
    }

    @Autowired
    public void setPower(Power power) {
        this.power = power;
        System.out.println("调用setPower");
    }

    public CDPlayer() {
        super();
        System.out.println("CDPlayer无参构造");
    }

//    @Autowired
//    public CDPlayer(CD cd, Power power) {
//        this.cd = cd;
//        this.power = power;
//        System.out.println("CDPlayer的多参构造");
//    }

    //    @Autowired
//    public CDPlayer(CD cd) {
//        this.cd = cd;
//        System.out.println("CDPlayer的有参构造");
//    }

    public void play(){
        power.supply();
        cd.play();
    }
}

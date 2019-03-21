package soundsystem;

import org.springframework.stereotype.Component;

@Component
public class CD {
    public CD() {
        super();
        System.out.println("CD无参构造函数");
    }

    public void play(){
        System.out.println("正在播放音乐......");
    }
}

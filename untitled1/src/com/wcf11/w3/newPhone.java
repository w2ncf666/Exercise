package com.wcf11.w3;

public class newPhone extends phone implements Iplay{
    @Override
    public void playgame() {
        System.out.println("新手机在玩游戏");
    }
    public void text(Iplay i){
        i.playgame();
    }
}

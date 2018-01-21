package com.jihite;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@Qualifier("songer")
public class Panweibo implements CompactDisc{
    private String song = "翻转地球";
    private String songer = "潘玮柏";
    @Override
    public void play() {
        System.out.println(String.format("%s演唱歌曲%s", songer, song));
    }
}

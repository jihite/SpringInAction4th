package com.jihite;

import org.springframework.stereotype.Component;

@Component
public class Zhoujielun implements CompactDisc{
    private String song = "七里香";
    private String songer = "周杰伦";
    @Override
    public void play() {
        System.out.println(String.format("%s演唱歌曲%s", songer, song));
    }
}

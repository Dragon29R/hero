package com.up202108890.hero;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;

import java.io.IOException;

public class Hero {
    private int x;
    private int y;

    public Hero(int i, int i2) {
        x = i;
        y = i2;
    }



    public void moveUp() {
        y--;
    }

    public void moveDown() {
        y++;
    }

    public void moveRight() {
        x++;
    }

    public void moveLeft() {
        x--;
    }

    public void draw(Screen screen) throws IOException {
        screen.setCharacter(x, y, TextCharacter.fromCharacter('X')[0]);
    }


}
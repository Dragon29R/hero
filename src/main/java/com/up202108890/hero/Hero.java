package com.up202108890.hero;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;

import java.io.IOException;

public class Hero {
    private Position position;

    public Hero(int i, int i2) {
    position = new Position(i,i2);
    }



    public Position moveUp(){
        return new Position(position.getX(), position.getY()-1);
    }

    public Position moveDown(){
        return new Position(position.getX(), position.getY()+1);
    }

    public Position moveRight(){
        return new Position(position.getX()+1, position.getY());
    }

    public Position moveLeft(){
        return new Position(position.getX()-1, position.getY());
    }
    public void draw(Screen screen) throws IOException {
        screen.setCharacter(position.getX(), position.getY(), TextCharacter.fromCharacter('X')[0]);
    }

    public void setPosition(Position position){
        this.position.setX(position.getX());
        this.position.setY(position.getY());
    }
    public int getX(){
        return position.getX();
    }
    public int getY(){
        return position.getY();
    }


}
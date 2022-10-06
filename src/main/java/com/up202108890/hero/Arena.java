package com.up202108890.hero;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class Arena {
    Hero hero = new Hero(10,10);
    private int width;
    private int height;
    public Arena(int x, int y){
        width = x;
        height = y;
        hero = new Hero(10,10);
    }
    public void processKey(KeyStroke key) throws IOException {
        if (key.getKeyType() == KeyType.ArrowUp) moveHero(hero.moveUp());
        if (key.getKeyType() == KeyType.ArrowDown) moveHero(hero.moveDown());
        if (key.getKeyType() == KeyType.ArrowRight) moveHero(hero.moveRight());
        if (key.getKeyType() == KeyType.ArrowLeft) moveHero(hero.moveLeft());
    }
    private void moveHero(Position position){
        if(canHeroMove(position)){hero.setPosition(position);}
    }
    public void draw(Screen s) {
        s.setCharacter(hero.getX(), hero.getY(), TextCharacter.fromCharacter('X')[0]);
    }
    public boolean canHeroMove(Position position){
        if(position.getX()<width && position.getX()>-1 && position.getY()<height && position.getY()>-1)return true;
        return false;
    }

}

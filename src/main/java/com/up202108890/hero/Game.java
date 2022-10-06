package com.up202108890.hero;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;


import java.io.IOException;

public class Game {
    private Screen screen;
    Hero hero = new Hero(10,10);
    public Game() {
        try {
            TerminalSize terminalSize = new TerminalSize(40, 20);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
            this.screen = new TerminalScreen(terminal);
            this.screen.setCursorPosition(null); // we don't need a cursor
            this.screen.startScreen(); // screens must be started
            this.screen.doResizeIfNecessary(); // resize screen if necessary

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void draw() throws IOException {
        this.screen.clear();
        hero.draw(screen);
        this.screen.refresh();
    }
    private void processKey (KeyStroke key) throws IOException {
        System.out.println(key);
        if(key.getKeyType()==KeyType.ArrowUp){
            moveHero(hero.moveUp());
        }
        if(key.getKeyType()==KeyType.ArrowDown){
            moveHero(hero.moveDown());
        }
        if(key.getKeyType()==KeyType.ArrowRight){
            moveHero(hero.moveRight());
        }
        if(key.getKeyType()==KeyType.ArrowLeft){
            moveHero(hero.moveLeft());
        }
        if(key.getKeyType() ==KeyType.Character && key.getCharacter()=='q'){
            screen.close();
        }

    }

    public void run() throws IOException {
        while(true) {
            draw();
            KeyStroke key = screen.readInput();
            if(key.getKeyType()== KeyType.EOF) break;
            processKey(key);

        }
    }
    private void moveHero(Position position){
        hero.setPosition(position);
    }
}
package com.mygame.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetsLoader {
    public static TextureRegion region;
    public static Texture backgroundImage;
    public static Texture snakeHead;
    public static Sound snakeEats;
    public static Sound snakeDies;
    public static Sound startGame;
    public static Sound endGame;
    public static Music mainMusic;
    public static Music gameMusic;
    public static Music endMusic;

    public AssetsLoader() {
    }
    public static void loadGameAssets(){
        snakeHead=new Texture(Gdx.files.internal("SnakeHead.jpg"));
        gameMusic=Gdx.audio.newMusic(Gdx.files.internal("Music\\funnyMusic.mp3"));
        gameMusic.setLooping(true);
    }
    public static void loadMainMenu(){
        backgroundImage=new Texture(Gdx.files.internal("SnakeHead.jpg"));;
        region  = new TextureRegion(backgroundImage, 0, 0, 800, 480);
        mainMusic = Gdx.audio.newMusic(Gdx.files.internal("Music\\mainMusic.mp3"));
        mainMusic.setLooping(true);

    }
    //http://www.sonidosmp3gratis.com/arcade-musica-3
}

package com.mygame.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetsLoader {
    public static TextureRegion region;
    public static TextureRegion region1;
    public static TextureRegion region2;
    public static Texture backgroundImage;
    public static Texture backgroundImage1;
    public static Texture backgroundImage2;
    public static Texture snakeHead;
    public static Sound snakeEats;
    public static Sound snakeDies;
    public static Sound startGame;
    public static Sound endGame;
    public static Music mainMusic;
    public static Music gameMusic;
    public static Music endMusic;
    public static TextureAtlas atlas;
    public static Texture ideSheet;
    public static Animation<TextureRegion> ideAnimation;


    public AssetsLoader() {

    }
    public static void loadGameAssets(){
        //snakeHead=new Texture(Gdx.files.internal("SnakeHead.jpg"));
        backgroundImage2=new Texture(Gdx.files.internal("Backgrounds\\backGroundGame.png"));
        region2  = new TextureRegion(backgroundImage2, 0, 0, 800, 480);
        gameMusic=Gdx.audio.newMusic(Gdx.files.internal("Music\\funnyMusic.mp3"));
        startGame=Gdx.audio.newSound(Gdx.files.internal("Sounds\\cortina.mp3"));
        gameMusic.setLooping(true);
        atlas = new TextureAtlas(Gdx.files.internal("Animations\\dino.atlas"));
        ideAnimation = new Animation<TextureRegion>(0.1f, atlas.findRegions("ide"), Animation.PlayMode.LOOP);
        ideSheet = new Texture(Gdx.files.internal("Animations\\dino.png"));
        TextureRegion[][] tmp = TextureRegion.split(ideSheet,
                ideSheet.getWidth() / 7,
                ideSheet.getHeight() / 7);
        TextureRegion[] ideFrames = new TextureRegion[7 * 7];
        int index = 0;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                ideFrames[index++] = tmp[i][j];
            }
        }
        ideAnimation = new Animation<TextureRegion>(0.1f, ideFrames);
    }

    public static void loadMainMenu(){

        backgroundImage=new Texture(Gdx.files.internal("Backgrounds\\backGroundMain.png"));
        region  = new TextureRegion(backgroundImage, 0, 0, 800, 480);
        mainMusic = Gdx.audio.newMusic(Gdx.files.internal("Music\\mainMusic.mp3"));
        mainMusic.setLooping(true);

    }
    public static void loadEndAssets(){
        backgroundImage1=new Texture(Gdx.files.internal("Backgrounds\\backGroundEnd.png"));
        region1  = new TextureRegion(backgroundImage1, 0, 0, 800, 480);
       // endMusic=Gdx.audio.newMusic(Gdx.files.internal("Sounds\\starWarsMusic.mp3"));
        endMusic=Gdx.audio.newMusic(Gdx.files.internal("Music\\DramaticMusic.mp3"));
        endGame=Gdx.audio.newSound(Gdx.files.internal("Sounds\\duffMan.mp3"));
        endMusic.setLooping(true);
    }
    //http://www.sonidosmp3gratis.com/arcade-musica-3
}

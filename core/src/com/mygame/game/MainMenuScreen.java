package com.mygame.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

import java.awt.Button;

public class MainMenuScreen implements Screen{
    final MyGame game;
    OrthographicCamera camera;
    private Button b1;

    public MainMenuScreen(final MyGame gam) {
        game = gam;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        AssetsLoader.loadMainMenu();
        b1=new Button("button");
    }

    @Override
    public void show() {
        AssetsLoader.mainMusic.play();

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        game.batch.draw(AssetsLoader.region,0,0);

        game.font.draw(game.batch, "Javiii93!!! ", 100, 150);
        game.font.draw(game.batch, "Toca la pantalla para empezar!", 100, 100);

        game.batch.end();


        if (Gdx.input.isTouched()) {
        game.setScreen(new GameScreen(game));
            dispose();
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
AssetsLoader.backgroundImage.dispose();
AssetsLoader.mainMusic.dispose();
    }
}

package com.mygame.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;


public class EndGameScreen implements Screen {
    private MyGame game;
    private OrthographicCamera camera;

    public EndGameScreen(final MyGame gam) {
        game = gam;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        AssetsLoader.loadEndAssets();


    }


    @Override
    public void show() {
       // AssetsLoader.endGame.play();
        AssetsLoader.endMusic.play();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // tell the camera to update its matrices.
        camera.update();

        // tell the SpriteBatch to render in the
        // coordinate system specified by the camera.
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        game.batch.draw(AssetsLoader.region1,0,0);
        game.batch.end();


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
        AssetsLoader.endGame.dispose();
        AssetsLoader.endMusic.dispose();
        AssetsLoader.backgroundImage1.dispose();
    }
}

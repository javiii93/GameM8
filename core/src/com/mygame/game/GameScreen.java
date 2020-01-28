package com.mygame.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;


public class GameScreen implements Screen {
    private Array<Rectangle> snake;
    private Rectangle snakeHeadRectangle;
    private MyGame game;
    private OrthographicCamera camera;
    private float stateTime;
    private boolean death = false;

    public GameScreen(MyGame gam) {
        game = gam;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
       /* snake = new Array<>();
        snakeHeadRectangle = new Rectangle();
        snakeHeadRectangle.x = 800 / 2 - 64 / 2; // center the bucket horizontally
        snakeHeadRectangle.y = 20; // bottom left corner of the bucket is 20 pixels above
        snakeHeadRectangle.width = 64;
        snakeHeadRectangle.height = 64;*/

        AssetsLoader.loadGameAssets();
        stateTime = 0f;
    }

    @Override
    public void show() {
        AssetsLoader.gameMusic.play();
        float vol = AssetsLoader.gameMusic.getVolume();
        AssetsLoader.startGame.play();

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stateTime += Gdx.graphics.getDeltaTime(); // Accumulate elapsed animation time

        // tell the camera to update its matrices.
        camera.update();

        // tell the SpriteBatch to render in the
        // coordinate system specified by the camera.
        game.batch.setProjectionMatrix(camera.combined);
        TextureRegion currentFrame = AssetsLoader.ideAnimation.getKeyFrame(stateTime, true);
        game.batch.begin();


        game.batch.draw(AssetsLoader.region2, 0, 0);
        // game.batch.draw(AssetsLoader.snakeHead, snakeHeadRectangle.x, snakeHeadRectangle.y);
        // Get current frame of animation for the current stateTime
        game.batch.draw(currentFrame, 400, 240); // Draw current frame at (50, 50)
        game.batch.end();
       /* if (death){
            game.setScreen(new EndGameScreen(game));
            dispose();
        }*/
        if (Gdx.input.justTouched()) {
            game.setScreen(new EndGameScreen(game));
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
        //AssetsLoader.snakeHead.dispose();
        AssetsLoader.backgroundImage2.dispose();
        AssetsLoader.gameMusic.dispose();
        AssetsLoader.startGame.dispose();
        AssetsLoader.atlas.dispose();
        AssetsLoader.ideSheet.dispose();
    }
}

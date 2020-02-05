package com.mygame.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;


public class GameScreen implements Screen {
    private Array<Rectangle> snake;
    private Rectangle dino;
    private MyGame game;
    private OrthographicCamera camera;
    private float stateTime;
    private boolean death = false, left = false, right = false, idle = true, isWalking = false;

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
        dino = new Rectangle();
        dino.x = 800 / 2 - 64 / 2;
        dino.y = 20;

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
        TextureRegion currentFrameWalking = AssetsLoader.walkingAnimation.getKeyFrame(stateTime, true);
        game.batch.begin();
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            isWalking = true;
        } else {
            isWalking = false;
        }
        if (left) {
            if (isWalking) {
                currentFrameWalking.flip(true, false);
                game.batch.draw(currentFrameWalking, dino.x, dino.y, 0.5f * currentFrameWalking.getRegionWidth(), 0.5f * currentFrameWalking.getRegionHeight());
                currentFrameWalking.flip(true, false);
            } else {
                currentFrame.flip(true, false);
                game.batch.draw(currentFrame, dino.x, dino.y, 0.5f * currentFrame.getRegionWidth(), 0.5f * currentFrame.getRegionHeight());
                currentFrame.flip(true, false);
            }

        } else if ((right) || (right == false && left == false && idle)) {
            if (isWalking) {
                game.batch.draw(currentFrameWalking, dino.x, dino.y, 0.5f * currentFrameWalking.getRegionWidth(), 0.5f * currentFrameWalking.getRegionHeight());
            } else {
                game.batch.draw(currentFrame, dino.x, dino.y, 0.5f * currentFrame.getRegionWidth(), 0.5f * currentFrame.getRegionHeight());
            }

        }

        game.batch.end();
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            dino.x -= 200 * Gdx.graphics.getDeltaTime();
            left = true;
            right = false;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            dino.y -= 200 * Gdx.graphics.getDeltaTime();
            
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            dino.x += 200 * Gdx.graphics.getDeltaTime();
            left = false;
            right = true;

        }
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE) || Gdx.input.isKeyPressed(Input.Keys.UP)) {
            dino.y += 200 * Gdx.graphics.getDeltaTime();

        }
        if (!Gdx.input.isKeyPressed(Input.Keys.ANY_KEY)) {
            idle = true;
            isWalking = false;

        } else {
            idle = false;
        }
        //System.out.println(Gdx.input.isKeyPressed(Input.Keys.ANY_KEY));


        if (dino.x < 0) {
            dino.x = 0;

        }
        if (dino.x > 800 - 64) {
            dino.x = 800 - 64;
        }

        if (Gdx.input.justTouched() && death) {
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
        // AssetsLoader.backgroundImage2.dispose();
        AssetsLoader.gameMusic.dispose();
        AssetsLoader.startGame.dispose();
        AssetsLoader.atlas.dispose();
        AssetsLoader.ideSheet.dispose();
    }
}

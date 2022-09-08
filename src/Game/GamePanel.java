/*
 * To change this license header, choose License Headers in Project Properties
 * To change this template file, choose Tools | Templates
 * and open the template in the editor
 */
package Game;

import Controller.KeyboardController;
import GameObjects.Beam;
import GameObjects.Bullet;
import GameObjects.Enemy;
import GameObjects.Enemy2;
import GameObjects.Enemy3;
import GameObjects.Shield;
import GameObjects.Ship;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Jake Harmon
 */
public class GamePanel extends JPanel {

    protected Ship ship;
    //all lists of things
    protected ArrayList<Enemy> enemyList;
    protected ArrayList<Beam> beamList;
    protected ArrayList<Bullet> bulletList;
    protected ArrayList<Beam> deletedBeams;
    protected ArrayList<Shield> shieldList;
    protected ArrayList<Enemy3> enemy3List;
    protected int currentFrame;
    protected int score;
    protected int highScore = 0;
    protected Random rand;
    protected int num;
    protected int num2;
    protected int num3;
    protected String message;
    protected boolean gameOver;
    protected Enemy2 boss;
    protected Enemy2 boss2;
    protected int numOfLives;
    protected Enemy temp;
    protected Enemy3 temp2;

    // These are for handling the frame rate of the game and player controls
    // You should pass the controller to any objects you create that will
    //  be under keyboard control
    private Timer gameTimer;
    private KeyboardController controller;

    // Controls size of game window and framerate
    // You can adjust these if you want to use different values 
    private final int gameWidth = 600;
    private final int gameHeight = 720;
    private final int framesPerSecond = 60;
    

    /**
     * This method is called by the GameFrame class when starting the game for
     * the first time. It should be used like a constructor method where you
     * initialize all of the instance variables. You can also use this method to
     * reset a game after a player wins or loses and wants to play again.
     */
    public final void setupGame() {
        //setting up ship starting point
        ship = new Ship(50, 650, Color.yellow, controller);
        //setting up enemyList
        enemyList = new ArrayList<>();
        // instantiate begining number of enemies
        enemyList.add(new Enemy(60, 80, -2, 0, Color.DARK_GRAY));
        enemyList.add(new Enemy(120, 80, -2, 0, Color.DARK_GRAY));
        enemyList.add(new Enemy(180, 80, -2, 0, Color.DARK_GRAY));
        enemyList.add(new Enemy(240, 80, -2, 0, Color.DARK_GRAY));
        enemyList.add(new Enemy(300, 80, -2, 0, Color.DARK_GRAY));
        enemyList.add(new Enemy(360, 80, -2, 0, Color.DARK_GRAY));
        enemyList.add(new Enemy(420, 80, -2, 0, Color.DARK_GRAY));
        enemyList.add(new Enemy(480, 80, -2, 0, Color.DARK_GRAY));
        enemyList.add(new Enemy(540, 80, -2, 0, Color.DARK_GRAY));
        enemyList.add(new Enemy(60, 150, 2, 0, Color.DARK_GRAY));
        enemyList.add(new Enemy(120, 150, 2, 0, Color.DARK_GRAY));
        enemyList.add(new Enemy(180, 150, 2, 0, Color.DARK_GRAY));
        enemyList.add(new Enemy(240, 150, 2, 0, Color.DARK_GRAY));
        enemyList.add(new Enemy(300, 150, 2, 0, Color.DARK_GRAY));
        enemyList.add(new Enemy(360, 150, 2, 0, Color.DARK_GRAY));
        enemyList.add(new Enemy(420, 150, 2, 0, Color.DARK_GRAY));
        enemyList.add(new Enemy(480, 150, 2, 0, Color.DARK_GRAY));
        enemyList.add(new Enemy(540, 150, 2, 0, Color.DARK_GRAY));
        //setting up beamList
        beamList = new ArrayList<>();
        //set up deletedBeamList
        deletedBeams = new ArrayList<>();
        //set up bulletList
        bulletList = new ArrayList<>();

        //set up shieldList
        shieldList = new ArrayList<>();
        int xPos = 0;
        shieldList.add(new Shield(0,   550, 8, 10, Color.white));
        shieldList.add(new Shield(10,  550, 8, 10, Color.white));
        shieldList.add(new Shield(20,  550, 8, 10, Color.white));
        shieldList.add(new Shield(30,  550, 8, 10, Color.white));
        shieldList.add(new Shield(40,  550, 8, 10, Color.white));
        shieldList.add(new Shield(50,  550, 8, 10, Color.white));
        shieldList.add(new Shield(60,  550, 8, 10, Color.white));
        shieldList.add(new Shield(70,  550, 8, 10, Color.white));
        shieldList.add(new Shield(80,  550, 8, 10, Color.white));
        shieldList.add(new Shield(90,  550, 8, 10, Color.white));
        shieldList.add(new Shield(100, 550, 8, 10, Color.white));
        shieldList.add(new Shield(110, 550, 8, 10, Color.white));
        shieldList.add(new Shield(120, 550, 8, 10, Color.white));
        shieldList.add(new Shield(130, 550, 8, 10, Color.white));
        shieldList.add(new Shield(140, 550, 8, 10, Color.white));
        shieldList.add(new Shield(150, 550, 8, 10, Color.white));
        shieldList.add(new Shield(160, 550, 8, 10, Color.white));
        shieldList.add(new Shield(170, 550, 8, 10, Color.white));
        shieldList.add(new Shield(180, 550, 8, 10, Color.white));
        shieldList.add(new Shield(190, 550, 8, 10, Color.white));
        shieldList.add(new Shield(200, 550, 8, 10, Color.white));
        shieldList.add(new Shield(210, 550, 8, 10, Color.white));
        shieldList.add(new Shield(220, 550, 8, 10, Color.white));
        shieldList.add(new Shield(230, 550, 8, 10, Color.white));
        shieldList.add(new Shield(240, 550, 8, 10, Color.white));
        shieldList.add(new Shield(250, 550, 8, 10, Color.white));
        shieldList.add(new Shield(260, 550, 8, 10, Color.white));
        shieldList.add(new Shield(270, 550, 8, 10, Color.white));
        shieldList.add(new Shield(280, 550, 8, 10, Color.white));
        shieldList.add(new Shield(290, 550, 8, 10, Color.white));
        shieldList.add(new Shield(300, 550, 8, 10, Color.white));
        shieldList.add(new Shield(310, 550, 8, 10, Color.white));
        shieldList.add(new Shield(320, 550, 8, 10, Color.white));
        shieldList.add(new Shield(330, 550, 8, 10, Color.white));
        shieldList.add(new Shield(340, 550, 8, 10, Color.white));
        shieldList.add(new Shield(350, 550, 8, 10, Color.white));
        shieldList.add(new Shield(360, 550, 8, 10, Color.white));
        shieldList.add(new Shield(370, 550, 8, 10, Color.white));
        shieldList.add(new Shield(380, 550, 8, 10, Color.white));
        shieldList.add(new Shield(390, 550, 8, 10, Color.white));
        shieldList.add(new Shield(400, 550, 8, 10, Color.white));
        shieldList.add(new Shield(410, 550, 8, 10, Color.white));
        shieldList.add(new Shield(420, 550, 8, 10, Color.white));
        shieldList.add(new Shield(430, 550, 8, 10, Color.white));
        shieldList.add(new Shield(440, 550, 8, 10, Color.white));
        shieldList.add(new Shield(450, 550, 8, 10, Color.white));
        shieldList.add(new Shield(460, 550, 8, 10, Color.white));
        shieldList.add(new Shield(470, 550, 8, 10, Color.white));
        shieldList.add(new Shield(480, 550, 8, 10, Color.white));
        shieldList.add(new Shield(490, 550, 8, 10, Color.white));
        shieldList.add(new Shield(500, 550, 8, 10, Color.white));
        shieldList.add(new Shield(510, 550, 8, 10, Color.white));
        shieldList.add(new Shield(520, 550, 8, 10, Color.white));
        shieldList.add(new Shield(530, 550, 8, 10, Color.white));
        shieldList.add(new Shield(540, 550, 8, 10, Color.white));
        shieldList.add(new Shield(550, 550, 8, 10, Color.white));
        shieldList.add(new Shield(560, 550, 8, 10, Color.white));
        shieldList.add(new Shield(570, 550, 8, 10, Color.white));
        shieldList.add(new Shield(580, 550, 8, 10, Color.white));
        shieldList.add(new Shield(590, 550, 8, 10, Color.white));
        shieldList.add(new Shield(600, 550, 8, 10, Color.white));

        //set up enemy3 list
        enemy3List = new ArrayList<>();
        enemy3List.add(new Enemy3(80,  300, 1, 0, Color.LIGHT_GRAY));
        enemy3List.add(new Enemy3(500, 300, 1, 0, Color.LIGHT_GRAY));
        enemy3List.add(new Enemy3(80,  100, 1, 0, Color.LIGHT_GRAY));
        enemy3List.add(new Enemy3(500, 100, 1, 0, Color.LIGHT_GRAY));
        enemy3List.add(new Enemy3(500, 100, 1, 0, Color.LIGHT_GRAY));
        enemy3List.add(new Enemy3(210, 200, 1, 0, Color.LIGHT_GRAY));
        //set up random
        rand = new Random();

        // sets gameOver
        gameOver = false;
        message = "";

        //set up boss enemys
        boss = new Enemy2();
        boss.setXpos(30);
        boss2 = new Enemy2();
        boss2.setXpos(570);
        numOfLives = 3;

        //adds temporary enemy for creating bullets
        temp = enemyList.get(rand.nextInt(enemyList.size() + 1));

    }

    /**
     * This method is automatically called by the game timer every frame. As
     * typical, you should use it to draw all of your game objects.
     *
     * @param g The Graphics object used for drawing the GameObject instances.
     */
    @Override
    public void paint(Graphics g) {

        if (gameOver == true) {
            //sets the font and draws the messge if gameOver == true;
            g.setFont(new Font("Impact", Font.PLAIN, 50));
            g.setColor(Color.red);
            message = "GAME OVER";

            // if you destroy all the ships a different message is presented 
            if (score == 310) {
                g.setColor(Color.GREEN);
                message = "You Win!!";
            }
            g.drawString(message, 180, 310);
            g.setFont(new Font("Impact", Font.PLAIN, 20));
            g.setColor(Color.BLUE);
            g.drawString("If you would like to play again press the up arrow!!", 100, 400);
            // if space bar is press resets game
            if (controller.getUpKeyStatus() == true) {
                numOfLives = 3;
                score = 0;
                gameOver = false;
                setupGame();

            }
        }

        if (gameOver == false) {
            //draws ship 
            ship.draw(g);

            //draws score and highscore
            g.setColor(Color.LIGHT_GRAY);
            if (score > highScore) {
                highScore = score;
            }

            g.setFont(new Font("Impact", Font.PLAIN, 20));
            g.drawString(String.valueOf("Score:" + score), 10, 30);
            g.drawString(String.valueOf("High Score:" + highScore), 10, 50);
            g.drawString(String.valueOf("Lives: " + numOfLives), 10, 700);
            // prints game over if gameOver = true

            //draws beams that are added to the list 
            if (beamList.isEmpty() == false) {
                for (Beam b : beamList) {
                    b.draw(g);
                }
            }

            //draws all enemies in enemyList
            if (enemyList.isEmpty() == false) {
                for (Enemy e : enemyList) {
                    e.draw(g);
                }
            }

            //draws all enemys in the enemy3List
            if (enemy3List.isEmpty() == false) {
                for (Enemy3 e : enemy3List) {
                    e.draw(g);
                }
            }

            //draws all bullets in bulletList
            if (bulletList.isEmpty() == false) {
                for (Bullet b : bulletList) {
                    b.draw(g);
                }
            }
            //draws shields in shieldList
            if (shieldList.isEmpty() == false) {
                for (Shield s : shieldList) {
                    s.draw(g);
                }
            }

            //draws starDestroyer
            boss.draw(g);
            boss2.draw(g);
        }

    }

    /**
     * This method is automatically called by the game timer every frame. Any of
     * your code for moving game objects or handling collisions, etc. should be
     * done by this method. The method has a single parameter which represents
     * the current frame number, which is incremented by the Timer each time
     * before the method is called. You can assume that it will always increase,
     * but it will eventually overflow if the game runs long enough (something
     * like 1 year)
     *
     * @param frameNumber The number of the current frame.
     */
    public void updateGameState(int frameNumber) {

        //controlls ship and enemy movement and checks for collision 
        ship.move();

        // adds beams to the beamList if the space bar is pressed
        if (frameNumber >= currentFrame + 20) {
            currentFrame = frameNumber;
            if (controller.getSpaceKeyStatus() == true) {

                //checks if the current frame is less than the frame number
                beamList.add(new Beam(ship.getXpos() + 18, ship.getYpos() - 30, 0, -5, 20, 5, Color.red));
                //adds beams to the beamList

            }
        }
        // if the frameNumber reaches a certain point a new bullet is shot from a random enemy
        
        if (frameNumber == num) {

            temp = enemyList.get(rand.nextInt(enemyList.size()));
            bulletList.add(new Bullet(temp.getXpos(), temp.getYpos(), 0, 2, 10, Color.GREEN));
            temp = enemyList.get(rand.nextInt(enemyList.size()));
            bulletList.add(new Bullet(temp.getXpos(), temp.getYpos(), 0, 2, 10, Color.GREEN));
            num += 80;
        }

        // if the frameNumber reaches a certain point a new bullet is shot from a random enemy
        if (frameNumber == num2) {

            bulletList.add(new Bullet(boss.getXpos(), boss.getYpos() + 30, 0, 2, 10, Color.GREEN));
            bulletList.add(new Bullet(boss.getXpos() + 15, boss.getYpos() + 30, 0, 2, 10, Color.GREEN));
            bulletList.add(new Bullet(boss2.getXpos(), boss2.getYpos() + 30, 0, 2, 10, Color.GREEN));
            bulletList.add(new Bullet(boss2.getXpos() + 15, boss2.getYpos() + 30, 0, 2, 10, Color.GREEN));
            num2 += 240;
        }

        // if the frameNumber reaches a certain number a new bullet will be added to the bullet list
        if (frameNumber == num3) {
            temp2 = enemy3List.get(rand.nextInt(enemy3List.size()));
            bulletList.add(new Bullet(temp2.getXpos(), temp2.getYpos(), 0, 2, 10, Color.magenta));
            bulletList.add(new Bullet(temp2.getXpos(), temp2.getYpos() - 10, 0, 2, 10, Color.magenta));

            temp = enemyList.get(rand.nextInt(enemy3List.size()));
            bulletList.add(new Bullet(temp2.getXpos(), temp2.getYpos(), 0, 2, 10, Color.magenta));
            bulletList.add(new Bullet(temp2.getXpos(), temp2.getYpos() - 10, 0, 2, 10, Color.magenta));

            num3 += 120;
        }

        // moves the beams in the beamList
        if (beamList.isEmpty() == false) {
            for (Beam b : beamList) {
                b.move();
            }
        }

        //moves bullets in the bullet list
        if (bulletList.isEmpty() != true) {
            for (Bullet u : bulletList) {
                u.move();
            }
        }

        //moves enemies in the enemyList
        if (enemyList.isEmpty() == false) {
            for (Enemy e : enemyList) {
                e.move();
            }
        }

        //moves enemys in the enemy3List
        if (enemyList.isEmpty() == false) {
            for (Enemy3 e : enemy3List) {
                e.move();
            }
        }

        //check for collision between beams and enemys
        if (beamList.isEmpty() == false) {
            for (Beam b : beamList) {
                for (Enemy e : enemyList) {

                    if (e.checkForBeamCollsion(b) == true && b.checkForCollison(e) == true) {

                        score = score + 10;
                        b.setYpos(-10);
                    }

                }
            }
        }

        //checks for collision between bullets and ship
        if (bulletList.isEmpty() == false) {
            for (Bullet b : bulletList) {
                if (ship.getBounds().intersects(b.getBounds())) {
                    b.setXpos(700);
                    numOfLives--;
                }
            }
        }

        //check for collision between beams and shields
        if (beamList.isEmpty() == false) {
            for (Beam b : beamList) {
                for (Shield s : shieldList) {
                    if (b.getBounds().intersects(s.getBounds())) {
                        s.setXpos(700);
                        b.setXpos(700);
                    }
                }
            }
        }

        //check for collision between bullets and shields
        if (bulletList.isEmpty() == false) {
            for (Bullet b : bulletList) {
                for (Shield s : shieldList) {
                    if (b.getBounds().intersects(s.getBounds())) {
                        s.setXpos(700);
                        b.setXpos(700);
                    }
                }
            }
        }

        //check for collison between beams and boss ships
        if (beamList.isEmpty() == false) {
            for (Beam b : beamList) {
                if (b.getBounds().intersects(boss.getBounds())) {
                    boss.setHitsToDestroy(boss.getHitsToDestroy() - 1);
                    b.setXpos(900);
                    if (boss.getHitsToDestroy() == 0) {
                        score += 20;
                    }
                }
                if (b.getBounds().intersects(boss2.getBounds())) {
                    boss2.setHitsToDestroy(boss2.getHitsToDestroy() - 1);
                    b.setYpos(-10);
                    if (boss2.getHitsToDestroy() == 0) {
                        score += 20;
                    }
                }

            }
        }

        //checks for collision between beams and tie bombers(enemy3)
        if (beamList.isEmpty() == false) {
            for (Beam b : beamList) {
                for (Enemy3 e : enemy3List) {
                    if (b.getBounds().intersects(e.getBounds())) {
                        e.setHitsToDestroy(e.getHitsToDestroy() - 1);
                        b.setYpos(-10);

                        if (e.getHitsToDestroy() == 0) {
                            score += 15;
                        }
                        if (e.getYpos() >= 600) {
                            gameOver = true;
                        }
                    }

                }
            }
        }

        //removes boss if the hits to destroy is 0 also checks if the y position is at a point to end the game
        if (boss.getHitsToDestroy() <= 0) {
            boss.setXpos(900);
            boss.setYpos(-10);

        }

        if (boss.getYpos() >= 600) {
            gameOver = true;
        }
        if (boss2.getHitsToDestroy() <= 0) {
            boss2.setXpos(900);
            boss2.setYpos(-10);

        }
        if (boss2.getYpos() >= 600) {
            gameOver = true;
        }

        //removes tie bombers if hits to destroy is 0
        if (enemy3List.isEmpty() == false) {
            for (Enemy3 e : enemy3List) {
                if (e.getHitsToDestroy() == 0) {
                    e.setXpos(1000);
                }
            }
        }
        //if beams go out of bounds removes them from the list
        if (beamList.isEmpty() == false) {
            for (Beam b : beamList) {
                if (b.getYpos() < -10) {
                    deletedBeams.add(b);
                }

            }
            beamList.removeAll(deletedBeams);
        }

        //move stardestroyer
        boss.move();
        boss2.move();

        //changes ships color based on number of lives
        if (numOfLives == 3) {
            ship.setColor(Color.yellow);
        }
        if (numOfLives == 2) {
            ship.setColor(Color.orange);
        }
        if (numOfLives == 1) {
            ship.setColor(Color.red);
        }

        if (numOfLives <= 0 || score == 310) {
            gameOver = true;
        }

        //as enemys move farther down the screen they start to move faster
    }

    /**
     * Constructor method for GamePanel class. It is not necessary for you to
     * modify this code at all
     */
    public GamePanel() {
        // Set the size of the Panel
        this.setSize(gameWidth, gameHeight);
        this.setPreferredSize(new Dimension(gameWidth, gameHeight));

        this.setBackground(Color.BLACK);

        // Register KeyboardController as KeyListener
        controller = new KeyboardController();
        this.addKeyListener(controller);

        // Call setupGame to initialize fields
        this.setupGame();

        this.setFocusable(true);
        this.requestFocusInWindow();

    }

    /**
     * Method to start the Timer that drives the animation for the game. It is
     * not necessary for you to modify this code unless you need to in order to
     * add some functionality.
     */
    public void start() {
        // Set up a new Timer to repeat based on the set framesPerSecond
        gameTimer = new Timer(1000 / framesPerSecond, new ActionListener() {

            // Tracks the number of frames that have been produced.
            // May be useful for limiting action rates
            private int frameNumber = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                // Update the game's state and repaint the screen
                updateGameState(frameNumber++);
                repaint();
            }
        });

        gameTimer.setRepeats(true);
        gameTimer.start();
    }
}

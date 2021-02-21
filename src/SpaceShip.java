import java.awt.Image;
import oop.ex2.*;

/**
 * The API spaceships need to implement for the SpaceWars game.
 * This class represents a spaceship object in the game. this is a father class to all kinds of spaceships in the game.
 *  
 * @author oop
 */
public abstract class SpaceShip extends java.lang.Object{
    public SpaceShip(){
        this.shipPhysics = new SpaceShipPhysics();
        this.maxEnergy = 210;
        this.currEnergy = 190;
        this.health = 22;
        this.shield = false;
        this.roundsCounter = 8;
    }


    /**The spaceship physics object of current spaceship. */
    public SpaceShipPhysics shipPhysics;

    /**Spaceship's physics position. */
    // public Physics shipPosition;

    /** Spaceship's maximal energy level. */
    public double maxEnergy;

    /** Spaceship's current energy level. */
    public double currEnergy;

    /** Spaceship's health level. */
    public int health;

    /** Spaceship's shield. */
    public boolean shield;

    /** After-shot rounds counter - counts how many rounds have passed since ship's last shot. */
    public int roundsCounter;


    /**
     * Does the actions of this ship for this round. 
     * This is called once per round by the SpaceWars game driver.
     * 
     * @param game the game object to which this ship belongs.
     */

    public void doAction(SpaceWars game) {
        }


    /**
     * This method is called every time a collision with this ship occurs
     */
    public void collidedWithAnotherShip(){
        if (this.shield = true) {
            this.maxEnergy += 18;
            this.currEnergy += 18;
        }
        this.health -= 1;
    }

    /** 
     * This method is called whenever a ship has died. It resets the ship's 
     * attributes, and starts it at a new random position.
     */
    public void reset(){
        this.shipPhysics = new SpaceShipPhysics();
        this.maxEnergy = 210;
        this.currEnergy = 190;
        this.health = 22;
        this.shield = false;
        this.roundsCounter = 8;
    }

    /**
     * Checks if this ship is dead.
     * 
     * @return true if the ship is dead. false otherwise.
     */
    public boolean isDead() {
        if (this.health == 0){
            return true;
        }
        return false;
    }

    /**
     * Gets the physics object that controls this ship.
     * 
     * @return the physics object that controls the ship.
     */
    public SpaceShipPhysics getPhysics() {
        return this.shipPhysics;
    }

    /**
     * This method is called by the SpaceWars game object when ever this ship
     * gets hit by a shot.
     */
    public void gotHit() {
        this.health -= 1;
        if (this.shield == false) {
            this.maxEnergy -= 10;
        }
        if (this.maxEnergy < this.currEnergy) {
            this.currEnergy = this.maxEnergy;
        }

    }

    /**
     * Gets the image of this ship. This method should return the image of the
     * ship with or without the shield. This will be displayed on the GUI at
     * the end of the round.
     * 
     * @return the image of this ship.
     */
    public Image getImage(){
        return null;
    }

    /**
     * Attempts to fire a shot.
     * 
     * @param game the game object.
     */
    public void fire(SpaceWars game) {
       if (this.roundsCounter > 7 && this.currEnergy >= 19 && this.maxEnergy >= 19) {
           game.addShot(this.getPhysics());
           this.currEnergy -= 19;
           this.maxEnergy -= 19;
           this.roundsCounter = 0;
       }

    }

    /**
     * Attempts to turn on the shield.
     */
    public void shieldOn() {
        this.shield = true;
        this.maxEnergy -= 3;
        this.currEnergy -= 3;
    }


    /**
     * Attempts to teleport.
     */
    public void teleport() {
        if (this.maxEnergy >= 140 && this.currEnergy >= 140){
            this.shipPhysics = new SpaceShipPhysics();
            this.maxEnergy -= 140;
            this.currEnergy -= 140;
        }

       
    }

    /** Side function that adds 1 to rounds counter.
     * This function is being used after each round that is not a shot.
     */
    public void updateCounter(){
        this.roundsCounter += 1;
    }

    
}

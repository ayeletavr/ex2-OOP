import java.awt.Image;
import oop.ex2.*;

/** This class represents the human-controlled spaceship. the keys are:
 * left-arrow and right-arrow to turn, up-arrow to accelerate,
 * 'd' to fire a shot, 's' to turn on the shield, 'a' to teleport.
 */

public class h extends SpaceShip {

    /**
     * Does the actions of this human-controlled ship for this round.
     * This is called once per round by the SpaceWars game driver.
     * @param game the game object to which this ship belongs.
     */
    public void doAction(SpaceWars game){
        if (game.getGUI().isTeleportPressed()){
            this.teleport();
        }
        if (game.getGUI().isUpPressed()){
            if (game.getGUI().isLeftPressed()){
                getPhysics().move(true,1);
            }
            if (game.getGUI().isRightPressed()){
                getPhysics().move(true,-1);
            }
        }
        if (game.getGUI().isLeftPressed()){
            getPhysics().move(false,1);
        }
        if (game.getGUI().isRightPressed()){
            getPhysics().move(false,-1);
        }
        if (game.getGUI().isShotPressed()){
            this.fire(game);
        }
        if (game.getGUI().isShieldsPressed()){
            this.shieldOn();
        }
        if (this.currEnergy < this.maxEnergy){
            this.currEnergy += 1;
        }
        this.roundsCounter += 1;

    }

    /**
     * Gets the image of this human-controlled ship. This method should return the image of the
     * ship with or without the shield. This will be displayed on the GUI at
     * the end of the round.
     *
     * @return the image of this ship.
     */
    public Image getImage() {
        if (this.shield){
            return GameGUI.SPACESHIP_IMAGE_SHIELD;
        }
        return GameGUI.SPACESHIP_IMAGE;

    }
}

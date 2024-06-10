package controller;

import view.imageUtilities.SpriteUtilities;
import java.awt.image.BufferedImage;

/***** Class for the Model controller to control the enemies in the game classes *****/
public class ModelController {

    /**** Fields ****/
    /** Enemies **/
    private final String reaperWalkingPath = "enemy_reaper/HostileRunningReaper.png";           // Path for the reaper walking images
    private final String reaperAttackingPath = "enemy_reaper/HostileAttackReaper.png";          // Path for the reaper attacking images
    private final String reaperDeathPath = "enemy_reaper/DeathAnimationReaper.png";             // Path for the reaper death images
    private final String skeletonWalkingPath = "enemy_skeleton/skeleton_walk.png";              // Path for the skeleton walking images
    private final String skeletonAttackingPath = "enemy_skeleton/skeleton_attack.png";          // Path for the skeleton attacking images
    private final String skeletonDeathPath = "enemy_skeleton/skeleton_dead.png";                // Path for the skeleton death images
    private final String zombieWalkingPath = "enemy_zombie/zombie_run.png";                     // Path for the zombie walking images
    private final String zombieAttackingPath = "enemy_zombie/zombie_attack.png";                // Path for the zombie attacking images
    private final String zombieDeathPath = "enemy_zombie/zombie_dead.png";                      // Path for the zombie death images


    /** Towers **/
    private BufferedImage[] standingImages;                                 // Buffered images array for the set of standing images of the tower
    private BufferedImage[] firingImages;                                   // Buffered images array for the set of firing images of the tower




    /**** Constructors ****/
    /** Main constructor **/
    public ModelController() {
        this.standingImages = new BufferedImage[11];                        // Max size of the standing images
        this.firingImages = new BufferedImage[11];                          // Max size of the firing images
    }




    /**** Methods ****/
    /** Enemies walking images getter **/
    public BufferedImage[] getWalkingImages(String path, int numOfImgs, int width, int height) {
        return SpriteUtilities.getAniSprites(0, 0, SpriteUtilities.getSpriteAtlas(path), numOfImgs, width, height);
    }

    /** Enemies attacking images getter **/
    public BufferedImage[] getAttackingImages(String path, int numOfImgs, int width, int height) {
        return SpriteUtilities.getAniSprites(0, 0, SpriteUtilities.getSpriteAtlas(path), numOfImgs, width, height);
    }

    /** Enemies death images getter **/
    public BufferedImage[] getDeathImages(String path, int numOfImgs, int width, int height) {
        return SpriteUtilities.getAniSprites(0, 0, SpriteUtilities.getSpriteAtlas(path), numOfImgs, width, height);
    }

    /** Tower standing images getter **/
    public BufferedImage[] getStandingImages() {
        return this.standingImages;
    }

    /** Tower firing images getter **/
    public BufferedImage[] getFiringImages() {
        return this.firingImages;
    }

    /** Tower standing images setter **/
    public void setStandingImages(BufferedImage[] imgs) {
        this.standingImages = imgs;
    }

    /** Tower firing images setter **/
    public void setFiringImages(BufferedImage[] imgs) {
        this.firingImages = imgs;
    }

    /** Turret atlas path getter **/
    public String getTurretAtlasPath() {
        return "tower_turret/turret_mk.png";
    }

    /** Machinegun firing atlas path getter **/
    public String getMachineGunFiringAtlasPath() {
        return "tower_machinegun/machinegun_shooting.png";
    }

    /** Machinegun standing atlas path getter **/
    public String getMachineGunStandingAtlasPath() {
        return "tower_machinegun/machinegun_standing.png";
    }

    /** Cannon firing atlas path getter **/
    public String getCannonFiringAtlasPath() {
        return "tower_cannon/cannon_shooting.png";
    }

    /** Cannon standing atlas path getter **/
    public String getCannonStandingAtlasPath() {
        return "tower_cannon/cannon_standing.png";
    }

    /** Zombie death atlas path getter **/
    public String getZombieDeathAtlasPath() {
        return this.zombieDeathPath;
    }

    /** Zombie attack atlas path getter **/
    public String getZombieAttackAtlasPath() {
        return this.zombieAttackingPath;
    }

    /** Zombie moving atlas path getter **/
    public String getZombieMovingAtlasPath() {
        return this.zombieWalkingPath;
    }

    /** Skeleton death atlas path getter **/
    public String getSkeletonDeathAtlasPath() {
        return this.skeletonDeathPath;
    }

    /** Skeleton attack path getter **/
    public String getSkeletonAttackAtlasPath() {
        return this.skeletonAttackingPath;
    }

    /** Skeleton moving atlas path getter **/
    public String getSkeletonMovingAtlasPath() {
        return this.skeletonWalkingPath;
    }

    /** Reaper death atlas path getter **/
    public String getReaperDeathAtlasPath() {
        return this.reaperDeathPath;
    }

    /** Reaper attack atlas path getter **/
    public String getReaperAttackAtlasPath() {
        return this.reaperAttackingPath;
    }

    /** Reaper moving atlas path getter **/
    public String getReaperMovingAtlasPath() {
        return this.reaperWalkingPath;
    }
}
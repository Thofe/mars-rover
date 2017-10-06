
/**
 * Write a description of class Rover here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rover
{
    public int used;
    
    // fields
    private String name;
    private int x;
    private int y;
    private int dir;// 0=North, 1=East, 2=South, 3=West
    private int numPics;
    private int memory;
    private boolean isAlive;
    private int battery;
    private int homeX;
    private int homeY;
    
    
    // constructor(s)
    /**
     * constructs a rover
     * 
     * @param name (as a string) the rovers name
     */
    public Rover(String name)
    {
        this.name = name;
        this.x = 0;
        this.y = 0;
        this.dir = 0;
        this.numPics = 0;
        this.isAlive = true;
        this.battery = 300;
        this.memory = 20;
        this.homeX = 0;
        this.homeY = 0;
    }
    
    /**
     * constructs a rover
     */
    public Rover()
    {
        this.name = "";
        this.x = 0;
        this.y = 0;
        this.dir = 0;
        this.numPics = 0;
        this.isAlive = true;
        this.battery = 300;
        this.memory = 20;
        this.homeX = 0;
        this.homeY = 0;
    }
    
    /**
     * constructs a rover
     * 
     * @param name (as a string) the rovers name
     * @param x (as an int) the x value of the rover on a coordinate plane
     * @param y (as an int) the y value of the rover on a coordinate plane
     * @param dir (as an int) 
     */
    public Rover(String name, int x, int y, int dir)
    {
        this.name = name;
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.numPics = 0;
        this.isAlive = true;
        this.battery = 300;
        this.memory = 20;
        this.homeX = x;
        this.homeY = y;
    }
    
    // methods - stuff the Rover can do
    
    /**
     * Checks the rover's battery
     * 
     * @param used (as an int) the battery used by an action
     */
    public void checkBattery(int used){
        if (this.battery - used <= 0){
            this.isAlive = false;
        }
    }
    
    /**
     * Charges the battery a given amount
     * 
     * @param used (as an int) the ammount of battery to be recharged
     */
    public void chargeBattery(int used){
        this.battery += used;
        if (this.battery > 300){
            this.battery = 300;
        }
        System.out.println("You have charged the battery");
    }
    
    /**
     * Moves the rover a specified amount of times
     * 
     * @param distance (as an int) ammount of times the rover moves
     */
    public void move(int distance)
    {
        used = 2;
        this.checkBattery(used);
        if (this.isAlive){
            if (dir == 0)
            {
                y += distance;
            }
            else if (dir == 1)
            {
                x += distance;
                y += distance;
            }
            else if (dir == 2)
            {
                x += distance;
            }
            else if (dir == 3)
            {
                x += distance;
                y -= distance;
            }
            else if (dir == 4)
            {
                y -= distance;
            }
            else if (dir == 5)
            {
                y -= distance;
                x -= distance;
            }
            else  if (dir == 6)
            {
                x -= distance;
            }
            else{
                x -= distance;
                y += distance;
            }
            
            System.out.println(name + " moved in direction " + dir);
            this.battery -= used*distance;
        }else{
            System.out.println("Error");
        }
    }
    
    /**
     * Teleports the rover to a given x and y value
     * 
     * @param tox (as an int) the x value the rover will be teleported to
     * @param toy (as an int) the y value the rover will be teleported to
     */
    public void teleport(int tox, int toy){
        used = 5;
        this.checkBattery(used);
        if (this.isAlive){
            this.x = tox;
            this.y = toy;
            System.out.println(name + " has teleported to [" + this.x + "," +this.y + "]");
            this.battery -= used;
        }else{
            System.out.println("Error");
        }
    }
    
    /**
     * Moves the rover to a given x and y value
     * 
     * @param tox (as an int) the x value the rover will move to
     * @param toy (as an int) the y value the rover will move to
     */
    public void moveTo(int tox, int toy){
        if ((tox - this.x) > 0){
            this.rotateTo(2);
            while(this.x< tox){
                this.move(1);
            }
        }else if ((tox - this.x) < 0){
            this.rotateTo(6);
            while(this.x> tox){
                this.move(1);
            }
        }
        if ((toy - this.y) > 0){
            this.rotateTo(0);
            while(this.y< toy){
                this.move(1);
            }
        }else  if ((toy - this.y) < 0){
            this.rotateTo(4);
            while(this.y> toy){
                this.move(1);
            }
        }
    }
    
    /**
     * Moves the rover to the coordinates it was spawned at
     */
    public void goHome(){
        this.moveTo(this.homeX, this.homeY);
        System.out.println(name + " has gone home");        
    }
    
    /**
     * Returns the x value of the rover
     */
    public int checkX()
    {
        return this.x;
    }
    
    /**
     * Returns the y value of the rover
     */
    public int checkY()
    {
        return this.y;
    }
    
    /**
     * Prints the name of the direction the rover is facing
     */
    public void getDirectionName(){
        if (this.dir == 0){
            System.out.println(this.name + " is facing North");
        }else if (this.dir == 1){
            System.out.println(this.name + " is facing North-East");
        }else if (this.dir == 2){
            System.out.println(this.name + " is facing East");
        }else if (this.dir == 3){
            System.out.println(this.name + " is facing South-East");
        }else if (this.dir == 4){
            System.out.println(this.name + " is facing South");
        }else if (this.dir == 5){
            System.out.println(this.name + " is facing South-West");
        }else if (this.dir == 6){
            System.out.println(this.name + " is facing West");
        }else{
            System.out.println(this.name + " is facing North-West");
        }
    }
    
    /**
     * Rotates the rover an  input amount of times
     * 
     * @param rotates (as an int) number of times rotated 90 degrees
     * 
     * Positive numbers rotate to the right 
     * Negitive numbers rotate to the left
     */
    public void rotate(int rotate) 
    {
        used = 5;
        this.checkBattery(used);
        if (this.isAlive){
            int workingDir = this.dir + rotate;
            if (workingDir > 7){
                this.dir = workingDir%8;
            }else if (workingDir < 0){
                int workingDir2 =java.lang.Math.abs(workingDir)%8;
                this.dir = 8 - workingDir2;
            }else{
                this.dir = workingDir;
            }
        }else{
            System.out.println("Error");
        }
    }
    
    /**
     * Rotates the rover to a given direction
     * 
     * @param toDir (as an int) the direction value the rover will rotate to
     */
    public void rotateTo(int toDir){
        used = 5;
        this.checkBattery(used);
        if (this.isAlive){
            this.dir = toDir;
            System.out.println(name + " is now facing direction " + dir);
            this.battery -= used;
        }else{
            System.out.println("Error");
        }
    }
    
    /**
     * Renames the rover
     * 
     * @param name (as a string) the new name of the rover
     */
    public void setName(String name){
        this.name = name;
    }
    
    /**
     * Has one rover kill another
     * 
     * @param other (as a rover) the rover that will be killed
     */
    public void kill(Rover other){
        used = 20;
        this.checkBattery(used);
        if (this.isAlive){
            System.out.println(this.name + " kills " + other.name + ".");
            other.isAlive = false;
            this.battery -= used;
        }else{
            System.out.println("Error");
        }
    }
    
    /**
     * Takes a "picture" (just the coords of where the rover is 
     */
    public void takePic(){
        used = 10;
        this.checkBattery(used);
        if (this.isAlive && numPics < memory){
            this.numPics += 1;
            System.out.println(this.name + " took a picture facing direction " + this.dir + " at [" + this.x + "," + this.y + "]");
            this.battery -= used;
        }else{
            System.out.println("Error");
        }
    }
    
    /**
     * Clears the rovers picture memory
     */
    public void transmitPictures(){
        used = 5;
        this.checkBattery(used);
        if (this.isAlive){
            this.numPics = 0;
            System.out.println("You have transfrerd all your pictures");
            this.battery -= used;
        }else{
            System.out.println("Error");
        }
    }
    
    /**
     * Returs the name of the rover
     */
    public String getName() {
        return name;
    }
    
    /**
     * Returns relevent data about the rover including its coords, the direction it is facing, its photo memory, and its battery remaining
     */
    public String toString() 
    {
        return "Rover[name=" + name + ", x=" + x + ", y=" + y + ", dir=" + dir + ", pictures= " + numPics + ", battery = " + battery +"]";
    }
}

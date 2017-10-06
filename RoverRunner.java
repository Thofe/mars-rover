
/**
 * Write a description of class RoverRunner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RoverRunner
{
    public static void main(String[] arrrggggggs)
    {
        // Make a SimpleScanner
        SimpleScanner input = new SimpleScanner();
        
        Rover r1 = new Rover("Curiosity");
        Rover r2 = new Rover("Spirit");
        Rover r3 = new Rover("");
        // Make a RoverGroup and add Rovers
        RoverGroup group = new RoverGroup();
        group.add(r1);
        group.add(r2);
        group.add(r3);
        
        boolean running = true;
        String exitCommand = "quit";
        
        while (running) {
            // Input name
            System.out.print("Enter the name of the Rover to act: ");
            String name = input.readString();
            
            // Select Rover with matching name
            Rover actor = group.find(name);
            
            if (actor != null) {
                // If the rover is found
                System.out.print("Enter a command: ");
                String command = input.readString();
                
                if (command.equals("move")) {
                    System.out.print("Enter distance to move: ");
                    int distance = input.readInt();
                    actor.move(distance);
                }
                else if (command.equals("rotate")) {
                    System.out.print("Enter number of rotations: ");
                    int number = input.readInt();
                    actor.rotate(number);
                }
                else if (command.equals("kill")) {
                    System.out.print("Enter the name the target rover: ");
                    String targetName = input.readString();
                    
                    Rover target = group.find(targetName);
                    
                    if (target != null) {
                        actor.kill(target);
                        System.out.println(target);
                    }
                    else {
                        System.out.println("Error: No such target.");
                    }
                }
                else if (command.equals("charge")){
                    System.out.println("Enter the ammount to charge:");
                    int ammount = input.readInt();
                    actor.chargeBattery(ammount);
                }
                else if (command.equals("teleport")){
                    System.out.println("Enter the \"x\" value to teleport to:");
                    int xtele = input.readInt();
                    System.out.println("Enter the \"y\" value to teleport to:");
                    int ytele = input.readInt();
                    actor.teleport(xtele, ytele);
                }
                else if (command.equals("move to")){
                    System.out.println("Enter the \"x\" value to move to:");
                    int xmove = input.readInt();
                    System.out.println("Enter the \"y\" value to move to:");
                    int ymove = input.readInt();
                    actor.moveTo(xmove, ymove);
                }
                else if (command.equals("go home")){
                    actor.goHome();
                }
                else if (command.equals("direction name")){
                    actor.getDirectionName();
                }
                else if (command.equals("rotate to")){
                    System.out.println("Enter direction to rotate to:");
                    int rotateto = input.readInt();
                    actor.rotateTo(rotateto);
                }
                else if (command.equals("set name")){
                    System.out.println("Enter the new name of the rover:");
                    String newname = input.readString();
                    actor.setName(newname);
                }
                else if (command.equals("take picture")){
                    actor.takePic();
                }
                else if (command.equals("transmit pictures")){
                    actor.transmitPictures();
                }
                else {
                    System.out.println("Error: Invalid command.");
                }
                
                System.out.println(actor);
            }
            else if (name.equals(exitCommand)) {
                running = false; // set flag to exit loop
            }
            else {
                System.out.println("Error: " + name + " doesn't exist.");
            }
            
            // just a blank line
            System.out.println();
        }
        
        System.out.println("Goodbye.");
    }
}

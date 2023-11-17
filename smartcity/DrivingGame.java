package smartcity;

import java.util.ArrayList;

public class DrivingGame {
    private Map map = null;
    ArrayList<Vehicle> vehicles = null;
    public DrivingGame(int junctions, int vehicles){
        map = new Map(junctions);
        this.vehicles = new ArrayList<Vehicle>();
        for(int i=0;i<vehicles;i++)
            this.vehicles.add(new Vehicle(map));

    }

    public void play(int turns){
        for(int i=0;i<turns;i++){
            System.out.println(String.format("\nTurn %d", i+1));
            for(int j =0;j<vehicles.size();j++){
                vehicles.get(j).move();
            }
            map.checkLights();
        }
    }
}
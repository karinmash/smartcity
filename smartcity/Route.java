package smartcity;

import java.util.ArrayList;

public class Route {
    private ArrayList<Road> random_route = null;
    public Route(ArrayList<Road>route){
        random_route = route;
    }

    public Road getRoad(int index){
        return random_route.get(index);
    }

    public double getLength(){
        double sum = 0;
        for(int i=0;i<random_route.size();i++){
            sum += random_route.get(i).getLength();
        }
        return sum;
    }
    public int num_of_roads(){
        return random_route.size();
    }

    @Override
    public String toString() {
        return this.random_route.toString();
    }
}
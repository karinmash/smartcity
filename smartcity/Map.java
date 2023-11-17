package smartcity;

import java.util.*;

public class Map {
    private ArrayList<Junction> junctions= null;
    private ArrayList<Road> roads= null;


    public Map(int wanted_junctions){
        build_junctions(wanted_junctions);
        build_roads(wanted_junctions);
        build_trafficLights(wanted_junctions);

    }
    public Map(ArrayList<Junction> junctions,ArrayList<Road>roads){
        this.junctions = junctions;
        this.roads = roads;
        build_trafficLights(junctions.size());
    }

    private void build_junctions(int wanted_junctions){
        junctions = new ArrayList<Junction>();
        for(int i=0;i<wanted_junctions;i++)
            junctions.add(new Junction());
    }
    private void build_roads(int wanted_roads){
        Random  random =  new Random();
        roads = new ArrayList<Road>();
        boolean found = false;
        for(int i=0;i<wanted_roads;i++)
        {
            found = false;
            for(int j=0;j<wanted_roads;j++){
                if(random.nextBoolean() && i!=j){
                    found = true;
                    roads.add(new Road(junctions.get(i), junctions.get(j)));
                }
            }
            //TODO if we did not happen to create a road for this junction, we want to force once
            if(!found){
                //debugging
                System.out.println(String.format("no created from index %d", i));
            }
        }
    }
    private void build_trafficLights(int num_of_junctions){

        Random r = new Random();
        int low = 1;
        int high = 5;

        Random  random =  new Random();
        for(int i=0;i<junctions.size();i++){
            int result = r.nextInt(high-low) + low;
            //TODO, is this the 0.25 probability that is needed?
            if(result != 4)
                continue;
            if(junctions.get(i).getEnteringRoads().size() ==0)
                continue;
            if(random.nextBoolean())
                junctions.get(i).setLight(new RandomTrafficLight(junctions.get(i)));
            else
                junctions.get(i).setLight(new ConsecutiveTrafficLight(junctions.get(i)));
        }


    }
    public Route createRoute(){
        //TODO, by shuffling juntions. i am creating new roads. is this allowed?
        int route_length =1;
        ArrayList<Road> random_route = new ArrayList<Road>();
        Integer[] array = new Integer[junctions.size()];
        for(int i=0;i<junctions.size();i++)
            array[i] = i;
        List<Integer> l = Arrays.asList(array);
        Collections.shuffle(l);

        random_route.add(new Road(junctions.get(l.get(0)), junctions.get(l.get(1))));
        for(int i=1;i<junctions.size()-1;i++){
            if(route_length>=4 || junctions.get(l.get(i)).getExitingRoads().size() ==0)
                break;
            route_length++;
            random_route.add(new Road(junctions.get(l.get(i)), junctions.get(l.get(i+1))));
        }
        return new Route(random_route);
    }

    public ArrayList<Road> getRoads() {
		return roads;
	}
	public void setRoads(ArrayList<Road> roads) {
		this.roads = roads;
	}
	public ArrayList<Junction> getJunctions() {
		return junctions;
	}
	public void setJunctions(ArrayList<Junction> junctions) {
		this.junctions = junctions;
	}
	public void checkLights(){
        for(int i=0;i<junctions.size();i++){
            //not all junctions have lights
            if(junctions.get(i).getLight()!=null)
                junctions.get(i).getLight().check();
        }

    }
	public char[] calcShortestPath(Junction junction, Junction junction2) {
		// TODO Auto-generated method stub
		return null;
	}
}

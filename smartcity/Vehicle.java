package smartcity;

public class Vehicle {
    int speed =0;
    private Route random_route = null;
    static int total_created = 0;
    private int id;
    private int curr_road = 0;
    private double passed_length = 0;
    public Vehicle(Map map){
        speed = (int)(Math.random() * (120 - 65 ) + 65);
        random_route = map.createRoute();
        id = ++total_created;

        System.out.println("Createing " + this.toString() + " ");
    }
    public void move(){
        if(curr_road>=random_route.num_of_roads()) {
            System.out.println(String.format("Vehicle %d arrived to its destination: ", id) + " " + random_route.getRoad(curr_road-1).getEnd());
            return;
        }
        System.out.println(String.format("Vehicle %d is moving on the ", id) + random_route.getRoad(curr_road));
        passed_length+=speed;
        if (passed_length >=random_route.getRoad(curr_road).getLength() ) {
            curr_road++;
            passed_length = 0;
        }


    }

    @Override
    public String toString() {
        return String.format("Vehicle %d, speed: %d, path: ", id, speed) + random_route;
    }
}
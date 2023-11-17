package smartcity;

import java.util.Random;

public abstract class TrafficLight {
    /**TODO a variable to hold the road that has the green light */
    protected Road curr_green_road = null;
    private int delay;
    protected  Junction m_junction;
    private Random random = new Random();
    int turns = 0;

    public TrafficLight(Junction j){
        delay = (int)(Math.random() * (2) + 2);
        m_junction = j;
        setCurr_green_road();
        System.out.println(this);
    }

    public void check(){
        if(++turns >= delay){
            turns = 0;
            this.setCurr_green_road();
            System.out.println(this);
        }

    }

    public int getDelay() {
        return delay;
    }
    public Road getCurrentGreen(){
        return curr_green_road;
    }

    protected abstract void setCurr_green_road();

    @Override
    public String toString() {
        return "TrafficLights " + m_junction + String.format(" , delay= %d: green light on ", this.delay) + curr_green_road;
    }
}
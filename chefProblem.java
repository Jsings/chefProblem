//John Singer
//101044375
//01/25/20
public class chefProblem extends Thread{
	public static void main(String[] args) {

		// TODO Auto-generated method stub
		Thread agent, PBchef,Jchef,Bchef;
        table table;
		 
		  
        table = new table(); // shared by producer and consumer

        // Create the producer and consumer threads, passing each thread
        // a reference to the shared BoundedBuffer object.
        agent = new Thread(new Agent(table),"Agent");
        PBchef = new Thread(new chef(table),"Peanut Butter Chef");
        Jchef = new Thread(new chef3(table),"Jam Chef");
        Bchef = new Thread(new chef2(table),"Bread Chef");
        agent.start();
        Jchef.start();
        PBchef.start();
        Bchef.start();

	}

}

//John Singer
//101044375
//01/25/20
public class chef2 implements Runnable {
	private table table;
	boolean ready=false;
	String[] get = new String[2];
    public chef2(table table)
    {
        this.table = table;
    }
    
    public synchronized  void run()
    {
    	while(true) {
    	   get =table.chef2Get();
    	   System.out.println(Thread.currentThread().getName() + " took " + get[0] +" and "+get[1]+" and made a sandwich");
           try {
               Thread.sleep(1000); // change to 100 to see difference
           } catch (InterruptedException e) {}
           
           }
    }
}



//John Singer
//101044375
//01/25/20
import java.util.Random;

public class Agent implements Runnable {
	
	String[] ingredients =new String[] {"Peanut Butter","Jam","Bread"};//ingredients the agent has to offer
	String[] chosenIngredients = new String[2]; // ingredients that will be put on table
	
	private table table;

    public Agent(table table)
    {
        this.table = table;
    }
    
    private void selectIngredients() {//method for agent to choose ingredients to put on table
    	Random rand = new Random(); 
    	int ingredient = rand.nextInt(3);//random number from 1-3 to chose ingredients in the array
    	if(ingredient==3) {//to index the string array 3rd option is actually at index 0 (0,1,2)
    		ingredient=0;
    	}
    	chosenIngredients[0]= ingredients[ingredient];//first ingredient
    	int ingredient2 = rand.nextInt(3);
    	if(ingredient==3) {//to index the string array 3rd option is actually at index 0 (0,1,2)
    		ingredient=0;
    	}
    	while(ingredient==ingredient2) {
    		ingredient2 = rand.nextInt(3);
    		if(ingredient==3) {//to index the string array 3rd option is actually at index 0 (0,1,2)
        		ingredient=0;
        	}
    	}
    	chosenIngredients[1]= ingredients[ingredient2];//second ingredient
    }
    public void run()
    {
    	for(int j = 1; j<=20;j++){//run 20 times
            selectIngredients();
            table.put(chosenIngredients[0],chosenIngredients[1]);
            System.out.println(Thread.currentThread().getName() + " put " + chosenIngredients[0]+" and "+chosenIngredients[1]+" on the table.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
    }
    }
}

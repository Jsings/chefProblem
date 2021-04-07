//John Singer
//101044375
//01/25/20
public class table {
	
	private String[] food = new String[2];//array to hold the ingredients on table
	private boolean empty = true;//whether table is empty or not
	private boolean Chef1,Chef2,Chef3=false;//if true the chef is suppose to take ingredients from table
	
	public synchronized void put(String item,String item2) {//put ingredients on table
        while (!empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                return;
            }
        }
        food[0] = item;
        food[1]= item2;
        empty = false;
        notifyWhen(food[0],food[1]);//notify specific chef to take ingredients
        notifyAll();

    }
	
	public synchronized String[] chef1Get() {//chef 1 takes ingredients
        while (Chef1==false) {
            try {
                wait();
            } catch (InterruptedException e) {
                return null;
            }
        }
        
        String[] item = new String[2];
        item[0]=food[0];
        item[1]=food[1];
        food[0] = null;
        food[1] = null;
        empty = true;
        Chef1 =false;
        notifyAll();
        return item;
    }
	public synchronized String[] chef2Get() {//chef 2 takes ingredients
        while (Chef2==false) {
            try {
                wait();
            } catch (InterruptedException e) {
                return null;
            }
        }
        
        String[] item = new String[2];
        item[0]=food[0];
        item[1]=food[1];
        food[0] = null;
        food[1] = null;
        empty = true;
        Chef2=false;
        notifyAll();
        return item;
    }
	
	public synchronized String[] chef3Get() {//chef 3 takes ingredients
        while (Chef3==false) {
            try {
                wait();
            } catch (InterruptedException e) {
                return null;
            }
        }
        
        String[] item = new String[2];
        item[0]=food[0];
        item[1]=food[1];
        food[0] = null;
        food[1] = null;
        empty = true;
        Chef3=false;
        notifyAll();
        return item;
    }
	
	
	private void notifyWhen(String food1,String food2) {//lets specific chef know it can take ingredients
		if((food1.equals("Bread")||food1.equals("Jam"))&&(food2.equals("Bread")||food2.equals("Jam"))) {
			Chef1=true;
		}
		else if((food1.equals("Peanut Butter")||food1.equals("Jam"))&&(food2.equals("Peanut Butter")||food2.equals("Jam"))) {
			Chef2=true;
		}
		else  {
			Chef3=true;
		}
	}

}

package counterpack;

public class Counter {
    //fields
    private int counterValue;
    //constructor
    /**
     * Function Name:counterpack.Counter.
     * Function Operation: constructor
     * @param counterValue .
     ***/
    public Counter(int counterValue){
        this.counterValue = counterValue;
    }
    /**
     * Function Name:increase.
     * Function Operation:add number to current count.
     * @param number of blocks to add
     ***/
   public void increase(int number){
        this.counterValue += number;
    }
    /**
     * Function Name:decrease.
     * Function Operation:subtract number from current count.
     * @param number of blocks to decrease
     ***/
   public void decrease(int number){
       this.counterValue -= number;
   }
    /**
     * Function Name:getValue.
     * Function Operation:get current count.
     * @return current value
     ***/
   public int getValue(){
       return this.counterValue;
   }
}

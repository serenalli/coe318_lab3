/**
 *
 * @author Serena Alli
 */
package coe318.lab3;
public class Counter {
    int mod, dig;
    Counter lef;
    public Counter(int modulus, Counter left) {
        this.mod = modulus;
        this.lef = left;
        
    }


    /**
     * @return the modulus
     */
    public int getModulus() {
        return this.mod;
    }

    /**
     * Returns the Counter to the left attached to this
     * Counter.  Returns null if there is no Counter
     * to the left.
     * @return the left
     */
    public Counter getLeft() {
        return this.lef;
    }

    /**
     * @return the digit
     */
    public int getDigit() {
        return this.dig;
    }

    /**
     * @param digit the digit to set
     */
    public void setDigit(int digit) {
        this.dig = digit;
    }

    /**
     * Increment this counter.  If it rolls over,
     * its left Counter is also incremented if it
     * exists.
     */
    public void increment() {
        setDigit(this.dig+1);
        if(getDigit()==getModulus())
        {
            this.dig=0;
            if(this.getLeft()!=null)
            {
                this.lef.increment();
            }
            
        }
    
    }

    /** Return the count of this Counter combined
     * with any Counter to its left.
     *
     * @return the count
     */
    public int getCount() {
        if(this.getLeft()!=null)
        {
            return getDigit()+(getModulus())*(this.lef.getCount());
        }
        else
        {
            return getDigit();
        }
    }

    /** Returns a String representation of the Counter's
     * total count (including its left neighbour).
     * @return the String representation
     */
    @Override
    public String toString() {
        //DO NOT MODIFY THIS CODE
        return "" + getCount();
    }

}
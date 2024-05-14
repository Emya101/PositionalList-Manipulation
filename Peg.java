//Emhenya Supreme 
/**
 * The Peg class represents a peg with a specific color.
 */
public class Peg{
    private Colour color;
 /**
     * Constructs a new Peg with the default color.
     */
    public Peg(){}
/**
     * Constructs a new Peg with the specified color.
     *
     * @param color The color of the peg.
     */
    public Peg(Colour color){
        this.color=color;
    }
/**
     * Returns the color of the peg.
     *
     * @return The color of the peg.
     */
    public Colour getColour(){
        return color;
    }
    /**
     * Sets the color of the peg.
     *
     * @param color The new color of the peg.
     */

    public void setColor(Colour color){
        this.color=color;
    }
        /**
     * Checks if this peg is equal to another object.
     *
     * @param obj The object to compare with this peg.
     * @return true if the objects are equal, false otherwise.
     */


    public boolean equals(Object obj){
        if(this==obj){
            return true;
        }

        if(!(obj instanceof Peg)){
            return false;
        }

        Peg other=(Peg) obj;
        return this.color.equals(other.color);
    }

     /**
     * Returns a string representation of the peg.
     *
     * @return A string representation of the peg.
     */
    public String toString(){
       return " "+this.color;
    }
}
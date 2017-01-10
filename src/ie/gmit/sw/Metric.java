package ie.gmit.sw;

import java.util.Map;

/**
 * 
 * @author Dara Starr - G00209787
 * A Class used for calculating the positional stability metric.
 * The Metric class is used to declare the setters and getters
 * for the inDegree, outDegree and and use both to calculate the the Stability
 *
 */
public class Metric {

	private int inDegree;
	private int outDegree;
	private String className;

	/**
	 * Gets the name of the class of the represented metric.
	 * @return
	 * String className
	 */
    public String getClassName() {
        return className;
    }

    /**
     * Sets the name of the class of the represented metric.
     *
     * @param className
     * The name of the class as a String.
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * Gets the indegree for the class.
     *
     * @return
     * inDegree as an int.
     */
	public int getInDegree() {
		return inDegree;
	}
	
	 /**
     * Sets the inDegree for the class.
     *
     * @param inDegree
     * In degree of the class represents the number of classes that
     * depend on this class.
     */
	public void setInDegree(int inDegree) {
		this.inDegree = inDegree;
	}
	
	/**
     * Gets the outDegree for the class.
     *
     * @return
     * outDegree as an int.
     */
	public int getOutDegree() {
		return outDegree;
	}
	
	/**
     * Sets the outDegree for the class.
     *
     * @param outDegree
     * Out degree of the class represents the number of
     * classes this class depends on.
     */
	public void setOutDegree(int outDegree) {
		this.outDegree = outDegree;
	}

	/**
     * Uses the inDegree and outDegree to calculate the stability.
     *
     * @return
     * Positional stability as a double
     */
	public double getStability(){
		double stability = 2f;
		
		if(getOutDegree() > 0)
		{
			stability = ((double)getOutDegree() /( (double)getInDegree() + (double)getOutDegree()));
		}
		else{
			stability = 0f;
		}
		return Math.round(stability * 100d) / 100d;
		//return stability;
	}	
}
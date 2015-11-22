package co.markhoward.pipeline;

/**
 * A processor carries out some processing on an input and returns the processed value
 * @param <Input> The input type
 */
public interface Processor extends Comparable<Processor> {
    /**
     * Process the data
     * @param input The input type
     * @return The processed data
     */
    Object process(Object input);

    /**
     * Returns the index of this processor
     * @return The index
     */
    int getIndex();

    /**
     * Set the index for this processor
     * @param index The index to set
     */
    void setIndex(int index);
    
    /* (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    default int compareTo(Processor processor){
    	if(this.getIndex() < processor.getIndex())
    		return -1;
    	if(this.getIndex() > processor.getIndex())
    		return 1;
		return 0;
    }
}

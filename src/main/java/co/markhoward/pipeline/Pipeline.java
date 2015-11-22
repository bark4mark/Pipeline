package co.markhoward.pipeline;

import java.util.Optional;

/**
 * The pipeline manages how and in what order the processors process the data
 */
public interface Pipeline {
    /**
     * Add a processor, next in the series
     * @param processor The processor to add
     */
    void addProcessor(Processor processor);

    /**
     * Remove a specific processor
     * @param processor The processor to remove
     */
    void removeProcessor(Processor processor);

    /**
     * Remove all processors from the pipeline
     */
    void removeAllProcessors();
    
    /**
     * Get the next index
     * @return The next index
     */
    int getNextIndex();
    
    /**
     * Start the processors in order and get the return value
     * @param value The initial value
     * @param type The return type
     * @return The resulting value, wrapped in an optional
     */
    <Type> Optional<Type> start(Object value, Class<Type> type);
}

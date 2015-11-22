package co.markhoward.pipeline.impl;

import java.util.Iterator;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import co.markhoward.pipeline.Pipeline;
import co.markhoward.pipeline.Processor;

public class DefaultPipeline implements Pipeline{
    private final Set<Processor> processors = new TreeSet<>();
    
    /* (non-Javadoc)
     * @see co.markhoward.pipeline.Pipeline#addProcessor(co.markhoward.pipeline.Processor)
     */
    @Override
    public void addProcessor(Processor processor) {
    	if(processor.getIndex()==0)
    		processor.setIndex(getNextIndex());
        this.processors.add(processor);
    }

    /* (non-Javadoc)
     * @see co.markhoward.pipeline.Pipeline#removeProcessor(co.markhoward.pipeline.Processor)
     */
    @Override
    public void removeProcessor(Processor processor) {
    	this.processors.remove(processor);
    }

    /* (non-Javadoc)
     * @see co.markhoward.pipeline.Pipeline#removeAllProcessors()
     */
    @Override
    public void removeAllProcessors() {
    	this.processors.clear();
    }

    /* (non-Javadoc)
     * @see co.markhoward.pipeline.Pipeline#start(java.lang.Object, java.lang.Class)
     */
    @Override
    public <Type> Optional<Type> start(Object value, Class<Type> type) {
    	if(value == null)
    		return Optional.empty();
    	
    	Iterator<Processor> processorIterator = this.processors.iterator();
    	Object result = value;
    	while(processorIterator.hasNext()){
    		Processor processor = processorIterator.next();
    		result = processor.process(result);
    	}
    	return Optional.of(type.cast(result));
    }

	/* (non-Javadoc)
	 * @see co.markhoward.pipeline.Pipeline#getNextIndex()
	 */
	@Override
	public int getNextIndex() {
		return this.processors.size();
	}
}

package co.markhoward.pipeline;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;

import co.markhoward.pipeline.util.Pipelines;

public class PipelineTest {
	@Test
	public void createAndTestPipeline(){
		Pipeline pipeline = Pipelines.createDefaultPipeline();
		pipeline.addProcessor(new Processor() {
			private int index;
			@Override
			public void setIndex(int index) {
				this.index = index;
			}
			
			@Override
			public Object process(Object input) {
				return (int)input + 1;
			}
			
			@Override
			public int getIndex() {
				return this.index;
			}
		});
		Optional<Integer> result = pipeline.start(1, Integer.class);
		Assert.assertTrue(result.get() == 2);
	}
}

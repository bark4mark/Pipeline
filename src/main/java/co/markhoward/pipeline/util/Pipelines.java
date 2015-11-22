package co.markhoward.pipeline.util;

import co.markhoward.pipeline.Pipeline;
import co.markhoward.pipeline.impl.DefaultPipeline;

/**
 * Created by Mark on 10/22/2015.
 */
public class Pipelines {
    public static Pipeline createDefaultPipeline(){
        return new DefaultPipeline();
    }

}

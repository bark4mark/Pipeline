package co.markhoward.pipeline.impl;

import org.jsoup.nodes.Element;

import co.markhoward.pipeline.Processor;

public class DocumentProcessor implements Processor {
	private int index=0;
	private final Element element;
	
	public DocumentProcessor(Element element) {
		this.element=element;
	}

	@Override
	public Object process(Object value) {
		String selector = (String) value;
		return this.element.select(selector);
	}

	@Override
	public int getIndex() {
		return this.index;
	}

	@Override
	public void setIndex(int index) {
		this.index=index;
	}

}

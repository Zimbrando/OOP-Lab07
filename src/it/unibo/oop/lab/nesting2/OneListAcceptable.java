package it.unibo.oop.lab.nesting2;

import java.util.List;

public class OneListAcceptable<T> implements Acceptable<T>{

	
	private List<T> list;
	private int counter;
	
	public OneListAcceptable(List<T> list) {
		this.list = list;
		this.counter = 0;
	}
	
	@Override
	public Acceptor<T> acceptor() {
		return new Acceptor<T>() {

			@Override
			public void accept(T newElement) throws ElementNotAcceptedException {
				if (list.isEmpty() ||  newElement != list.get(counter)) {
					throw new ElementNotAcceptedException(newElement);
				}
				counter++;
			}

			@Override
			public void end() throws EndNotAcceptedException {
				if(counter < list.size()) {
					throw new EndNotAcceptedException();
				}
				counter = 0;
			}
			
		};
	}

}

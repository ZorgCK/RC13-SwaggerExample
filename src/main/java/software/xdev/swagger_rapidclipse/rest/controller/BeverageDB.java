package software.xdev.swagger_rapidclipse.rest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class BeverageDB {
	
	private static BeverageDB INSTANCE = null;
	
	private final AtomicInteger idCounter = new AtomicInteger(0);
	
	private final List<Beverage> beverages = new ArrayList<>();
	
	public List<Beverage> getAll() {
		return beverages;
	}
	
	public Beverage addBeverage(String beverageName) {
		Beverage beverage = new Beverage(idCounter.incrementAndGet(), beverageName);
		beverages.add(beverage);
		
		return beverage;
	}
	
	public static BeverageDB getInstance() {
		if(INSTANCE == null) {
			INSTANCE =new BeverageDB();
		}
		return INSTANCE;
	}

	public Optional<Beverage> update(Beverage updateDTO) {
		
		final Optional<Beverage> optBeverage = this.beverages
				.stream()
				.filter(bev -> bev.id() == updateDTO.id())
				.findFirst();

		if(optBeverage.isPresent())
		{
			beverages.remove(optBeverage.get());
			final Beverage bev = new Beverage(optBeverage.get().id(), updateDTO.name());
			beverages.add(bev);
			
			return Optional.of(bev);
		}
		return Optional.empty();
	}

	public Optional<Beverage> delete(int beverageId) {
		
		final Optional<Beverage> optBeverage = this.beverages
				.stream()
				.filter(bev -> bev.id() == beverageId)
				.findFirst();

        optBeverage.ifPresent(beverages::remove);
		
		return optBeverage;
	}
}

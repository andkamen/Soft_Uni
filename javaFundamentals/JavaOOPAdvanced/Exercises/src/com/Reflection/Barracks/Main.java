package com.Reflection.Barracks;

import com.Reflection.Barracks.contracts.Repository;
import com.Reflection.Barracks.contracts.Runnable;
import com.Reflection.Barracks.contracts.UnitFactory;
import com.Reflection.Barracks.core.Engine;
import com.Reflection.Barracks.core.factories.UnitFactoryImpl;
import com.Reflection.Barracks.data.UnitRepository;

public class Main {

	public static void main(String[] args) {
		Repository repository = new UnitRepository();
		UnitFactory unitFactory = new UnitFactoryImpl();
		Runnable engine = new Engine(repository, unitFactory);
		engine.run();
	}
}

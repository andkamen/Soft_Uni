package com.Reflection.pr0304Barracks;

import com.Reflection.pr0304Barracks.contracts.Repository;
import com.Reflection.pr0304Barracks.contracts.Runnable;
import com.Reflection.pr0304Barracks.contracts.UnitFactory;
import com.Reflection.pr0304Barracks.core.Engine;
import com.Reflection.pr0304Barracks.core.factories.UnitFactoryImpl;
import com.Reflection.pr0304Barracks.data.UnitRepository;

public class Main {

	public static void main(String[] args) {
		Repository repository = new UnitRepository();
		UnitFactory unitFactory = new UnitFactoryImpl();
		Runnable engine = new Engine(repository, unitFactory);
		engine.run();
	}
}

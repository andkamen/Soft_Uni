package com.Reflection.pr0304Barracks.core.factories;

import com.Reflection.pr0304Barracks.contracts.Unit;
import com.Reflection.pr0304Barracks.contracts.UnitFactory;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"pr0304Barracks.models.units.";

	@Override
	public Unit createUnit(String unitType) {
		// TODO: implement for problem 3
		throw new NotImplementedException();
	}
}

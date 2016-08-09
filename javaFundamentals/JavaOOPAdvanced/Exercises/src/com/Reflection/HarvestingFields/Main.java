package com.Reflection.HarvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		Class<RichSoilLand> richSoilLand = RichSoilLand.class;

		while (true){
			String input = reader.readLine();

			if (input.equals("HARVEST")){
				break;
			}

			Field[] fields = richSoilLand.getDeclaredFields();

			for (Field field : fields) {
				int modifierInt = field.getModifiers();
				String modifier = Modifier.toString(modifierInt);

				if (!modifier.equals(input) && !input.equals("all")){
					continue;
				}

				System.out.printf("%s %s %s%n",modifier, field.getType().getSimpleName(), field.getName());
			}

		}

	}
}

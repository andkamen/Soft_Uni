package com.Generics.CustomList;

import com.Generics.CustomList.models.BubbleSort;
import com.Generics.CustomList.models.CustomList;
import com.Generics.CustomList.models.Sorter;

public class CommandParser {

    private CustomList<String> list;


    public CommandParser() {
        this.list = new CustomList<>();
    }

    public void execute(String[] params) {
        String command = params[0];
        String element;

        switch (command) {
            case "Add":
                element = params[1];
                this.list.add(element);
                break;
            case "Remove":
                int index = Integer.parseInt(params[1]);
                this.list.remove(index);
                break;
            case "Contains":
                element = params[1];
                System.out.println(this.list.contains(element));
                break;
            case "Swap":
                int firstIndex = Integer.parseInt(params[1]);
                int secondIndex = Integer.parseInt(params[2]);
                this.list.swapElements(firstIndex, secondIndex);
                break;
            case "Greater":
                element = params[1];
                System.out.println(this.list.countGreaterThan(element));
                break;
            case "Max":
                System.out.println(this.list.getMax());
                break;
            case "Min":
                System.out.println(this.list.getMin());
                break;
            case "Print":
                for (String str : list) {
                    System.out.println(str);
                }
                break;
            case "Sort":
                this.list.sort();
                break;
            default:
                break;
        }
    }
}

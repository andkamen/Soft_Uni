package com.commands;

import com.commands.contracts.Command;
import com.core.contracts.RecyclingStation;

public abstract class BaseCommand implements Command {

    private RecyclingStation recyclingStation;

    public BaseCommand(RecyclingStation recyclingStation) {
        this.setRecyclingStation(recyclingStation);
    }

    protected RecyclingStation getRecyclingStation() {
        return this.recyclingStation;
    }

    protected void setRecyclingStation(RecyclingStation recyclingStation) {
        this.recyclingStation = recyclingStation;
    }

    @Override
    public abstract String execute();
}

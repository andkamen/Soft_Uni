package commands;

import core.contracts.RecyclingStation;

public class StatusCommand extends BaseCommand {
    public StatusCommand(RecyclingStation recyclingStation) {
        super(recyclingStation);
    }

    @Override
    public String execute() {
        String status = getRecyclingStation().toString();
        return status;
    }
}

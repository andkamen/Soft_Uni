package core.contracts;

import wasteDisposal.Contracts.ProcessingData;

public interface RecyclingStation extends ProcessingData{

    void processGarbage(ProcessingData processingData);

}

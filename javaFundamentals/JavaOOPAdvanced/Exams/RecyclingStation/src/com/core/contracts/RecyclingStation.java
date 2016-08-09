package com.core.contracts;

import com.wasteDisposal.Contracts.ProcessingData;

public interface RecyclingStation extends ProcessingData{

    void processGarbage(ProcessingData processingData);

    void changeManagementRequirement(ManagementRequirement managementRequirement);

    ManagementRequirement getManagementRequirement();
}

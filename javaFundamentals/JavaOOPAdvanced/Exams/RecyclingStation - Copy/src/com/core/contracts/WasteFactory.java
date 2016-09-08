package com.core.contracts;

import com.wasteDisposal.Contracts.Waste;

public interface WasteFactory {

    Waste createWaste(String[] arguments);
}

package test.frameworkTest;

import com.wasteDisposal.Annotations.Burnable;
import com.wasteDisposal.Annotations.Recyclable;
import com.wasteDisposal.Annotations.Storable;
import com.wasteDisposal.Contracts.GarbageProcessor;
import com.wasteDisposal.Contracts.ProcessingData;
import com.wasteDisposal.Contracts.StrategyHolder;
import com.wasteDisposal.Contracts.Waste;
import com.wasteDisposal.DefaultGarbageProcessor;
import com.wasteDisposal.DefaultStrategyHolder;
import com.wasteDisposal.Strategies.BurnableStrategy;
import com.wasteDisposal.Strategies.RecyclableStrategy;
import com.wasteDisposal.Strategies.StorableStrategy;
import com.wasteDisposal.models.ProcessedData;
import com.wasteDisposal.models.garbage.RecyclableGarbage;
import com.wasteDisposal.models.garbage.StorableGarbage;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class DefaultGarbageProcessorTests {

    private GarbageProcessor garbageProcessor;
    private StrategyHolder strategyHolder;


    @Before
    public void setUp() {
        this.strategyHolder = new DefaultStrategyHolder();
        this.strategyHolder.addStrategy(Burnable.class, new BurnableStrategy());
        this.strategyHolder.addStrategy(Recyclable.class, new RecyclableStrategy());

        this.garbageProcessor = new DefaultGarbageProcessor(this.strategyHolder);
    }

    @Test
    public void emptyCtorHasDefaultHolder() {
        boolean actualStrategyHolderIsEmpty = true;

        this.garbageProcessor = new DefaultGarbageProcessor();
        boolean expectedStrategyHolderIsEmpty = this.garbageProcessor.getStrategyHolder().getDisposalStrategies().isEmpty();

        assertEquals(actualStrategyHolderIsEmpty, expectedStrategyHolderIsEmpty);
    }

    @Test
    public void ctorWithFullHolderHasCorrectAmountOfStrategies() {
        int expectedStrategiesCount = 2;
        int actualStrategiesCount = this.garbageProcessor.getStrategyHolder().getDisposalStrategies().size();

        assertEquals(expectedStrategiesCount, actualStrategiesCount);
    }


    @Test
    public void testProcessWasteProcessesWasteCorrectly() {
        Waste garbage = new RecyclableGarbage("Glass", 10, 1.14);
        ProcessingData expectedProcessedData = new ProcessedData(-5.7, 4000);
        ProcessingData actualProcessedData = this.garbageProcessor.processWaste(garbage);
        double epsilon = 0.00001;

        assertEquals(expectedProcessedData.getCapitalBalance(), actualProcessedData.getCapitalBalance(), epsilon);
        assertEquals(expectedProcessedData.getEnergyBalance(), actualProcessedData.getEnergyBalance(), epsilon);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testProcessWasteWithMissingStrategyThrows() {
        Waste garbage = new StorableGarbage("Store", 10, 1.14);
        ProcessingData actualProcessedData = this.garbageProcessor.processWaste(garbage);
    }


}

package test.frameworkTest;

import com.wasteDisposal.Annotations.Burnable;
import com.wasteDisposal.Annotations.Recyclable;
import com.wasteDisposal.Contracts.GarbageDisposalStrategy;
import com.wasteDisposal.Contracts.StrategyHolder;
import com.wasteDisposal.DefaultStrategyHolder;

import static org.junit.Assert.*;

import com.wasteDisposal.Strategies.BurnableStrategy;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

public class DefaultStrategyHolderTests {

    private StrategyHolder strategyHolder;

    @Before
    public void setUp() {
        this.strategyHolder = new DefaultStrategyHolder();
    }

    @Test
    public void testCtor() {
        int expectedStrategiesMapSize = 0;
        this.strategyHolder = new DefaultStrategyHolder();
        int actualStrategiesMapSize = strategyHolder.getDisposalStrategies().size();

        assertEquals(expectedStrategiesMapSize, actualStrategiesMapSize);
    }

    @Test
    public void testGetDisposalStrategies() {
        Map<Class, GarbageDisposalStrategy> strategies;
        strategies = this.strategyHolder.getDisposalStrategies();

        int expectedStrategiesMapSize = 0;
        int actualStrategiesMapSize = strategies.size();

        assertEquals(expectedStrategiesMapSize, actualStrategiesMapSize);
    }

    @Test
    public void testAddDisposalStrategyAddingAStrategyReturnsTrue() {
        boolean expectedStrategiesAdded = true;
        boolean actualStrategyAdded = this.strategyHolder.addStrategy(Burnable.class, new BurnableStrategy());

        assertEquals(expectedStrategiesAdded, actualStrategyAdded);
    }

    @Test
    public void testAddingDuplicateStrategyReturnsFalse() {
        boolean expectedStrategiesAdded = false;
        this.strategyHolder.addStrategy(Burnable.class, new BurnableStrategy());
        boolean actualStrategyAdded = this.strategyHolder.addStrategy(Burnable.class, new BurnableStrategy());

        assertEquals(expectedStrategiesAdded, actualStrategyAdded);
    }

    @Test
    public void testAddDisposalStrategyAddsCorrectStrategy() {
        GarbageDisposalStrategy strategy = new BurnableStrategy();

        this.strategyHolder.addStrategy(Burnable.class, strategy);

        GarbageDisposalStrategy expectedStrategy = this.strategyHolder.getDisposalStrategies().get(Burnable.class);

        assertEquals(strategy, expectedStrategy);
    }

    @Test
    public void testRemoveExistingStrategyReturnsTrue() {
        boolean expectedRemovedStrategy = true;
        this.strategyHolder.addStrategy(Burnable.class, new BurnableStrategy());

        boolean actualRemovedStrategy = this.strategyHolder.removeStrategy(Burnable.class);

        assertEquals(expectedRemovedStrategy, actualRemovedStrategy);
    }

    @Test
    public void testRemoveNonExistingStrategyReturnsFalse() {
        boolean expectedRemovedStrategy = false;
        this.strategyHolder.addStrategy(Burnable.class, new BurnableStrategy());

        boolean actualRemovedStrategy = this.strategyHolder.removeStrategy(Recyclable.class);

        assertEquals(expectedRemovedStrategy, actualRemovedStrategy);
    }


}

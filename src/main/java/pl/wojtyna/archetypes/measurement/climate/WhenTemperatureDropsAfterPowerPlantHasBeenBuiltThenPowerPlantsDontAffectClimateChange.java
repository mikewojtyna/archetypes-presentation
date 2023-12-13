package pl.wojtyna.archetypes.measurement.climate;

import pl.wojtyna.archetypes.measurement.core.FalsificationRules;
import pl.wojtyna.common.DomainEvents;

public class WhenTemperatureDropsAfterPowerPlantHasBeenBuiltThenPowerPlantsDontAffectClimateChange implements FalsificationRules {

    @Override
    public boolean isFalsifiedBy(DomainEvents facts) {
        var events = facts.stream().toList();
        var temperatureDroppedIndex = events.stream().filter(TemperatureDropped.class::isInstance)
                                            .map(events::indexOf).findAny()
                                            .orElse(-1);
        var coalPlantBuiltIndex = events.stream().filter(CoalPlantBuilt.class::isInstance)
                                        .map(events::indexOf).findAny()
                                        .orElse(-1);
        return temperatureDroppedIndex > coalPlantBuiltIndex;
    }
}

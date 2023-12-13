package pl.wojtyna.archetypes.measurement.climate;

import pl.wojtyna.archetypes.measurement.core.ConfirmationRules;
import pl.wojtyna.common.DomainEvent;
import pl.wojtyna.common.DomainEvents;

import java.util.List;

public class WhenTemperatureRisesAfterPowerPlantHasBeenBuiltThenPowerPlantsAffectClimateChange implements ConfirmationRules {

    @Override
    public boolean isConfirmedBy(DomainEvents facts) {
        var events = facts.stream().toList();
        var temperatureRoseIndex = events.stream().filter(TemperatureRose.class::isInstance)
                                         .map(events::indexOf).findAny()
                                         .orElse(-1);
        var coalPlantBuiltIndex = events.stream().filter(CoalPlantBuilt.class::isInstance)
                                        .map(events::indexOf).findAny()
                                        .orElse(-1);
        return temperatureRoseIndex > coalPlantBuiltIndex;
    }
}

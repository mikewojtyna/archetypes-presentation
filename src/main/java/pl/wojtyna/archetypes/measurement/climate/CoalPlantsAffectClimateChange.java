package pl.wojtyna.archetypes.measurement.climate;

import pl.wojtyna.archetypes.measurement.core.ConfirmationRules;
import pl.wojtyna.archetypes.measurement.core.FalsificationRules;
import pl.wojtyna.archetypes.measurement.core.Hypothesis;

public class CoalPlantsAffectClimateChange extends Hypothesis {

    public CoalPlantsAffectClimateChange() {
        super(new WhenTemperatureRisesAfterPowerPlantHasBeenBuiltThenPowerPlantsAffectClimateChange(),
              new WhenTemperatureDropsAfterPowerPlantHasBeenBuiltThenPowerPlantsDontAffectClimateChange());
    }
}

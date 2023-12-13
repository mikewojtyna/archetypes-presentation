package pl.wojtyna.archetypes.measurement.core;

public interface Hypotheses {

    Hypothesis formNewHypothesis(ConfirmationRules confirmationRules, FalsificationRules falsificationRules);
}

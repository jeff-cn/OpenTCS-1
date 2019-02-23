package org.opentcs.util;

import org.opentcs.util.persistence.binding.PlantModelTO;
import org.opentcs.util.persistence.models.Model;

public final class PlantModelConverter {

	private PlantModelConverter() {

	}
	public static final PlantModelTO convertModelToPlantModelTO(final Model model) {
		final PlantModelTO plantModelTo = new PlantModelTO();
		plantModelTo.setVersion(model.getVersion());
		return plantModelTo;
	}

	public static final Model convertPlantModelTOtoDbModel(final PlantModelTO plantModelTo) {
		Model model = new Model();
		model.setVersion(plantModelTo.getVersion());
		return model;
	}
}

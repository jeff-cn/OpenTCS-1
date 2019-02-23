package org.opentcs.util;

import java.util.List;
import org.opentcs.util.persistence.binding.PlantModelTO;
import org.opentcs.util.persistence.models.Block;
import org.opentcs.util.persistence.models.Model;

public final class PlantModelConverter {

	private PlantModelConverter() {

	}
	public static final PlantModelTO convertModelToPlantModelTO(final Model model) {
		final PlantModelTO plantModelTo = new PlantModelTO();
		plantModelTo.setVersion(model.getVersion());
    plantModelTo.setName(model.getName());
    
    List<Block> modelBlocks=model.getBlocks();
    
    
		return plantModelTo;
	}

	public static final Model convertPlantModelTOtoDbModel(final PlantModelTO plantModelTo) {
		Model model = new Model();
		model.setVersion(plantModelTo.getVersion());
    model.setName(plantModelTo.getName());
//    model.setId(plantModelTo.getId());
//    
//    
//    
//    model.setBlocks(blocks);
    
		return model;
	}
}

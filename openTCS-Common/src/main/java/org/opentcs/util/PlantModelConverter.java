package org.opentcs.util;

import java.util.ArrayList;
import java.util.List;
import org.opentcs.util.persistence.binding.*;

import org.opentcs.util.persistence.binding.LocationTypeTO;
import org.opentcs.util.persistence.binding.PlantModelTO;
import org.opentcs.util.persistence.binding.PointTO;
import org.opentcs.util.persistence.binding.PointTO.OutgoingPath;
import org.opentcs.util.persistence.binding.VisualLayoutTO.ModelLayoutElement;
import org.opentcs.util.persistence.models.AllowedOperation;
import org.opentcs.util.persistence.models.Block;
import org.opentcs.util.persistence.models.Location;
import org.opentcs.util.persistence.models.LocationType;
import org.opentcs.util.persistence.models.Member;
import org.opentcs.util.persistence.models.Model;
import org.opentcs.util.persistence.models.Path;
import org.opentcs.util.persistence.models.Point;
import org.opentcs.util.persistence.models.Property;
import org.opentcs.util.persistence.models.Vehicle;
import org.opentcs.util.persistence.models.VisualLayout;

public final class PlantModelConverter {

	private PlantModelConverter() {

	}

	public static final PlantModelTO convertModelToPlantModelTO(final Model model) {
		final PlantModelTO plantModelTo = new PlantModelTO();
		plantModelTo.setVersion(model.getVersion());
		plantModelTo.setName(model.getName());

		final List<Block> modelBlocks = model.getBlocks();
    final List<BlockTO> blockTO =new ArrayList<>();
    for(Block b:modelBlocks){
      blockTO.add(blockTOFromBlock(b));
    }
    final List<PointTO> pointTO=new ArrayList<>();
    final List<Point> point =model.getPoints();
    for(Point p:point){
      pointTO.add(pointTOFronPoint(p));
    }
    final List<LocationTO> locationTO=new ArrayList<>();
    final List<Location> location=model.getLocations();
    for(Location l:location){
    locationTO.add(locationTOFromLocation(l));
    }
    
    final List<LocationTypeTO> locationTypeTO=new ArrayList();
    final List<LocationType> locationType=model.getLocationTypes();
    LocationType  locationtype=new LocationType();
    final List<Property> property=locationtype.getProperties();
    for(LocationType lt:locationType) {
        locationTypeTO.add(locationTypeTOFromLocationType(lt));
    
    }
    	final List<Path> path = model.getPaths();
      final List<PathTO> pathTO=new ArrayList();
      for(Path p:path){
       pathTO.add(pathTOFromPath(p));
      }
    final List<Vehicle> vehicle = model.getVehicles();
    final List<VehicleTO> vehicleTO=new ArrayList();
    for(Vehicle v:vehicle){
        vehicleTO.add(vehicleTOFromVehicle(v));
    }
    final List<VisualLayout> visualLayout=model.getVisualLayouts();
    final List<VisualLayoutTO> visualLayoutTO=new ArrayList();
    for(VisualLayout v:visualLayout){
        visualLayoutTO.add(visualLayoutTOFromVisualLayout(v));
    }
   
    plantModelTo.setBlocks(blockTO);
    plantModelTo.setPoints(pointTO);
    plantModelTo.setPaths(pathTO);
    plantModelTo.setVehicles(vehicleTO);
    plantModelTo.setLocations(locationTO);
    plantModelTo.setLocationTypes(locationTypeTO);
    plantModelTo.setVisualLayouts(visualLayoutTO);
		return plantModelTo;

	}
  private static BlockTO blockTOFromBlock(Block b)
  {
    final List<MemberTO> memberTO=new ArrayList();
    b.getMembers().forEach(member->{
    MemberTO mt=new MemberTO();
    mt.setName(member.getName());
    });
    
    BlockTO blockTO=new BlockTO();
    return blockTO;
  }
  
  private static PointTO pointTOFronPoint(Point p){
  PointTO pointTO=new PointTO();
  pointTO.setxPosition(Long.parseLong(p.getxPosition()));
      pointTO.setyPosition(Long.parseLong(p.getyPosition()));
      pointTO.setzPosition(Long.parseLong(p.getzPosition()));
      pointTO.setVehicleOrientationAngle(Float.parseFloat(p.getVehicleOrientationAngle()));
      pointTO.setType(p.getType());
      final List<PointTO.OutgoingPath> op=new ArrayList<>();
      p.getOutGoingPaths().forEach(op1 ->{
       PointTO.OutgoingPath pointTOOutgoingPath=new PointTO.OutgoingPath();
       pointTOOutgoingPath.setName(op1.getName());
       op.add(pointTOOutgoingPath);
        });
      pointTO.setOutgoingPaths(op);
  return pointTO;
  }
  private static LocationTO locationTOFromLocation(Location l){
    LocationTO locationTO=new LocationTO();
    locationTO.setxPosition(Long.parseLong(l.getxPosition()));
    locationTO.setyPosition(Long.parseLong(l.getyPosition()));
    locationTO.setzPosition(Long.parseLong(l.getzPosition()));
    locationTO.setName(l.getName());
    locationTO.setType(l.getType());
   
    final List <LocationTO.Link> linkTO=new ArrayList();
    l.getLinks().forEach(l1->{
    LocationTO.Link link=new LocationTO.Link();
    link.setPoint(l1.getPoint());
    linkTO.add(link);
    });
    locationTO.setLinks(linkTO);
    return locationTO;
  }
  private static LocationTypeTO locationTypeTOFromLocationType(LocationType locationType){
     LocationTypeTO locationTypeTO=new LocationTypeTO();  
    List<PropertyTO> propertise =new ArrayList();
     locationType.getProperties().forEach(property->{
          PropertyTO pTO=new PropertyTO();
          pTO.setName(property.getName());
          pTO.setValue(property.getValue());
          propertise.add(pTO);
     });
     
      final List<AllowedOperationTO> allowedOperationTO =new ArrayList();
      locationType.getAllowedOperations().forEach(allowedOperation ->{
          AllowedOperationTO operationTO=new AllowedOperationTO();
          operationTO.setName(allowedOperation.getName());
          operationTO.setProperties(propertise);
          allowedOperationTO.add(operationTO);
      });
      locationTypeTO.setAllowedOperations(allowedOperationTO);
      return locationTypeTO;
  }
  
  
  private static PathTO pathTOFromPath(Path path){
            PathTO pathTO=new PathTO();
            pathTO.setName(path.getName());
            pathTO.setSourcePoint(path.getSourcePoint());
            pathTO.setDestinationPoint(path.getDestinationPoint());
            pathTO.setLength(Long.parseLong(path.getLength()));
            pathTO.setRoutingCost(Long.parseLong(path.getRoutingCost()));
            pathTO.setMaxVelocity(Long.parseLong(path.getMaxVelocity()));
            pathTO.setMaxReverseVelocity(Long.parseLong(path.getMaxReverseVelocity()));;
            pathTO.setLocked(path.getLocked());
            return pathTO;
  }
  private static VehicleTO vehicleTOFromVehicle(Vehicle v){
        VehicleTO vehicleTO=new VehicleTO();
        vehicleTO.setName(v.getName());
        vehicleTO.setLength(Long.parseLong(v.getLength()));
        vehicleTO.setEnergyLevelCritical(Long.parseLong(v.getEnergyLevelCritical()));
        vehicleTO.setEnergyLevelGood(Long.parseLong(v.getEnergyLevelGood()));
        vehicleTO.setMaxVelocity(Integer.parseInt(v.getMaxVelocity()));
        vehicleTO.setMaxReverseVelocity(Integer.parseInt(v.getMaxReverseVelocity()));
        vehicleTO.setType(v.getType());
        
        return vehicleTO;
  }
  private static VisualLayoutTO visualLayoutTOFromVisualLayout(VisualLayout v){
    VisualLayoutTO visualLayoutTO=new VisualLayoutTO();
    List<ModelLayoutElement> modelLayoutElement=new ArrayList<>();
    v.getModelLayoutElements().forEach(modellayout->{
          ModelLayoutElement modelLayout=new ModelLayoutElement();
          modelLayout.setVisualizedObjectName(modellayout.getVisualizedObjectName());
          modelLayout.setLayer(Long.parseLong(modellayout.getLayer()));
          List<PropertyTO> propertise =new ArrayList();
          modellayout.getProperties().forEach(property->{
              PropertyTO p=new PropertyTO();
              p.setName(property.getName());
              p.setValue(property.getValue());
              propertise.add(p);
          });
          modelLayout.setProperties(propertise);
          modelLayoutElement.add(modelLayout);
    });
    visualLayoutTO.setScaleX(Float.parseFloat(v.getScaleX()));
    visualLayoutTO.setScaleY(Float.parseFloat(v.getScaleY()));
    visualLayoutTO.setModelLayoutElements(modelLayoutElement);
    return visualLayoutTO;
  }
	public static final Model convertPlantModelTOtoDbModel(final PlantModelTO plantModelTo) {
		final Model model = new Model();
//				model.setId(5);

		model.setVersion(plantModelTo.getVersion());
		model.setName(plantModelTo.getName());

		for (final PointTO pointTO : plantModelTo.getPoints()) {
			model.getPoints().add(pointTOtoPoint(pointTO));
		}

		//Setting Up Blocks
		final List<Block> modelBlocks = new ArrayList<>();
		final List<Member> modelMembers = new ArrayList<>();
		plantModelTo.getBlocks().forEach(blockTO -> {
			final Member member = new Member();
			member.setName(blockTO.getName());
			modelMembers.add(member);
			final Block block = new Block();
			block.setMembers(modelMembers);
			block.setName(blockTO.getName());
			modelBlocks.add(block);
		});
		model.setBlocks(modelBlocks);

		//Setting LocationType
		final List<LocationType> modelLoactionTypes = new ArrayList<>();
		final List<AllowedOperation> allowedOperationsModel = new ArrayList<>();
		final List<Property> propertyListForLocationType = new ArrayList<>();
		final List<LocationTypeTO> plantModelLocationTypeTO = plantModelTo.getLocationTypes();
		plantModelLocationTypeTO.forEach(locationTypeTo -> {
			locationTypeTo.getAllowedOperations().forEach(allowedOperation -> {
				final AllowedOperation allowedOperationForModel = new AllowedOperation();
				//        allowedOperationForModel.setId(Integer.getInteger(allowedOperation.getId().toString()));
				allowedOperationForModel.setName(allowedOperation.getName());
				allowedOperationsModel.add(allowedOperationForModel);
			});
			locationTypeTo.getProperties().forEach(toProperty -> {
				final Property property = new Property();
				property.setName(toProperty.getName());
				property.setValue(toProperty.getValue());
				propertyListForLocationType.add(property);
			});
			final LocationType locationType = new LocationType();
			locationType.setName(locationTypeTo.getName());
			locationType.setAllowedOperations(allowedOperationsModel);
			locationType.setProperties(propertyListForLocationType);
			modelLoactionTypes.add(locationType);
		});
		model.setLocationTypes(modelLoactionTypes);

		return model;
	}

	private static Point pointTOtoPoint(final PointTO pointTo) {
		final Point point = new Point();
		point.setName(pointTo.getName());
		point.setType(pointTo.getType());
		point.setVehicleOrientationAngle(pointTo.getVehicleOrientationAngle().toString());
		point.setxPosition(pointTo.getxPosition().toString() );
		point.setyPosition(pointTo.getyPosition().toString());
		point.setzPosition(pointTo.getzPosition().toString());

		final List<OutgoingPath> outgoingPathsTO = pointTo.getOutgoingPaths();
		for (final OutgoingPath outgoingPathTO : outgoingPathsTO) {
			final org.opentcs.util.persistence.models.OutgoingPath op = new org.opentcs.util.persistence.models.OutgoingPath();
			op.setName(outgoingPathTO.getName());
			point.getOutGoingPaths().add(op);
		}
		return point;

	}
}

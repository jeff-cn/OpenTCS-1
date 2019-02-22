/*
 * Copyright (c) The openTCS Authors.
 *
 * This program is free software and subject to the MIT license. (For details,
 * see the licensing information (LICENSE.txt) you should have received with
 * this copy of the software.)
 */
package org.opentcs.custom.plantoverview;

import java.util.ArrayList;
import java.util.List;
import org.opentcs.access.to.model.BlockCreationTO;
import org.opentcs.access.to.model.GroupCreationTO;
import org.opentcs.access.to.model.LocationCreationTO;
import org.opentcs.access.to.model.LocationTypeCreationTO;
import org.opentcs.access.to.model.PathCreationTO;
import org.opentcs.access.to.model.PlantModelCreationTO;
import org.opentcs.access.to.model.PointCreationTO;
import org.opentcs.access.to.model.VehicleCreationTO;
import org.opentcs.access.to.model.VisualLayoutCreationTO;
import org.opentcs.data.model.Point;
import org.opentcs.data.model.Triple;
import org.opentcs.util.persistence.binding.BlockTO;
import org.opentcs.util.persistence.binding.GroupTO;
import org.opentcs.util.persistence.binding.LocationTO;
import org.opentcs.util.persistence.binding.LocationTypeTO;
import org.opentcs.util.persistence.binding.PathTO;
import org.opentcs.util.persistence.binding.PlantModelTO;
import org.opentcs.util.persistence.binding.PointTO;
import org.opentcs.util.persistence.binding.VehicleTO;
import org.opentcs.util.persistence.binding.VisualLayoutTO;

/**
 *
 * @author shashank singh
 */
public class PlantModelCreationFactory {
  
  private PlantModelCreationFactory(){}
  
  
  private static PlantModelCreationFactory plantModelCreationFactory;
  private static PlantModelTO plantModelCreationTO;
  private List<PointTO> pointCreationTOs;
  private List<PathTO> pathCreationTOs;
  private List<LocationTypeTO> locationTypeCreationTOs;
  private List<LocationTO> locationCreationTOs;
  private List<BlockTO> blockCreationTOs;
  private List<GroupTO> groupCreationTOs;
  private List<VehicleTO> vehicleCreationTOs;
  private List<VisualLayoutTO> visualLayoutCreationTOs;
  
  
  
  
  static {
    plantModelCreationTO = new PlantModelTO();
    plantModelCreationTO.setVersion("0.0.2");
    plantModelCreationTO.setName("CUSTOM");
    PointTO pointTO = new PointTO();
    pointTO.setxPosition(53288L);
    pointTO.setName("Point-0001");
    pointTO.setyPosition(-3893L);
    pointTO.setzPosition(0L);
    pointTO.setVehicleOrientationAngle(Float.NaN);
    pointTO.setType("HALT_POSITION");
    
    List<PointTO.OutgoingPath> opList=new ArrayList<>();
    PointTO.OutgoingPath op1= new PointTO.OutgoingPath();
    PointTO.OutgoingPath op2= new PointTO.OutgoingPath();
    op1.setName("Point-0001 --- Point-0002");
    op2.setName("Point-0001 --- Point-0003");
    
    opList.add(op1);
    opList.add(op2);
    
    pointTO.setOutgoingPaths(opList);
    List<PointTO> pointToList = new ArrayList<>();
    pointToList.add(pointTO);
    plantModelCreationTO.setPoints(pointToList);
  }
  
  
  
  
  public static PlantModelCreationFactory getInstance(){
    if(plantModelCreationFactory==null)
      plantModelCreationFactory = new PlantModelCreationFactory();
    return plantModelCreationFactory;
  }

  public PlantModelTO getPlantModelCreationTO() {
    return plantModelCreationTO;
  }

  
  
  
}

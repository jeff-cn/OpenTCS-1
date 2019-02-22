/**
 * Copyright (c) The openTCS Authors.
 *
 * This program is free software and subject to the MIT license. (For details,
 * see the licensing information (LICENSE.txt) you should have received with
 * this copy of the software.)
 */
package org.opentcs.gradle.plugin.integration.builder;

import java.nio.file.Path;
import org.gradle.api.Project;
import org.gradle.api.logging.Logger;
import org.gradle.api.logging.Logging;
import static org.opentcs.gradle.plugin.integration.Constants.RESOURCE_FOLDER_KERNELCONTROLCENTER;
import org.opentcs.gradle.plugin.integration.util.PluginFileUtils;

/**
 * Builds the kernel control center project.
 *
 * @author Martin Grzenia (Fraunhofer IML)
 */
public class KernelControlCenterProjectBuilder
    extends AbstractProjectBuilder {

  /**
   * This class' logger.
   */
  private static final Logger LOG = Logging.getLogger(KernelControlCenterProjectBuilder.class);

  public KernelControlCenterProjectBuilder(Path outputPath, Project projectBase) {
    super(outputPath, projectBase);
  }

  @Override
  public void build()
      throws Exception {
    PluginFileUtils.copyDirectoryFromProject(getProjectBase(), "src/dist", getOutputPath());
    PluginFileUtils.copyFileFromResources(RESOURCE_FOLDER_KERNELCONTROLCENTER, "build.gradle.tmpl", getOutputPath());
    LOG.quiet("Kernel control center project built at '{}'.", getOutputPath());
  }
}

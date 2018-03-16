package com.equeo.gradle.plugins;

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.publish.maven.plugins.MavenPublishPlugin

class SamplePlugin implements Plugin<Project> {

  @Override
  void apply(Project project) {
    project.tasks.create("sampleTask", SampleTask.class)
  }
}

package com.equeo.heart.gradle.plugins.publishing

import com.equeo.heart.gradle.plugins.publishing.extensions.PublishExtension
import com.equeo.heart.gradle.plugins.publishing.tasks.BuildAndPublishTask
import com.equeo.heart.gradle.plugins.publishing.tasks.CurrentVersionTask
import com.equeo.heart.gradle.plugins.publishing.tasks.SourceJarTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.publish.maven.plugins.MavenPublishPlugin

abstract class SamplePlugin implements Plugin<Project> {

  @Override
  void apply(Project project) {
    project.tasks.create("sampleTask", SampleTask.class)
  }
}

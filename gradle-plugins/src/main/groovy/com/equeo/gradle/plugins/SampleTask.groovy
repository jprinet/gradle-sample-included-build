package com.equeo.heart.gradle.plugins.publishing.tasks

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class SampleTask extends DefaultTask {

  @TaskAction
  def sampleTask() {
    logger.lifecycle("I'm a task!")
  }
}

package com.sample.plugins;

import org.gradle.api.Plugin
import org.gradle.api.Project
import com.gradle.enterprise.gradleplugin.GradleEnterprisePlugin;
import org.gradle.api.initialization.Settings;
import com.gradle.enterprise.gradleplugin.GradleEnterpriseExtension;
import com.gradle.enterprise.gradleplugin.GradleEnterprisePlugin;
import com.gradle.scan.plugin.BuildScanExtension;
import com.gradle.scan.plugin.BuildScanPlugin;
import com.gradle.CommonCustomUserDataGradlePlugin

class SamplePlugin implements Plugin<Settings> {

  @Override
  void apply(Settings settings) {
    settings.getPluginManager().apply(GradleEnterprisePlugin.class);
    configureGradleEnterprise(settings.getExtensions().getByType(GradleEnterpriseExtension.class))

    settings.getPluginManager().apply(CommonCustomUserDataGradlePlugin.class);
  }

  private void configureGradleEnterprise(GradleEnterpriseExtension gradleEnterprise) {
    gradleEnterprise.setServer("http://localhost:5086");
    BuildScanExtension buildScan = gradleEnterprise.getBuildScan();
    buildScan.publishAlways();
    buildScan.capture.taskInputFiles = true
  }
}

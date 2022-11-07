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
import org.gradle.caching.configuration.BuildCacheConfiguration
import org.gradle.caching.http.HttpBuildCache

class SamplePlugin implements Plugin<Settings> {

  @Override
  void apply(Settings settings) {
    settings.getPluginManager().apply(io.invertase.gradle.settings.SettingsPlugin.class)
    settings.getPluginManager().apply(CommonCustomUserDataGradlePlugin.class);
    settings.getPluginManager().apply(GradleEnterprisePlugin.class);
    configureGradleEnterprise(settings.getExtensions().getByType(GradleEnterpriseExtension.class))
    configureBuildCache(settings.getBuildCache())
  }

  private void configureGradleEnterprise(GradleEnterpriseExtension gradleEnterprise) {
    gradleEnterprise.setServer("http://localhost:5086");
    BuildScanExtension buildScan = gradleEnterprise.getBuildScan();
    buildScan.publishAlways();
    buildScan.capture.taskInputFiles = true
  }

  private void configureBuildCache(BuildCacheConfiguration buildCache) {
    buildCache.local(local -> {
      local.setEnabled(false);
    });
    buildCache.remote(HttpBuildCache.class, remote -> {
      remote.setUrl("http://localhost:5086/cache/")
      remote.setAllowUntrustedServer(true)
      remote.allowInsecureProtocol(true)
      remote.setEnabled(true)
      remote.setPush(true)
    });
  }
}

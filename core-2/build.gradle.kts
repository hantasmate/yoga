plugins {
  id("com.hantasmate.iris.gradle.plugin.library")
}

dependencies {
  testImplementation(platform(Common.junitBom))
  testImplementation(Common.junitJupiterApi)
  testImplementation(Common.junitJupiterEngine)
  testImplementation(Common.junitPlatformEngine)
}

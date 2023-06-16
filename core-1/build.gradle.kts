plugins {
  id("com.hantasmate.iris.gradle.plugin.library")
}

dependencies {
  implementation(platform(SpringBoot.bom))
  implementation(SpringBoot.mariadb)
}

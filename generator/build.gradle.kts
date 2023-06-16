plugins {
  id("com.hantasmate.iris.gradle.plugin.library")
}

repositories {
  maven {
    url = uri("https://jitpack.io")
    name = "jitpack.io"
  }
}

dependencies {
  implementation("org.freemarker:freemarker:2.3.32")
  implementation(Google.guava)
  implementation(project(":core-3"))
  implementation("com.github.PM-Master:policy-machine-core:2.0-alpha.10.1")
}

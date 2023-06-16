enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

// 复合构建, 用于统一依赖管理, 版本更新
includeBuild("gradle-dependencies")
includeBuild("gradle-plugin")

rootProject.name = "yoga"

include(":core")
include(":core-1")
include(":core-2")
include(":core-3")
include(":generator")
include(":antlr")

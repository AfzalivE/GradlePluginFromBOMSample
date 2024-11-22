import gradle.kotlin.dsl.accessors._b43a41b3a2c24e7f863347686afebb31.versionCatalogs
import org.gradle.api.GradleException
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog

class MySqlDelightConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                val sqlDelightPlugin = target.versionCatalogs.named("libs").pluginId("sqlDelight")
                apply(sqlDelightPlugin)
            }
        }
    }
}

/**
 * From https://github.com/rickbusarow/kotlin-gradle-extensions/blob/main/kotlin-gradle-extensions/src/main/kotlin/com/rickbusarow/kgx/catalogs.kt
 */
fun VersionCatalog.pluginId(alias: String): String {
    val errorMessage by lazy(LazyThreadSafetyMode.NONE) {
        "No plugin ID was found in the catalog for the alias '$alias'."
    }
    return findPlugin(alias)
        .orElseThrow { GradleException(errorMessage) }
        .orNull
        ?.pluginId
        ?: throw GradleException(errorMessage)
}


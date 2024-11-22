# GradlePluginFromBOMSample
Sample project that shows how to use a BOM for a Gradle plugin.

There's a sample BOM included in the project, in the `bom-repo` directory. It points to the [SQLDelight](https://github.com/sqldelight/sqldelight) gradle plugin.

- version catalog contains the bom and the SQLDelight gradle plugin
- `build-logic` creates a convention plugin which applies the SQLDelight gradle plugin, using the version in the catalog
- `app` applies the convention created by `build-logic`

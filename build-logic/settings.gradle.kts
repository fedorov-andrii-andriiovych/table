// Unique build name so this included build does not collide with the consuming project's own
// `build-logic` when `table` is consumed as an included build (both define ua.wwind.convention.*).
rootProject.name = "table-build-logic"

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from(files("../gradle/libs.versions.toml"))
        }
    }
}

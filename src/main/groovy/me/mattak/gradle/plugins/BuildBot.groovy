package me.mattak.gradle.plugins

import org.gradle.api.Plugin
import org.gradle.api.Project;

class BuildBot implements Plugin<Project> {
    void apply(Project project) {
        project.extensions.create("buildbot", BuildBotExtension)

        def task = project.task('postIrc', type: IrcPostTask)
        task.group = "BuildBot"
        task.description = "post irc to build status."
    }
}

package me.mattak.gradle.plugins

/**
 * Created by maruyama on 2014/04/03.
 */
class BuildBotExtension {
    String server
    int port
    String channel
    String nick
    String mentionTo

    public BuildBotExtension() {
        server = null
        port = 6667
        channel = null
        nick = "buildbot"
        mentionTo = "@" + System.getenv("USER")
    }
}

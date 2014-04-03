package me.mattak.gradle.plugins

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 * Created by maruyama on 2014/04/03.
 */
class IrcPostTask extends DefaultTask {
    String server
    int port
    String channel
    String nick
    String mentionTo
    def messageListener

    def init() {
        server = project.buildbot.server
        port = project.buildbot.port
        channel = project.buildbot.channel
        nick = project.buildbot.nick
        mentionTo = project.buildbot.mentionTo
    }

    @TaskAction
    def postIrc() {
        init()
        println "-------------------------------"
        messageListener = { channel, sender, login, hostname, message -> println "message: $message"}

        IrcBot bot = new IrcBot(nick, messageListener)
        bot.connect(server, port)
        bot.joinChannel(channel)
        bot.sendMessage(channel, "build finished > $mentionTo")

        // XXX: wait for server response.
        sleep(2000)
        bot.quitServer()
        bot.disconnect()
    }
}

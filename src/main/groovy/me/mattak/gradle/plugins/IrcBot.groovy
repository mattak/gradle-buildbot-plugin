package me.mattak.gradle.plugins;

import org.jibble.pircbot.PircBot;

/**
 * Created by maruyama on 2014/04/03.
 */
class IrcBot extends PircBot {
    def messageListener;

    public IrcBot(botName, messageListener) {
        setName(botName)
        setVerbose(true)
        this.messageListener = messageListener
    }

    public void onMessage(String channel, String sender, String login, String hostname, String message) {
        this.messageListener(channel, sender, login, hostname, message)
    }
}

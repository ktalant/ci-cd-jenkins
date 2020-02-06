node {
    properties([pipelineTriggers([cron('* * * * *')])])


    stage("Stage1"){
        echo "Hello, World!!!"
    }
    stage("Stage2"){
        echo "Hello, World!!!"
    }
    stage("Stage3"){
        echo "Hello, World!!!"
    }
    stage("Send notifications to Slack"){
        echo "Hello, World!!!"
        slackSend channel: 'nagios_alerts', message: 'Completed!'
    }
}
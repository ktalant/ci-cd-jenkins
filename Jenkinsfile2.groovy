node{
    properties([pipelineTriggers([cron('* * * */2 *')])])
    stage("Pull the code"){
        echo "Hello, World.."
    }
    stage("Stage2"){
        echo "Hello, World.."
    }
    stage("Send notifications to Slack"){
        echo "Hello, World.."
        slackSend channel: '#jenkins', message: 'Success'
    }
}
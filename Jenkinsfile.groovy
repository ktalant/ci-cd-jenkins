node {
    properties([pipelineTriggers([cron('* * * * *')])])


    stage("Pull Repo"){
        echo "Hello, World!!!"
    }
    stage("Deploy to Dev"){
        echo "Hello, World!!!"
    }
    stage("Wait"){
        input 'Deploy to QA?'
    }
    stage("Deploy to QA"){
        echo "Hello, World!!!"
    }
    stage("Send notifications to Slack"){
        echo "Hello, World!!!"
        slackSend channel: 'nagios_alerts', message: 'Completed!'
        mail bcc: 'uchkunfan@gmail.com', body: 'completed task', cc: 'uchkunfan@gmail.com', from: '', replyTo: '', subject: 'completed', to: 'uchkunfan@gmail.com'
    }
}
node {
    //properties([pipelineTriggers([cron('* * * * *')])])
    stage("Pull Repo"){
        //This line pulls a repo
        git 'https://github.com/farrukh90/packer.git'    
    }
    stage("Deploy to Dev"){
        echo "Hello World"
    }
    stage("Wait"){
        //input 'Deploy to QA? '
        //sleep 3
    }
    stage("Perform Some Other Task"){
        //This will call another job
        //build "Item1"
    }
    stage("Deploy to QA"){
        echo "Hello World"
    }
    stage("Perform task on Husein Machine")
        // Performs task on remote system
        //sh "curl http://jenkins_master.acirrustech.com:8080/job/Item1/build?token=ITEM1"
    stage("Script"){
		sh label: '', script: 
		'''#!/bin/bash
			if [ ! -f /tmp/foo.txt ]; 
			then
				echo "File not found!"
				echo "Creating a file"
				touch "/tmp/foo.txt"
			fi
		'''
	}
    stage("Timestamp"){
		timestamps {
			echo "hello"
		}
	}
    stage("Failure"){
        //error 'Intentional Failure'
    }

    stage("Send Notification to slack"){
        echo "Hello World"
        slackSend channel: 'nagios_alerts', message: 'Completed'
        mail bcc: 'farrukh@gmail.com', body: 'message', cc: 'farrukh@gmail.com', from: '', replyTo: '', subject: 'Completed', to: 'farrukh@gmail.com'
    }
    stage("Clean WS"){
        cleanWs()
    }
}
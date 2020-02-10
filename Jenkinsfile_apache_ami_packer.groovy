node {
    stage("Pull repo"){
        git 'https://github.com/ktalant/packer-AMIs.git'
    }
    stage("Build an image"){
        sh "ls -a"
    }
    stage("Send an email"){
        echo "Sending an email"
    }
    stage("Send Slack message"){
        echo "Sending message to Slack"
    }
}
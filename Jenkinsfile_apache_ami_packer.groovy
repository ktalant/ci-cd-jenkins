node {
    stage("Pull repo"){
        git 'https://github.com/ktalant/packer-AMIs.git'
    }
    stage("Run the job"){
        echo "Running job1"
    }
    stage("Send an email"){
        echo "Sending an email"
    }
    stage("Send Slack message"){
        echo "Sending message to Slack"
    }
}
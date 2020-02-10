node {
    properties([
        //Number or builds to be discarded
        buildDiscarder(logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '', 
        daysToKeepStr: '', numToKeepStr: '4')),

        parameters([
        // region choice parameter
        choice(choices: ['us-east-1', 'us-east-2', 'us-west-1', 'us-west-2'], 
        description: 'Choose the region for AMI to be created', 
        name: 'AMI_REGION'),

        // instance_type string parameter
        string(defaultValue: 't2.micro', 
        description: 'Enter proper instance type, e.g (t2.medium, m2.large etc)', 
        name: 'INSTANCE_TYPE', trim: false)])
        
        ])


    stage("Pull repo"){
        git 'https://github.com/ktalant/packer-AMIs.git'
    }
    stage("Build an image"){
        sh "ls -a"
        sh "packer version && pwd && ls -l"
    }
    stage("Send an email"){
        echo "Sending an email"
    }
    stage("Send Slack message"){
        echo "Sending message to Slack"
    }
}
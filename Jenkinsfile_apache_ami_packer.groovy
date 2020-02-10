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
        //Have multiple ami-Folders jumping into proper folder which i want to build AMI from  
        sh "cd amzn-apache-ami && packer build --var=aws_region=${AMI_REGION}  --var=instance_type=${INSTANCE_TYPE} amazon_ami.json"
    }

    stage("Send an email"){
        mail bcc: '', 
        body: 'AMI build has been started in ${AMI_REGION}', cc: '', from: '', replyTo: '', 
        subject: 'Build message', to: 'talantasan@outlook.com'
    }

    stage("Send Slack message"){
        echo "Sending message to Slack"
    }
}
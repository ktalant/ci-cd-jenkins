node {
    properties([
            //discard old builds set to 4
            buildDiscarder(logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '', 
            daysToKeepStr: '', numToKeepStr: '4')), 
            
            parameters([
                //choice parameter for app version
                choice(choices: ['version/0.1', 'version/0.2', 'version/0.3', 'version/0.4', 'version/0.5'], 
                description: 'Choose app version to be deployed', name: 'ARTEMIS_VERSION'), 
                
                //choice parameter for app environment
                choice(choices: ['dev1.talantzon.com', 'qa1.talantzon.com', 'stage1.talantzon.com', 'prod1.talantzon.com'], 
                description: 'Choose environment ', name: 'ARTEMIS_ENV')])])


    stage("Pull repo"){
        timestamps {
            ws {
                checkout([$class: 'GitSCM', branches: [[name: '${ARTEMIS_VERSION}']], 
                doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], 
                userRemoteConfigs: [[url: 'https://github.com/fuchicorp/artemis.git']]])
            }
        }

    }
    stage("Install necessary tools"){
        timestamps {
            ws {
                sh '''
                    rm -rf .ssh/known_hosts
                    ssh centos@${ARTEMIS_ENV} sudo yum install epel-release -y
                    ssh centos@${ARTEMIS_ENV} sudo yum install python-pip -y
                    ssh centos@${ARTEMIS_ENV} sudo pip install Flash
                '''
            }
        }
    }
    stage("Pull repo"){
        
    }
    stage("Pull repo"){
        
    }
}
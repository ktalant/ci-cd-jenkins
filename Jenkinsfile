pipeline {
  agent any
  stages {
    stage('Stage1') {
      steps {
        echo 'Hello, World'
      }
    }

    stage('Stage2') {
      parallel {
        stage('Stage2') {
          steps {
            echo 'Hello, it is declarative pipeline'
          }
        }

        stage('Pull code') {
          steps {
            dir(path: '/tmp')
          }
        }

      }
    }

    stage('Stage3') {
      steps {
        echo 'Built new'
      }
    }

  }
}
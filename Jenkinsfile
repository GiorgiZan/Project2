pipeline {
  agent any
  stages {
    stage('Checkout') {
      steps {
        checkout([$class: 'GitSCM', branches: [[name: '*/main']], userRemoteConfigs: [[url: 'https://github.com/GiorgiZan/Project2.git']]])
      }
    }

    stage('Build and Version') {
      parallel {
        stage('Build Project') {
          steps {
            script {
              bat 'mvn clean test'
            }

          }
        }

        stage('Get Maven Version') {
          steps {
            script {
              bat 'mvn --version'
            }

          }
        }

      }
    }

  }
}

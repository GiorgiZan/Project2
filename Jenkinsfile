pipeline {
    agent any

    stages {
        stage('Parallel Stages') {
            parallel {
                stage('Run Maven Project') {
                    steps {
                        script {
                            checkout scm

                            sh 'mvn clean install'
                        }
                    }
                }
                stage('Get Maven Version') {
                    steps {
                        script {
                            sh 'mvn --version'
                        }
                    }
                }
            }
        }
    }

    post {
        always {
        }
    }
}

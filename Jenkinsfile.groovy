pipeline {
    agent any

    stages {
        stage('Parallel Stages') {
            parallel {
                stage('Run Maven Project') {
                    steps {
                        script {
                            // Checkout your branch
                            checkout scm

                            // Run Maven build
                            sh 'mvn clean install'
                        }
                    }
                }
                stage('Get Maven Version') {
                    steps {
                        script {
                            // Get Maven version
                            sh 'mvn --version'
                        }
                    }
                }
            }
        }
    }

    post {
        always {
            // Add any cleanup or post-build steps here
        }
    }
}
